package User;

public class DeviceClass implements Device {
    private String name;

    public DeviceClass(String name){
        this.name = name;

    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString(){ return this.name;}
}
