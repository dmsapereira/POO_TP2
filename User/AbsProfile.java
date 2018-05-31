package User;

import Media.*;

import java.util.*;

public class AbsProfile implements Profile {
    private LinkedList<Media> watchedMedia;//LinkedList has been used for it's ability to return specific values easily and it's preservation of the insertion order
    private LinkedList<Rated> ratedMedia;
    private String name;

    public AbsProfile(String name) {
        watchedMedia = new LinkedList<Media>();
        ratedMedia = new LinkedList<Rated>();
        this.name = name;
    }

    @Override
    public LinkedList<Media> getWatched() {
        return watchedMedia;
    }

    @Override
    public LinkedList<Rated> getRated() {
        return ratedMedia;
    }

    @Override
    public void watch(Media media) {
        if (watchedMedia.contains(media))
            watchedMedia.remove(media);
        else if (watchedMedia.size() == 10)
            watchedMedia.remove(0);
        watchedMedia.add(media);
    }

    @Override
    public void rateMedia(String name, int rating) {
        Media media = getWatchedMediaByName(name);
        if (media instanceof Show)
            ratedMedia.add(new RatedShow((Show) media, rating));
        else
            ratedMedia.add(new RatedMovie((Movie) media, rating));
    }

    public String toString() {
        return this.name;
    }//facilitates print methods

    @Override
    public Media getWatchedMediaByName(String name) {
        for (Media current : watchedMedia) {
            if (current.toString().equals(name))
                return current;
        }
        return null;
    }

    @Override
    public Media getRatedMediaByName(String name) {
        for (Media current : ratedMedia) {
            if (current.toString().equals(name))
                return current;
        }
        return null;
    }
}
