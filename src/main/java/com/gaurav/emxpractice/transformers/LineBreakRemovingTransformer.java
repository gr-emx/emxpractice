package com.gaurav.emxpractice.transformers;

import org.springframework.stereotype.Controller;

/**
 * Removes linebreaks from input string.
 */
@Controller
public class LineBreakRemovingTransformer  implements StringTransformer{
    @Override
    public String transform(String input) {
        return input.replace("\n", "").replace("\r", "");
    }
}
