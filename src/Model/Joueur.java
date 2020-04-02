package Model;

public class Joueur {
    public boolean aPerdu(boolean bPerdu) {
        return bPerdu;
    }

    public boolean aGagne(boolean bGagne) {
        return bGagne;
    }

    public boolean tour(boolean bTour) {
        return bTour;
    }

    public int position(int y, int x) {
        return y + x;
    }
}