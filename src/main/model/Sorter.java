package model;


import java.util.ArrayList;
import java.util.Collections;

// Sorts a list of restaurants accordingly
public class Sorter {

    public Sorter(ArrayList<Restaurant> r) {
    }

    public ArrayList<Restaurant> sortByPrice(ArrayList<Restaurant> restaurants) {
        Collections.sort(restaurants, Restaurant.priceComparator);
        return restaurants;
    }

    public ArrayList<Restaurant> sortByTaste(ArrayList<Restaurant> restaurants) {
        Collections.sort(restaurants, Restaurant.tasteComparator);
        return restaurants;
    }

    public ArrayList<Restaurant> sortByService(ArrayList<Restaurant> restaurants) {
        Collections.sort(restaurants, Restaurant.serviceComparator);
        return restaurants;
    }

    public ArrayList<Restaurant> sortByOverall(ArrayList<Restaurant> restaurants) {
        Collections.sort(restaurants, Restaurant.overallComparator);
        return restaurants;
    }

    public ArrayList<Restaurant> sortByName(ArrayList<Restaurant> restaurants) {
        Collections.sort(restaurants, Restaurant.nameComparator);
        return restaurants;
    }


}
