package com.gaurav.emxpractice.responsegenerator;

import com.gaurav.emxpractice.datastore.Answers;
import com.gaurav.emxpractice.responsegenerator.ResponseGenerator;
import com.gaurav.emxpractice.transformers.SpaceTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleResponseGenerator implements ResponseGenerator {

    @Autowired
    SpaceTransformer spaceTransformer;

    @Override
    public String respond(String shortForm, String longForm) {
        Answers answer = Answers.valueOf(spaceTransformer.transform(shortForm));
        return answer.getResponse();
    }

    public void setSpaceTransformer(SpaceTransformer spaceTransformer) {
        this.spaceTransformer = spaceTransformer;
    }
}
