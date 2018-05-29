package Media;
import java.util.Objects;
import java.util.Set;


public class AbsMedia implements Media,Comparable<Media> {
    private String name,directorName,genre;
    private int ageRating,debutDate;
    private Set<String> cast;//A Set has been used for it's ease of Iteration and preservation of insertion order (we use a LinkedHashSet)


    public AbsMedia(String name, String directorName, int ageRating, int debutDate, String genre, Set<String> cast ){
        this.name=name;
        this.directorName=directorName;
        this.ageRating=ageRating;
        this.debutDate=debutDate;
        this.genre=genre;
        this.cast=cast;
    }

    public String toString(){ return this.name;}//facilitates print methods

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
    public Set<String> getCast() {
        return cast;
    }


    @Override
    public int compareTo(Media media) {
        return this.name.compareTo(media.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbsMedia absMedia = (AbsMedia) o;
        return Objects.equals(name, absMedia.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}