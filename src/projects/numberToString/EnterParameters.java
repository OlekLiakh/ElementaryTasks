package projects.numberToString;

import inputParameters.DataEnterFromConsole;
import validator.Validator;

public class EnterParameters implements MessagesEnglish {

    DataEnterFromConsole input = new DataEnterFromConsole();
    Validator<Long> validator = new ValidatorNumberToString();
    String[] args;
    private Long number;

    public EnterParameters(String args[]){
        this.args = args;
    }
    public void setInputParameters() {
        try {
            if (args.length == 0) {
                System.out.println(INPUT_NUMBER_TEMPLATE);
                this.number = enterParameters();
            } else if (args.length == 1) {
                long enteredNumber = Long.parseLong(args[0]);
                if (validator.isDataValid(enteredNumber)) {
                    this.number = enteredNumber;
                }
            } else {
                throw new IllegalArgumentException(INCORRECT_VALUE);
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.out.println(INPUT_NUMBER_TEMPLATE);
            enterParameters();
        }
    }
    private Long enterParameters() {
        while (true) {
            String enteredString = input.getParameters();
            try {
                long number = Long.parseLong(enteredString);
                if (validator.isDataValid(number)) {
                    return number;
                } else {
                    throw new IllegalArgumentException(INCORRECT_VALUE);
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public Long getNumber(){
        setInputParameters();
        return number;
    }
}
