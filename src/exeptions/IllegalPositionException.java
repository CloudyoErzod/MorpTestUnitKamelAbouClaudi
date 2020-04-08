package exceptions;

/**
 * Exception survenant lorsqu'un veut
 * etre place en dehors du tableau
 */
public class IllegalPositionException extends RuntimeException {

    public IllegalPositionException(String message) {
        super(message);
    }
}
