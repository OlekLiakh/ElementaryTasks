package projects.chessBoard.converter;

import projects.chessBoard.modelBoard.ChessBoard;

public class ConverterSchemeChessBoardToString {
    private ChessBoard chessBoard;

    public ConverterSchemeChessBoardToString(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public String getScheme() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0; i < chessBoard.getHeight(); i++)
        {
            for(int j = 0; j < chessBoard.getWidth(); j++)
            {
                if((i+j) % 2 == 0){
                    stringBuilder.append("*");
                }
                else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}