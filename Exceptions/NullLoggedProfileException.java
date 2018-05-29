package Exceptions;

/**
 * An exception for when there's an attempt at executing a command that requires a logged in <code>Profile</code>, however there is no <code>Profile</code> in use
 */
public class NullLoggedProfileException extends Exception {
    public NullLoggedProfileException(){
        super();
    }

    public String toString(){
        return "No profile is selected.";
    }
}
