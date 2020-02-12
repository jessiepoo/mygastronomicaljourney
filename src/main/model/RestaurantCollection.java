package model;

import java.util.ArrayList;
import java.util.Collections;


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

    // REQUIRES: restaurantList is a non-empty list
    // MODIFIES: this
    // EFFECTS: removes a restaurant from the list of restaurants
    public final void removeRestaurant(Restaurant restaurant) {
        restaurantList.remove(restaurant);
    }

    // EFFECTS: Returns the list of restaurants sorted by taste
    public ArrayList<Restaurant> getSortedRestaurantsByTaste() {
        Collections.sort(restaurantList, Restaurant.tasteComparator);
        Collections.reverse(restaurantList);
        return restaurantList;
    }

    // EFFECTS: Returns the list of restaurants sorted by price
    public ArrayList<Restaurant> getSortedRestaurantsByPrice() {
        Collections.sort(restaurantList, Restaurant.priceComparator);
        Collections.reverse((restaurantList));
        return restaurantList;
    }

    // EFFECTS: Returns the list of restaurants sorted by service
    public ArrayList<Restaurant> getSortedRestaurantsByService() {
        Collections.sort(restaurantList, Restaurant.serviceComparator);
        Collections.reverse(restaurantList);
        return restaurantList;
    }

    // EFFECTS: Returns the list of restaurants sorted by overall
    public ArrayList<Restaurant> getSortedRestaurantOverall() {
        Collections.sort(restaurantList, Restaurant.overallComparator);
        Collections.reverse(restaurantList);
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

