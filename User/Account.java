package User;
import java.util.*;

public interface Account {

    String getName();

    String getEmail();

    String getPassword();

    Set<Device> getDevices();

    Set<Profile> getProfiles();

    Plan getPlan();

    void changePlan(Plan newPlan);

    int getMaxDevices();

}
