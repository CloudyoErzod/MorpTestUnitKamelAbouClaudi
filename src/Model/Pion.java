package Model;

import MyExeptions.LaCasePasVideExecption;

public class Pion {
public static final  char croix = 'X';
public static final char  rond = 'O';

    public Pion() {
    }

    // croix true , rond false
    public boolean croixOuRond( boolean croixOuRond ) {
        return croixOuRond;
    }

// possible ajout pion(croix et/ou rond) true emplacement dispo , false  car emplacemnt non dispo
    public boolean possibleAjoutPion( boolean possibleAjoutPion ) throws LaCasePasVideExecption {
        if (false){
            throw  new LaCasePasVideExecption("Utilisez une autre case, car elle n'est pas vide");
        }
        return possibleAjoutPion;
    }

//verifie si les pion(croix et/ou rond) sont alinge
    public boolean pionAlinge( boolean pionAligne ) {
        return pionAligne ;
    }


}
