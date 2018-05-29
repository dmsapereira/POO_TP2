package Media;

/**
 * A Movie. Differs from the <code>Media</code> because it has a duration
 */
public interface Movie extends Media {

    /**
     * Returns the duration
     * @return duration
     */
    int getDuration();
}
