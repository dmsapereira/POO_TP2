import java.util.*;

import Exceptions.*;
import Media.*;
import User.*;

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
                    watch(in, system);
                    break;
                case RATE:
                    rate(in, system);
                    break;
                case INFOACCOUNT:
                    infoAccount(system);
                    break;
                case SEARCHBYGENRE:
                    //TODO
                    break;
                case SEARCHBYNAME:
                    //TODO
                    break;
                case SEARCHBYRATE:
                    //TODO
                    break;
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

    private static Command getCommand(Scanner in) {
        try {
            String input = in.nextLine().toUpperCase();
            return Command.valueOf(input);
        } catch (IllegalArgumentException e) {
            return Command.UNKNOWN;
        }
    }

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
                    //TODO
                    break;
                case SEARCHBYRATE:
                    //TODO
                    break;
                case UPLOAD:
                case UNKNOWN:
                    System.out.println("Unknown command.");
                    break;
                default:
                    break;
            }
            System.out.println();
        } while (!option.equals(Command.EXIT));
    }

    private static void searchByGenre(Scanner in, Streaming system) {
        Media current;
        int auxCast;
        String genre=in.nextLine();
        Iterator<Media> itera=system.searchByGenre(genre);
        while(itera.hasNext()){
            current=itera.next();
            if (current instanceof Movie)
                System.out.printf(FORMAT_MOVIE, current, current.getDirector(), ((Movie) current).getDuration(), current.getAgeRating(), current.getDebut(), current.getGenre());
            else
                System.out.printf(FORMAT_SHOW, current, current.getDirector(), ((Show) current).getNumSeasons(), ((Show) current).getNumEpisodes(), current.getAgeRating(), current.getDebut(), current.getGenre());
            auxCast = 0;
            while (itera.hasNext() && auxCast < 3) {
                System.out.print("; " + itera.next());
                auxCast++;
            }
            System.out.println(".");
        }
    }

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

    private static void printRated(Profile current) {
        Rated rated;
        Iterator<Rated> itera=current.getRated().values().iterator();
        if(itera.hasNext()){
            while (itera.hasNext()) {
                rated=itera.next();
                System.out.print(rated + " (" + rated.getRating() + ")");
                if (itera.hasNext())
                    System.out.print("; ");
            }
            System.out.println(".");
        }
    }

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

    private static void printDevices(Account account) {
        Iterator<Device> deviceItera = account.getDevices().values().iterator();
        while (deviceItera.hasNext()) {
            System.out.print(deviceItera.next());
            if (deviceItera.hasNext())
                System.out.print("; ");
        }
        System.out.println(").");
    }

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

    private static void watch(Scanner in, Streaming system) {
        String mediaName = in.nextLine();
        try {
            system.watch(mediaName);
            System.out.println("Loading " + mediaName + "...");
        } catch (NullLoggedAccountException | NullLoggedProfileException | NullMediaException | AgeRatingMismatchException e) {
            System.out.println(e);
        }
    }


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

    private static void logout(Streaming system) {
        try {
            Account loggedAccount = system.getLoggedAccount();
            Device device = system.logout();
            System.out.println("Goodbye " + loggedAccount + " (" + device + " still connected).");
        } catch (NullLoggedAccountException e) {
            System.out.println(e);
        }
    }

    private static void disconnect(Streaming system) {
        try {
            Account loggedAccount = system.getLoggedAccount();
            Device device = system.disconnect();
            System.out.println("Goodbye " + loggedAccount + " (" + device + " was disconnected).");
        } catch (NullLoggedAccountException e) {
            System.out.println(e);
        }
    }

    private static void login(Scanner in, Streaming system) {
        String email, password, device;
        email = in.nextLine();
        password = in.nextLine();
        device = in.nextLine();

        try {
            system.login(email, password, device);
            System.out.println("Welcome " + system.getAccount(email).getName() + " (" + device + ").");
        } catch (AccountLoggedInException | OtherAccountLoggedInException | WrongPasswordException | NullAccountException | DeviceCapacityException e) {
            System.out.println(e);
        }
    }

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

    private static void upload(Scanner in, Streaming system) {
        int auxCast;
        Iterator<String> itera;
        Iterator<Media> iteraMedia;
        Media current;
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
        System.out.println();
        System.out.println("Database was updated:");
        iteraMedia = system.getMedia();
        while (iteraMedia.hasNext()) {
            current = iteraMedia.next();
            itera = current.getCast().iterator();
            if (current instanceof Movie)
                System.out.printf(FORMAT_MOVIE, current, current.getDirector(), ((Movie) current).getDuration(), current.getAgeRating(), current.getDebut(), current.getGenre());
            else
                System.out.printf(FORMAT_SHOW, current, current.getDirector(), ((Show) current).getNumSeasons(), ((Show) current).getNumEpisodes(), current.getAgeRating(), current.getDebut(), current.getGenre());
            auxCast = 0;
            while (itera.hasNext() && auxCast < 3) {
                System.out.print("; " + itera.next());
                auxCast++;
            }
            System.out.println(".");
        }
    }

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


}