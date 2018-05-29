package Exceptions;

/**
 * An exception for when there's an attempt at rating a <code>Media</code> that has not been watched, yet, exists
 */
public class NullWatchedMediaException extends Exception {
    public NullWatchedMediaException(){
        super();
    }

    public String toString(){ return "Can only rate recently seen shows.";}
}
