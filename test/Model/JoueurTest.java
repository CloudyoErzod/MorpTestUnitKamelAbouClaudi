package Model;
import MyExeptions.MonTourExeption;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class JoueurTest {
    @Test
    public void sePositionneTest() {
        Joueur monJoueur = new Joueur();
        int y = 1, x = 2;
        assertEquals(2, monJoueur.sePositionne(y,x));
    }

    @Test
    public void positionTest(){
        Joueur monJoueur = new Joueur();
        int y = 1, x = 1;
        assertEquals( 2, monJoueur.position(y,x));
    }

    @Test
    public void aGagneTest() {
        Joueur monJoueur = new Joueur();
        //boolean gagne;
        assertFalse(monJoueur.aGagne(false));
    }

    @Test
    public void aPerduTest() {
        Joueur monJoueur = new Joueur();
        //boolean perd;
        assertFalse(monJoueur.aPerdu(false));
    }

    @Test
    public void tourTest(){
        Joueur monJoueur = new Joueur();
        try {
            assertFalse(monJoueur.tour(false));
        } catch (MonTourExeption monTourExeption) {
            monTourExeption.printStackTrace();
        }
    }

}