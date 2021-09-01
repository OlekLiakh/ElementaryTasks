package main.runMainApplication;

import main.elementaryTasksAPI.Validator;

import java.util.function.Predicate;

public class ValidatorMain implements Validator<Integer> {

    private final Integer MAX_VALUE = 8;
    private final Integer MIN_VALUE = 1;
    Predicate<Integer> moreThanMinValue = x->x>= MIN_VALUE;
    Predicate<Integer> lessThanMaxValue = x->x<= MAX_VALUE;

    public boolean isDataValid(Integer value){
        return validation(value, moreThanMinValue.and(lessThanMaxValue));
    }
}
