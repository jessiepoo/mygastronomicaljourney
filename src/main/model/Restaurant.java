package model;

import exceptions.EmptyRestaurantNameException;

import java.util.ArrayList;
import java.util.Comparator;

// A restaurant that has a certain rating for taste, price and service and where bookings can be made.
public class Restaurant {

    private String restaurantName;
    private double tasteRating;
    private double priceRating; // Higher rating represents lower price
    private double serviceRating;
    private double overallRating; // Average of all 3 ratings
    private Booking booking;


    // REQUIRES: restaurantName is not a non-empty string
    // EFFECTS: Constructs Restaurant with the name of this restaurant.
    public Restaurant(String restaurantName) throws EmptyRestaurantNameException {
        if (restaurantName == "") {
            throw new EmptyRestaurantNameException("Restaurant name empty");
        }
        this.restaurantName = restaurantName;
        tasteRating = 0;
        priceRating = 0;
        serviceRating = 0;
        overallRating = 0;
        booking = new Booking();
    }

    // EFFECTS: gets the name of this restaurant
    public String getRestaurantName() {
        return restaurantName;
    }

    // EFFECTS: gets the taste rating of this restaurant
    public double getTasteRating() {
        return tasteRating;
    }

    // EFFECTS: gets the price rating of this restaurant
    public double getPriceRating() {
        return priceRating;
    }

    // EFFECTS: gets the service rating of this restaurant
    public double getServiceRating() {
        return serviceRating;
    }

    // EFFECTS: gets the overall rating of this restaurant
    public double getOverallRating() {
        return overallRating;
    }

    // EFFECTS: gets the booking of this restaurant
    public Booking getBooking() {
        return booking;
    }


    // REQUIRES: rating must be between 0 and 5
    // MODIFIES: this
    // EFFECTS: calculates the overall rating of this restaurant
    public void rateTaste(double rating) {
        this.tasteRating = rating;
        overallRating = (tasteRating + priceRating + serviceRating) / 3;
    }

    // REQUIRES: rating must be between 0 and 5
    // MODIFIES: this
    // EFFECTS: rates the pricing of this restaurant (higher rating corresponds to lower prices)
    public void ratePrice(double rating) {
        this.priceRating = rating;
        overallRating = (tasteRating + priceRating + serviceRating) / 3;
    }

    // REQUIRES: rating must be between 0 and 5
    // MODIFIES: this
    // EFFECTS: rates the service of this restaurant
    public void rateService(Double rating) {
        this.serviceRating = rating;
        overallRating = (tasteRating + priceRating + serviceRating) / 3;
    }


    // EFFECTS: Sets up the restaurant objects as a comparator in terms of taste rating
    public static Comparator<Restaurant> tasteComparator = new Comparator<Restaurant>() {
        @Override
        public int compare(Restaurant restaurant1, Restaurant restaurant2) {
            return (restaurant1.getTasteRating() < restaurant2.getTasteRating() ?  1 :
                    (restaurant2.getTasteRating() == restaurant1.getTasteRating() ? 0 : -1));
        }
    };

    // EFFECTS: Sets up the restaurant objects as a comparator in terms of price rating
    public static Comparator<Restaurant> priceComparator = new Comparator<Restaurant>() {
        @Override
        public int compare(Restaurant restaurant1, Restaurant restaurant2) {
            return (restaurant1.getPriceRating() < restaurant2.getPriceRating() ? 1 :
                    (restaurant2.getPriceRating() == restaurant1.getPriceRating() ? 0 : -1));
        }
    };

    // EFFECTS: Sets up the restaurant objects as a comparator in terms of service rating
    public static Comparator<Restaurant> serviceComparator = new Comparator<Restaurant>() {
        @Override
        public int compare(Restaurant restaurant1, Restaurant restaurant2) {
            return (restaurant1.getServiceRating() < restaurant2.getServiceRating() ? 1 :
                    (restaurant2.getServiceRating() == restaurant1.getServiceRating() ? 0 : -1));
        }
    };

    public static Comparator<Restaurant> overallComparator = new Comparator<Restaurant>() {
        @Override
        public int compare(Restaurant restaurant1, Restaurant restaurant2) {
            return (restaurant1.getOverallRating() < restaurant2.getOverallRating() ? 1 :
                    (restaurant2.getOverallRating() == restaurant1.getOverallRating() ? 0 : -1));
        }

    };

    // EFFECTS: Sets up the restaurant objects as a comparator in terms of alphabetized first letter
    public static Comparator<Restaurant> nameComparator = new Comparator<Restaurant>() {
        @Override
        public int compare(Restaurant restaurant1, Restaurant restaurant2) {
            return (int) (restaurant1.getRestaurantName().compareTo(restaurant2.getRestaurantName()));
        }
    };


}
