package projects.chessBoard.setParameters;

import main.elementaryTasksAPI.inputOutput.input.InputDataFromConsole;
import projects.chessBoard.message.MessageChessBoard;
import projects.chessBoard.modelBoard.ChessBoard;
import projects.chessBoard.setParameters.validator.ValidatorChessBoard;
import main.elementaryTasksAPI.Validator;

import java.io.IOException;

public class ChessBoardInitializer implements MessageChessBoard {
    private InputDataFromConsole dataInput = new InputDataFromConsole();
    protected Validator<Integer> validator = new ValidatorChessBoard();
    private String[] enteredParameters;

    public ChessBoardInitializer(String[] args) {
        this.enteredParameters = args;
    }

    private ChessBoard initChessBord() {
        int height = 0;
        int width = 0;
        boolean isSuccessful = false;
        while (!isSuccessful) {
            try {
                if (enteredParameters.length == 2) {
                    height = setParameter(enteredParameters[0], HEIGHT);
                    width = setParameter(enteredParameters[1], WIDTH);
                    isSuccessful = true;
                } else {
                    System.out.println(ENTERED_AN_INCORRECT_VALUE);
                    System.out.println(ENTER_VALUES);
                    System.out.println(INPUT_SCHEME);
                    String enteredValue = dataInput.getParameters();
                    enteredParameters = enteredValue.split(" ");
                }
            } catch (IllegalArgumentException |IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return new ChessBoard(height, width);
    }

    private int setParameter(String enteredString, String nameSide) throws IllegalArgumentException {
        int valueChessBoardSide = 0;
        Integer value = Integer.parseInt(enteredString);
        if (validator.isDataValid(value)) {
            valueChessBoardSide = value;
        } else {
            throw new IllegalArgumentException(INCORRECT_ONE_SIDE_VALUE + nameSide);
        }
        return valueChessBoardSide;
    }

    public ChessBoard getChessBoard() {
        ChessBoard chessBoard = initChessBord();
        return chessBoard;
    }
}