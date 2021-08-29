package projects.fibonacciSequence;

public class Main {
    public static void main(String[] args) {
        ParserEnteredParameters enterParameters = new ParserEnteredParameters(args);
        long[]param=enterParameters.getFibonacciSequenceRange();
        FibonacciSequence fibonacciSequence = new FibonacciSequence(param);
        String result = fibonacciSequence.getFibonacciSequence();
        System.out.println(result);
    }

}
