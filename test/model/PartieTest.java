package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;


public class PartieTest {

    Partie partie ;
    Scanner scanner;

    @BeforeEach
    void setUp() throws FileNotFoundException { // appele a chaque test
        //intialise mes variable
        partie = new Partie(3);
    }

    @Test
    void testJoueur1Gagne() throws FileNotFoundException {
        File test = new File("src/test/resources/jouer1Gagne.txt");
        scanner = new Scanner(test);
        partie.scanner = scanner;
        partie.jouer();
        assertEquals('X', partie.plateau.typeDePionAligne);
        assertFalse(partie.matchNul());
        assertTrue(partie.victoire());
        scanner.close();
    }

    @Test
    void testMatchNull() throws FileNotFoundException {
        File test = new File("src/test/resources/matchNull.txt");
        scanner = new Scanner(test);
        partie.scanner = scanner;
        partie.jouer();
        assertTrue(partie.matchNul());
        assertFalse(partie.victoire());
        scanner.close();
    }
}
