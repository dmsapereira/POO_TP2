package Exceptions;

/**
 * An exception for when there's an attempt at iterating an empty list of watched <code>Media</code>
 */
public class MediaIterationException extends Exception {
    public MediaIterationException(){super();}

    public String toString(){ return "No show found.";}

}
