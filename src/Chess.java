import board.Board;
import board.PrintBoard;
import pieces.*;

import java.util.LinkedList;

public class Chess {
    private Board board;
    private LinkedList<Piece> blackPieces;
    private LinkedList<Piece> whitePieces;

    public Chess() {
        this.board = new Board();
        this.blackPieces = new LinkedList<>();
        this.whitePieces = new LinkedList<>();
        setUp();
    }

    private void pieceColorHelper(Piece piece, boolean isWhite) {
        if (isWhite) {
            whitePieces.add(piece);
        } else {
            blackPieces.add(piece);
        }
    }

    private void setUp() {
        addBishop(true, 2, 7);
        addBishop(true, 5, 7);
        addKnight(true, 1, 7);
        addKnight(true, 6, 7);
        addRook(true, 0, 7);
        addRook(true, 7, 7);
        addQueen(true, 3, 7);
        addPawn(true, 0, 6);
        addPawn(true, 1, 6);
        addPawn(true, 2, 6);
        addPawn(true, 3, 6);
        addPawn(true, 4, 6);
        addPawn(true, 5, 6);
        addPawn(true, 6, 6);
        addPawn(true, 7, 6);
        addBishop(false, 2, 0);
        addBishop(false, 5, 0);
        addKnight(false, 1, 0);
        addKnight(false, 6, 0);
        addRook(false, 0, 0);
        addRook(false, 7, 0);
        addQueen(false, 3, 0);
        addPawn(false, 0, 1);
        addPawn(false, 1, 1);
        addPawn(false, 2, 1);
        addPawn(false, 3, 1);
        addPawn(false, 4, 1);
        addPawn(false, 5, 1);
        addPawn(false, 6, 1);
        addPawn(false, 7, 1);
        addKing(true, 4, 7);
        addKing(false, 4, 0);
    }

    private void addKing(boolean isWhite, int x, int y) {
        King king = new King(isWhite);
        board.setPieceOnTheBoard(king, x, y);
        pieceColorHelper(king, isWhite);
    }

    private void addPawn(boolean isWhite, int x, int y) {
        Pawn pawn = new Pawn(isWhite);
        board.setPieceOnTheBoard(pawn, x, y);
        pieceColorHelper(pawn, isWhite);
    }

    private void addBishop(boolean isWhite, int x, int y) {
        Bishop bishop = new Bishop(isWhite);
        board.setPieceOnTheBoard(bishop, x, y);
        pieceColorHelper(bishop, isWhite);
    }

    private void addKnight(boolean isWhite, int x, int y) {
        Knight knight = new Knight(isWhite);
        board.setPieceOnTheBoard(knight, x, y);
        pieceColorHelper(knight, isWhite);
    }

    private void addRook(boolean isWhite, int x, int y) {
        Rook rook = new Rook(isWhite);
        board.setPieceOnTheBoard(rook, x, y);
        pieceColorHelper(rook, isWhite);
    }

    private void addQueen(boolean isWhite, int x, int y) {
        Queen queen = new Queen(isWhite);
        board.setPieceOnTheBoard(queen, x, y);
        pieceColorHelper(queen, isWhite);
    }

    public void startGame() {
        moveTo();
        PrintBoard.printWhiteBoard((board));
    }

    public void moveTo() {

        board.setPieceOnTheBoard(board.getPieceFromBoard(4, 6), 4, 5);
    }


}
