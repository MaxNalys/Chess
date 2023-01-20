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

    public void setPieceOnTheStartPosition(Piece piece, String position) {
        Coordinates coordinates = Parser.convertFistPartOfMove(position);
        board[coordinates.getX()][coordinates.getY()] = piece;
    }

    public Piece getPieceFromBoard(String position) {
        Coordinates coordinates = Parser.convertFistPartOfMove(position);
        return board[coordinates.getX()][coordinates.getY()];
    }
    public Piece getPieceFromBoard(int x,int y) {
        return board[x][y];
    }

    public void deletePieceFromBoard(String position) {
        Coordinates coordinates = Parser.convertFistPartOfMove(position);
        board[coordinates.getX()][coordinates.getY()] = null;
    }

    public void setPieceOnTheNextSpot(String move) {
        Coordinates[] coordinates = Parser.parseInput(move);
        board[coordinates[1].getX()][coordinates[1].getY()] = getPieceFromBoard(move);
        deletePieceFromBoard(move);
    }
}



