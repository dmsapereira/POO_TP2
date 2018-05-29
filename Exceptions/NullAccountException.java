package Exceptions;

/**
 * An exception for when there's an attempt at logging in to a non-existent <code>Account</code>
 */
public class NullAccountException extends Exception {
    public NullAccountException(){
        super();
    }

    public String toString(){
        return "Account does not exist.";
    }
}
