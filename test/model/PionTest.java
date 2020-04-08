package model;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PionTest {

    Partie partie;
    Pion pion;

    @BeforeEach
    void setUp() {
        partie = new Partie(3);
        pion = partie.listeJoueurs.get(0).pion; // pion du 1er Jouer de la liste
    }

    @Test
    void testToString() {
        assertEquals("X", pion.toString());

    }
}

