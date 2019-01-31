package com.gaurav.emxpractice.transformers;

import org.springframework.stereotype.Component;

/**
 * A code with a space is converted to snake_case
 */
@Component
public class SpaceTransformer implements StringTransformer {
    @Override
    public String transform(String input) {
        return input.replace(" ", "_");
    }
}
