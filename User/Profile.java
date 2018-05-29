package User;
import java.util.*;
import Media.*;

/**
 * A generic Profile
 */
public interface Profile {

    /**
     * Returns a LinkedHashMap containing the profile's watched <code>Media</code>
     * @return <code>LinkedHashMap</code> containing watched <code>Media</code> in order of insertion
     */
    LinkedHashMap<String,Media> getWatched();

    /**
     * Returns a LinkedHashMap containing the profile's rated <code>Media</code>
     * @return <code>LinkedHashMap</code> containing the rated <code>Media</code> in order of insertion
     */
    LinkedHashMap<String,Rated> getRated();

    /**
     * Watches a <code>Media</code>
     * @param media <code>Media</code> to be watched
     * @pre <code>media</code>!=null
     */
    void watch(Media media);

    /**
     * Rates a <code>Media</code>
     * @param name <code>Media</code>'s name
     * @param rating rating to be given
     * @pre <code>Media</code> with <code>name</code> has been watched && 0<=<code>rating</code><=5
     */
    void rateMedia(String name, int rating);

}
