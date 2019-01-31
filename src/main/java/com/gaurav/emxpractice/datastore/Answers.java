package com.gaurav.emxpractice.datastore;

/**
 * Contains all the answers excpet for the one related to the puzzle. Use this to change any answer.
 */
public enum Answers {
    Ping("Please return OK so that I know your service works.", "OK"),
    Years("How many years of software development experience do you have?", "10"),
    Puzzle("Please solve this puzzle:\n" + " ABCD\n" + "A->--\n" + "B--->\n" + "C---<\n" + "D---=", " ABCD\n" +
            "A=><>\n" +
            "B<=<<\n" +
            "C>>=>\n" +
            "D<><="),
    Email_Address("What is your email address?", "gaurav.raje07@gmail.com"),
    Referrer("How did you hear about this position?", "recruiter"),
    Status("Can you provide proof of eligibility to work in the US?", "no"),
    Phone("Please provide a phone number we c   an use to reach you.", "720-924-6627"),
    Position("Which position are you applying for?", "Lead Software Developer"),
    Source("Please provide a URL where we can download the source code of your resume submission web service.", "https://github.com/gr-emx/emxpractice"),
    Resume("Please provide a URL where we can download your resume and cover letter.", "https://www.chimbs.com or http://chimbs.com/assets/resumeGauravRajeOffline.pdf "),
    Degree("Please list your relevant university degree(s).", "MBA - Digital Marketing/Finance, MS- Computer Science"),
    Name("What is your full name?", "Gaurav Raje");
    String fullQuestion;
    String response;

    Answers(String fullQuestion, String response) {
        this.fullQuestion = fullQuestion;
        this.response = response;
    }

    public String getFullQuestion() {
        return fullQuestion;
    }

    public void setFullQuestion(String fullQuestion) {
        this.fullQuestion = fullQuestion;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
