package Exceptions;

public class AccountLoggedInException extends Exception {
    public AccountLoggedInException(){
        super();
    }

    public String toString(){
        return "Client already logged in.";
    }
}
