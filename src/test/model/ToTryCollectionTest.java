package model;

import exceptions.EmptyRestaurantNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.Writer;
import ui.RestaurantCollectionApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ToTryCollectionTest {
    private ToTryCollection testToTryCollection;
    private Restaurant miku;
    private Restaurant haiDiLao;


    @BeforeEach
    void runBefore() {
        try {
            testToTryCollection = new ToTryCollection();
            miku = new Restaurant("Miku");
            haiDiLao = new Restaurant("Haidilao Hotpot");
        } catch (EmptyRestaurantNameException e) {
            fail();
        }
    }

    @Test
    void testConstructor() {
        assertEquals(0, testToTryCollection.restaurantList.size());
    }

    @Test
    void testAddRestaurant() {
        testToTryCollection.addRestaurant(miku);
        assertEquals(1, testToTryCollection.restaurantList.size());
        assertEquals(miku, testToTryCollection.restaurantList.get(0));
    }

    @Test
    void testViewAllRestaurants() {
        testToTryCollection.restaurantList.add(miku);
        testToTryCollection.restaurantList.add(haiDiLao);

        String allRestaurants = testToTryCollection.viewAllRestaurants(testToTryCollection.restaurantList);
        assertEquals("" + "Miku" + "\n" + "Haidilao Hotpot" + "\n", allRestaurants);
    }

    @Test
    void testSave() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new File("./data/testToTry.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        testToTryCollection.addRestaurant(miku);
        testToTryCollection.addRestaurant(haiDiLao);
        testToTryCollection.save(printWriter);

        ArrayList<Restaurant> testList = new ArrayList<>();
        testList.add(miku);
        testList.add(haiDiLao);

        assertEquals(testList, testToTryCollection.restaurantList);
    }
}




