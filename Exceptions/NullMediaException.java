package Exceptions;

/**
 * An exception for when there's an attempt at watching or rating a non-existent <code>Media</code>
 */
public class NullMediaException extends Exception {
    public NullMediaException(){
        super();
    }

    public String toString(){
        return "Show does not exist.";
    }
}
