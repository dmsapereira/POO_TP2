package Exceptions;

/**
 * An exception for when a user exceeds his <code>Plan</code>'s device capacity
 */
public class DeviceCapacityException extends  Exception {
    public DeviceCapacityException(){
        super();
    }
    public String toString(){
        return "Not possible to connect more devices.";
    }
}
