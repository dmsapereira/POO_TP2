package User;
import java.util.*;
import Media.*;

public interface Profile {

    Set<Show> getWatched();

    void watch(Show show);

}
