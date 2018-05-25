package Media;

public class RatedShow extends ShowClass implements Rated {
    private float rating;
    private int numRating;
    public RatedShow(Show twin, int rating){
        super(twin.toString(),twin.getDirector(),twin.getNumSeasons(),twin.getNumEpisodes(),twin.getAgeRating(),twin.getDebut(),twin.getGenre(),twin.getCast());
        this.rating=rating;
        this.numRating=1;
    }

    public RatedShow(RatedShow twin){
        super(twin.toString(),twin.getDirector(),twin.getNumSeasons(),twin.getNumEpisodes(),twin.getAgeRating(),twin.getDebut(),twin.getGenre(),twin.getCast());
        this.rating=twin.getRating();
         this.numRating=1;
    }


    @Override
    public float getRating() {
        return this.rating/this.numRating;
    }

    @Override
    public void addRating(int rating) {
        this.rating+=rating;
        numRating++;
    }
}
