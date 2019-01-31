package com.gaurav.emxpractice;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.AbstractMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmxpracticeApplicationTests {
    Pattern patternQuestion = Pattern.compile("ABCD(.*?)</div>", Pattern.MULTILINE);
    Pattern patternAnswer = Pattern.compile("was:<pre> ABCD(.*?)</pre>", Pattern.MULTILINE);

    @Value("${training.filename}")
    String filename;

    @Test
    public void test() throws Exception {
        brute();
    }

    private Map.Entry<String, String> getQuestionAnswer(String url) throws Exception {
        URL path = new URL(url);
        WebRequest webRequest = new WebRequest(path, HttpMethod.POST);
        webRequest.setRequestBody("url=http%3A%2F%2Ff91f77f3.ngrok.io");

        WebClient client = new WebClient();
        Page page = client.getPage(webRequest);
        String resp = page.getWebResponse().getContentAsString();
        resp = resp.replace("\n", "").replace("\r", "");
        Matcher matcherQuestion = patternQuestion.matcher(resp);
        Matcher matcherAnswer = patternAnswer.matcher(resp);
        boolean ans = matcherAnswer.find();
        boolean ques = matcherQuestion.find();
        String question = matcherQuestion.group(1);
        String answer = matcherAnswer.group(1);
        return new AbstractMap.SimpleEntry<>(unescapeHtml4(question), answer);
    }

    public void brute() throws Exception {

        while (true) {
            try (FileWriter fw = new FileWriter("myfile.txt", true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                Map.Entry<String, String> response = getQuestionAnswer("http://resumes.brealtime.com/test.php");
                out.println(response.getKey() + " : " + response.getValue());
            }
        }
    }

}

