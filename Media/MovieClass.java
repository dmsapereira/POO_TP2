package Media;

import Iterable.Array;

public class MovieClass extends AbsMedia implements Movie {
    private int duration;

    public MovieClass(String name, String directorName, int duration, int ageRating, int debutDate, String genre, Array<String> cast) {
        super(name, directorName, ageRating, debutDate, genre, cast);
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }
}