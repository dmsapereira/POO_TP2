package Exceptions;

public class OtherAccountLoggedInException extends Exception {
    public OtherAccountLoggedInException(){
        super();
    }

    public String toString(){
        return "Another client is logged in.";
    }
}
