package projects.fibonacci;

import inputParameters.DataEnterFromConsole;
import messages.Messages;
import validator.Validator;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciSequence implements Messages {

    protected DataEnterFromConsole input = new DataEnterFromConsole();
    protected Validator<Integer> validator = new ValidatorFibonacci();

    private double startRange;
    private double endRange;

    public void setInputParameters(String[] enteredParameters) {
        boolean isSuccessful = false;
        while (!isSuccessful) {
            try {
                if (enteredParameters.length == 1) {
                    isSuccessful = setRange(enteredParameters[0]);
                } else if (enteredParameters.length == 2) {
                    isSuccessful = setRange(enteredParameters[0], enteredParameters[1]);
                } else {
                    throw new NumberFormatException(ENTERED_AN_INCORRECT_VALUE);
                }
            } catch (NumberFormatException exception) {
                System.out.println(exception.getMessage());
                enteredParameters = input.getParameters().split(";");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean setRange(String enteredParameter) throws NumberFormatException {
        int numberLength = Integer.parseInt(enteredParameter);
        if (validator.isDataValid(numberLength)) {
            startRange = (Math.pow(10, numberLength - 1));
            endRange = (Math.pow(10, numberLength));
            return true;
        } else {
            throw new NumberFormatException(ENTERED_AN_INCORRECT_VALUE);
        }
    }

    private boolean setRange(String firstEnteredParameter,
                             String secondEnteredParameter) throws NumberFormatException {
        int firstNumberRange = Integer.parseInt(firstEnteredParameter);
        int secondNumberRange = Integer.parseInt(secondEnteredParameter);
        if (validator.isDataValid(firstNumberRange)
                && validator.isDataValid(secondNumberRange)) {
            if (firstNumberRange <= secondNumberRange) {
                startRange = firstNumberRange;
                endRange = secondNumberRange;
            } else {
                startRange = secondNumberRange;
                endRange = firstNumberRange;
            }
            return true;
        } else {
            throw new NumberFormatException(ENTERED_AN_INCORRECT_VALUE);
        }
    }

    public String getFibonacciSequence(String[] args) {
        setInputParameters(args);
        String fibonacciSequence = buildFibonacciSequence(startRange, endRange);
        return fibonacciSequence;
    }

    private String buildFibonacciSequence(Double startRange, Double endRange) {
        String fibonacciSequence = Stream.iterate(new Double[]{0D, 1D},
                x -> new Double[]{x[1], x[0] + x[1]})
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
