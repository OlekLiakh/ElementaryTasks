package projects.numberToString;

import inputParameters.EnterDataFromConsole;
import projects.numberToString.message.MessagesEnglish;
import validator.Validator;

public class EnterParameters implements MessagesEnglish {

    protected EnterDataFromConsole input = new EnterDataFromConsole();
    protected Validator<Long> validator = new ValidatorNumberToString();
    private String[] args;
    private Long number;

    public EnterParameters(String args[]) {
        this.args = args;
    }

    protected void setInputParameter() {
        boolean isSuccessful = false;
        do {
            try {
                String enteredString;
                if (args == null || args.length != 1) {
                    enteredString = input.getParameters(ENTER_VALUES, INPUT_SCHEME);
                } else {
                    enteredString = args[0];
                }
                number = convertStringToNumber(enteredString);
                isSuccessful = true;
            } catch (IllegalArgumentException exception) {
                System.out.println(INCORRECT_VALUE + "\n" +exception.getMessage());
                args = input.getParameters("", INPUT_SCHEME).split(" ");
            } catch (Exception e) {
                System.out.println(EXCEPTION);
            }
        } while (!isSuccessful);
    }

    private Long convertStringToNumber(String enteredString) throws IllegalArgumentException {
        Long number = Long.parseLong(enteredString);
        if (validator.isDataValid(number)) {
            return number;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Long getNumber() {
        if (number == null) {
            setInputParameter();
        }
        return number;
    }
}
