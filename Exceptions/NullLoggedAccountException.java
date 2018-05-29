package Exceptions;

/**
 * An exception for when there's an attempt at using a command that requires a logged in <code>Account</code>, however there is no <code>Account</code> logged in
 */
public class NullLoggedAccountException extends Exception {
    public NullLoggedAccountException() {
        super();
    }

    public String toString() {
        return "No client is logged in.";
    }
}
