package Model;

public class Partie {
    Plateau plateau;

    public Partie(int taillePlateau) {
        plateau = new Plateau(taillePlateau);
    }

    public void jouer() {
        boolean joueurGagne = false;
        boolean egalite = false;
        int col, row;
        do {
            System.out.println(plateau);
            System.out.println("Choisissez une case.");
            System.out.println("Ligne (de 1 ŕ "+plateau.taillePlateau+") :");
            row = Lire.Entier() - 1;
            System.out.println("Colonne (de 1 ŕ "+plateau.taillePlateau+") :");
            col = Lire.Entier() - 1;
            if (plateau.jouer(row, col)) {
                if (plateau.victoire('X')) {
                    joueurGagne = true;
                    System.out.println(plateau);
                    System.out.println("Fin de partie.");
                } else {
                    if (plateau.victoire('O')) {
                        System.out.println(plateau);
                        System.out.println("Fin de partie.");
                    }
                }
            }
            if (plateau.fin() && joueurGagne == false) {
                egalite = true;
                System.out.println(plateau);
                System.out.println("Fin de partie. Egalité.");
            }
        } while (joueurGagne == false  && egalite == false);
    }


}
