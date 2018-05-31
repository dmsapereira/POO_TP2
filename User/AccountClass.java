package User;

import Media.*;

import java.util.*;

public class AccountClass implements Account {

    private Plan plan;
    private String email, password, name;
    private Device loggedDevice;
    private Profile currentProfile;
    private LinkedList<Device> devices;//LinkedHashMap for it's ease of returning specific values and preservation of insertion order
    private LinkedList<Profile> profiles;

    public AccountClass(String name, String email, String password, Device device) {
        plan = Plan.BASIC;
        devices = new LinkedList<>();
        profiles = new LinkedList<>();
        devices.add(device);
        loggedDevice = device;
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
    public LinkedList<Device> getDevices() {
        return devices;
    }

    @Override
    public LinkedList<Profile> getProfiles() {
        return profiles;
    }

    @Override
    public void login(Device device) {
        if (!devices.contains(device))
            devices.add(device);
        loggedDevice = device;
    }

    @Override
    public Device disconnect() {
        Device removedDevice = loggedDevice;
        devices.remove(loggedDevice);
        loggedDevice = null;
        currentProfile=null;
        return removedDevice;
    }

    @Override
    public Device logout() {
        Device currentDevice = loggedDevice;
        loggedDevice = null;
        currentProfile=null;
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
    public void addNormalProfile(String name) {
        profiles.add(new StandardProfileClass(name));

    }

    @Override
    public void addChildProfile(String name, int age) {
        profiles.add(new KidProfileClass(name, age));

    }

    @Override
    public void logProfile(String name) {
        currentProfile=searchProfileByName(name);
    }

    @Override
    public Profile getCurrentProfile() {
        return currentProfile;
    }

    @Override
    public void watch(Media media) {
        currentProfile.watch(media);
    }

    @Override
    public void rate(String media, int rating) {
        currentProfile.rateMedia(media,rating);
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

   @Override
    public Profile searchProfileByName(String name){
        for(Profile profile: profiles){
            if (profile.toString().equals(name))
                return profile;
        }
        return null;
    }
}
