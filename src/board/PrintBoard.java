package board;

import pieces.PieceIdentifier;

import java.util.HashMap;

public class PrintBoard {
    public static HashMap<Enum, String> pieceIdentifiers;
    private static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE
    private static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    private static final String MAGENTA = "\033[0;35m";


    static {
        pieceIdentifiers = new HashMap<>();
        pieceIdentifiers.put(PieceIdentifier.BISHOP, "♗");
        pieceIdentifiers.put(PieceIdentifier.KING, "♔");
        pieceIdentifiers.put(PieceIdentifier.PAWN, "♙");
        pieceIdentifiers.put(PieceIdentifier.KNIGHT, "♘");
        pieceIdentifiers.put(PieceIdentifier.QUEEN, "♕");
        pieceIdentifiers.put(PieceIdentifier.ROOK, "♖");
    }

    public static void printBoard(Board board, boolean isWhite) {
        if (isWhite) {
            printWhiteBoard(board);
        } else {
            printBlackBoard(board);
        }
    }

    public static void printWhiteBoard(Board board) {
        for (int i = 0; i < Board.BOARD_SIZE; i++) {
            for (int j = 0; j < Board.BOARD_SIZE; j++) {
                if (j == 0) {
                    System.out.print(WHITE_BOLD_BRIGHT + (Board.BOARD_SIZE-i));
                }
                if (board.getBoard()[j][i] == null) {
                    System.out.print(MAGENTA + "\t☐");
                } else {
                    if (board.getBoard()[j][i].isWhite()) {
                        System.out.print("\t" + WHITE_BOLD_BRIGHT + pieceIdentifiers.get(board.getBoard()[j][i].getPieceIdentifier()));
                    } else {
                        System.out.print("\t" + BLACK_BOLD_BRIGHT + pieceIdentifiers.get(board.getBoard()[j][i].getPieceIdentifier()));
                    }
                }
            }
            System.out.println("");
        }
        System.out.print(WHITE_BOLD_BRIGHT + "    a   b   c   d   e   f   g   h");
    }

    public static void printBlackBoard(Board board) {
        for (int i = Board.BOARD_SIZE - 1; i >= 0; i--) {
            for (int j = Board.BOARD_SIZE - 1; j >= 0; j--) {
                if (j == 7) {
                    System.out.print(WHITE_BOLD_BRIGHT + (Math.abs(i-Board.BOARD_SIZE)));
                }
                if (board.getBoard()[j][i] == null) {
                    System.out.print(MAGENTA + "\t☐");
                } else {
                    if (board.getBoard()[j][i].isWhite()) {
                        System.out.print("\t" + WHITE_BOLD_BRIGHT + pieceIdentifiers.get(board.getBoard()[j][i].getPieceIdentifier()));
                    } else {
                        System.out.print("\t" + BLACK_BOLD_BRIGHT + pieceIdentifiers.get(board.getBoard()[j][i].getPieceIdentifier()));
                    }
                }
            }
            System.out.println("");
        }
        System.out.print(WHITE_BOLD_BRIGHT + "    h   g   f   e   d   c   b   a");
    }
}
