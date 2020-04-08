package model;

import exceptions.IllegalDeplacementException;
import exceptions.IllegalPositionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class PartieTest {

    Partie partie;
    Partie mockPartie = mock(Partie.class); // mock de
    Plateau mockPlateau = mock(Plateau.class);
    Joueur joueur1 = mock(Joueur.class);

    @BeforeEach
    void setUp() { // appele a chaque test
        //intialise mes variables
        partie = new Partie(3);
        mockPlateau.taille = 3;
        mockPartie.plateau = mockPlateau;
        joueur1.pionType = 'x';
        joueur1.pion = new Pion('X');
    }

    @Test
    public void testMouvementLegal() {
        //0, 0 ne contient aucun pion et est une position valide
        assertTrue(partie.mouvementLegal(0, 0)); // doit etre true
        //0, 3 en revanche n'est pas valide .... donc IllegalPositionException est attendu
        assertThrows(IllegalPositionException.class, ()->partie.mouvementLegal(0, 3),"La Colonne  entrer n'est pas valide");
        partie.plateau.tableau[0][0] = partie.listeJoueurs.get(0).pion;
        //0, 0 ne contient maintenant un pion et est une position valide...donc IllegalDeplacementException est attendu
        assertThrows(IllegalDeplacementException.class, ()->partie.mouvementLegal(0, 0),"La Case est déja occupé");
    }

    @Test
    void testDeplacement() {

        /*int[] result = partie.deplacement(scanner);
        assertEquals(2, result[0]);
        assertEquals(1, result[1]);

        int[] result2 = partie.deplacement(scanner);
        assertEquals(-1, result[0]);
        assertEquals(-1, result[1]);*/

    }

    @Test
    void testVictoire() {
        partie.plateau = mockPlateau;
        //si le mock appelle la fonction alors return ce qui est indiqué
        // alignement sur la colonne 2
        when(mockPlateau.pionsAlignerVerticalementSurUneColonne(2)).thenReturn(true);
        // sur toutes les autres colonnes, lignes et digonales pas d'alignement
        when(mockPlateau.pionsAlignerVerticalementSurUneColonne(1)).thenReturn(false);
        when(mockPlateau.pionsAlignerVerticalementSurUneColonne(0)).thenReturn(false);
        when(mockPlateau.pionsAlignerHorizontalementSurUneLigne(anyInt())).thenReturn(false);
        when(mockPlateau.pionsAlignésDiagonalementDroite()).thenReturn(false);
        when(mockPlateau.pionsAlignésDiagonalementGauche()).thenReturn(false);
        //victoire car aligneement sur la colonne 2
        assertTrue(partie.victoire());

        //plus d'alignement sur la colonne 2
        when(mockPlateau.pionsAlignerVerticalementSurUneColonne(anyInt())).thenReturn(false);
        //maintenant plus de victoire
        assertFalse(partie.victoire());

    }

    @Test
    void testMatchNul() {

        //aucun alignement (pas de victoire)
        when(mockPlateau.pionsAlignerVerticalementSurUneColonne(anyInt())).thenReturn(false);
        when(mockPlateau.pionsAlignerHorizontalementSurUneLigne(anyInt())).thenReturn(false);
        when(mockPlateau.pionsAlignésDiagonalementDroite()).thenReturn(false);
        when(mockPlateau.pionsAlignésDiagonalementGauche()).thenReturn(false);
        //mettre des pions dans toutes les cases du tableau
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                partie.plateau.tableau[x][y] = new Pion('X');

            }
        }
        mockPlateau.tableau = partie.plateau.tableau; //copie le tableau dans notre mock objet
        partie.plateau = mockPlateau; // remplace le plateau par notre mock objet plateau
        assertTrue(partie.matchNul()); // match nul attendu

        mockPlateau.tableau[0][1] = null; // enleve un pion du tableau(toutes les  case ne sont plus occupés)
        assertFalse(partie.matchNul()); // pas de match nul attendu

        //maitenant toute la diagonale droite est occupé par des meme pions
        when(mockPlateau.pionsAlignésDiagonalementDroite()).thenReturn(true);
        mockPlateau.tableau[0][1] = new Pion('O');// toutes les cases sont occupes maintenat
        assertFalse(partie.matchNul()); // pas de match nul car victoire


    }
}
