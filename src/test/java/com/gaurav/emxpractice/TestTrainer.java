package com.gaurav.emxpractice;

import com.gaurav.emxpractice.datastore.Trainer;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("")
public class TestTrainer {
    @Autowired
    Trainer trainer;
    @Value("${emx.url}")
    protected String emxUrl;

    @Test
    @Ignore("This requires a separate server running. Test it locally and ignore")
    public void testTrainer() throws Exception {
        Map.Entry<String, String> answer = trainer.getQuestionAnswer(emxUrl);
        //Ensure no exception is thrown
        Assert.assertTrue(answer.getKey().contains("A"));
        //Ensure that at least one of the characters of the puzzle is present. I chose A.
        Assert.assertTrue(answer.getValue().contains("A"));
    }
}
