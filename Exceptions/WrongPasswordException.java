package Exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException(){
        super();
    }

    public String toString(){
        return "Wrong password.";
    }
}
