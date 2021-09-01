package projects.fibonacciSequence;

import main.elementaryTasksAPI.Validator;

import java.util.function.Predicate;

public class ValidatorFibonacci implements Validator<Long> {

    private final int limitDigitsInNumber = 10;
    private final Predicate<Long> moreThenZero = n -> n >= 0;
    private final Predicate<Long> lessThenMaxNumber = n -> n < Math.pow(10, limitDigitsInNumber + 1);

    public boolean isDataValid(Long value) {
        return validation(value, moreThenZero.and(lessThenMaxNumber));
    }

}
