package projects.chessBoard.modelBoard;

public class ChessBoard {
    private int width, height;

    public ChessBoard(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public String toString() {
        return "Chess board with dimensions height: " + height + ", width: " + width + ".";
    }
}