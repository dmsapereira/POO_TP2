package Media;

/**
 * A Show. Differs from <code>Media</code> because it has a number of seasons and episodes per season
 */
public interface Show extends Media {

    /**
     * Returns the number of seasons
     * @return number of seasons
     */
    int getNumSeasons();

    /**
     * Returns the number of episodes per season
     * @return number of episodes per season
     */
    int getNumEpisodes();
}
