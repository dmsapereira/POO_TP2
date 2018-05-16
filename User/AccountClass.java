package User;

import Media.Named;
import Iterable.*;

public class AccountClass implements Account, Named {

    private Plan plan;
    private String email, password, name;
    private Array<Device> devices;
    private Array<Profile> profiles;

    public AccountClass(String name, String email, String password, Device device) {
        plan = Plan.BASIC;
        devices = new ArrayClass<Device>(plan.getDeviceNum());
        profiles = new ArrayClass<Profile>(plan.getProfileNum());
        devices.insertLast(device);
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
    public Array<Device> getDevices() {
        return devices;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Array<Profile> getProfiles() {
        return profiles;
    }

    @Override
    public Plan getPlan() {
        return plan;
    }

    @Override
    public void changePlan(Plan plan) {
        Array<Device> newDevices = new ArrayClass<Device>(plan.getDeviceNum());
        Array<Profile> newProfiles = new ArrayClass<Profile>(plan.getProfileNum());
        for (int i = 0; i < this.plan.profileNum; i++)
            newProfiles.insertLast(profiles.get(i));
        for (int i = 0; i < this.plan.deviceNum; i++)
            newDevices.insertLast(devices.get(i));
        this.plan=plan;
        devices=newDevices;
        profiles=newProfiles;

    }

}
