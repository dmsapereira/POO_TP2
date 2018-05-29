package Exceptions;

/**
 * An exception for when there's an attempt at rating a <code>Media</code> that's already been rated
 */
public class DuplicateRatedMediaException extends Exception {
    public DuplicateRatedMediaException(){
        super();
    }

    public String toString(){ return "Show already rated.";}
}
