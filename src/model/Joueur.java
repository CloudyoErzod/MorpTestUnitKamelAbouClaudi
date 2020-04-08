package model;


import exceptions.IllegalDeplacementException;
import exceptions.IllegalPositionException;

/**
 * Classe representant un joueur dans le jeu Morpion
 */
public class Joueur {

    public Pion pion;
    public char pionType;

    public Joueur(char type) {
        pionType = type;
        pion = new Pion(type);
    }

    /**
     * action de placer un pion sur le plateau
     * @param partie partie en cours de jeu
     * @param row la ligne ou le pion va etre placé
     * @param col la colonne ou le pion va etre placé
     */
    public void placePion(Partie partie, int row, int col) {
        try {
            if(partie.mouvementLegal(row, col)) {   // verifie si le mouvement est permis
                partie.plateau.tableau[row][col] = pion; // si oui place le pion à cet endroit du tableau
            }
        } catch (IllegalPositionException ip ) { // en cas de mauvaise donné de ligne ou de colonne
            throw new IllegalPositionException(ip.getMessage()); // renvoie la meme erreur
        } catch (IllegalDeplacementException id) { // cas de case deja occupé
            throw new IllegalDeplacementException(id.getMessage()); // renvoi la meme erreur
        }
    }
}