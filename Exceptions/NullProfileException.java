package Exceptions;

/**
 * An exception for when there's an attempt at selecting a non-existent <code>Profile</code>
 */
public class NullProfileException extends Exception {
    public NullProfileException(){
        super();
    }

    public String toString(){
        return "Profile does not exist.";
    }
}
