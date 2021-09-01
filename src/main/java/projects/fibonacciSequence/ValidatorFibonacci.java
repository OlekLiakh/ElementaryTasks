package projects.fibonacciSequence;

import main.Validator;

import java.util.function.Predicate;

public class ValidatorFibonacci implements Validator<Integer> {

    private final int limitDigitsInNumber = 10;
    private final Predicate<Integer> moreThenZero = n->n>0;
    private final Predicate<Integer> lessThenLimit = numberDigitsInNumber->numberDigitsInNumber<=limitDigitsInNumber;
    private final Predicate<Integer> lessThenMaxNumber = n->n<Math.pow(10,limitDigitsInNumber+1);

    public boolean isDataValid(Integer value){
        return validation(value, moreThenZero.and(lessThenMaxNumber));
    }

    public boolean isNumberForRangeValid(Integer value){
        return validation(value, moreThenZero.and(lessThenLimit));
    }
}
