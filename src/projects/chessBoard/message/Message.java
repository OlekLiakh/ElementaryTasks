package projects.chessBoard.message;

import messages.Messages;

public interface Message extends Messages {
    String CHESS_BOARD_INPUT_SCHEME = "Input value must be an integer positive number more then zero";
    String ENTER_VALUES = "Enter height and width for output chess board";
    String INCORRECT_ONE_SIDE_VALUE = "Incorrect value of ";
    String WIDTH = "width";
    String HEIGHT = "height";
}


