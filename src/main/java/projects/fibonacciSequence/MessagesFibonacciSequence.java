package projects.fibonacciSequence;

public interface MessagesFibonacciSequence {
    String ENTER_VALUES = "To display a sequence of Fibonacci numbers, enter a range \n" +
            "or number indicating the maximum number of digits in the sequence numbers.";
    String INPUT_SCHEME = "Range must be entered by scheme: <start number;end number>. \n"+
            "Start number and end number ranging from 0 to 9 999 999 999. \n"+
            "Number of digits in in the sequence numbers may be in range within 1 to 10.";
    String ENTERED_AN_INCORRECT_VALUE = "Entered an incorrect value ";
    String EXCEPTION = "Something went wrong. Try enter parameters again.";
}