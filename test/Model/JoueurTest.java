package Model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JoueurTest {
    @Test
    public void aGange() {
        Joueur monJoueur = new Joueur();
        //boolean gagne;
        assertFalse(monJoueur.aGagne(true));
    }

    @Test
    public void aPerdu() {
        Joueur monJoueur = new Joueur();
        //boolean perd;
        assertFalse(monJoueur.aPerdu(true));
    }

    @Test
    public void tour(){
        Joueur monJoueur = new Joueur();
    }

    @Test
    public void position(){
        Joueur monJoueur = new Joueur();
    }
}