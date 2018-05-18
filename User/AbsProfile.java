package User;
import Media.Show;
import java.util.*;

public class AbsProfile implements Profile {
    private Set<Show> watchedShows;
    private String name;

    public AbsProfile(String name){
        watchedShows=new LinkedHashSet<>();
        this.name=name;
    }

    @Override
    public Set<Show> getWatched() {
        return null;
    }

    @Override
    public void watch(Show show) {

    }
}
