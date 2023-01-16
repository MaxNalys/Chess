package pieces;

public class Rook extends Piece {
    private boolean isMoved;

    public Rook(boolean isWhite) {
        super(isWhite, PieceIdentifier.ROOK);
        this.isMoved = false;
    }

    public void setHasMoved(boolean hasMoved) {
        this.isMoved = hasMoved;
    }

    public boolean isMoved() {
        return isMoved;
    }
}
