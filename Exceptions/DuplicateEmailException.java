package Exceptions;

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
