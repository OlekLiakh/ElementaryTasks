package projects.chessBoard.message;

import messages.Messages;

public interface MessageChessBoard extends Messages {
    String ENTER_VALUES = "Enter height and width for output chess board";
    String INPUT_SCHEME = "Input value must be an integer number more than zero";
    String INCORRECT_ONE_SIDE_VALUE = "Incorrect value of ";
    String WIDTH = "width";
    String HEIGHT = "height";
}


