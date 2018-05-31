package Media;
import java.util.LinkedList;
import java.util.Set;

/**
 * A piece of indistinguishable Media, whether it be a <code>Show</code> or <code>Movie</code>
 */
public interface Media {

    /**
     * Returns the director's name
     * @return director's name
     */
    String getDirector();

    /**
     * Returns the age rating
     * @return age rating
     */
    int getAgeRating();

    /**
     * Returns the debut date
     * @return debut date
     */
    int getDebut();

    /**
     * Returns the genre
     * @return genre
     */
    String getGenre();

    /**
     * Returns a <code>List</code> containing the cast
     * @return <code>List</code> containing the cast
     */
    LinkedList<String> getCast();

}
