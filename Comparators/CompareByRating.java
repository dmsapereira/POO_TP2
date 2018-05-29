package Comparators;

import Media.Rated;

import java.util.Comparator;

public class CompareByRating implements Comparator<Rated> {

    @Override
    public int compare(Rated o1, Rated o2) {
        if(o1.getRating()<o2.getRating())
            return 1;
        else if (o1.getRating()>o2.getRating())
            return -1;
        else
            return o1.toString().compareTo(o2.toString());
    }
}
