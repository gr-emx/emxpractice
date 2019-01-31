package com.gaurav.emxpractice.web;

import com.gaurav.emxpractice.responsegenerator.ResponseGenerator;
import com.gaurav.emxpractice.responsegenerator.ResponseGeneratorFactory;
import com.gaurav.emxpractice.datastore.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WebController {
    @Autowired
    Trainer trainer;

    @Autowired
    ResponseGeneratorFactory responseGeneratorFactory;

    @RequestMapping("/respond/**")
    public String respond(@RequestParam("q") String shortForm, @RequestParam("d") String longForm) throws IOException {

        ResponseGenerator responseGenerator = responseGeneratorFactory.fetchResponseGenerator(shortForm);
        return responseGenerator.respond(shortForm, longForm);
    }

    @RequestMapping("/train/**")
    public String train(@RequestParam(value = "number", defaultValue = "50", required = false) int numberOfTrainingRounds) throws IOException {
        trainer.train(numberOfTrainingRounds);
        return "trained";
    }
}
