package Media;

import java.util.LinkedList;

public class ShowClass extends AbsMedia implements Show {
    private int numSeasons, numEpisodes;

    public ShowClass(String name, String directorName, int numSeasons, int numEpisodes, int ageRating, int debutDate, String genre, LinkedList<String> cast) {
        super(name, directorName, ageRating, debutDate, genre, cast);
        this.numSeasons = numSeasons;
        this.numEpisodes = numEpisodes;

    }

    @Override
    public int getNumSeasons() {
        return numSeasons;
    }

    @Override
    public int getNumEpisodes() {
        return numEpisodes;
    }
}
