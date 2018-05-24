package User;

import Media.*;

import java.util.*;

public class AbsProfile implements Profile {
    private LinkedHashMap<String, Media> watchedMedia;
    private LinkedHashMap<String, Rated> ratedMedia;
    private String name;

    public AbsProfile(String name) {
        watchedMedia = new LinkedHashMap<>();
        ratedMedia = new LinkedHashMap<>();
        this.name = name;
    }

    @Override
    public LinkedHashMap<String, Media> getWatched() {
        return watchedMedia;
    }

    @Override
    public LinkedHashMap<String, Rated> getRated() {
        return ratedMedia;
    }

    @Override
    public void watch(Media media) {
        if (watchedMedia.containsKey(media.toString()))
            watchedMedia.remove(media.toString());
        else if (watchedMedia.size()==10)
            watchedMedia.remove(watchedMedia.keySet().toArray()[0].toString());
        watchedMedia.put(media.toString(), media);
    }

    @Override
    public void rateMedia(String name, int rating) {
        Media media= watchedMedia.get(name);
        if(media instanceof Show)
            ratedMedia.put(name,new RatedShow((Show)media,rating));
        else
            ratedMedia.put(name, new RatedMovie((Movie)media,rating));
    }

    public String toString() {
        return this.name;
    }
}
