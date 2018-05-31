

import Comparators.CompareByDebut;
import Comparators.CompareByRating;
import Comparators.CompareByTitle;
import Exceptions.*;
import Media.*;
import User.*;

import java.util.*;

public class StreamingClass implements Streaming {

    private Map<String, Media> media;
    private Account loggedAcc;
    private Map<String, Account> accountMap;

    public StreamingClass() {
        this.media = new TreeMap<>();
        this.accountMap = new HashMap<>();
    }


    @Override
    public void register(String name, String email, String password, String device) throws OtherAccountLoggedInException, DuplicateEmailException {
        if (loggedAcc != (null)) {
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
        Device newDevice;
        if (aux != null && loggedAcc != null && loggedAcc.getEmail().equals(email))
            throw new AccountLoggedInException();
        if (loggedAcc != (null))
            throw new OtherAccountLoggedInException();
        if (aux == (null))
            throw new NullAccountException();
        if (!aux.getPassword().equals(password))
            throw new WrongPasswordException();
        newDevice = new DeviceClass(device);
        if (aux.getMaxDevices() == aux.getDevices().size() && !(aux.getDevices().contains(new DeviceClass(device))))
            throw new DeviceCapacityException();
        loggedAcc = aux;
        loggedAcc.login(newDevice);
    }

    @Override
    public void uploadMovie(String name, String directorName, int duration, int ageRating, int debutDate, String
            genre, LinkedList<String> cast) {
        media.put(name, new MovieClass(name, directorName, duration, ageRating, debutDate, genre, cast));
    }

    @Override
    public void uploadShow(String name, String directorName, int numSeasons, int numEpisodes, int ageRating,
                           int debutDate, String genre, LinkedList<String> cast) {
        media.put(name, new ShowClass(name, directorName, numSeasons, numEpisodes, ageRating, debutDate, genre, cast));
    }

    @Override
    public Device disconnect() throws NullLoggedAccountException {
        Device device;
        if (loggedAcc == null)
            throw new NullLoggedAccountException();
        device = loggedAcc.disconnect();
        loggedAcc = null;
        return device;
    }

    @Override
    public Device logout() throws NullLoggedAccountException {
        Device device;
        if (loggedAcc == null)
            throw new NullLoggedAccountException();
        device = loggedAcc.logout();
        loggedAcc = null;
        return device;
    }

    @Override
    public Account getLoggedAccount() throws NullLoggedAccountException {
        if (loggedAcc == null)
            throw new NullLoggedAccountException();
        return loggedAcc;
    }

    @Override
    public void changePlan(Plan newPlan) throws NullLoggedAccountException, DuplicatePlanException, PlanLimitationOverflowException {
        if (loggedAcc == null)
            throw new NullLoggedAccountException();
        if (newPlan.equals(loggedAcc.getPlan()))
            throw new DuplicatePlanException();
        if (newPlan.getDeviceNum() < loggedAcc.getDevices().size())
            throw new PlanLimitationOverflowException();
        loggedAcc.changePlan(newPlan);
    }

    @Override
    public Iterator<Media> getMedia() {
        return media.values().iterator();
    }

    @Override
    public Account getAccount(String email) {
        return accountMap.get(email);
    }

    @Override
    public void addStandardProfile(String name) throws NullLoggedAccountException, DuplicateProfileException, ProfileLimitationOverflowException {
        if (loggedAcc == null)
            throw new NullLoggedAccountException();
        if (loggedAcc.getProfiles().contains(loggedAcc.searchProfileByName(name)))
            throw new DuplicateProfileException(name);
        if (loggedAcc.getProfiles().size() >= loggedAcc.getPlan().getProfileNum())
            throw new ProfileLimitationOverflowException();
        loggedAcc.addNormalProfile(name);
    }

    @Override
    public void addChildProfile(String name, int ageRating) throws NullLoggedAccountException, DuplicateProfileException, ProfileLimitationOverflowException {
        if (loggedAcc == null)
            throw new NullLoggedAccountException();
        if (loggedAcc.getProfiles().contains(loggedAcc.searchProfileByName(name)))
            throw new DuplicateProfileException(name);
        if (loggedAcc.getProfiles().size() >= loggedAcc.getPlan().getProfileNum())
            throw new ProfileLimitationOverflowException();
        assert ageRating>=5:"invalid ageRating for children";
        loggedAcc.addChildProfile(name, ageRating);
    }

    @Override
    public void selectProfile(String name) throws NullProfileException, NullLoggedAccountException {
        if (loggedAcc == null)
            throw new NullLoggedAccountException();
        if (loggedAcc.searchProfileByName(name) == null)
            throw new NullProfileException();
        loggedAcc.logProfile(name);
    }

    @Override
    public void watch(String media) throws NullLoggedAccountException, NullLoggedProfileException, NullMediaException, AgeRatingMismatchException {
        if (loggedAcc == null)
            throw new NullLoggedAccountException();
        if (loggedAcc.getCurrentProfile() == null)
            throw new NullLoggedProfileException();
        if (this.media.get(media) == null)
            throw new NullMediaException();
        if (loggedAcc.getCurrentProfile() instanceof KidProfile && ((KidProfile) loggedAcc.getCurrentProfile()).getAgeRating() < this.media.get(media).getAgeRating())
            throw new AgeRatingMismatchException();
        loggedAcc.watch(this.media.get(media));
    }

    @Override
    public void rate(String media, int rating) throws NullLoggedAccountException, NullLoggedProfileException, NullMediaException, NullWatchedMediaException, DuplicateRatedMediaException {
        if(loggedAcc==null)
            throw new NullLoggedAccountException();
        if(loggedAcc.getCurrentProfile()==null)
            throw new NullLoggedProfileException();
        if(this.media.get(media)==null)
            throw new NullMediaException();
        if(loggedAcc.getCurrentProfile().getWatchedMediaByName(media)==null)
            throw new NullWatchedMediaException();
        if(loggedAcc.getCurrentProfile().getRatedMediaByName(media)!=null)
            throw new DuplicateRatedMediaException();
        loggedAcc.rate(media,rating);
    }

    @Override
    public Iterator<Media> searchByGenre(String genre) throws NullLoggedAccountException,NullLoggedProfileException,MediaIterationException {
        Media current;
        if(loggedAcc==null)
            throw new NullLoggedAccountException();
        if(loggedAcc.getCurrentProfile()==null)
            throw new NullLoggedProfileException();
        Set<Media> list=new TreeSet<Media>(new CompareByTitle()) {
        };
        Iterator<Media> itera= getMedia();
        while(itera.hasNext()){
            current=itera.next();
            if(current.getGenre().equals(genre))
                list.add(current);
        }
        if(list.size()==0)
            throw new MediaIterationException();
        return list.iterator();



    }

    @Override
    public Iterator<Media> searchByName(String name) throws NullLoggedAccountException,NullLoggedProfileException,MediaIterationException {
        Media current;
        if(loggedAcc==null)
            throw new NullLoggedAccountException();
        if(loggedAcc.getCurrentProfile()==null)
            throw new NullLoggedProfileException();
        Set<Media> list=new TreeSet<Media>(new CompareByDebut());
        Iterator<Media> itera=getMedia();
        while(itera.hasNext()){
            current=itera.next();
            if(current.getCast().contains(name)||current.getDirector().equals(name))
                list.add(current);
        }
        if(list.size()==0)
            throw new MediaIterationException();
        return list.iterator();
    }

    @Override
    public Iterator<Rated> searchByRating(int rating) throws NullLoggedAccountException,NullLoggedProfileException, MediaIterationException {
        if(loggedAcc==null)
            throw new NullLoggedAccountException();
        if(loggedAcc.getCurrentProfile()==null)
            throw new NullLoggedProfileException();
        Map<String,Rated> firstStack=new HashMap<>();
        TreeSet<Rated> finalStack=new TreeSet<>(new CompareByRating());
        for(Account account: accountMap.values()){
           for(Profile profile: account.getProfiles()){
               for(Rated current: profile.getRated()){
                    if(!(loggedAcc.getCurrentProfile() instanceof KidProfile)||(loggedAcc.getCurrentProfile() instanceof KidProfile && (current.getAgeRating()<=((KidProfile) loggedAcc.getCurrentProfile()).getAgeRating()))) {
                        if (firstStack.containsKey(current.toString()))
                            firstStack.get(current.toString()).addRating((int)current.getRating());
                        else{
                            if(current instanceof Show)
                                firstStack.put(current.toString(),new RatedShow((RatedShow)current));
                            else
                                firstStack.put(current.toString(),(new RatedMovie((RatedMovie)current)));
                        }

                    }
                }
            }
        }
        for(Rated current: firstStack.values()){
            if(current.getRating()>=rating)
                finalStack.add(current);
        }
        if(finalStack.size()==0)
            throw new MediaIterationException();
        return finalStack.iterator();
    }
}