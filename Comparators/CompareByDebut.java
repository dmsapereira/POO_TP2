package Comparators;

import Media.Media;

import java.util.Comparator;
import java.util.Map;

public class CompareByDebut implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        if(o1.getDebut()>o2.getDebut())
            return 1;
        else if (o1.getDebut()<o2.getDebut())
            return -1;
        else
            return o1.toString().compareTo(o2.toString());
    }
}
