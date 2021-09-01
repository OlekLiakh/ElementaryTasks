package projects.numberToString;

import main.Validator;

import java.util.function.Predicate;

public class ValidatorNumberToString implements Validator<Long> {

    private final long MAX_VALUE = (long) Math.pow(10, 15);
    private final long MIN_VALUE = (long) Math.pow(10, 15)*-1;
    Predicate<Long> moreThanMinValue = x->x> MIN_VALUE;
    Predicate<Long> lessThanMaxValue = x->x< MAX_VALUE;

    public boolean isDataValid(Long value){
        return validation(value, moreThanMinValue.and(lessThanMaxValue));
    }
}
