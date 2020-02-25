package persistence;

import model.Restaurant;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
    @Test
    void testParseRestaurantsFile1() {
        try {
            ArrayList<Restaurant> restaurants1 = Reader.readRestaurants(new File("data/triedCollection.txt"));
            Restaurant miku = restaurants1.get(0);
            assertEquals("Miku", miku.getRestaurantName());
            assertEquals(5.0, miku.getTasteRating());
            assertEquals(3.0, miku.getPriceRating());
            assertEquals(4.0, miku.getServiceRating());
            assertFalse(miku.getBooking().getIsBooked());
            assertEquals(5, miku.getBooking().getSeats());
            assertEquals(2000, miku.getBooking().getYear());
            assertEquals(1, miku.getBooking().getMonth());
            assertEquals(8, miku.getBooking().getDay());
            assertEquals(9, miku.getBooking().getHour());

            ArrayList<Restaurant> restaurants2 = Reader.readRestaurants(new File("data/triedCollection.txt"));
            Restaurant ds = restaurants2.get(1);
            assertEquals("Dolar_shop", ds.getRestaurantName());
            assertEquals(3.0, ds.getTasteRating());
            assertEquals(4.0, ds.getPriceRating());
            assertEquals(1.0, ds.getServiceRating());
            assertFalse(ds.getBooking().getIsBooked());
            assertEquals(0, ds.getBooking().getSeats());
            assertEquals(0, ds.getBooking().getYear());
            assertEquals(0, ds.getBooking().getMonth());
            assertEquals(0, ds.getBooking().getDay());
            assertEquals(0, ds.getBooking().getHour());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testParseRestaurantsFile2() {
        try {
            ArrayList<Restaurant> restaurants = Reader.readRestaurants(new File("data/toTryCollection.txt"));
            Restaurant dosanko = restaurants.get(0);
            assertEquals("Dosanko", dosanko.getRestaurantName());
            assertEquals(0.0, dosanko.getTasteRating());
            assertEquals(0.0, dosanko.getPriceRating());
            assertEquals(0.0, dosanko.getServiceRating());
            assertFalse(dosanko.getBooking().getIsBooked());
            assertEquals(0, dosanko.getBooking().getSeats());
            assertEquals(0, dosanko.getBooking().getYear());
            assertEquals(0, dosanko.getBooking().getMonth());
            assertEquals(0, dosanko.getBooking().getDay());
            assertEquals(0, dosanko.getBooking().getHour());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testIOException() {
        try {
            Reader.readRestaurants(new File("./path/does/not/exist/testAccount.txt"));
        } catch (IOException e) {
            // expected
        }
    }
}
