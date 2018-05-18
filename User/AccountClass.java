package User;

import java.util.*;

public class AccountClass implements Account {

    private Plan plan;
    private String email, password, name;
    private int maxDevices;
    private Set<Device> devices;
    private Set<Profile> profiles;

    public AccountClass(String name, String email, String password, Device device) {
        plan = Plan.BASIC;
        devices = new LinkedHashSet<>(plan.getDeviceNum());
        profiles = new LinkedHashSet<>(plan.getProfileNum());
        devices.add(device);
        this.name = name;
        this.email = email;
        this.password = password;
        maxDevices= plan.deviceNum;
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
    public Set<Device> getDevices() {
        return devices;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<Profile> getProfiles() {
        return profiles;
    }

    @Override
    public Plan getPlan() {
        return plan;
    }

    @Override
    public void changePlan(Plan plan) {
            maxDevices = plan.deviceNum;
            this.plan = plan;
    }

    @Override
    public int getMaxDevices() {
        return maxDevices;
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
}
