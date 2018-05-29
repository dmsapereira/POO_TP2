package Exceptions;

/**
 * An exception for when there's an attempt at creating a new <code>Profile</code>, however the <code>Account</code>'s <code>Plan</code> doesn't allow more <code>Profile</code>s
 */
public class ProfileLimitationOverflowException extends Exception{
    public ProfileLimitationOverflowException(){
        super();
    }

    public String toString(){
        return "Not possible to add more profiles.";
    }
}
