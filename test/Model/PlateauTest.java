package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PlateauTest {


    /**
     * Test de la methode <code>setCase</code> : on regarde si
     * on gagne avec une colonne.
     *
     */
    @Test
    public void testSetCaseCaseColonne() {
        Plateau monPlateau = new Plateau();
        monPlateau.TestCaseCol(0,0);
        monPlateau.TestCaseCol(1,0);
        monPlateau.TestCaseCol(0,1);
        monPlateau.TestCaseCol(1,1);
        assertTrue( monPlateau.TestCaseCol(0,2));
        //assertEquals(Pion.CROIX, Joueur.getJoueur());
    }
    /**
     * Test de la methode <code>setCase</code> : on regarde si
     * on gagne avec une ligne.
     *
     */
    @Test
    public void testSetCaseCaseLigne(){
        Plateau monPlateau = new Plateau();
        monPlateau.TestCaseLigne(2,2);
        monPlateau.TestCaseLigne(0,0);
        monPlateau.TestCaseLigne(0,1);
        monPlateau.TestCaseLigne(1,0);
        monPlateau.TestCaseLigne(1,1);
        assertTrue(monPlateau.TestCaseLigne(2,0));
        //assertEquals(Pion.ROND, Joueur.getJoueur());

    }
    /**
     * Test de la methode <code>setCase</code> : on regarde si
     * on gagne avec une diagonale.
     *
     */
    @Test
    public void testSetCaseCaseDiagonale() {
        Plateau monPlateau = new Plateau();
        monPlateau.TestCaseDiagonal(0,0);
        monPlateau.TestCaseDiagonal(0,1);
        monPlateau.TestCaseDiagonal(1,1);
        monPlateau.TestCaseDiagonal(1,2);
        assertTrue(monPlateau.TestCaseDiagonal(2,2));
       // assertEquals(Pion.CROIX, Joueur.getJoueur());
    }


}

