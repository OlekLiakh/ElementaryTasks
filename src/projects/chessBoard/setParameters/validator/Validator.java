package projects.chessBoard.setParameters.validator;

import projects.chessBoard.message.MessageChessBoard;


public class Validator implements MessageChessBoard {

    public boolean isValid(String enteredValue) {
        try {
            int number = Integer.parseInt(enteredValue);
            return number > 0;
        } catch (NumberFormatException nfe){
            System.out.println(ENTERED_AN_INCORRECT_VALUE);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
