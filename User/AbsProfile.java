package User;
import Media.Show;
import Iterable.*;

public class AbsProfile implements Profile {
    private Array<Show> watchedShows;
    private String name;

    public AbsProfile(String name){
        watchedShows=new ArrayClass<Show>();
        this.name=name;
    }

    @Override
    public Array<Show> getWatched() {
        return null;
    }

    @Override
    public void watch(Show show) {

    }
}
