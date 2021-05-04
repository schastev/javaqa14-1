package repository;

import domain.Offer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfferRepositoryTest {
    private OfferRepository repo = new OfferRepository();
    private Offer one = new Offer(0, 25, "DCA", "DLC", 120);
    private Offer two = new Offer(1, 16, "DLC", "DCA", 120);
    private Offer three = new Offer(2, 45, "EPL", "FNI", 120);
    private Offer four = new Offer(3, 10, "DCA", "DLC", 50);
    private Offer five = new Offer(4, 69, "HRE", "MLH", 120);
    private Offer six = new Offer(5, 24, "KIX", "KMG", 120);
    private Offer seven = new Offer(6, 40, "KIX", "DLC", 120);
    private Offer eight = new Offer(7, 48, "LGA", "EPL", 120);
    private Offer nine = new Offer(8, 28, "KMG", "KIX", 120);
    private Offer ten = new Offer(9, 99, "FNI", "LGA", 120);
    private Offer eleven = new Offer(10, 30, "MLH", "HRE", 120);

    @BeforeEach
    public void setUp(){
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
    public void cleanUp(){
        repo.removeAll();
    }

    @Test
    void getAll() {
        Offer[] expected = new Offer[]{one, two, three,four, five, six, seven, eight, nine, ten, eleven};
        Offer[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeById() {
        Offer[] expected = new Offer[]{one, two, three, five, six, seven, eight, nine, ten};
        repo.removeById(10);
        repo.removeById(3);
        Offer[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeAll() {
        Offer[] expected = new Offer[0];
        repo.removeAll();
        Offer[] actual = repo.getAll();
        assertArrayEquals(expected, actual);
    }
}