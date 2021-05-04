package manager;

import domain.Offer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.*;

class OfferManagerTest {
    private OfferRepository repo = new OfferRepository();
    private OfferManager manager = new OfferManager(repo);
    private Offer one = new Offer(0, 25, "DCA", "DLC", 120);
    private Offer two = new Offer(1, 16, "DLC", "DCA", 38);
    private Offer three = new Offer(2, 45, "EPL", "FNI", 200);
    private Offer four = new Offer(3, 10, "DCA", "DLC", 50);
    private Offer five = new Offer(4, 69, "HRE", "MLH", 120);
    private Offer six = new Offer(5, 24, "KIX", "KMG", 20);
    private Offer seven = new Offer(6, 40, "KIX", "DLC", 180);
    private Offer eight = new Offer(7, 48, "LGA", "EPL", 10);
    private Offer nine = new Offer(8, 28, "KMG", "KIX", 190);
    private Offer ten = new Offer(9, 99, "FNI", "LGA", 78);
    private Offer eleven = new Offer(10, 30, "MLH", "HRE", 300);

    @BeforeEach
    public void setUp() {
        repo.save(one);
        repo.save(two);
        repo.save(three);
        repo.save(four);
        repo.save(five);
        repo.save(six);
        repo.save(seven);
        repo.save(eight);
        repo.save(nine);
        repo.save(ten);
        repo.save(eleven);
    }

    @AfterEach
    public void cleanUp() {
        repo.removeAll();
    }

    @Test
    void searchByTestNoResults() {
        Offer[] expected = new Offer[0];
        Offer[] actual = manager.searchBy("EPL", "DLC");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByTestOneResult() {
        Offer[] expected = new Offer[]{six};
        Offer[] actual = manager.searchBy("KIX", "KMG");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByTestSeveralResults() {
        Offer[] expected = new Offer[]{four, one};
        Offer[] actual = manager.searchBy("DCA", "DLC");
        assertArrayEquals(expected, actual);
    }
}