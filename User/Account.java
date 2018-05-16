package User;
import Iterable.*;

public interface Account {

    String getEmail();

    String getPassword();

    Array<Device> getDevices();

    Array<Profile> getProfiles();

    Plan getPlan();

    void changePlan(Plan newPlan);

}
