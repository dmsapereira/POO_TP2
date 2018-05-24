package Media;

public class RatedShow extends ShowClass implements Rated {
    private int rating,numRating;
    public RatedShow(Show twin, int rating){
        super(twin.toString(),twin.getDirector(),twin.getNumSeasons(),twin.getNumEpisodes(),twin.getAgeRating(),twin.getDebut(),twin.getGenre(),twin.getCast());
        this.rating=rating;
        this.numRating=1;
    }


    @Override
    public float getRating() {
        return this.rating/numRating;
    }

    @Override
    public void addRating(int rating) {
        this.rating+=rating;
    }
}
