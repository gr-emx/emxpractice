package com.gaurav.emxpractice;

import com.gaurav.emxpractice.responsegenerator.PuzzleResponseGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingTest {
    @Autowired
    PuzzleResponseGenerator puzzleResponseGenerator;

    @Test
    public void testPuzzle() throws Exception {
        String response = puzzleResponseGenerator.respond("Puzzle", "A=---B>---C<---D->--");
        Assert.assertTrue(response.equals("A=<><B>=><C<<=<D>>>="));

        response = puzzleResponseGenerator.respond("Puzzle", "A=---B>---C->--D<---");
        Assert.assertTrue(response.equals("A=<<>B>=<>C>>=>D<<<="));

        response = puzzleResponseGenerator.respond("Puzzle", "A--<-B-->-C--=-D->--");
        Assert.assertTrue(response.equals("A=<<<B>=><C><=<D>>>="));

    }
}
