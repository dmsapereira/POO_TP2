package Exceptions;

/**
 * An exception for when there's an attempt at changing an <code>Account</code>'s <code>Plan</code> to the same plan
 */
public class DuplicatePlanException extends Exception {
    public DuplicatePlanException(){
        super();
    }
    public String toString(){
        return "No membership plan change.";
    }
}
