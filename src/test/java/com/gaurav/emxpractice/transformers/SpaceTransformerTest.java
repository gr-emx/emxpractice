package com.gaurav.emxpractice.transformers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTransformerTest {
    @Test
    public void testSpaceTransformer(){
        SpaceTransformer spaceTransformer = new SpaceTransformer();
        Assert.assertTrue(spaceTransformer.transform("gaurav raje").equals("gaurav_raje"));
    }

}