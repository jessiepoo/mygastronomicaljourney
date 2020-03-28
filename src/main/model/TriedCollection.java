package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

// A collection of restaurants that the user has already tried.
public class TriedCollection implements Saveable, RestaurantCollections {

    public ArrayList<Restaurant> restaurantList;
    private Sorter sorter;

    // Constructs a restaurant collection with an empty list of restaurants
    public TriedCollection() {
        restaurantList = new ArrayList<Restaurant>();
        sorter = new Sorter(restaurantList);
    }

    // EFFECTS: Adds a restaurant to the restaurant list
    @Override
    public final void addRestaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);

    }

    // EFFECTS: Gets the sorter
    public Sorter getSorter() {
        return sorter;
    }


    @Override
    public String viewAllRestaurants(ArrayList<Restaurant> restaurants) {
        String allRestaurants = "";

        for (Restaurant restaurant: restaurants) {
            String restName = restaurant.getRestaurantName();
            allRestaurants = allRestaurants + restName + "\n";

        }
        return allRestaurants;
    }

    @Override
    public void save(PrintWriter printWriter) {
        for (Restaurant r : restaurantList) {
            printWriter.print(r.getRestaurantName());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(r.getTasteRating());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(r.getPriceRating());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(r.getServiceRating());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(r.getBooking().getIsBooked());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(r.getBooking().getSeats());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(r.getBooking().getYear());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(r.getBooking().getMonth());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(r.getBooking().getDay());
            printWriter.print(Reader.DELIMITER);
            printWriter.println(r.getBooking().getHour());

        }
    }
}

