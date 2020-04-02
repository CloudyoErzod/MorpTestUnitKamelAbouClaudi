package Model;


import MyExeptions.LaCasePasVideExecption;
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
    // puis je mettre un pion ,oui a l emplacement choisi
    public void peutMettreUnPion() throws LaCasePasVideExecption {
        Pion pion = new Pion();
        assertTrue(pion.possibleAjoutPion(true));
    }
    @Test
    // puis je mettre un pion ,non a l emplacement choisi
    public void nePeutPasMettreUnPion(){
        Pion pion = new Pion();
        try {
            assertFalse(pion.possibleAjoutPion(false));
        }catch (LaCasePasVideExecption laCaseNestPasVide) {
            laCaseNestPasVide.printStackTrace();
        }
    }

    @Test
    public void verifDesPionSiAligne(){//
        Pion pion = new Pion();
        assertTrue(pion.pionAlinge(true));


    }
    @Test
    public void verifDesPionSiPasAligne(){//
        Pion pion = new Pion();
        assertFalse(pion.pionAlinge(false));


    }


}

