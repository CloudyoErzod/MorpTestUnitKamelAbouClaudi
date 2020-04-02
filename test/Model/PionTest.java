package Model;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PionTest {

    @Test
    public void rond(){// a qui de jouer, c est a moi
        Pion pion= new Pion();

        assertTrue(pion.croixOuRond(true));

    }


    @Test
    public void croix(){// a qui de jouer, c est a moi
        Pion pion= new Pion();

        assertFalse(pion.croixOuRond(false));

    }


    @Test
    public void peutMettreUnPion(){// puis je mettre un pion ,oui a l emplacement choisi
        Pion pion = new Pion();
        boolean possibleAjoutPion = true;
        assertTrue(pion.possibleAjoutPion(true));


    }
    @Test
    public void nePeutPasMettreUnPion(){// puis je mettre un pion ,non a l emplacement choisi
        Pion pion = new Pion();
        boolean possibleAjoutPion = true;
        assertFalse(pion.possibleAjoutPion(false));


    }

    @Test
    public void verifDesPionSiAligne(){//
        Pion pion = new Pion();
        boolean gagnantOupas = true;
        assertTrue(pion.pionAlinge(true));


    }
    @Test
    public void verifDesPionSiPasAligne(){//
        Pion pion = new Pion();
        boolean gagnantOupas = true;
        assertFalse(pion.pionAlinge(false));


    }



}

