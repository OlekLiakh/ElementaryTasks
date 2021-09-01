package projects.chessBoard.setParameters.validator;

import main.elementaryTasksAPI.Validator;

public class ValidatorChessBoard implements Validator<Integer> {

    public boolean isDataValid(Integer value){
        return validation(value, x -> {
            return x.compareTo(0) > 0;
        });
    }
}