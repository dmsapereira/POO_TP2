package Exceptions;

public class NullLoggedProfileException extends Exception {
    public NullLoggedProfileException(){
        super();
    }

    public String toString(){
        return "No profile is selected.";
    }
}
