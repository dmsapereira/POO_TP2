import java.util.*;

import Exceptions.*;
import Media.*;
import User.Account;
import User.AccountClass;
import User.DeviceClass;

public class StreamingClass implements Streaming {

    private Set<AbsMedia> media;
    private Account loggedAcc;
    private Map<String, Account> accountMap;

    public StreamingClass() {
        this.media = new LinkedHashSet<AbsMedia>();
        this.accountMap = new LinkedHashMap<>();
    }


    @Override
    public void register(String name, String email, String password, String device) throws OtherAccountLoggedInException, DuplicateEmailException {
        if (loggedAcc!=(null)) {
            throw new OtherAccountLoggedInException();
        } else if (accountMap.containsKey(email)) {
            throw new DuplicateEmailException(email);
        }
        accountMap.put(email, new AccountClass(name, email, password, new DeviceClass(device)));
        loggedAcc = accountMap.get(email);
    }

    @Override
    public void login(String email, String password, String device) throws AccountLoggedInException, DeviceCapacityException, NullAccountException, OtherAccountLoggedInException, WrongPasswordException {
        Account aux = accountMap.get(email);

        if (aux!=null && loggedAcc.getEmail().equals(email))
            throw new AccountLoggedInException();
        if (aux !=null && loggedAcc!=(null))
            throw new OtherAccountLoggedInException();
        if (aux==(null))
            throw new NullAccountException();
        if (!aux.getPassword().equals(password))
            throw new WrongPasswordException();
        if (aux.getMaxDevices() == aux.getDevices().size())
            throw new DeviceCapacityException();

        loggedAcc = aux;
    }

    @Override
    public void uploadMovie(String name, String directorName, int duration, int ageRating, int debutDate, String
            genre, Set<String> cast) {
        media.add(new MovieClass(name, directorName, duration, ageRating, debutDate, genre, cast));
    }

    @Override
    public void uploadShow(String name, String directorName, int numSeasons, int numEpisodes, int ageRating,
                           int debutDate, String genre, Set<String> cast) {
        media.add(new ShowClass(name, directorName, numSeasons, numEpisodes, ageRating, debutDate, genre, cast));
    }

    @Override
    public Iterator<Show> getShows() {
        AbsMedia current;
        Set<Show> aux = new LinkedHashSet<Show>(media.size());
        Iterator<AbsMedia> itera = media.iterator();
        while (itera.hasNext()) {
            current = itera.next();
            if (current instanceof Show)
                aux.add((Show) current);
        }
        return aux.iterator();
    }

    @Override
    public Iterator<Movie> getMovies() {
        AbsMedia current;
        Set<Movie> aux = new LinkedHashSet<Movie>(media.size());
        Iterator<AbsMedia> itera = media.iterator();
        while (itera.hasNext()) {
            current = itera.next();
            if (current instanceof Movie)
                aux.add((Movie) current);
        }
        return aux.iterator();
    }

    @Override
    public Account getAccount(String email) {
        return accountMap.get(email);
    }

}
