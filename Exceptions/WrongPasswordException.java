package Exceptions;

/**
 * An exception for when there's an attempt at logging into an <code>Account</code> with the wrong credentials
 */
public class WrongPasswordException extends Exception {
    public WrongPasswordException(){
        super();
    }

    public String toString(){
        return "Wrong password.";
    }
}
