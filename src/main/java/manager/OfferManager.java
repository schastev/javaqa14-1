package manager;

import domain.Offer;
import repository.OfferRepository;

import java.util.Arrays;

public class OfferManager {

    private OfferRepository repository;

    public OfferManager(OfferRepository repository) {
        this.repository = repository;
    }

    public void save(Offer item) {repository.save(item);}

    public Offer[] searchBy(String adep, String aod) {
        Offer[] items = repository.getAll();
        Offer[] searchResult = new Offer[0];
        for (Offer item : items) {
            if (item.matchesAdep(adep) && item.matchesAod(aod)) {
                int len = searchResult.length + 1;
                Offer[] tmp = new Offer[len];
                if (len > 1) { //only bring over the old array when there is something to bring over
                    System.arraycopy(searchResult, 0, tmp, 0, len - 1);
                }
                tmp[len - 1] = item;
                searchResult = tmp;
            }
        }
        Arrays.sort(searchResult);
        return searchResult;
    }


}
