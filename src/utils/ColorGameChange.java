package utils;

public class ColorGameChange {
    boolean isWhite;

    public ColorGameChange() {
        this.isWhite = true;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void gameChangeColour() {
        isWhite = !isWhite();
    }
}
