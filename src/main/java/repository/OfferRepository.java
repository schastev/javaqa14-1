package repository;

import domain.Offer;

public class OfferRepository {
    private static Offer[] repository = new Offer[0];

    public void save(Offer item) {
        int j = repository.length;
        Offer[] tmp = new Offer[j + 1];
        System.arraycopy(repository, 0, tmp, 0, j);
        tmp[j] = item;
        repository = tmp;
    }

    public Offer[] getAll() {
        return repository;
    }

    public void removeById(int id) {
        int j = repository.length;
        Offer[] tmp = new Offer[j - 1];
        int i = 0;
        for (Offer prod : repository) {
            if (prod.getId() != id) {
                tmp[i] = prod;
                i++;
            }
        }
        repository = tmp;
    }
    public void removeAll() {
        repository = new Offer[0];
    }

}
