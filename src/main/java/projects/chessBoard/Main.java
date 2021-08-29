package projects.chessBoard;

import projects.chessBoard.converter.ConverterSchemeChessBoardToString;
import projects.chessBoard.modelBoard.ChessBoard;
import projects.chessBoard.setParameters.ChessBoardInitializer;


public class Main {
    public static void main (String [] args) {
            ChessBoardInitializer initializer = new ChessBoardInitializer(args);
            ChessBoard chessBoard = initializer.getChessBoard();
            ConverterSchemeChessBoardToString chessboardSchemeToString
                    = new ConverterSchemeChessBoardToString(chessBoard);
            System.out.println(chessboardSchemeToString.getScheme());
    }
}
