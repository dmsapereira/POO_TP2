package Exceptions;

/**
 * An exception for when the user tries to log into an account that's already logged in
 */
public class AccountLoggedInException extends Exception {
    public AccountLoggedInException(){
        super();
    }

    public String toString(){
        return "Client already logged in.";
    }
}
