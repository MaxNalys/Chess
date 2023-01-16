package pieces;

public class King extends Piece {
    private boolean isMoved;

    public King(boolean isWhite) {
        super(isWhite, PieceIdentifier.KING);
        this.isMoved = false;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved = moved;
    }
}
