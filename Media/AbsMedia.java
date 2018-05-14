package Media;
import Iterable.Array;

public class AbsMedia implements Media, Named {
    private String name,directorName,genre;
    private int ageRating,debutDate;
    private Array<String> cast;


    public AbsMedia(String name, String directorName, int ageRating, int debutDate, String genre, Array<String> cast ){
        this.name=name;
        this.directorName=directorName;
        this.ageRating=ageRating;
        this.debutDate=debutDate;
        this.genre=genre;
        this.cast=cast;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDirector() {
        return directorName;
    }

    @Override
    public int getAgeRating() {
        return ageRating;
    }

    @Override
    public int getDebut() {
        return debutDate;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public Array<String> getCast() {
        return cast;
    }

}
