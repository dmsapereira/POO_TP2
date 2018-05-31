package AbsProfileTest.User;

import Media.AbsMedia;
import Media.MovieClass;
import Media.ShowClass;
import User.AbsProfile;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.LinkedList;

public class AbsProfileTest {
    private AbsProfile test = new AbsProfile("name1");//instance of dummy test class

    private String[] castValue1 = new String[]{"a","b","c"};//instances of test cast
    private String[] castValue2 = new String[]{"d","e","f"};

    private LinkedList<String> testCast1 = new LinkedList<>(Arrays.asList(castValue1));//storage of test cast
    private LinkedList<String> testCast2 = new LinkedList<>(Arrays.asList(castValue2));

    private AbsMedia mediaTest1 = new ShowClass("n1","dir1",18,200,18,2040,"genre1",testCast1);//instance of media test class
    private AbsMedia mediaTest2 = new MovieClass("n2","dir2",111,17,2020,"genre2",testCast2);


    /**
     * tests the creation of a watched list
     */
    @Test
    void getWatched() {
        assert test.getWatched()!=null:"get watched return error";
    }

    /**
     * tests the creation of a rated list
     */
    @Test
    void getRated() {
        assert test.getRated()!=null:"get rated return error";
    }

    /**
     * tests the watch Method, and the insertion of elements into the list
     */
    @Test
    void watch() {
        test.watch(mediaTest1);
        assert test.getWatched().contains(mediaTest1):"adding to watched failed";
        assert test.getWatched().size()==1:"adding to watched failed";
    }

    /**
     * tests the rate Method, and the insertion of elements into the list
     */
    @Test
    void rateMedia() {
        test.watch(mediaTest2);
        test.rateMedia("n2",3);
        assert test.getRated().contains(mediaTest2):"adding to rated failed";
        assert test.getWatched().contains(mediaTest2):"adding to watched failed";
        assert test.getRated().size()==1:"adding to rated failed";
    }
}