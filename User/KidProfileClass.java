package User;

public class KidProfileClass extends AbsProfile implements KidProfile {
    private int ageRating;

    public KidProfileClass(String name, int ageRating) {
        super(name);
        this.ageRating = ageRating;
    }

    public int getAgeRating() {
        return this.ageRating;
    }
}