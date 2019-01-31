package com.gaurav.emxpractice.transformers;

import org.junit.Assert;
import org.junit.Test;

public class PuzzleResponseTransformerTest {
    @Test
    public void testLineBreak() {
        PuzzleResponseTransformer transformer = new PuzzleResponseTransformer();
        Assert.assertTrue(transformer.transform("A=<<<B>=><C><=<D>>>=").equals(" ABCD \n" +
                "A=<<<\n" +
                "B>=><\n" +
                "C><=<\n" +
                "D>>>="));
    }

}