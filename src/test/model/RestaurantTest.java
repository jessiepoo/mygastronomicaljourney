package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RestaurantTest {
    private Restaurant testRestaurant;
    private MenuItem tomatoSoupBase;
    private MenuItem handTossedNoodles;

    @BeforeEach
    void runBefore() {
        testRestaurant = new Restaurant("HaiDiLao Hotpot");
        tomatoSoupBase = new MenuItem("Tomato soup base", 5.00);
        handTossedNoodles = new MenuItem("Hand tossed noodles", 7.50);
    }

    @Test
    void testConstructor() {
        assertEquals("HaiDiLao Hotpot", testRestaurant.getRestaurantName());
        assertEquals(0, testRestaurant.getTasteRating());
        assertEquals(0, testRestaurant.getPriceRating());
        assertEquals(0, testRestaurant.getServiceRating());
        assertEquals(0, testRestaurant.getOverallRating());
        assertFalse(testRestaurant.getBooking().getIsBooked());
        assertEquals(0, testRestaurant.triedItems.size());
    }

    @Test
    void testGetRestaurantName() {
        assertEquals("HaiDiLao Hotpot", testRestaurant.getRestaurantName());
    }

    @Test
    void testGetTasteRating() {
        testRestaurant.rateTaste(5.0);
        assertEquals(5.0, testRestaurant.getTasteRating());
    }

    @Test
    void testGetPriceRating() {
        testRestaurant.ratePrice(3.2);
        assertEquals(3.2, testRestaurant.getPriceRating());
    }

    @Test
    void testGetServiceRating() {
        testRestaurant.rateService(5.0);
        assertEquals(5.0, testRestaurant.getServiceRating());
    }

    @Test
    void testGetOverallRating() {
        testRestaurant.rateTaste(5.0);
        testRestaurant.ratePrice(3.2);
        testRestaurant.rateService(5.0);
        double overallRating = ((5.0+3.2+5.0)/3);
        assertEquals(overallRating, testRestaurant.getOverallRating());
    }

    @Test
    void testAddItem() {
        testRestaurant.addItem(tomatoSoupBase);
        assertEquals(1, testRestaurant.triedItems.size());
        testRestaurant.addItem(handTossedNoodles);
        assertEquals(2, testRestaurant.triedItems.size());
        assertEquals("Hand tossed noodles", testRestaurant.triedItems.get(1).getItemName());
    }

    @Test
    void testRateTaste() {
        testRestaurant.rateTaste(3.7);
        assertEquals(3.7, testRestaurant.getTasteRating());
        assertEquals((3.7/3), testRestaurant.getOverallRating());
    }

    @Test
    void testRatePrice() {
        testRestaurant.ratePrice(2.0);
        assertEquals(2.0, testRestaurant.getPriceRating());
        assertEquals((2.0/3), testRestaurant.getOverallRating());
    }

    @Test
    void testRateService() {
        testRestaurant.rateService(5.0);
        assertEquals(5.0, testRestaurant.getServiceRating());
        assertEquals((5.0/3), testRestaurant.getOverallRating());
    }
}
