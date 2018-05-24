package Media;

import java.util.Set;

public class RatedMovie extends MovieClass implements Rated {
    private int rating,numRatings;
    public RatedMovie(Movie twin, int rating) {
        super(twin.toString(),twin.getDirector(),twin.getDuration(),twin.getAgeRating(),twin.getDebut(),twin.getGenre(),twin.getCast());
        this.rating=rating;
        this.numRatings=1;
    }

    @Override
    public float getRating() {
        return this.rating/this.numRatings;
    }

    @Override
    public void addRating(int rating) {
        this.rating+=rating;
    }


}
