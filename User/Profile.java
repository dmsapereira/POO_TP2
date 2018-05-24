package User;
import java.util.*;
import Media.*;

public interface Profile {

    LinkedHashMap<String,Media> getWatched();

    LinkedHashMap<String,Rated> getRated();

    void watch(Media media);

    void rateMedia(String name, int rating);

}
