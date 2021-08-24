package projects.chessBoard.setParameters;

import inputParameters.DataEnterFromConsole;
import projects.chessBoard.message.MessageChessBoard;
import projects.chessBoard.modelBoard.ChessBoard;
import projects.chessBoard.setParameters.validator.Validator;

public class ChessBoardBuilder implements MessageChessBoard {
    protected DataEnterFromConsole dataInput = new DataEnterFromConsole();
    protected Validator validator = new Validator();
    private String[] enteredParameters;

    public ChessBoardBuilder(String[] args) {
        this.enteredParameters = args;
    }

    protected ChessBoard setChessBordParameters() {
        int height = 0;
        int width = 0;
        if (enteredParameters.length == 0) {
            System.out.println(ENTER_VALUES);
            System.out.println(INPUT_SCHEME);
            height = setParameter(HEIGHT);
            width = setParameter(WIDTH);
        } else {
            height = setParameter(enteredParameters[0], HEIGHT);
            try {
                width = setParameter(enteredParameters[1], WIDTH);
            } catch (ArrayIndexOutOfBoundsException e) {
                width = setParameter(WIDTH);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new ChessBoard(height, width);
    }
    protected int setParameter(String value, String nameChessboardSide) {
        int valueChessBoardSide = 0;
        if (validator.isValid(value)) {
            valueChessBoardSide = Integer.parseInt(value);
        } else {
            System.out.println(INCORRECT_ONE_SIDE_VALUE + nameChessboardSide);
            System.out.println(INPUT_SCHEME);
            valueChessBoardSide = setParameter(nameChessboardSide);
        }
        return valueChessBoardSide;
    }
    protected int setParameter(String nameChessBoardSide) {
        int valueChessBoardSide = 0;
        boolean isSuccessful = false;
        while (!isSuccessful) {
            System.out.printf("Enter %s \n", nameChessBoardSide);
            String input = dataInput.getParameters();
            isSuccessful = validator.isValid(input);
            if (isSuccessful) {
                valueChessBoardSide = Integer.parseInt(input);
            } else {
                System.out.println(INPUT_SCHEME);
                System.out.println(ENTER_VALUES);
            }
        }
        return valueChessBoardSide;
    }
    public ChessBoard getChessBoard(){
        ChessBoard chessBoard = setChessBordParameters();
        return chessBoard;
    }
}