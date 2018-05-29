package Exceptions;

public class NullProfileException extends Exception {
    public NullProfileException(){
        super();
    }

    public String toString(){
        return "Profile does not exist.";
    }
}
