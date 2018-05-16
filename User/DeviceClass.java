package User;

public class DeviceClass implements Device {

    private boolean loggedIn;

    public DeviceClass(){
        loggedIn=false;
    }

    @Override
    public void login() {
        loggedIn=true;
    }

    @Override
    public void logout() {
        loggedIn=false;
    }

    @Override
    public boolean isLoggedIn() {
        return loggedIn;
    }
}
