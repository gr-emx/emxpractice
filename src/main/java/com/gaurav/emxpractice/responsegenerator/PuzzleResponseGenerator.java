package com.gaurav.emxpractice.responsegenerator;

import com.gaurav.emxpractice.transformers.PuzzleRequestTransformer;
import com.gaurav.emxpractice.transformers.PuzzleResponseTransformer;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class PuzzleResponseGenerator implements ResponseGenerator {
    @Value("${training.filename}")
    protected String filename;
    @Autowired
    PuzzleRequestTransformer puzzleRequestTransformer;
    @Autowired
    PuzzleResponseTransformer puzzleResponseTransformer;

    protected Map<String, String> responseLookup = new LinkedHashMap<>();


    @PostConstruct
    public void doInit() throws IOException {

        String trainingData = FileUtils.readFileToString(new File(filename));
        String[] trainingItems = trainingData.split("\n");
        for (String trainingItem : trainingItems) {
            String[] entry = trainingItem.split(" : ");
            responseLookup.put(entry[0], entry[1]);
        }

    }

    @Override
    public String respond(String shortForm, String longForm) {
        return puzzleResponseTransformer.transform(responseLookup.get(puzzleRequestTransformer.transform(longForm)));
    }
}
