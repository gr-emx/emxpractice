package com.gaurav.emxpractice.responsegenerator;

/**
 * Abstract factory that returns the right response generator
 * depending on what response is being requested
 */
public interface ResponseGeneratorFactory {
    ResponseGenerator fetchResponseGenerator(String shortForm);
}
