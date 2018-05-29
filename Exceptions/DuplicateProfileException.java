package Exceptions;

public class DuplicateProfileException extends Exception {
    private String name;
    public DuplicateProfileException(String name){
        super();
        this.name=name;

    }

    public String toString(){
        return "There is already a profile "+this.name+".";
    }
}
