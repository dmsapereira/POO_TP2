package Media;

public class RatedMovie extends MovieClass implements Rated {
    private int numRatings;
    private float rating;
    public RatedMovie(Movie twin, int rating) {
        super(twin.toString(),twin.getDirector(),twin.getDuration(),twin.getAgeRating(),twin.getDebut(),twin.getGenre(),twin.getCast());
        this.rating=rating;
        this.numRatings=1;
    }

    public RatedMovie(RatedMovie twin) {
        super(twin.toString(),twin.getDirector(),twin.getDuration(),twin.getAgeRating(),twin.getDebut(),twin.getGenre(),twin.getCast());
        this.rating=twin.getRating();
        this.numRatings=1;
    }

    @Override
    public float getRating() {
        return this.rating/this.numRatings;
    }

    @Override
    public void addRating(int rating) {
        this.rating+=rating;
        numRatings++;
    }


}
