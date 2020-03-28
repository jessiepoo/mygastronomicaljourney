package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;

// A restaurant collection that includes the restaurants the user would like to try
public class ToTryCollection implements Saveable, RestaurantCollections {

    public ArrayList<Restaurant> restaurantList;

    // Constructs a restaurant collection with an empty list of restaurants
    public ToTryCollection() {
        restaurantList = new ArrayList<Restaurant>();
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurantList.add(restaurant);
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
