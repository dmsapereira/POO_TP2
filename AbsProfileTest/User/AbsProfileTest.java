package User;

import Media.AbsMedia;
import Media.MovieClass;
import Media.ShowClass;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class AbsProfileTest {
    private AbsProfile test = new AbsProfile("name1");

    private String[] castValue1 = new String[]{"a","b","c"};
    private String[] castValue2 = new String[]{"d","e","f"};

    private Set<String> testCast1 = new LinkedHashSet<>(Arrays.asList(castValue1));
    private Set<String> testCast2 = new LinkedHashSet<>(Arrays.asList(castValue2));

    private AbsMedia mediaTest1 = new ShowClass("n1","dir1",18,200,18,2040,"genre1",testCast1);
    private AbsMedia mediaTest2 = new MovieClass("n2","dir2",111,17,2020,"genre2",testCast2);




    @Test
    void getWatched() {
        assert test.getWatched()!=null:"get watched return error";
    }

    @Test
    void getRated() {
        assert test.getRated()!=null:"get rated return error";
    }

    @Test
    void watch() {
        test.watch(mediaTest1);
        assert test.getWatched().containsKey("n1"):"adding to watched failed";
        assert test.getWatched().containsValue(mediaTest1):"adding to watched failed";
        assert test.getWatched().size()==1:"adding to watched failed";
    }

    @Test
    void rateMedia() {
        test.watch(mediaTest2);
        test.rateMedia("n2",3);
        assert test.getRated().containsKey("n2"):"adding to rated failed";
        assert test.getWatched().containsValue(mediaTest2):"adding to watched failed";
        assert test.getRated().size()==1:"adding to rated failed";
    }
}