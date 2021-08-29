package projects.chessBoard.setParameters;

import inputParameters.EnterDataFromConsole;
import projects.chessBoard.message.MessageChessBoard;
import projects.chessBoard.modelBoard.ChessBoard;
import projects.chessBoard.setParameters.validator.ValidatorChessBoard;
import validator.Validator;

public class ChessBoardInitializer implements MessageChessBoard {
    private EnterDataFromConsole dataInput = new EnterDataFromConsole();
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
                    throw new IllegalArgumentException(ENTERED_AN_INCORRECT_VALUE);
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                String enteredValue = dataInput.getParameters(ENTER_VALUES, INPUT_SCHEME);
                enteredParameters = enteredValue.split(" ");
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