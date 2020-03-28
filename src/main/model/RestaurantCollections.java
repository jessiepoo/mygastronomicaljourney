package model;

import java.io.PrintWriter;
import java.util.ArrayList;

public interface RestaurantCollections {

    public void addRestaurant(Restaurant restaurant);

    public String viewAllRestaurants(ArrayList<Restaurant> restaurants);


}
