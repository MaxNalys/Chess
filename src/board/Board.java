package board;

import pieces.Piece;
import utils.Coordinates;
import utils.Parser;

public class Board {
    private Piece[][] board;
    public static final int BOARD_SIZE = 8;

    public Board() {
        this.board = new Piece[BOARD_SIZE][BOARD_SIZE];
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setPieceOnTheBoard(Piece piece, int x,int y) {
        board[x][y] = piece;
    }

    public Piece getPieceFromBoard(int x,int y) {
        return board[x][y];
    }
}



