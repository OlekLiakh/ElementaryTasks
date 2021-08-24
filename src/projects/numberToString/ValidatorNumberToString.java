package projects.numberToString;

import validator.Validator;

public class ValidatorNumberToString implements Validator<Long> {

    private final long MAX_INPUT_VALUE = (long) Math.pow(10, 15);

    public boolean isDataValid(Long value){
        return validation(value, x -> x<MAX_INPUT_VALUE);
    }
}
