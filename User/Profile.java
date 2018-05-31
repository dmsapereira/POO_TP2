package User;

import java.util.LinkedList;

import Media.*;

/**
 * A generic Profile
 */
public interface Profile {

    /**
     * Returns a <code>LinkedList</code> containing the profile's watched <code>Media</code>
     *
     * @return <code>LinkedList</code> containing watched <code>Media</code> in order of insertion
     */
    LinkedList<Media> getWatched();

    /**
     * Returns a <code>LinkedList</code> containing the profile's rated <code>Media</code>
     *
     * @return <code>LinkedList</code> containing the rated <code>Media</code> in order of insertion
     */
    LinkedList<Rated> getRated();

    /**
     * Watches a <code>Media</code>
     *
     * @param media <code>Media</code> to be watched
     * @pre <code>media</code>!=null
     */
    void watch(Media media);

    /**
     * Rates a <code>Media</code>
     *
     * @param name   <code>Media</code>'s name
     * @param rating rating to be given
     * @pre <code>Media</code> with <code>name</code> has been watched && 0<=<code>rating</code><=5
     */
    void rateMedia(String name, int rating);

    /**
     * Searches for a piece of <code>Media</code> with the given name
     *
     * @param name <code>Media</code>'s name to search for
     * @return <code>Media</code> with the given name
     */
    Media getWatchedMediaByName(String name);

    /**
     * Searches for a piece of <code>Rated</code> <code>Media</code> with the given name
     *
     * @param name <code>Rated</code> <code>Media</code>'s name to search for
     * @return <code>Rated</code> <code>Media</code> with the given name
     */
    Media getRatedMediaByName(String name);
}
