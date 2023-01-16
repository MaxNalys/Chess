package pieces;

public class Piece {
    private boolean isWhite;
    private Enum pieceIdentifier;

    public Piece(boolean isWhite, Enum pieceIdentifier) {
        this.isWhite = isWhite;
        this.pieceIdentifier = pieceIdentifier;
    }

    public Enum getPieceIdentifier() {
        return pieceIdentifier;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean isWhite() {
        return isWhite;
    }
}
