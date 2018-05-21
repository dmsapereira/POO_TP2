package Media;

import java.util.Set;

public class MovieClass extends AbsMedia implements Movie {
    private int duration;

    public MovieClass(String name, String directorName, int duration, int ageRating, int debutDate, String genre, Set<String> cast) {
        super(name, directorName, ageRating, debutDate, genre, cast);
        this.duration = duration;
    }

    @Override
    public int getDuration() {
        return duration;
    }
}