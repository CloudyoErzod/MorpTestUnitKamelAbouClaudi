package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlateauTest {

    Partie partie;

    @BeforeEach
    void setUp() {
        partie = new Partie(3);
    }


    @Test
    void testPionsAlignerHorizontalementSurUneLigne() {
        //tableau vide.. donc aucun alignement possible
        assertFalse(partie.plateau.pionsAlignerHorizontalementSurUneLigne(0));
        //ajoute des pions a toutes les cases de la ligne 2
        for(int i = 0; i < 3; i++) {
            partie.plateau.tableau[2][i] = partie.listeJoueurs.get(0).pion;
        }
        //vrai est attendu
        assertTrue(partie.plateau.pionsAlignerHorizontalementSurUneLigne(2));
    }

    @Test
    void testPionsAlignerVerticalementSurUneLigne() {
        //tableau vide.. donc aucun alignement possible
        assertFalse(partie.plateau.pionsAlignerVerticalementSurUneColonne(0));
        //ajoute des pions a toutes les cases de la colonne 1
        for(int i = 0; i < 3; i++) {
            partie.plateau.tableau[i][1] = partie.listeJoueurs.get(0).pion;
        }
        //vrai est attendu
        assertTrue(partie.plateau.pionsAlignerVerticalementSurUneColonne(1));
    }

    @Test
    void testPionsAlignerDiagonalementAGauche() {
        //tableau vide.. donc aucun alignement possible
        assertFalse(partie.plateau.pionsAlignésDiagonalementGauche());
        //ajoute des pions a toutes les cases de la diagonale gauche
        for(int i = 0; i < 3; i++) {
            partie.plateau.tableau[i][i] = partie.listeJoueurs.get(0).pion;
        }
        //vrai est attendu
        assertTrue(partie.plateau.pionsAlignésDiagonalementGauche());
    }

    @Test
    void testPionsAlignerDiagonalementADroite() {
        //tableau vide.. donc aucun alignement possible
        assertFalse(partie.plateau.pionsAlignésDiagonalementDroite());
        //ajoute des pions a toutes les cases de la diagonale droite
        for(int i = 0, j = 2; i < 3 && j >= 0; i++, j--) {
            partie.plateau.tableau[i][j] = partie.listeJoueurs.get(0).pion;
        }
        //vrai est attendu
        assertTrue(partie.plateau.pionsAlignésDiagonalementDroite());
    }

    @Test
    void testTostring() {
        StringBuilder builder = new StringBuilder();
        //test tableau vide
        builder.append("|   |   |   |").append("\n");
        builder.append("|   |   |   |").append("\n");
        builder.append("|   |   |   |").append("\n");
        //plateau encore vide
        assertEquals(builder.toString(), partie.plateau.toString());

        builder = new StringBuilder();
        //test tableau avec elements(0,0 joueur 1 et 2,1 joueur 2)
        builder.append("| X |   |   |").append("\n");
        builder.append("|   |   |   |").append("\n");
        builder.append("|   | O |   |").append("\n");

        //ajout d'element dans le plateau
        partie.plateau.tableau[0][0] = partie.listeJoueurs.get(0).pion;
        partie.plateau.tableau[2][1] = partie.listeJoueurs.get(1).pion;

        assertEquals(builder.toString(), partie.plateau.toString());
    }
}

