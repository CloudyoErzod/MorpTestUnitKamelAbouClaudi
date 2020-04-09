package exeptions;

/**
 * Exception survenant lorsqu'un pion veut
 * etre  placé sur une case occupé
 */
public class IllegalDeplacementException extends RuntimeException {

    public IllegalDeplacementException(String message) {
        super(message);
    }
}
