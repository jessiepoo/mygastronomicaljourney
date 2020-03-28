package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

// A collection of restaurants that can be sorted according to the restaurants rating
public class TriedCollection implements Saveable, RestaurantCollections {

    public ArrayList<Restaurant> restaurantList;

    // Constructs a restaurant collection with an empty list of restaurants
    public TriedCollection() {
        restaurantList = new ArrayList<Restaurant>();
    }

    // EFFECTS: Adds a restaurant to the restaurant list
    @Override
    public final void addRestaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);
    }

    // EFFECTS: Returns the list of restaurants sorted by taste
    public ArrayList<Restaurant> getSortedRestaurantsByTaste() {
        Collections.sort(restaurantList, Restaurant.tasteComparator);
        return restaurantList;
    }

    // EFFECTS: Returns the list of restaurants sorted by price
    public ArrayList<Restaurant> getSortedRestaurantsByPrice() {
        Collections.sort(restaurantList, Restaurant.priceComparator);
        return restaurantList;
    }

    // EFFECTS: Returns the list of restaurants sorted by service
    public ArrayList<Restaurant> getSortedRestaurantsByService() {
        Collections.sort(restaurantList, Restaurant.serviceComparator);
        return restaurantList;
    }

    // EFFECTS: Returns the list of restaurants sorted by overall
    public ArrayList<Restaurant> getSortedRestaurantOverall() {
        Collections.sort(restaurantList, Restaurant.overallComparator);
        return restaurantList;
    }

    // EFFECTS: Returns the list of restaurants sorted by name
    public ArrayList<Restaurant> getSortedRestaurantsByName() {
        Collections.sort(restaurantList, Restaurant.nameComparator);
        return restaurantList;
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

