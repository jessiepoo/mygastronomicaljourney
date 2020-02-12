package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuItemTest {
    private MenuItem testItem;

    @BeforeEach
    void runBefore() {
        testItem = new MenuItem("Salmon aburi sushi", 18.00);
    }

    @Test
    void testConstructor() {
        assertEquals("Salmon aburi sushi", testItem.getItemName());
        assertEquals(18.00, testItem.getItemPrice());
        assertEquals(0.0, testItem.getItemRating());
    }

    @Test
    void testGetItemName() {
        assertEquals("Salmon aburi sushi", testItem.getItemName());
    }

    @Test
    void testGetItemPrice() {
        assertEquals(18.00, testItem.getItemPrice());
    }

    @Test
    void testGetItemRating() {
        testItem.rateItem(4.8);
        assertEquals(4.8, testItem.getItemRating());
    }

    @Test
    void rateItem() {
        testItem.rateItem(4.6);
        assertEquals(4.6, testItem.getItemRating());
    }
}
