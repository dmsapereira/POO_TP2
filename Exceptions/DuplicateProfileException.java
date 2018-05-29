package Exceptions;

/**
 * An exception for when there's an attempt at creating a new <code>Profile</code> with a name that's already in use
 */
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
