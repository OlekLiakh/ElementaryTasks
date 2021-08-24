package projects.chessBoard;

import projects.chessBoard.converter.ConverterSchemeChessBoardToString;
import projects.chessBoard.modelBoard.ChessBoard;
import projects.chessBoard.setParameters.ChessBoardBuilder;

import java.io.IOException;

public class Main {
    public static void main (String [] args) {
            ChessBoardBuilder builder = new ChessBoardBuilder(args);
            ChessBoard chessBoard = builder.getChessBoard();
            ConverterSchemeChessBoardToString chessboardSchemeToString
                    = new ConverterSchemeChessBoardToString(chessBoard);
            System.out.println(chessboardSchemeToString.getScheme());
    }
}
