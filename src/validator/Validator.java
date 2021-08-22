package validator;

import projects.chessBoard.message.Message;


public class Validator implements Message {

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
