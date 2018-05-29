package User;

/**
 * A <code>Profile</code> with age restrictions
 */
public interface KidProfile extends Profile {
    /**
     * Returns the age rating
     * @return age rating
     */
    int getAgeRating();
}
