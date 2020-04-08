package model;


/**
 * Represente le plateau du jeu Morpion( un carré )
 */
public class Plateau {

    public int taille;
    public  Pion[][] tableau;
    public  char typeDePionAligne;


    public Plateau(int taille) {
        this.taille = taille;
        tableau = new Pion[taille][taille];
        for (int x = 0; x < taille; x++) {   // initialise le plateau
            for (int y=0; y < taille; y++) {
                tableau[x][y] = null;   // aucun pion
            }
        }
    }


    /**
     * Etat du tableau en string
     * @return
     */
    public String toString() {
        StringBuilder builder = new StringBuilder(); // contructeur de string(vide)
        for(int i = 0; i < taille; i++) { //forme une ligne a chaque fin de la boucle interieur
            builder.append("|"); // ajoute cet element a mon string
            for(int j = 0; j < taille; j++) {
                if(tableau[i][j] == null) {
                    builder.append(" ").append(" ");
                } else {
                    builder.append(" ").append(tableau[i][j]); //si un pion est sur le tableau a
                    // cette positon, ajoute son type dans mon string
                }
                builder.append(" |"); // fin de la ligne
            }
            builder.append("\n"); // va a la ligne
        }
        return  builder.toString();
    }

    /**
     * vertifie si toutes case de cette ligne
     * sont occupés par des pions de meme type
     * @param row ligne a verifier
     * @return true si effectivement toute cette
     *         ligne est occupé par les memes pions
     */
    public boolean pionsAlignerHorizontalementSurUneLigne(int row) {
        char type;
        if(tableau[row][0]!= null) {
            type = tableau[row][0].type; // recupere le type de pion dans la 1er case de la ligne a verifier
        } else {                   //si elle est vide(la case) alors  pas d'alignement
            return false;
        }
        for(int i = 1; i < taille; i++) { //on verifie la suite
            if(tableau[row][i] != null) { // si une case n'est pas vide
                if(tableau[row][i].type != type) { //et son type n'est pas du meme type que la 1er casese
                    return false;         // retourner pas d'alignement
                }
            } else {       // case vide
                return false;  // pas d'alignement
            }
        }
        //si pas de retour jusqu'ici alors alignement
        typeDePionAligne = type;
        return true;
    }

    /**
     * vertifie si toutes case de cette colonne
     * sont occupés par des pions de meme type
     * @param col ligne a verifier
     * @return true si effectivement toute cette
     *         colonne est occupé par les memes pions
     */
    public boolean pionsAlignerVerticalementSurUneColonne(int col) {
        char type;
        if(tableau[0][col] != null) {
            type = tableau[0][col].type;
        } else {
            return false;
        }
        for(int i = 1; i < taille; i++) {   // meme principe que la methode precedente
            if(tableau[i][col] != null) {
                if(tableau[i][col].type != type) {
                    return false;
                }
            } else {
                return false;
            }
        }
        typeDePionAligne = type;
        return true;
    }

    /**
     * vertifie si toutes case de la diagonale
     * comprenant la premiere case du haut à gauche
     * sont occupés par des pions de meme type
     * @return true si effectivement toute cette
     *         diagonale est occupé par les memes pions
     */
    public boolean pionsAlignésDiagonalementGauche() {
        char type;
        if(tableau[0][0] != null) {
            type = tableau[0][0].type;
        } else {
            return false;
        }
        for(int i = 1; i < taille; i++) {
            if(tableau[i][i] != null) {
                if(tableau[i][i].type != type) {
                    return false;
                }
            } else {
                return false;
            }
        }
        typeDePionAligne = type;
        return true;
    }

    /**
     * vertifie si toutes case de la diagonale
     * comprenant la dernière case du haut à droite
     * sont occupés par des pions de meme type
     * @return true si effectivement toute cette
     *         diagonale est occupé par les memes pions
     */
    public boolean pionsAlignésDiagonalementDroite() {
        char type;
        if(tableau[0][taille - 1]!= null) {
            type = tableau[0][taille - 1].type;
        } else {
            return false;
        }
        for(int i = 1, j = taille - 2; i < taille && j >= 0; i++, j--) {
            if(tableau[i][j] != null) {
                if(tableau[i][j].type != type) {
                    return false;
                }
            } else {
                return false;
            }
        }
        typeDePionAligne = type;
        return true;
    }
}

