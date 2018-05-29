package User;

public class KidProfileClass extends AbsProfile implements KidProfile {
    private int ageRating;

    public KidProfileClass(String name, int ageRating) {
        super(name);
        this.ageRating = ageRating;
    }

    public int getAgeRating() {
        assert this.ageRating>=5:"invalid ageRating for children";
        return this.ageRating;
    }
}