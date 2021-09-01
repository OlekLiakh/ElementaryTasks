package main.runMainApplication;

import main.elementaryTasksAPI.Message;

public class MessageMain extends Message {
    private final String ENTER_VALUES = "Enter number to choose program";
    private final String INPUT_SCHEME = "Application list:\n" +
            "5. Number to string.\n" +
            "8. Fibonacci sequence.";
    private final String INCORRECT_VALUE = "Entered an incorrect value.";
    private final String EXCEPTION = "Something went wrong. We are working to fix this.";

    @Override
    public String getENTER_VALUES() {
        return ENTER_VALUES;
    }

    @Override
    public String getINPUT_SCHEME() {
        return INPUT_SCHEME;
    }

    @Override
    public String getINCORRECT_VALUE() {
        return INCORRECT_VALUE;
    }

    @Override
    public String getEXCEPTION() {
        return EXCEPTION;
    }
}
