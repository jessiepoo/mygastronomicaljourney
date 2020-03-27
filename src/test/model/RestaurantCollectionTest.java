package model;

import exceptions.EmptyRestaurantNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantCollectionTest {
    private RestaurantCollection testCollection;

    private Restaurant miku;
    private MenuItem salmonAburiSushi;
    private MenuItem uniNigiri;
    private MenuItem threeFlightSake;

    private Restaurant haiDiLao;
    private MenuItem wagyuBeef;
    private MenuItem handTossedNoodle;

    private Restaurant oebBreakfast;
    private MenuItem scallopAndHogPoutine;
    private MenuItem crepeWithBerries;

    private Restaurant sushiMura;
    private MenuItem spicySalmonSashimi;
    private MenuItem TempuraUdon;


    @BeforeEach
    void runBefore() {
        try {
            testCollection = new RestaurantCollection();
            miku = new Restaurant("Miku");
            haiDiLao = new Restaurant("Haidilao Hotpot");
            sushiMura = new Restaurant("Sushi Mura");
            oebBreakfast = new Restaurant("OEB Breakfast");
        } catch (EmptyRestaurantNameException e) {
            fail();
        }
    }

    @Test
    void testConstructor() {
        assertEquals(0, testCollection.restaurantList.size());
    }

    @Test
    void testAddRestaurant() {
        testCollection.addRestaurant(miku);
        assertEquals(1, testCollection.restaurantList.size());
        assertEquals(miku, testCollection.restaurantList.get(0));
    }

    @Test
    void testGetSortedRestaurantsByTaste() {
        miku.rateTaste(4.4);
        testCollection.restaurantList.add(miku);

        haiDiLao.rateTaste(4.8);
        testCollection.restaurantList.add(haiDiLao);

        sushiMura.rateTaste(2.8);
        testCollection.restaurantList.add(sushiMura);

        ArrayList<Restaurant> sortedRestaurants = testCollection.getSortedRestaurantsByTaste();

        assertEquals(3, sortedRestaurants.size());
        assertEquals(haiDiLao, sortedRestaurants.get(0));
        assertEquals(sushiMura, sortedRestaurants.get(2));
    }

    @Test
    void testGetSortedRestaurantsBySameTaste() {
        miku.rateTaste(4.2);
        haiDiLao.rateTaste(4.2);
        testCollection.addRestaurant(miku);
        testCollection.addRestaurant(haiDiLao);
        ArrayList<Restaurant> sortedList = testCollection.getSortedRestaurantsByTaste();
        assertEquals(miku, sortedList.get(0));
        assertEquals(haiDiLao, sortedList.get(1));
    }

    @Test
    void testGetSortedRestaurantsByPrice() {
        miku.ratePrice(0.8);
        testCollection.restaurantList.add(miku);

        haiDiLao.ratePrice(1.3);
        testCollection.restaurantList.add(haiDiLao);

        sushiMura.ratePrice(4.7);
        testCollection.restaurantList.add(sushiMura);

        oebBreakfast.ratePrice(3.3);
        testCollection.restaurantList.add(oebBreakfast);

        ArrayList<Restaurant> sortedList = testCollection.getSortedRestaurantsByPrice();

        assertEquals(4, testCollection.restaurantList.size());
        assertEquals(sushiMura, sortedList.get(0));
        assertEquals(haiDiLao, sortedList.get(2));
        assertEquals(miku, sortedList.get(3));
    }

    @Test
    void testGetSortedRestaurantsBySamePrice() {
        testCollection.addRestaurant(miku);
        testCollection.addRestaurant(haiDiLao);
        miku.ratePrice(2.2);
        haiDiLao.ratePrice(2.2);
        ArrayList<Restaurant> sortedList = testCollection.getSortedRestaurantsByPrice();
        assertEquals(miku, sortedList.get(0));
        assertEquals(haiDiLao, sortedList.get(1));
    }

    @Test
    void testGetSortedRestaurantsByService() {
        miku.rateService(4.1);
        testCollection.restaurantList.add(miku);

        haiDiLao.rateService(5.0);
        testCollection.restaurantList.add(haiDiLao);

        sushiMura.rateService(3.7);
        testCollection.restaurantList.add(sushiMura);

        oebBreakfast.rateService(1.9);
        testCollection.restaurantList.add(oebBreakfast);

        ArrayList<Restaurant> sortedList = testCollection.getSortedRestaurantsByService();

        assertEquals(4, sortedList.size());
        assertEquals(haiDiLao, sortedList.get(0));
        assertEquals(sushiMura, sortedList.get((2)));
    }

    @Test
    void testGetSortedRestaurantsBySameService() {
        testCollection.addRestaurant(miku);
        testCollection.addRestaurant(haiDiLao);
        miku.ratePrice(4.3);
        haiDiLao.ratePrice(4.3);
        ArrayList<Restaurant> sortedList = testCollection.getSortedRestaurantsByService();
        assertEquals(miku, sortedList.get(0));
        assertEquals(haiDiLao, sortedList.get(1));
    }

    @Test
    void testGetSortedRestaurantsOverall() {
        testCollection.restaurantList.add(miku);
        miku.rateService(4.1);
        miku.rateTaste(4.7);
        miku.ratePrice(2.2);
        assertEquals(((4.1+4.7+2.2)/3), miku.getOverallRating());

        testCollection.restaurantList.add(sushiMura);
        sushiMura.ratePrice(3.2);
        sushiMura.rateTaste(0.1);
        sushiMura.rateService(1.2);
        assertEquals(((3.2+0.1+1.2)/3), sushiMura.getOverallRating());

        ArrayList<Restaurant> sortedList = testCollection.getSortedRestaurantOverall();
        assertEquals(2, sortedList.size());
        assertEquals(miku, sortedList.get(0));

        testCollection.restaurantList.add(oebBreakfast);
        oebBreakfast.rateService(4.9);
        oebBreakfast.ratePrice(4.2);
        oebBreakfast.rateTaste(5.0);

        sortedList = testCollection.getSortedRestaurantOverall();
        assertEquals(oebBreakfast, sortedList.get(0));
        assertEquals(sushiMura, sortedList.get(2));
    }

    @Test
    void testGetSortedRestaurantSameOverall() {
        testCollection.restaurantList.add(miku);
        miku.rateService(4.1);
        miku.rateTaste(4.7);
        miku.ratePrice(2.2);
        assertEquals(((4.1+4.7+2.2)/3), miku.getOverallRating());

        testCollection.restaurantList.add(haiDiLao);
        miku.rateService(4.1);
        miku.rateTaste(4.7);
        miku.ratePrice(2.2);
        assertEquals(((4.1+4.7+2.2)/3), haiDiLao.getOverallRating());

        ArrayList<Restaurant> sortedList = testCollection.getSortedRestaurantOverall();
        assertEquals(miku, sortedList.get(0));
        assertEquals(haiDiLao, sortedList.get(1));
    }

    @Test
    void testGetSortedRestaurantsByName() {
        testCollection.restaurantList.add(miku);
        testCollection.restaurantList.add(haiDiLao);
        testCollection.restaurantList.add(sushiMura);
        testCollection.restaurantList.add(oebBreakfast);

        ArrayList<Restaurant> sortedList = testCollection.getSortedRestaurantsByName();

        assertEquals(haiDiLao, sortedList.get(0));
        assertEquals(miku, sortedList.get(1));
        assertEquals(oebBreakfast, sortedList.get(2));
        assertEquals(sushiMura, sortedList.get(3));
    }

    @Test
    void testViewAllRestaurants() {
        testCollection.restaurantList.add(miku);
        testCollection.restaurantList.add(haiDiLao);
        testCollection.restaurantList.add(sushiMura);
        testCollection.restaurantList.add(oebBreakfast);

        String allRestaurants = testCollection.viewAllRestaurants(testCollection.restaurantList);
        assertEquals(""+"Miku"+"\n"+"Haidilao Hotpot"+"\n"+"Sushi Mura"+"\n"+"OEB Breakfast"+"\n",
                allRestaurants);
    }
}
