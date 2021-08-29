package projects.chessBoard.setParameters.validator;

import validator.Validator;

import java.util.List;

public class ValidatorChessBoard implements Validator<Integer> {

    public boolean isDataValid(Integer value){
        return validation(value, x -> {
            return x.compareTo(0) > 0;
        });
    }
}