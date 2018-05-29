package Exceptions;

public class NullWatchedMediaException extends Exception {
    public NullWatchedMediaException(){
        super();
    }

    public String toString(){ return "Can only rate recently seen shows.";}
}
