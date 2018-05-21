package User;
import Media.*;

import java.util.*;

public interface Account {

    String getName();

    String getEmail();

    String getPassword();

    LinkedHashMap<String,Device> getDevices();

    LinkedHashMap<String,Profile> getProfiles();

    LinkedHashMap<String, Media> getWatched(String profile);

    LinkedHashMap<String, Integer> getRated(String profile);

    void login(Device device);

    Device disconnect();

    Device logout();

    Plan getPlan();

    void changePlan(Plan newPlan);

    int getMaxDevices();

    void addNormalProfile(String name);

    void addChildProfile(String name, int age);

    void logProfile(String name);

    Profile getCurrentProfile();

    Profile getProfile(String name);

    void watch(Media show);

    void rate(String media, int rating);



}
