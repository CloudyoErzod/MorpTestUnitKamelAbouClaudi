package Model;

public class Main {
    public static void main(String[] args) {

        System.out.println("\rM O R P I O N");
        System.out.println("\rTaille du plateau (standard: 3) :");
        int taillePlateau = 3;
        Partie p = new Partie(taillePlateau);
        p.jouer();

    }
}
