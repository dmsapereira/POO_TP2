package Exceptions;

/**
 * An exception for when there's an attempt at creating a new <code>Account</code> with an e-mail that's already in use
 */
public class DuplicateEmailException extends Exception {
    private String email;
    public DuplicateEmailException(String email){
        super();
        this.email = email;

    }

    public String toString(){
        return "There is another account with email "+this.email+".";
    }
}
