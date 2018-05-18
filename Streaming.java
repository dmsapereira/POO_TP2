import java.util.*;

import Exceptions.*;
import Media.*;
import User.Account;

public interface Streaming {

    void register(String name,String email,String password,String device) throws OtherAccountLoggedInException, DuplicateEmailException;

    void login(String email,String password,String device) throws AccountLoggedInException, DeviceCapacityException, NullAccountException,OtherAccountLoggedInException,WrongPasswordException;

    void uploadMovie(String name, String directorName, int duration, int ageRating, int debutDate, String genre, Set<String> cast);

    void uploadShow(String name, String directorName, int numSeasons, int numEpisodes, int ageRating, int debutDate, String genre, Set<String> cast);

    Iterator<Show> getShows();

    Iterator<Movie> getMovies();

    Account getAccount(String email);
}
