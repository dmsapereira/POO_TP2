package User;
import Iterable.*;
import Media.*;

public interface Profile {

    Array<Show> getWatched();

    void watch(Show show);

}
