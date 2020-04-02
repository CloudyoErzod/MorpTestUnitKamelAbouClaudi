package Model;

public class Joueur {
    /**
     *
     * il faut verifier si la colone, ligne ou diagonal sont
     * rempli pour le joueur
     *
     */
    public boolean aPerdu(boolean bPerdu) {
        return bPerdu;
    }
    /**
     *
     * il faut verifier si la colone, ligne ou diagonal sont
     * rempli pour le joueur
     *
     */
    public boolean aGagne(boolean bGagne) {
        return bGagne;
    }
    /**
     *
     * il faut verifier a qui est le tour par rapport
     * aux class Pion et Plateau
     *
     */
    public boolean tour(boolean bTour) {
        return bTour;
    }
    /**
     *
     * il faut verifier la position par rapport
     * a la class Plateau
     *
     */
    public int position(int y, int x) {
        return y + x;
    }
}