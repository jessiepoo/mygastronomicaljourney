package ExceptionsTest;

import exceptions.EmptyRestaurantNameException;
import model.Restaurant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class EmptyRestaurantNameExceptionTest {
    private Restaurant r;

    @Test
    void testNonEmptyName() {
        try {
            r = new Restaurant("Miku");
        } catch (EmptyRestaurantNameException e) {
            fail();
        }
    }

    @Test
    void testEmptyName() {
        try {
            r = new Restaurant("");
            fail();
        } catch (EmptyRestaurantNameException e) {
            // expected
            e.printStackTrace();
        }
    }
}



