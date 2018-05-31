package User;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceClass that = (DeviceClass) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}

