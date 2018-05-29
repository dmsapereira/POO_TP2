package Exceptions;

public class NullAccountException extends Exception {
    public NullAccountException(){
        super();
    }

    public String toString(){
        return "Account does not exist.";
    }
}
