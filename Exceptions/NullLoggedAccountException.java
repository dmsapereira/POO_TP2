package Exceptions;

public class NullLoggedAccountException extends Exception {
    public NullLoggedAccountException(){
        super();
    }

    public String toString(){
        return "No client is logged in.";
    }
}
