package Exceptions;

public class ProfileLimitationOverflowException extends Exception{
    public ProfileLimitationOverflowException(){
        super();
    }

    public String toString(){
        return "Not possible to add more profiles.";
    }
}
