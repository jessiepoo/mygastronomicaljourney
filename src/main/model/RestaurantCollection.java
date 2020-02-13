package model;

import java.util.ArrayList;
import java.util.Collections;

// A collection of restaurants that can be sorted according to the restaurants rating
public class RestaurantCollection {

    public ArrayList<Restaurant> restaurantList;

    // Constructs a restaurant collection with an empty list of restaurants
    public RestaurantCollection() {
        restaurantList = new ArrayList<Restaurant>();
    }

    // EFFECTS: Adds a restaurant to the restaurant list
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

    public String viewAllRestaurants(ArrayList<Restaurant> restaurants) {
        String allRestaurants = "";

        for (Restaurant restaurant: restaurants) {
            String restName = restaurant.getRestaurantName();
            allRestaurants = allRestaurants + restName + "\n";

        }
        return allRestaurants;
    }
}

