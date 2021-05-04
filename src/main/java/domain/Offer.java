package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Offer implements Comparable<Offer>{
    private int id;
    private int price;
    private String adep;
    private String aod;
    private int duration;

    @Override
    public int compareTo(Offer o) {
        return price - o.price;
    }

    public boolean matchesAdep(String search) {
        if (this.getAdep().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
    public boolean matchesAod(String search) {
        if (this.getAod().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}
