package Exceptions;

/**
 * An exception for when there's an attempt at logging into an <code>Account</code> when there's another one already logged in
 */
public class OtherAccountLoggedInException extends Exception {
    public OtherAccountLoggedInException(){
        super();
    }

    public String toString(){
        return "Another client is logged in.";
    }
}
