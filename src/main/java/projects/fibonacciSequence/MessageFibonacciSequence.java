package projects.fibonacciSequence;

import main.Message;

public class MessageFibonacciSequence extends Message {
    private final String ENTER_VALUES = "To display a sequence of Fibonacci numbers, enter a range \n" +
            "or number indicating the maximum number of digits in the sequence numbers.";
    private final String INPUT_SCHEME = "Range must be entered by scheme: <start number;end number>. \n" +
            "Start number and end number ranging from 0 to 9 999 999 999. \n" +
            "Number of digits in in the sequence numbers may be in range within 1 to 10.";
    private final String INCORRECT_VALUE = "Entered an incorrect value. ";
    private final String EXCEPTION = "Something went wrong. We are working to fix this.";
    private final String OUT_OF_RANGE = "Число не в пределах диапазоне";
    private final String DELIMITER = ";";


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

    public String getDELIMITER() {
        return DELIMITER;
    }

    public String getOUT_OF_RANGE() {
        return OUT_OF_RANGE;
    }
}
