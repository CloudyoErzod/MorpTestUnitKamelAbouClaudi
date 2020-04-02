package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PlateauTest {


    /**
     * Test de la methode <code>setCase</code> : on regarde si
     * on gagne avec une colonne.
     *
     */
    @Test
    public void testCaseColonne() {
        Plateau monPlateau = new Plateau(3);
//        monPlateau.TestCaseCol(0,0);
//        monPlateau.TestCaseCol(1,0);
//        monPlateau.TestCaseCol(0,1);
//        monPlateau.TestCaseCol(1,1);
        assertTrue( monPlateau.TestCaseCol(0,2));
        assertEquals(Pion.croix, Joueur.Joueur1);
    }
    /**
     * Test de la methode <code>setCase</code> : on regarde si
     * on gagne avec une ligne.
     *
     */
    @Test
    public void testCaseLigne(){
        Plateau monPlateau = new Plateau(3);
//        monPlateau.TestCaseLigne(2,2);
//        monPlateau.TestCaseLigne(0,0);
//        monPlateau.TestCaseLigne(0,1);
//        monPlateau.TestCaseLigne(1,0);
//        monPlateau.TestCaseLigne(1,1);
        assertTrue(monPlateau.TestCaseLigne(2,0));
        assertEquals(Pion.rond, Joueur.Joueur2);

    }
    /**
     * Test de la methode <code>setCase</code> : on regarde si
     * on gagne avec une diagonale.
     *
     */
    @Test
    public void testCaseDiagonale() {
        Plateau monPlateau = new Plateau(3);
//        monPlateau.TestCaseDiagonal(0,0);
//        monPlateau.TestCaseDiagonal(0,1);
//        monPlateau.TestCaseDiagonal(1,1);
//        monPlateau.TestCaseDiagonal(1,2);
        assertTrue(monPlateau.TestCaseDiagonal(2,2));
        assertEquals(Pion.croix, Joueur.Joueur1);
    }


}

