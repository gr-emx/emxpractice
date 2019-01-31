package com.gaurav.emxpractice.transformers;

/**
 * This is an adapter class that  transforms an input string to match the expected input of the receiver.
 */
public interface StringTransformer {
    String transform(String input);

}
