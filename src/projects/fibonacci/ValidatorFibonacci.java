package projects.fibonacci;

import validator.Validator;

public class ValidatorFibonacci implements Validator<Integer> {

    public boolean isDataValid(Integer value){
        return validation(value, integer -> integer>0);
    }
}
