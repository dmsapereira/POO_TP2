import java.util.*;

import Exceptions.*;
import Media.*;
import User.Account;
import User.Device;
import User.Plan;

public interface Streaming {

    void register(String name,String email,String password,String device) throws OtherAccountLoggedInException, DuplicateEmailException;

    void login(String email,String password,String device) throws AccountLoggedInException, DeviceCapacityException, NullAccountException,OtherAccountLoggedInException,WrongPasswordException;

    void uploadMovie(String name, String directorName, int duration, int ageRating, int debutDate, String genre, Set<String> cast);

    void uploadShow(String name, String directorName, int numSeasons, int numEpisodes, int ageRating, int debutDate, String genre, Set<String> cast);

    Device disconnect() throws NullLoggedAccountException;

    Device logout() throws NullLoggedAccountException;

    Account getLoggedAccount()throws NullLoggedAccountException;

    void checkPlanChange(Plan newplan) throws DuplicatePlanException,PlanLimitationOverflowException;

    Iterator<Media> getMedia();

    Iterator<Show> getShows();

    Iterator<Movie> getMovies();

    Account getAccount(String email);

    void addStandardProfile(String name) throws NullLoggedAccountException,DuplicateProfileException,ProfileLimitationOverflowException;

    void addChildProfile(String name,int ageRating) throws NullLoggedAccountException,DuplicateProfileException,ProfileLimitationOverflowException;
}
