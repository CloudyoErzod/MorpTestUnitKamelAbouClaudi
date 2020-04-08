package model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\rM O R P I O N");
        System.out.println("\rTaille du plateau:");
        Scanner scanner = new Scanner(System.in);
        Partie partie = null;
        boolean ok;
        do {
            try {
                ok = true;
                int taillePlateau = scanner.nextInt();
                partie = new Partie(taillePlateau);
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                System.out.println("Entrer la taille du plateau: ");
                ok = false;
            }
        } while(!ok);

        partie.jouer();

    }
}
