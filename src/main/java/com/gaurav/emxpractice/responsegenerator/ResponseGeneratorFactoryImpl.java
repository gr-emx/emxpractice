package com.gaurav.emxpractice.responsegenerator;

import com.gaurav.emxpractice.datastore.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseGeneratorFactoryImpl implements ResponseGeneratorFactory {
    @Autowired
    PuzzleResponseGenerator puzzleResponseGenerator;

    @Autowired
    SimpleResponseGenerator simpleResponseGenerator;

    @Override
    public ResponseGenerator fetchResponseGenerator(String shortForm) {
        if (shortForm.equals(Answers.Puzzle.name())) {
            return puzzleResponseGenerator;
        } else {
            return simpleResponseGenerator;
        }
    }
}
