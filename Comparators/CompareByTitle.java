package Comparators;

import Media.Media;

import java.util.Comparator;

public class CompareByTitle implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        return o1.toString().compareTo(o2.toString());
    }
}