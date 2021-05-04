package domain;

import java.util.Comparator;

public class CompareByDuration implements Comparator<Offer> {

    @Override
    public int compare(Offer o1, Offer o2) {
        return o1.getDuration() - o2.getDuration();
    }
}
