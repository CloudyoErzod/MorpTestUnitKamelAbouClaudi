package model;

/**
 * Represente un pion dans le jeur Morpion
 */
public class Pion {

    public char type;


    public Pion(char type) {
        this.type = type;
    }

    /**
     * Un Pion est representé par son type qui sera affiché sur le plateau
     * @return representation de ce pion en string
     */
    public String toString() {
        return "" + this.type;
    }
}
