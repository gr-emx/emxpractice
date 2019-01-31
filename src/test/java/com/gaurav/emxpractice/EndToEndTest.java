package com.gaurav.emxpractice;

import com.gaurav.emxpractice.datastore.Answers;
import com.gaurav.emxpractice.responsegenerator.PuzzleResponseGenerator;
import com.gaurav.emxpractice.responsegenerator.SimpleResponseGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EndToEndTest {
    @Autowired
    PuzzleResponseGenerator puzzleResponseGenerator;
    @Autowired
    SimpleResponseGenerator simpleResponseGenerator;

    @Test
    public void testPuzzle() throws Exception {
        String response = puzzleResponseGenerator.respond("Puzzle", "Please solve this puzzle:\n" +
                " ABCD\n" +
                "A=---\n" +
                "B>---\n" +
                "C->--\n" +
                "D<---\n");
        Assert.assertTrue(response.equals(" ABCD \n" +
                "A=<<>\n" +
                "B>=<>\n" +
                "C>>=>\n" +
                "D<<<="));

    }

    @Test
    public void testName(){

        String response = simpleResponseGenerator.respond(Answers.Name.name(), Answers.Name.getFullQuestion());
        Assert.assertEquals(response,Answers.Name.getResponse());
    }

    @Test
    public void testPing(){


        String response = simpleResponseGenerator.respond(Answers.Ping.name(), Answers.Ping.getFullQuestion());
        Assert.assertEquals(response,Answers.Ping.getResponse());
    }
}
