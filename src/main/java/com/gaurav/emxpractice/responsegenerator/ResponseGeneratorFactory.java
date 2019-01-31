package com.gaurav.emxpractice.responsegenerator;

import com.gaurav.emxpractice.responsegenerator.ResponseGenerator;

public interface ResponseGeneratorFactory {
    ResponseGenerator fetchResponseGenerator(String shortForm);
}
