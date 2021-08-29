package projects.fibonacciSequence;

import inputParameters.EnterDataFromConsole;

public class ParserEnteredParameters implements MessagesFibonacciSequence {

    protected EnterDataFromConsole input = new EnterDataFromConsole();
    protected ValidatorFibonacci validator = new ValidatorFibonacci();

    private String[] parameters;
    private long startRange;
    private long endRange;

    public ParserEnteredParameters(String [] args){
        this.parameters =args;
    }

    public void parseEnteredParameters() {
        boolean isSuccessful = false;
        do {
            try {
                if (parameters.length == 1) {
                    isSuccessful = setRange(parameters[0]);
                } else if (parameters.length == 2) {
                    isSuccessful = setRange(parameters[0], parameters[1]);
                } else {
                    parameters = input
                            .getParameters(ENTER_VALUES, INPUT_SCHEME)
                            .split(";");
                }
            } catch (NumberFormatException exception) {
                System.out.println(ENTERED_AN_INCORRECT_VALUE);
                parameters = input
                        .getParameters(ENTER_VALUES, INPUT_SCHEME)
                        .split(";");
            } catch (Exception e) {
                System.out.println(EXCEPTION);
            }
        } while (!isSuccessful);
    }

    private boolean setRange(String enteredParameter) throws NumberFormatException {
        int numberLength = Integer.parseInt(enteredParameter);
        if (validator.isNumberForRangeValid(numberLength)) {
            startRange = (long)(Math.pow(10, numberLength - 1));
            endRange = (long)(Math.pow(10, numberLength));
            return true;
        } else {
            throw new NumberFormatException();
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
            throw new NumberFormatException();
        }
    }

    public long[] getFibonacciSequenceRange() {
        if (startRange == 0 || endRange == 0) {
            parseEnteredParameters();
        }
        return new long[]{startRange, endRange};
    }
}
