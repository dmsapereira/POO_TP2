package User;
import java.util.*;

public interface Account {

    String getName();

    String getEmail();

    String getPassword();

    LinkedHashMap<String,Device> getDevices();

    LinkedHashMap<String,Profile> getProfiles();

    void login(Device device);

    Device disconnect();

    Device logout();
    Plan getPlan();

    void changePlan(Plan newPlan);

    int getMaxDevices();

}
