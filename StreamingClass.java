import Iterable.*;
import Media.*;

public class StreamingClass implements Streaming {

    private Array<AbsMedia> media;

    public StreamingClass() {
        this.media = new ArrayClass<AbsMedia>();
    }


    @Override
    public void uploadMovie(String name, String directorName, int duration, int ageRating, int debutDate, String genre, Array<String> cast) {
        media.insertLast(new MovieClass(name, directorName, duration, ageRating, debutDate, genre, cast));
    }

    @Override
    public void uploadShow(String name, String directorName, int numSeasons, int numEpisodes, int ageRating, int debutDate, String genre, Array<String> cast) {
        media.insertLast(new ShowClass(name, directorName, numSeasons, numEpisodes, ageRating, debutDate, genre, cast));
    }

    @Override
    public Iterator<Show> getShows() {
        AbsMedia current;
        Array<Show> aux = new ArrayClass<Show>(media.size());
        Iterator<AbsMedia> itera = media.iterator();
        while (itera.hasNext()) {
            current = itera.next();
            if (current instanceof Show)
                aux.insertLast((Show) current);
        }
        return aux.iterator();
    }

    @Override
    public Iterator<Movie> getMovies() {
        AbsMedia current;
        Array<Movie> aux = new ArrayClass<Movie>(media.size());
        Iterator<AbsMedia> itera = media.iterator();
        while (itera.hasNext()) {
            current = itera.next();
            if (current instanceof Movie)
                aux.insertLast((Movie) current);
        }
        return aux.iterator();
    }

}
