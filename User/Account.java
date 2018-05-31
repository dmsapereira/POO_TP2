package User;
import Media.*;

import java.util.*;

/**
 * An account. Contains <code>Profile</code>s and <code>Device</code>s
 */
public interface Account {

    /**
     * Returns the email
     * @return email
     */
    String getEmail();

    /**
     * Returns the password
     * @return password
     */
    String getPassword();

    /**
     * Returns the <code>LinkedList</code> containing the <code>Device</code>s that are in use
     * @return <code>LinkedList</code> containing <code>Device</code>s
     */
    LinkedList<Device> getDevices();

    /**
     * Returns the <code>LinkedList</code> containing the <code>Profile</code>s
     * @return <code>LinkedList</code> containing <code>Profile</code>s
     */
    LinkedList<Profile> getProfiles();

    /**
     * Logs in on a <code>Device</code>, If it's the first time, adds it to <code>Set</code>
     * @param device <code>Device</code> for the log in
     * @pre Device!=null && loggedProfile==null && loggedDevices<maxDevices
     */
    void login(Device device);

    /**
     * Disconnects, leaving the current <code><Device/code> in use
     * @return <code>Device</code> currently in use
     * @pre loggedProfile!=null
     */
    Device disconnect();

    /**
     * Logs out, terminating the current <code>Device</code>'s connection
     * @return <code>Device</code> that was connected
     * @pre loggedProfile!=null
     */
    Device logout();

    /**
     * Returns the current <code>Plan</code>
     * @return current <code>Plan</code>
     */
    Plan getPlan();

    /**
     * Changes the <code>Plan</code>
     * @param newPlan new <code>Plan</code>
     * @pre newPlan!=currentPlan
     */
    void changePlan(Plan newPlan);

    /**
     * Returns the current <code>Plan</code>'s maximum <code>Device</code>s
     * @return maximum number of concurrent <code>Device</code>s
     */
    int getMaxDevices();

    /**
     * Adds a new standard <code>Profile</code>
     * @param name new <code>Profile</code>'s name
     * @pre no profile with same name && profiles<maxProfiles
     */
    void addNormalProfile(String name);

    /**
     * Adds a new <code>KidProfile</code>, with age restrictions
     * @param name new <code>Profile</code>'s name
     * @param age new <code>Profile</code>'s age restriction
     * @pre no profile with same name && age>=5 && profiles<maxProfiles
     */
    void addChildProfile(String name, int age);

    /**
     * Logs into another <code>Profile</code>
     * @param name <code>Profile</code>'s name
     * @pre profile with <code>name</code>!=null && loggedProfile==null
     */
    void logProfile(String name);

    /**
     * Returns the currently logged <code>Profile</code>
     * @return currently logged <code>Profile</code>
     */
    Profile getCurrentProfile();

    /**
     * Watches a <code>Media</code>
     * @param show <code>Media</code> in question
     * @pre <code>show</code>!=null
     */
    void watch(Media show);

    /**
     * Rates a <code>Media</code> that's been watched
     * @param media <code>Media</code> in question
     * @param rating rating to be given
     * @pre <code>media</code> is in watchedShows && 0<=<code>rating</code><=5
     */
    void rate(String media, int rating);

    /**
     * Searches for a <code>Profile</code> with the given name
     * @param name <code>Profile</code>'s name to search for
     * @return <code>Profile</code> with the given name
     */
    Profile searchProfileByName(String name);


}
