package com.gaurav.emxpractice.transformers;

import org.springframework.stereotype.Component;

/**
 * Converting the puzzle response to the format expected by the endpoint.
 */
@Component
public class PuzzleResponseTransformer implements StringTransformer {
    @Override
    public String transform(String input) {
        return " ABCD "+input.replaceAll("[A-Z]","\n$0");
    }
}
