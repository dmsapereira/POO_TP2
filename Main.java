
import java.util.*;

import Exceptions.*;
import Media.*;
import User.Account;

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

            if (option.equals(Command.UPLOAD))
                upload(in, system);
            else if (option.equals(Command.EXIT))
                break;

            else
                System.out.println("Unknown command.");

        } while (!option.equals(Command.UPLOAD) && !option.equals(Command.EXIT));
        if(!option.equals(Command.EXIT))
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
                case DISCONNECT:
                    //TODO
                    break;
                case LOGOUT:
                    //TODO
                    break;
                case MEMBERSHIP:
                    //TODO
                    break;
                case PROFILE:
                    //TODO
                    break;
                case SELECT:
                    //TODO
                    break;
                case WATCH:
                    //TODO
                    break;
                case RATE:
                    //TODO
                    break;
                case INFOACCOUNT:
                    //TODO
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

    private static void login(Scanner in, Streaming system) {
        String email, password, device;
        email = in.nextLine();
        password = in.nextLine();
        device = in.nextLine();

        try {
            system.login(email, password, device);
            System.out.println("Welcome " + system.getAccount(email).getName() + "(" + device + ").");
        } catch (AccountLoggedInException e) {
            System.out.println(e);
        } catch (OtherAccountLoggedInException e) {
            System.out.println(e);
        } catch (NullAccountException e) {
            System.out.println(e);
        } catch (WrongPasswordException e) {
            System.out.println(e);
        } catch (DeviceCapacityException e) {
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
            System.out.println("Welcome " + name + "(" + device + ").");
        } catch (OtherAccountLoggedInException e) {
            System.out.println(e);
        } catch (DuplicateEmailException e) {
            System.out.println(e);
        }
    }

    private static void upload(Scanner in, Streaming system) {
        Set<String> aux;
        Iterator<String> itera;
        Iterator<Show> iteraShow;
        Iterator<Movie> iteraMovie;
        Show currentShow;
        Movie currentMovie;
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
        System.out.println("Database was uploaded:");
        iteraShow = system.getShows();
        while (iteraShow.hasNext()) {
            currentShow = iteraShow.next();
            aux = currentShow.getCast();
            System.out.printf(FORMAT_SHOW, currentShow.getName(), currentShow.getDirector(), currentShow.getNumSeasons(), currentShow.getNumEpisodes(), currentShow.getAgeRating(), currentShow.getDebut(), currentShow.getGenre());
            itera = aux.iterator();
            while (itera.hasNext()) {
                System.out.print(" " + itera.next());
                if (itera.hasNext())
                    System.out.print(";");
            }
            System.out.println(".");
        }
        iteraMovie = system.getMovies();
        while (iteraMovie.hasNext()) {
            currentMovie = iteraMovie.next();
            aux = currentMovie.getCast();
            System.out.printf(FORMAT_MOVIE, currentMovie.getName(), currentMovie.getDirector(), currentMovie.getDuration(), currentMovie.getAgeRating(), currentMovie.getDebut(), currentMovie.getGenre());
            itera = aux.iterator();
            while (itera.hasNext()) {
                System.out.print(" " + itera.next());
                if (itera.hasNext())
                    System.out.print(";");
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
        in.nextLine();
        debut = in.nextInt();
        in.nextLine();
        genre = in.nextLine();
        numCast = in.nextInt();
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
        for (int i = 0; i <= numCast; i++) {
            collabName = in.nextLine();
            cast.add(collabName);
        }
        system.uploadMovie(name, director, duration, ageRating, debut, genre, cast);
    }


}

