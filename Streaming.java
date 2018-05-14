import Iterable.*;
import Media.*;

public interface Streaming {

    void uploadMovie(String name, String directorName, int duration, int ageRating, int debutDate, String genre, Array<String> cast);

    void uploadShow(String name, String directorName, int numSeasons, int numEpisodes, int ageRating, int debutDate, String genre, Array<String> cast);

    Iterator<Show> getShows();

    Iterator<Movie> getMovies();
}
