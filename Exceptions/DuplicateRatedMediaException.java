package Exceptions;

public class DuplicateRatedMediaException extends Exception {
    public DuplicateRatedMediaException(){
        super();
    }

    public String toString(){ return "Show already rated.";}
}
