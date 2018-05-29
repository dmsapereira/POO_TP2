package Exceptions;

public class DeviceCapacityException extends  Exception {
    public DeviceCapacityException(){
        super();
    }
    public String toString(){
        return "Not possible to connect more devices.";
    }
}
