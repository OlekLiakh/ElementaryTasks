package projects.fibonacciSequence;

import main.Message;
import main.Validator;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciSequence {

    private long startRange;
    private long endRange;
    private String fibonacciSequenceString;
    private Validator<Long> validator = new ValidatorFibonacci();
    private Message message = new MessageFibonacciSequence();
    private FibonacciSequence(){}

    public FibonacciSequence (long [] rangeSequence){
        if (rangeSequence[0] <= rangeSequence[1]) {
            startRange = rangeSequence[0];
            endRange = rangeSequence[1];
        } else {
            startRange = rangeSequence[1];
            endRange = rangeSequence[0];
        }
    }

    public String getFibonacciSequence() throws IllegalArgumentException{
        if(fibonacciSequenceString==null) {
            createFibonacciSequenceString();
        }
        return  fibonacciSequenceString;
    }
    private void createFibonacciSequenceString() throws IllegalArgumentException{
        if(validator.isDataValid(startRange)&&validator.isDataValid(endRange)){
            fibonacciSequenceString = buildFibonacciSequence();
        }else {
            throw new IllegalArgumentException();
        }
    }
    private String buildFibonacciSequence() {
        String fibonacciSequence = Stream.iterate(new Long[]{0L, 1L},
                x -> new Long[]{x[1], x[0] + x[1]})
                .map(x -> x[0])
                .filter(x -> x >= startRange)
                .takeWhile(x -> x < endRange)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        if(fibonacciSequence.length()==0){
            return "There are no Fibonacci numbers in the specified range";
        }
        return fibonacciSequence;
    }
}