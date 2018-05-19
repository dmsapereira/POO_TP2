package User;

import java.util.*;

public class AccountClass implements Account {

    private Plan plan;
    private String email, password, name;
    private Device loggedDevice;
    private LinkedHashMap<String,Device> devices;
    private LinkedHashMap<String,Profile> profiles;

    public AccountClass(String name, String email, String password, Device device) {
        plan = Plan.BASIC;
        devices = new LinkedHashMap<>();
        profiles = new LinkedHashMap<>();
        devices.put(device.getName(),device);
        loggedDevice=device;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public LinkedHashMap<String,Device> getDevices() {
        return devices;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LinkedHashMap<String,Profile> getProfiles() {
        return profiles;
    }

    @Override
    public void login(Device device) {
        if(!devices.containsValue(device))
            devices.put(device.getName(),device);
        loggedDevice=device;
    }

    @Override
    public Device disconnect() {
        Device removedDevice=loggedDevice;
        devices.remove(loggedDevice.getName());
        loggedDevice=null;
        return removedDevice;
    }

    @Override
    public Device logout() {
        Device currentDevice=loggedDevice;
        loggedDevice=null;
        return currentDevice;
    }


    @Override
    public Plan getPlan() {
        return plan;
    }

    @Override
    public void changePlan(Plan plan) {
            this.plan = plan;
    }

    @Override
    public int getMaxDevices() {
        return plan.getDeviceNum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountClass that = (AccountClass) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return name;
    }
}
