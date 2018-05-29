package Exceptions;


/**
 * An exception for when a <code>Kid Profile</code> tries to watch a show with an inappropriate age rating
 */
public class AgeRatingMismatchException extends Exception {
    public AgeRatingMismatchException(){
        super();
    }

    public String toString(){
        return "Show not available.";
    }
}
