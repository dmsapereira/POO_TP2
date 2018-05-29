package Exceptions;

public class DuplicatePlanException extends Exception {
    public DuplicatePlanException(){
        super();
    }
    public String toString(){
        return "No membership plan change.";
    }
}
