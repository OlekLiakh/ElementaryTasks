package projects.numberToString;

import inputParameters.DataInput;
import inputParameters.DataInputFromConsole;

public class ParseStringToNumber implements Messages {

    DataInput input = new DataInputFromConsole();

    private final String[] inputArray;

    public ParseStringToNumber(String[] args) {
        this.inputArray = args;
    }

    public Long getNumber() {
        String enteredString;
        if (inputArray.length == 0) {
            System.out.println(INPUT_NUMBER_TEMPLATE);
            enteredString = input.getParameters();
        } else if (inputArray.length > 1) {
            System.out.println(INCORRECT_VALUE);
            System.out.println(INPUT_NUMBER_TEMPLATE);
            enteredString = input.getParameters();
        } else {
            enteredString = this.inputArray[0];
        }
        long number = parseStringToLong(enteredString);
        return number;
    }

    private Long parseStringToLong(String enteredString) {
        enteredString = enteredString.trim();
        while (true) {
            try {
                long number = Long.parseLong(enteredString);
                long quadrillion = (long) Math.pow(10, 15);
                if (number >= quadrillion) {
                    throw new NumberFormatException();
                }
                return number;
            } catch (NumberFormatException nfe) {
                System.out.println(INCORRECT_VALUE);
                System.out.println(INPUT_NUMBER_TEMPLATE);
                enteredString = input.getParameters();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
