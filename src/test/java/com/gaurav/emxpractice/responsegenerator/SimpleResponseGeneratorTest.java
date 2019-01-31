package com.gaurav.emxpractice.responsegenerator;

import com.gaurav.emxpractice.datastore.Answers;
import com.gaurav.emxpractice.transformers.SpaceTransformer;
import org.junit.Assert;
import org.junit.Test;

public class SimpleResponseGeneratorTest {
    SimpleResponseGenerator simpleResponseGenerator = new SimpleResponseGenerator();

    @Test
    public void testSimpleResponse() {
        simpleResponseGenerator.setSpaceTransformer(new SpaceTransformer());
        for (Answers answer : Answers.values()) {
            if (!answer.equals(Answers.Puzzle)) {
                Assert.assertTrue(answer.getResponse().equals(simpleResponseGenerator.respond(answer.name(), answer.getFullQuestion())));
            }
        }
    }

}