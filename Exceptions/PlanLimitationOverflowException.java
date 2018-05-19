package Exceptions;

public class PlanLimitationOverflowException extends Exception{
    public PlanLimitationOverflowException(){
        super();
    }

    public String toString(){
        return "Cannot downgrade membership plan at the moment.";
    }
}
