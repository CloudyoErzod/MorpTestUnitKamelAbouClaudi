package model;



import exceptions.IllegalDeplacementException;
import exceptions.IllegalPositionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JoueurTest {

    Joueur joueur;
    Partie partie;
    Plateau plateau;

    @BeforeEach
    void setUp() {
        //intialise mes globales variables
        partie = new Partie(3);
        joueur = partie.listeJoueurs.get(0);
        plateau = partie.plateau;
    }

    @Test
    /**
     * teste la methode placePion dans la classe joueur
     */
    void testplacePion() {

        //place un pion à 3, 2  --------- Une IllegalPositionException est attendu
        assertThrows(IllegalPositionException.class,
                ()->joueur.placePion(partie, 3, 2),
                "La ligne entrer n'est pas valide");

        //place un pion à 3, -1 --------- Une IllegalPositionException est attendu
        assertThrows(IllegalPositionException.class,
                ()->joueur.placePion(partie, 3, -1),
                "La Colonne entrer n'est pas valide");


        plateau.tableau[1][1] = joueur.pion; // (1, 1) contient pion
        //place un pion à 1, 1 --------- Une IllegalDeplacementException est attendu
        assertThrows(IllegalDeplacementException.class,
                ()->joueur.placePion(partie, 1, 1),
                "La Case est déja occupé");

        //place un pion à 1, 2 --------- Bonne position donc attendu a cette position est le pion placé
        joueur.placePion(partie, 1, 2);
        assertEquals('X', plateau.tableau[1] [2].type);
    }


}