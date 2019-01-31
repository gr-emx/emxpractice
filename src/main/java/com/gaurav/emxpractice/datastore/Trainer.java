package com.gaurav.emxpractice.datastore;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gaurav.emxpractice.transformers.LineBreakRemovingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.AbstractMap.SimpleEntry;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;
import static org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4;

/**
 * Instead of trying to find an answer, I used the training dataset to train  a model with all possible outcomes of the puzzle.
 * The file trainingdata.txt contains various answers and this class helps add more values to it.
 * Run this trainer multiple times to get all possible answers of the puzzle.
 */
@Service
public class Trainer {
    @Value("${training.filename}")
    protected String trainingFile;
    @Value("${emx.url}")
    protected String emxUrl;
    @Value("${request.body}")
    protected String requestBody;

    @Autowired
    protected LineBreakRemovingTransformer lineBreakRemovingTransformer;

    @Value("${response.question.pattern}")
    protected String questionPattern;
    @Value("${response.answer.pattern}")
    protected String answerPattern;

    //Set in the post construct
    protected Pattern patternQuestion;
    protected Pattern patternAnswer;

    @PostConstruct
    public void init() {
        patternQuestion = compile(questionPattern, Pattern.MULTILINE);
        patternAnswer = compile(answerPattern, Pattern.MULTILINE);
    }

    public void train(int numberOfRequests) {
        Map<String, String> responseDictionary = new LinkedHashMap<>();

        for (int i = 0; i < numberOfRequests; i++) {
            try {
                Map.Entry<String, String> responseTuple = getQuestionAnswer(emxUrl);
                responseDictionary.put(responseTuple.getKey(), responseTuple.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        persistMap(responseDictionary);
    }

    private void persistMap(Map<String, String> map) {
        try (FileWriter fw = new FileWriter(trainingFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (Map.Entry<String, String> response : map.entrySet()) {
                out.println(response.getKey() + " : " + response.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map.Entry<String, String> getQuestionAnswer(String url) throws Exception {
        URL path = new URL(url);
        WebRequest webRequest = new WebRequest(path, HttpMethod.POST);
        webRequest.setRequestBody(requestBody);

        WebClient client = new WebClient();
        Page page = client.getPage(webRequest);
        String resp = page.getWebResponse().getContentAsString();
        resp = lineBreakRemovingTransformer.transform(resp);
        Matcher matcherQuestion = patternQuestion.matcher(resp);
        Matcher matcherAnswer = patternAnswer.matcher(resp);
        boolean ans = matcherAnswer.find();
        boolean ques = matcherQuestion.find();
        String question = matcherQuestion.group(1);
        String answer = matcherAnswer.group(1);
        return new SimpleEntry<>(unescapeHtml4(question), answer);
    }
}
