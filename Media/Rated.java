package Media;

/**
 * A <code>Media</code> that has been rated
 */
public interface Rated extends Media {

    /**
     * Returns the rating
     * @return rating
     */
    float getRating();

    /**
     * Adds a rating
     * @param rating rating to add
     */
    void addRating(int rating);


}
