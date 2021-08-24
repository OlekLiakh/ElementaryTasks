package projects.numberSequence;

import inputParameters.DataEnterFromConsole;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberSequence implements MessageNumberSequence {

    DataEnterFromConsole input = new DataEnterFromConsole();
    String[] inputtedParameters;
    int startNumber = 1;
    long sequenceLength;
    Double inputtedNumbersSquare;

    public NumberSequence(String[] args) {
        inputtedParameters = args;
    }

    public boolean setInputtedParameters() {
        boolean isValid = false;
        while(!isValid) {
            System.out.println(ENTER_VALUES);
            System.out.println(INPUT_SCHEME);
            inputtedParameters = input.getParameters().split(" ");
            isValid = validateParameters(inputtedParameters);
        }
        return true;
    }

    public boolean validateParameters(String[] inputtedParameters) {
        try {
            if (inputtedParameters.length != 2) {
                throw new IllegalArgumentException(ENTERED_AN_INCORRECT_VALUE);
            }
            sequenceLength = Long.parseLong(inputtedParameters[0]);
            if (sequenceLength <= 0) {
                throw new IllegalArgumentException("Sequence length can't be less or equals zero");
            }
            inputtedNumbersSquare = Double.parseDouble(inputtedParameters[1]);
            if (inputtedNumbersSquare < 0) {
                throw new IllegalArgumentException("Sequence length can't be less than zero");
            }
            return true;
        } catch (IllegalArgumentException exception) {
            System.out.println(ENTERED_AN_INCORRECT_VALUE + exception.getMessage());
            return false;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }


    public String getNumberSequence(String[] args) {
        if (validateParameters(args)) {
            String numberSequence = Stream.iterate(startNumber, m -> m + 1)
                    .limit(sequenceLength)
                    .map(x -> x.toString() + ", ")
                    .collect(Collectors.joining());
         return numberSequence = numberSequence.substring(0, numberSequence.length() - 2);
        }
        return "";
    }
}