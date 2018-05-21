package Exceptions;

public class NullMediaException extends Exception {
    public NullMediaException(){
        super();
    }

    public String toString(){
        return "Show does not exist.";
    }
}
