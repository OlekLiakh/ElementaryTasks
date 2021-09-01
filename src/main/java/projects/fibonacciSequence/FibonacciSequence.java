package projects.fibonacciSequence;

import messages.Messages;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciSequence {

    private long startRange;
    private long endRange;

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

    private String buildFibonacciSequence(long startRange, long endRange) {
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

    public String getFibonacciSequence() {
        String fibonacciSequence = buildFibonacciSequence(startRange, endRange);
        return fibonacciSequence;
    }
}