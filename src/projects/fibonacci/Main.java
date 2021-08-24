package projects.fibonacci;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence fibonacciSequence = new FibonacciSequence();
        String result = fibonacciSequence.getFibonacciSequence(args);
        System.out.println(result);
    }

}
