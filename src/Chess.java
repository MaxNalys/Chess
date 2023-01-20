import board.Board;
import board.PrintBoard;
import pieces.*;
import utils.Coordinates;
import utils.Parser;
import java.util.LinkedList;
import java.util.Scanner;

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
        addBishop(true, "c1");
        addBishop(true, "f1");
        addKnight(true, "b1");
        addKnight(true, "g1");
        addRook(true, "a1");
        addRook(true, "h1");
        addQueen(true, "d1");
        addPawn(true, "a2");
        addPawn(true, "b2");
        addPawn(true, "c2");
        addPawn(true, "d2");
        addPawn(true, "e2");
        addPawn(true, "f2");
        addPawn(true, "g2");
        addPawn(true, "h2");
        addBishop(false, "c8");
        addBishop(false, "f8");
        addKnight(false, "b8");
        addKnight(false, "g8");
        addRook(false, "a8");
        addRook(false, "h8");
        addQueen(false, "d8");
        addPawn(false, "a7");
        addPawn(false, "b7");
        addPawn(false, "c7");
        addPawn(false, "d7");
        addPawn(false, "e7");
        addPawn(false, "f7");
        addPawn(false, "g7");
        addPawn(false, "h7");
        addKing(true, "e1");
        addKing(false, "e8");
    }

    private void addKing(boolean isWhite, String position) {
        King king = new King(isWhite);
        board.setPieceOnTheStartPosition(king, position);
        pieceColorHelper(king, isWhite);
    }

    private void addPawn(boolean isWhite, String position) {
        Pawn pawn = new Pawn(isWhite);
        board.setPieceOnTheStartPosition(pawn, position);
        pieceColorHelper(pawn, isWhite);
    }

    private void addBishop(boolean isWhite, String position) {
        Bishop bishop = new Bishop(isWhite);
        board.setPieceOnTheStartPosition(bishop, position);
        pieceColorHelper(bishop, isWhite);
    }

    private void addKnight(boolean isWhite, String position) {
        Knight knight = new Knight(isWhite);
        board.setPieceOnTheStartPosition(knight, position);
        pieceColorHelper(knight, isWhite);
    }

    private void addRook(boolean isWhite, String position) {
        Rook rook = new Rook(isWhite);
        board.setPieceOnTheStartPosition(rook, position);
        pieceColorHelper(rook, isWhite);
    }

    private void addQueen(boolean isWhite, String position) {
        Queen queen = new Queen(isWhite);
        board.setPieceOnTheStartPosition(queen, position);
        pieceColorHelper(queen, isWhite);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        PrintBoard.printWhiteBoard((board));
        while (true) {
            String move = scanner.next();
            moveTo(move);
            PrintBoard.printWhiteBoard((board));
        }
    }

    public void moveTo(String move) {
        if(canMove(move)) {
            board.setPieceOnTheNextSpot(move);
        }
    }

    public boolean canMove(String move) {
        Enum pieceIdentifier = board.getPieceFromBoard(move).getPieceIdentifier();
        if (PieceIdentifier.PAWN.equals(pieceIdentifier)) {
            return isPawnMovement(move);
        } else if (PieceIdentifier.BISHOP.equals(pieceIdentifier)) {
            return isDiagonalMovement(move);
        } else if (PieceIdentifier.ROOK.equals(pieceIdentifier)) {
            return isStraightMovement(move);
        } else if (PieceIdentifier.QUEEN.equals(pieceIdentifier)) {
            return isStraightMovement(move) || isDiagonalMovement(move);
        } else if (PieceIdentifier.KNIGHT.equals(pieceIdentifier)) {
            return isKnightMovement(move);
        } else if (PieceIdentifier.KING.equals(pieceIdentifier)) {
            return isKingMovement(move);
        }
        return false;
    }

    public boolean isPawnMovement(String move) {
        Coordinates[] coordinates = Parser.parseInput(move);
        Pawn pawn = (Pawn) board.getPieceFromBoard(move);
        int oneSquare;
        int twoSquare;
        if (pawn.isWhite()) {
            oneSquare = -1;
            twoSquare = -2;
        } else {
            oneSquare = 1;
            twoSquare = 2;
        }
        if (coordinates[1].getY() - coordinates[0].getY() == oneSquare) {
            if (coordinates[1].getX() == coordinates[0].getX()) {
                pawn.setHasMoved(true);
                return true;
            } else if (Math.abs(coordinates[0].getX() - coordinates[1].getX()) == 1) {
                pawn.setHasMoved(true);
                return true;
            }
        } else if (!pawn.isHasMoved() && coordinates[1].getY() - coordinates[0].getY() == twoSquare) {
            if (coordinates[0].getX() == coordinates[1].getX()) {
                pawn.setHasMoved(true);
                return true;
            }
        }
        return false;
    }

    public boolean isStraightMovement(String move) {
        Coordinates[] coordinates = Parser.parseInput(move);
        int startPosition;
        int endPosition;
        if (coordinates[0].getX() == coordinates[1].getX()) {
            if (coordinates[0].getY() > coordinates[1].getY()) {
                startPosition = coordinates[1].getY();
                endPosition = coordinates[0].getY();
            } else {
                startPosition = coordinates[0].getY();
                endPosition = coordinates[1].getY();
            }

            startPosition++;
            for (; startPosition < endPosition; startPosition++) {
                if (board.getPieceFromBoard(coordinates[0].getX(), startPosition) != null) {
                    return false;
                }
            }
            return true;
        } else if (coordinates[0].getY() == coordinates[1].getY()) {
            if (coordinates[0].getX() > coordinates[1].getX()) {
                startPosition = coordinates[1].getX();
                endPosition = coordinates[0].getX();
            } else {
                startPosition = coordinates[0].getX();
                endPosition = coordinates[1].getX();
            }

            startPosition++;
            for (; startPosition < endPosition; startPosition++) {
                if (board.getPieceFromBoard(coordinates[0].getX(), startPosition) != null) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isDiagonalMovement(String move) {

        Coordinates[] coordinates = Parser.parseInput(move);
        int xLarge;
        int xSmall;
        int yCoordinate;
        //x0>x1&&y0<y1 --1-DONE
        if (coordinates[0].getX() > coordinates[1].getX() && coordinates[0].getY() < coordinates[1].getY()) {
            xLarge = coordinates[0].getX();
            xSmall = coordinates[1].getX();
            yCoordinate = coordinates[0].getY();
            xLarge--;
            yCoordinate++;
            for (; xSmall < xLarge; yCoordinate++, xLarge--) {
                if (board.getPieceFromBoard(xLarge, yCoordinate) != null) {
                    return false;
                }
            }
            return true;
            //x0<x1&&y0<y1 --2-????
        } else if (coordinates[0].getX() < coordinates[1].getX() && coordinates[0].getY() < coordinates[1].getY()) {
            yCoordinate = coordinates[0].getY();
            xSmall = coordinates[0].getX();
            xLarge = coordinates[1].getX();
            xSmall++;
            yCoordinate++;
            for (; xSmall < xLarge; xSmall++, yCoordinate++) {
                if (board.getPieceFromBoard(xSmall, yCoordinate) != null) {
                    return false;
                }
            }
            //x0>x1&&y0>y1 --3--DONE
        } else if (coordinates[0].getX() > coordinates[1].getX() && coordinates[0].getY() > coordinates[1].getY()) {
            xLarge = coordinates[0].getX();
            xSmall = coordinates[1].getX();
            yCoordinate = coordinates[0].getY();
            xLarge--;
            yCoordinate--;
            for (; xSmall < xLarge; yCoordinate--, xLarge--) {
                if (board.getPieceFromBoard(xLarge, yCoordinate) != null) {
                    return false;
                }
            }
            return true;
            //x0<x1&&y0>y1 --4-DONE
        } else if (coordinates[0].getX() < coordinates[1].getX() && coordinates[0].getY() > coordinates[1].getY()) {
            xLarge = coordinates[1].getX();
            xSmall = coordinates[0].getX();
            yCoordinate = coordinates[1].getY();
            yCoordinate--;
            xSmall++;
            for (; xSmall < xLarge; xSmall++, yCoordinate--) {
                if (board.getPieceFromBoard(xSmall, yCoordinate) != null) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

    public boolean isKnightMovement(String move) {
        Coordinates[] coordinates = Parser.parseInput(move);
        if (Math.abs(coordinates[0].getX() - coordinates[1].getX()) == 2 && Math.abs(coordinates[0].getY() - coordinates[1].getY()) == 1)
            return true;
        return Math.abs(coordinates[0].getX() - coordinates[1].getX()) == 1 && Math.abs(coordinates[0].getY() - coordinates[1].getY()) == 2;
    }

    public boolean isKingMovement(String move) {
        Coordinates[] coordinates = Parser.parseInput(move);
        int absoluteX = Math.abs(coordinates[1].getX() - coordinates[0].getX());
        int absoluteY = Math.abs(coordinates[1].getY() - coordinates[0].getY());
        if (absoluteX <= 1 && absoluteY <= 1) {
            return absoluteX != 0 || absoluteY != 0;
        }
        return false;
    }
}