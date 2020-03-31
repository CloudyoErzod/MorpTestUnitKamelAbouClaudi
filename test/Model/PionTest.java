package Model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PionTest {
    @Test
    public void joueur1(){// a qui de jouer, c est a moi
        Pion pion= new Pion();
        boolean CmonTour = true;
       assertEquals(true, pion.sonTour(true));
    }


    @Test
    public void joueur2(){// a qui de jouer, c est a moi
        Pion pion= new Pion();
        boolean CmonTour = true;
        assertNotEquals(false, pion.sonTour(true));
    }

    @Test
    public void peutMettreUnPion(){// puis je mettre un pion ,oui a l emplacement choisi
        Pion pion = new Pion();
        boolean possibleAjoutPion = true;
        assertEquals(true, pion.ajoutPion(true));

    }
    @Test
    public void nePeutPasMettreUnPion(){// puis je mettre un pion ,non a l emplacement choisi
        Pion pion = new Pion();
        boolean possibleAjoutPion = true;
        assertNotEquals(false, pion.ajoutPion(true));

    }

    @Test
    public void verifDesPionSiAligne(){// puis je mettre un pion ,oui a l emplacement choisi
        Pion pion = new Pion();
        boolean gagnantOupas = true;
        assertEquals(true, pion.pionAligne(true));

    }
    @Test
    public void verifDesPionSiPasAligne(){// puis je mettre un pion ,oui a l emplacement choisi
        Pion pion = new Pion();
        boolean gagnantOupas = true;
        assertNotEquals(false, pion.pionAligne(true));

    }



}

