package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Offer implements Comparable{
    private int id;
    private int price;
    private String adep;
    private String aod;
    private int duration;

    @Override
    public int compareTo(Object o) {
        Offer p = (Offer) o;
        return price - p.price;
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
