package Exceptions;

/**
 * An exception for when there's an attempt at changing a <code>Plan</code>, however the current conditions of the <code>Account</code> do not allow it (too many <code>Device</code>s or <code>Profile</code>s)
 */
public class PlanLimitationOverflowException extends Exception{
    public PlanLimitationOverflowException(){
        super();
    }

    public String toString(){
        return "Cannot downgrade membership plan at the moment.";
    }
}
