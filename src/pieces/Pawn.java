package pieces;

public class Pawn extends Piece {
    private boolean isMoved;

    public Pawn(boolean isWhite) {
        super(isWhite, PieceIdentifier.PAWN);
        this.isMoved=false;
    }

    public boolean isHasMoved() {
        return isMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.isMoved = hasMoved;
    }
}
