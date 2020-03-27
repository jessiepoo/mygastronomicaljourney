package persistence;

import exceptions.EmptyRestaurantNameException;
import model.Restaurant;
import model.RestaurantCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {
    private static final String TEST_FILE = "data/triedCollection.txt";
    private Writer testWriter;
    private RestaurantCollection tried = new RestaurantCollection();
    private Restaurant newMandarin;


    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        try {
            newMandarin = new Restaurant("New_Mandarin");
        } catch (EmptyRestaurantNameException e) {
            fail();
        }
        newMandarin.rateTaste(4.8);
        newMandarin.ratePrice(3.6);
        newMandarin.rateService(2.9);
        newMandarin.getBooking().setIsBooked(true);
        newMandarin.getBooking().setAll(2020,2,14,18,2);
        tried.addRestaurant(newMandarin);
    }

    @Test
    void testWriteAccounts() {
        // save restaurant to file
        testWriter.write(tried);
        testWriter.close();;

        try {
            ArrayList<Restaurant> restaurants = Reader.readRestaurants(new File("data/triedCollection.txt"));
            Restaurant ds = restaurants.get(0);
            assertEquals("New_Mandarin", newMandarin.getRestaurantName());
            assertEquals(4.8, newMandarin.getTasteRating());
            assertEquals(3.6, newMandarin.getPriceRating());
            assertEquals(2.9, newMandarin.getServiceRating());
            assertTrue(ds.getBooking().getIsBooked());
            assertEquals(2, newMandarin.getBooking().getSeats());
            assertEquals(2020, newMandarin.getBooking().getYear());
            assertEquals(2, newMandarin.getBooking().getMonth());
            assertEquals(14, newMandarin.getBooking().getDay());
            assertEquals(18, newMandarin.getBooking().getHour());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
