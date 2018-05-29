import java.util.*;

import Exceptions.*;
import Media.*;
import User.*;

/**
 * @author 52886: Bruno Ramos   52890: David Pereira    FCT     POO17/18
 */
public class Main {
    private static final String FORMAT_SHOW = "%s; %s; %d; %d; %d+; %d; %s";
    private static final String FORMAT_MOVIE = "%s; %s; %d; %d+; %d; %s";

    private enum Command

    {
        UPLOAD, REGISTER, LOGIN, DISCONNECT, LOGOUT, MEMBERSHIP, PROFILE, SELECT, WATCH, RATE, INFOACCOUNT, SEARCHBYGENRE, SEARCHBYNAME, SEARCHBYRATE, EXIT, UNKNOWN
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Streaming system = new StreamingClass();
        firstCommand(in, system);
        System.out.println("Exiting...");
    }

    /**
     *Executes the commands before there's an <code>upload</code> command
     */
    private static void firstCommand(Scanner in, Streaming system) {
        Command option;
        do {
            option = getCommand(in);
            switch (option) {
                case UPLOAD:
                    upload(in, system);
                    break;
                case REGISTER:
                    register(in, system);
                    break;
                case LOGIN:
                    login(in, system);
                    break;
                case DISCONNECT:
                    disconnect(system);
                    break;
                case LOGOUT:
                    logout(system);
                    break;
                case MEMBERSHIP:
                    changePlan(in, system);
                    break;
                case PROFILE:
                    addProfile(in, system);
                    break;
                case SELECT:
                    selectProfile(in, system);
                    break;
                case WATCH:
                case RATE:
                case INFOACCOUNT:
                case SEARCHBYGENRE:
                case SEARCHBYNAME:
                case SEARCHBYRATE:
                case UNKNOWN:
                    System.out.println("Unknown command.");
                    break;
                default:
                    break;
            }
            if (!option.equals(Command.EXIT))
                System.out.println();
        } while (!option.equals(Command.UPLOAD) && !option.equals(Command.EXIT));
        if (!option.equals(Command.EXIT))
            processCommand(in, system);
    }

    /**
     * Reads the user's input and transforms it into a <code>Command</code>
     * @return <code>Command</code> corresponding to the user's input. <code>Unknown</code> if it's invalid
     */
    private static Command getCommand(Scanner in) {
        try {
            String input = in.nextLine().toUpperCase();
            return Command.valueOf(input);
        } catch (IllegalArgumentException e) {
            return Command.UNKNOWN;
        }
    }

    /**
     * Analyzes the user's input and chooses the method associated with the inserted command
     */
    private static void processCommand(Scanner in, Streaming system) {
        Command option;
        do {
            option = getCommand(in);
            switch (option) {
                case REGISTER:
                    register(in, system);
                    break;
                case LOGIN:
                    login(in, system);
                    break;
                case DISCONNECT:
                    disconnect(system);
                    break;
                case LOGOUT:
                    logout(system);
                    break;
                case MEMBERSHIP:
                    changePlan(in, system);
                    break;
                case PROFILE:
                    addProfile(in, system);
                    break;
                case SELECT:
                    selectProfile(in, system);
                    break;
                case WATCH:
                    watch(in, system);
                    break;
                case RATE:
                    rate(in, system);
                    break;
                case INFOACCOUNT:
                    infoAccount(system);
                    break;
                case SEARCHBYGENRE:
                    searchByGenre(in,system);
                    break;
                case SEARCHBYNAME:
                    searchByName(in,system);
                    break;
                case SEARCHBYRATE:
                    searchByRate(in,system);
                    break;
                case UPLOAD:
                case UNKNOWN:
                    System.out.println("Unknown command.");
                    break;
                default:
                    break;
            }
            if(!option.equals(Command.EXIT))
            System.out.println();
        } while (!option.equals(Command.EXIT));
    }

    /**
     * Executes the <code>searchByRate</code> command
     * Reading the user's input and printing a list of <code>Rated</code> <code>Media</code> accordingly
     */
    private static void searchByRate(Scanner in, Streaming system) {
        int rating=in.nextInt();
        in.nextLine();
        try {
            Iterator<Rated> itera = system.searchByRating(rating);
            while (itera.hasNext())
                printRatedMedia(itera.next());
        }catch (NullLoggedAccountException | NullLoggedProfileException | MediaIterationException e){
            System.out.println(e);
        }
    }

    /**
     * Executes the <code>searchByName</code> command
     * Reading the user's input and printing a list of <code>Media</code> accordingly
     */
    private static void searchByName(Scanner in, Streaming system) {
        String name=in.nextLine();
        try {
            Iterator<Media> itera = system.searchByName(name);
            while (itera.hasNext())
                printMediaFullCast(itera.next());
        }catch (NullLoggedAccountException | NullLoggedProfileException | MediaIterationException e){
            System.out.println(e);
        }
    }

    /**
     * Executes the <code>searchByGenre</code> command
     * Reading the user's input and printing a list of <code>Media</code> accordingly
     */
    private static void searchByGenre(Scanner in, Streaming system) {
        String genre=in.nextLine().trim();
        try {
            Iterator<Media> itera = system.searchByGenre(genre);
            while (itera.hasNext())
                printMediaFullCast(itera.next());
        }catch (NullLoggedAccountException | NullLoggedProfileException | MediaIterationException e){
            System.out.println(e);
        }
    }

    /**
     * Executes the <code>infoAccount</code> command
     * Printing information about the current <code>Account</code> and it's <code>Profile</code>s
     */
    private static void infoAccount(Streaming system) {
        Account account;
        try {
            account = system.getLoggedAccount();
            System.out.println(account + ":");
            System.out.print(account.getPlan() + " (");
            printDevices(account);
            printProfiles(account);
        } catch (NullLoggedAccountException e) {
            System.out.println(e);
        }
    }

    /**
     * Prints information about the current <code>Account</code>'s <code>Profile</code>'s
     */
    private static void printProfiles(Account account) {
        Profile current;
        Iterator<Profile> itera = account.getProfiles().values().iterator();
        if (!itera.hasNext())
            System.out.println("No profiles defined.");
        else {
            while (itera.hasNext()) {
                current = itera.next();
                System.out.print("Profile: " + current);
                if (current instanceof KidProfile)
                    System.out.println(" (" + ((KidProfile) current).getAgeRating() + ")");
                else
                    System.out.println();
                    printWatched(current);
                    printRated(current);

            }
        }
    }

    /**
     * Prints a list of <code>Rated</code> <code>Media</code>
     */
    private static void printRated(Profile current) {
        Rated rated;
        Iterator<Rated> itera=current.getRated().values().iterator();
        if(itera.hasNext()){
            while (itera.hasNext()) {
                rated=itera.next();
                System.out.print(rated + " (" + ((int)rated.getRating()) + ")");
                if (itera.hasNext())
                    System.out.print("; ");
            }
            System.out.println(".");
        }
    }

    /**
     * Prints a list of watched <code>Media</code>
     */
    private static void printWatched(Profile current) {
        int numShown=0;
        Collection<Media> watched=current.getWatched().values();
        if (watched.size()==0)
            System.out.println("Empty list of recently seen shows.");
        else {
           for(int i=watched.size()-1;i>=0&&numShown<10;i--){
               System.out.print(watched.toArray()[i]);
               numShown++;
               if(i>0&&numShown<10)
                   System.out.print("; ");
           }
            System.out.println(".");
        }
    }

    /**
     *Prints a list of <code>Device</code>s
     * */
    private static void printDevices(Account account) {
        Iterator<Device> deviceItera = account.getDevices().values().iterator();
        while (deviceItera.hasNext()) {
            System.out.print(deviceItera.next());
            if (deviceItera.hasNext())
                System.out.print("; ");
        }
        System.out.println(").");
    }

    /**
     * Executes the <code>rate</code> command
     * Reading the user's input and rating a piece of <code>Media</code> accordingly
     */
    private static void rate(Scanner in, Streaming system) {
        String media;
        int rating;
        media = in.nextLine();
        rating = in.nextInt();
        in.nextLine();
        try {
            system.rate(media, rating);
            System.out.println("Thank you for rating " + media + ".");
        } catch (NullLoggedAccountException | NullLoggedProfileException | NullMediaException | NullWatchedMediaException | DuplicateRatedMediaException e) {
            System.out.println(e);
        }

    }

    /**
     * Executes the <code>watch</code> command
     */
    private static void watch(Scanner in, Streaming system) {
        String mediaName = in.nextLine();
        try {
            system.watch(mediaName);
            System.out.println("Loading " + mediaName + "...");
        } catch (NullLoggedAccountException | NullLoggedProfileException | NullMediaException | AgeRatingMismatchException e) {
            System.out.println(e);
        }
    }


    /**
     * Executes the <code>selectProfile</code> command
     * Reading the user's input and selecting a <code>Profile</code> accordingly
     */
    private static void selectProfile(Scanner in, Streaming system) {
        String name;
        name = in.nextLine();
        try {
            system.selectProfile(name);
            System.out.println("Welcome " + name + ".");
        } catch (NullLoggedAccountException | NullProfileException e) {
            System.out.println(e);
        }
    }

    /**
     * Executes the <code>addProfile</code> command
     * Reading the user's input and creating a new <code>Profile</code> accordingly
     */
    private static void addProfile(Scanner in, Streaming system) {
        String name, profile;
        int ageRating = 0;
        name = in.nextLine();
        profile = in.nextLine().toUpperCase();
        try {
            if (profile.equals("CHILDREN")) {
                ageRating = in.nextInt();
                in.nextLine();
                system.addChildProfile(name, ageRating);
            } else
                system.addStandardProfile(name);
            System.out.println("New profile added.");
        } catch (NullLoggedAccountException | DuplicateProfileException | ProfileLimitationOverflowException e) {
            System.out.println(e);
        }
    }

    /**
     * Executes the <code>changePlan</code> command
     * Reading the user's input and changing the current <code>Account</code>'s <code>Plan</code> accordingly
     */
    private static void changePlan(Scanner in, Streaming system) {
        Plan newPlan = Plan.valueOf(in.nextLine().toUpperCase());
        try {
            Plan oldPlan = system.getLoggedAccount().getPlan();
            system.changePlan(newPlan);
            System.out.println("Membership plan was changed from " + oldPlan + " to " + newPlan + ".");
        } catch (NullLoggedAccountException | DuplicatePlanException | PlanLimitationOverflowException e) {
            System.out.println(e);
        }
    }

    /**
     * Executes the <code>logout</code> command
     * Logging the current <code>Account</code> out
     */
    private static void logout(Streaming system) {
        try {
            Account loggedAccount = system.getLoggedAccount();
            Device device = system.logout();
            System.out.println("Goodbye " + loggedAccount + " (" + device + " still connected).");
        } catch (NullLoggedAccountException e) {
            System.out.println(e);
        }
    }

    /**
     * Executes the <code>disconnect</code> command
     * Disconnecting the current <code>Account</code>
     */
    private static void disconnect(Streaming system) {
        try {
            Account loggedAccount = system.getLoggedAccount();
            Device device = system.disconnect();
            System.out.println("Goodbye " + loggedAccount + " (" + device + " was disconnected).");
        } catch (NullLoggedAccountException e) {
            System.out.println(e);
        }
    }

    /**
     * Executes the <code>login</code> command
     * Reading the user's input and logging into an <code>Account</code> accordingly
     */
    private static void login(Scanner in, Streaming system) {
        String email, password, device;
        email = in.nextLine();
        password = in.nextLine();
        device = in.nextLine();

        try {
            system.login(email, password, device);
            System.out.println("Welcome " + system.getAccount(email).toString() + " (" + device + ").");
        } catch (AccountLoggedInException | OtherAccountLoggedInException | WrongPasswordException | NullAccountException | DeviceCapacityException e) {
            System.out.println(e);
        }
    }

    /**
     * Executes the <code>register</code> command
     * Reading the user's inpit and creating an <code>Account</code> accordingly
     */
    private static void register(Scanner in, Streaming system) {
        String name, email, password, device;
        name = in.nextLine();
        email = in.nextLine();
        password = in.nextLine();
        device = in.nextLine();
        try {
            system.register(name, email, password, device);
            System.out.println("Welcome " + name + " (" + device + ").");
        } catch (OtherAccountLoggedInException | DuplicateEmailException e) {
            System.out.println(e);
        }
    }

    /**
     * Executes the <code>upload</code> command
     * Reading the user's input and creating <code>Media</code> accordingly
     */
    private static void upload(Scanner in, Streaming system) {
        Iterator<Media> iteraMedia;
        int numAux = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numAux; i++) {
            readMovie(in, system);
        }
        numAux = in.nextInt();
        in.nextLine();
        for (int j = 0; j < numAux; j++) {
            readShow(in, system);
        }
        System.out.println("Database was updated:");
        iteraMedia = system.getMedia();
        while (iteraMedia.hasNext())
            printMedia(iteraMedia.next());
    }

    /**
     * Reads the user's input regarding the creation of new <code>Show</code>s
     */
    private static void readShow(Scanner in, Streaming system) {
        String name, director, genre, collabName, ageString;
        int numEpisodes, numSeasons, debut, numCast;
        Set<String> cast = new LinkedHashSet<>();
        name = in.nextLine();
        director = in.nextLine();
        numSeasons = in.nextInt();
        in.nextLine();
        numEpisodes = in.nextInt();
        in.nextLine();
        ageString = in.nextLine();
        ageString = ageString.substring(0, ageString.length() - 1);
        Integer ageRating = Integer.valueOf(ageString);
        debut = in.nextInt();
        in.nextLine();
        genre = in.nextLine();
        numCast = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numCast; i++) {
            collabName = in.nextLine();
            cast.add(collabName);
        }
        system.uploadShow(name, director, numSeasons, numEpisodes, ageRating, debut, genre, cast);
    }

    /**
     * Reads the user's input regarding the creation of new <code>Movie</code>s
     */
    private static void readMovie(Scanner in, Streaming system) {
        String name, director, genre, ageString, collabName;
        int duration, debut, numCast;
        Set<String> cast = new LinkedHashSet<>();
        name = in.nextLine();
        director = in.nextLine();
        duration = in.nextInt();
        in.nextLine();
        ageString = in.nextLine();
        ageString = ageString.substring(0, ageString.length() - 1);
        Integer ageRating = Integer.valueOf(ageString);
        debut = in.nextInt();
        in.nextLine();
        genre = in.nextLine();
        numCast = in.nextInt();
        in.nextLine();
        for (int i = 0; i < numCast; i++) {
            collabName = in.nextLine();
            cast.add(collabName);
        }
        system.uploadMovie(name, director, duration, ageRating, debut, genre, cast);
    }

    /**
     * Prints information about a certain <code>Media</code>, but it prints all of the members of the cast, instead of just 3
     */
    private static void printMediaFullCast(Media media){
        Iterator<String>itera = media.getCast().iterator();
        if (media instanceof Movie)
            System.out.printf(FORMAT_MOVIE, media, media.getDirector(), ((Movie) media).getDuration(), media.getAgeRating(), media.getDebut(), media.getGenre());
        else
            System.out.printf(FORMAT_SHOW, media, media.getDirector(), ((Show) media).getNumSeasons(), ((Show) media).getNumEpisodes(), media.getAgeRating(), media.getDebut(), media.getGenre());
        while (itera.hasNext())
            System.out.print("; " + itera.next());
        System.out.println(".");
    }

    /**
     * Prints information about a certain <code>Media</code>
     * @param media
     */
    private static void printMedia(Media media){
        int auxCast;
        Iterator<String>itera = media.getCast().iterator();
        if (media instanceof Movie)
            System.out.printf(FORMAT_MOVIE, media, media.getDirector(), ((Movie) media).getDuration(), media.getAgeRating(), media.getDebut(), media.getGenre());
        else
            System.out.printf(FORMAT_SHOW, media, media.getDirector(), ((Show) media).getNumSeasons(), ((Show) media).getNumEpisodes(), media.getAgeRating(), media.getDebut(), media.getGenre());
        auxCast = 0;
        while (itera.hasNext() && auxCast < 3) {
            System.out.print("; " + itera.next());
            auxCast++;
        }
        System.out.println(".");
    }

    /**
     * Prints information about a certain <code>Rated</code> <code>Media</code>
     */
    private static void printRatedMedia(Media media){
        Iterator<String>itera = media.getCast().iterator();
        if (media instanceof Movie)
            System.out.printf(FORMAT_MOVIE, media, media.getDirector(), ((Movie) media).getDuration(), media.getAgeRating(), media.getDebut(), media.getGenre());
        else
            System.out.printf(FORMAT_SHOW, media, media.getDirector(), ((Show) media).getNumSeasons(), ((Show) media).getNumEpisodes(), media.getAgeRating(), media.getDebut(), media.getGenre());
        while (itera.hasNext())
            System.out.print("; " + itera.next());
        System.out.print(".");
        System.out.printf(" [%.1f]\n",((Rated)media).getRating());
    }


}