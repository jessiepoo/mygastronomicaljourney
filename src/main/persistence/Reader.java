package persistence;

import exceptions.EmptyRestaurantNameException;
import model.Restaurant;
import model.RestaurantCollection;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// A reader that can read account data from a file
public class Reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of restaurants parsed from file;
    // throws IOException if an exception is raised when opening / reading from file
    public static ArrayList<Restaurant> readRestaurants(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings,
    // each string containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of Restaurants parsed from list of strings
    // where each string contains data for one restaurant
    private static ArrayList<Restaurant> parseContent(List<String> fileContent) {
        ArrayList<Restaurant> restaurants = new ArrayList<>();

        for (String line: fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            restaurants.add(parseRestaurant(lineComponents));
        }

        return restaurants;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components have size 11 where:
    // element 0 represents name of restaurant,
    // element 1 represents the taste rating,
    // element 2 represents the price rating,
    // element 3 represents the service rating,
    // element 4 represents whether booking has been made,
    // element 5 represents the number of seats of booking (0 if no booking),
    // element 6 represents the year of booking (0 if no booking),
    // element 7 represents the month of booking (0 if no booking),
    // element 8 represents the day of booking (0 if no booking),
    // element 9 represents the hour of booking (0 if no booking)
    // EFFECTS: returns a restaurant constructed from components
    private static Restaurant parseRestaurant(List<String> components) {
        String name = components.get(0);
        double taste = Double.parseDouble(components.get(1));
        double price = Double.parseDouble(components.get(2));
        double service = Double.parseDouble(components.get(3));
        boolean bookingIsMade = Boolean.parseBoolean(components.get(4));
        int seats = Integer.parseInt(components.get(5));
        int year = Integer.parseInt(components.get(6));
        int month = Integer.parseInt(components.get(7));
        int day = Integer.parseInt(components.get(8));
        int hour = Integer.parseInt(components.get(9));

        Restaurant restaurant = null;
        try {
            restaurant = new Restaurant(name);
        } catch (EmptyRestaurantNameException e) {
            System.out.println("name of restaurant must be a non-empty string");
        }
        restaurant.rateTaste(taste);
        restaurant.ratePrice(price);
        restaurant.rateService(service);
        restaurant.getBooking().setIsBooked(bookingIsMade);
        restaurant.getBooking().setAll(year, month, day, hour, seats);

        return restaurant;
    }
}
