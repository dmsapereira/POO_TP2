import java.util.Scanner;

import Iterable.*;
import Media.*;

public class Main {
    private static final String FORMAT_SHOW = "%s; %s; %d; %d; %d+; %d; %s; %s";
    private static final String FORMAT_MOVIE = "%s; %s; %d; %d+; %d; %s; %s";

    private enum Command

    {
        UPLOAD,REGISTER, DISCONNECT, LOGOUT, MEMBERSHIP, PROFILE, SELECT, WATCH, RATE, INFOACCOUNT, SEARCHBYGENRE, SEARCHBYNAME, SEARCHBYRATE, EXIT, UNKNOWN
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Streaming system = new StreamingClass();
        processCommand(in,system);
    }

    private static void processCommand(Scanner in, Streaming system) {
        Command option;
        do {
            option = getCommand(in);
            switch (option) {
                case UPLOAD:
                    upload(in,system);
                    break;
                case REGISTER:
                    //TODO
                    break;
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
                case UNKNOWN:
                    System.out.println("Unknown command.");
                    break;
                default:
                    break;
            }
            System.out.println();
        } while (!option.equals(Command.EXIT));
    }

    private static void upload(Scanner in, Streaming system) {
        Array<String> aux;
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
            System.out.printf(FORMAT_SHOW, currentShow.getName(), currentShow.getDirector(), currentShow.getNumSeasons(), currentShow.getNumEpisodes(), currentShow.getAgeRating(), currentShow.getDebut(), currentShow.getGenre(), aux.get(0));
            itera = aux.iterator();
            itera.next();
            while (itera.hasNext()) {
                System.out.print(" " + itera.next());
                if(itera.hasNext())
                    System.out.print(";");
            }
            System.out.println(".");
        }
        iteraMovie = system.getMovies();
        while (iteraMovie.hasNext()) {
            currentMovie = iteraMovie.next();
            aux = currentMovie.getCast();
            System.out.printf(FORMAT_MOVIE, currentMovie.getName(), currentMovie.getDirector(), currentMovie.getDuration(), currentMovie.getAgeRating(), currentMovie.getDebut(), currentMovie.getGenre(), aux.get(0));
            itera = aux.iterator();
            itera.next();
            while (itera.hasNext()) {
                System.out.print(" " + itera.next());
                if(itera.hasNext())
                    System.out.print(";");
            }
            System.out.println(".");
        }
    }

    private static void readShow(Scanner in, Streaming system) {
        String name, director, genre, collabName;
        int numEpisodes, numSeasons, ageRating, debut, numCast;
        Array<String> cast = new ArrayClass<String>();
        name = in.nextLine();
        director = in.nextLine();
        numSeasons = in.nextInt();
        in.nextLine();
        numEpisodes = in.nextInt();
        in.nextLine();
        ageRating = in.nextInt();
        in.nextLine();
        debut = in.nextInt();
        in.nextLine();
        genre = in.nextLine();
        numCast = in.nextInt();
        for (int i = 0; i < numCast; i++) {
            collabName = in.nextLine();
            cast.insertLast(collabName);
        }
        system.uploadShow(name, director, numSeasons, numEpisodes, ageRating, debut, genre, cast);
    }

    private static void readMovie(Scanner in, Streaming system) {
        String name, director, genre, ageString, collabName;
        int duration, debut, numCast;
        Array<String> cast = new ArrayClass<String>();
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
            cast.insertLast(collabName);
        }
        system.uploadMovie(name, director, duration, ageRating, debut, genre, cast);
    }

    private static Command getCommand(Scanner in) {
        try {
            String input = in.nextLine().toUpperCase();
            return Command.valueOf(input);
        } catch (IllegalArgumentException e) {
            return Command.UNKNOWN;
        }
    }
}

