package com.gaurav.emxpractice.transformers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PuzzleRequestTransformerTest {
    @Test
    public void testRequestTransformer(){
        PuzzleRequestTransformer puzzleRequestTransformer= new PuzzleRequestTransformer();
        String transformedPuzzleRequest = puzzleRequestTransformer.transform("Please solve this puzzle:\n" +
                " ABCD\n" +
                "A=---\n" +
                "B<---\n" +
                "C>---\n" +
                "D-->-\n");
        Assert.assertTrue(transformedPuzzleRequest.equals("A=---B<---C>---D-->-"));
    }

}