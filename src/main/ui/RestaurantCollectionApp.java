package ui;

import model.Restaurant;
import model.RestaurantCollection;
import persistence.Reader;
import persistence.Saveable;
import persistence.Writer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Restaurant collection application
public class RestaurantCollectionApp {

    private static final String COLLECTIONS_FILE = "./data/collections.txt";
    private RestaurantCollection tried;
    private RestaurantCollection totry;
    private Scanner input;

    // EFFECTS: runs the collection application
    public RestaurantCollectionApp() {
        runCollection();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runCollection() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        loadCollections();

        System.out.println("Welcome to your gastronomical journey!");
        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("3")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nHappy eating! ꒰✩’ω`ૢ✩꒱");
    }

    // MODIFIES: this
    // EFFECTS: loads accounts from COLLECTIONS_FILE, if that file exists;
    // otherwise initializes collections with default values
    private void loadCollections() {
        try {
            List<RestaurantCollection> restaurantCollections = Reader.readCollections(new File(COLLECTIONS_FILE));
            tried = restaurantCollections.get(0);
            totry = restaurantCollections.get(1);
        } catch (IOException e) {
            init();
        }
    }

    // EFFECTS: saves state of tried restaurants and to-try restaurants to COLLECTIONS_FILE
    private void saveCollections() {
        try {
            Writer writer = new Writer(new File(COLLECTIONS_FILE));
            writer.write((Saveable) tried);
            writer.write((Saveable) totry);
            writer.close();
            System.out.println("Collections saved to file" + COLLECTIONS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save collections to" + COLLECTIONS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("1")) {
            triedOptionSelected();
        } else if (command.equals("2")) {
            toTryOptionSelected();
        }
    }

    private void init() {
        tried = new RestaurantCollection();
        totry = new RestaurantCollection();
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\n Select from:");
        System.out.println("\t1 ➳ restaurants you have tried");
        System.out.println("\t2 ➳ restaurants you would like to try");
        System.out.println("\t3 ➳ quit application");
    }

    private void triedOptionSelected() {
        RestaurantCollection selected = tried;

        String selection = "";

        while (!(selection.equals("v") || selection.equals("a") || selection.equals("b"))) {
            System.out.println("a ➳ add a restaurant");
            System.out.println("v ➳ view restaurants");
            System.out.println("b ➳ make a booking for a restaurant");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("v")) {
            chooseViewOptions();
        } else if (selection.equals("a")) {
            addTriedRestaurant();
        } else {
            chooseRestaurantToBook();
        }
    }

    private void addTriedRestaurant() {
        System.out.print("Enter the name of restaurant (underlines for spaces): ");
        String name = input.next();
        Restaurant newRestaurant = new Restaurant(name);
        tried.addRestaurant(newRestaurant);

        System.out.print("　" +
                "∧＿∧\n" +
                "（｡･ω･｡)つ━☆・*。\n" +
                "⊂　　 ノ 　　　・゜+.\n" +
                "しーＪ　　　°。+ *´¨)\n" +
                "Give a star rating out of 5 for taste: ");
        double tasteRating = Double.parseDouble(input.next());
        newRestaurant.rateTaste(tasteRating);

        System.out.print("　" +
                "∧＿∧\n" +
                "（｡･ω･｡)つ━☆・*。\n" +
                "⊂　　 ノ 　　　・゜+.\n" +
                "しーＪ　　　°。+ *´¨)\n" +
                "Give a star rating out of 5 for price: ");
        double priceRating = Double.parseDouble(input.next());
        newRestaurant.ratePrice(priceRating);

        System.out.print("　" +
                "∧＿∧\n" +
                "（｡･ω･｡)つ━☆・*。\n" +
                "⊂　　 ノ 　　　・゜+.\n" +
                "しーＪ　　　°。+ *´¨)\n" +
                "Give a star rating out of 5 for service: ");
        double serviceRating = Double.parseDouble(input.next());
        newRestaurant.rateService(serviceRating);
        System.out.println(newRestaurant.getRestaurantName() + " has been added to this collection.");
    }

    private void chooseViewOptions() {
        String selection = "";

        while (!(selection.equals("n") ||
                selection.equals("o") ||
                selection.equals("t") ||
                selection.equals("p") ||
                selection.equals("s"))) {
            System.out.println("n ➳ view by name");
            System.out.println("o ➳ view by overall rating");
            System.out.println("t ➳ view by taste rating");
            System.out.println("p ➳ view by price rating");
            System.out.println("s ➳ view by service rating");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("n")) {
            ArrayList<Restaurant> restaurantsByName = tried.getSortedRestaurantsByName();
            System.out.println(tried.viewAllRestaurants(restaurantsByName));
        }
        if (selection.equals("o")) {
            ArrayList<Restaurant> restaurantsByOverall = tried.getSortedRestaurantOverall();
            System.out.println(tried.viewAllRestaurants(restaurantsByOverall));
        }
        if (selection.equals("t")) {
            ArrayList<Restaurant> restaurantsByTaste = tried.getSortedRestaurantsByTaste();
            System.out.println(tried.viewAllRestaurants(restaurantsByTaste));
        }
        if (selection.equals("p")) {
            ArrayList<Restaurant> restaurantsByPrice = tried.getSortedRestaurantsByPrice();
            System.out.println((tried.viewAllRestaurants(restaurantsByPrice)));
        }
        if (selection.equals("s")) {
            ArrayList<Restaurant> restaurantsByService = tried.getSortedRestaurantsByService();
            System.out.println(tried.viewAllRestaurants(restaurantsByService));
        }

    }

    private void chooseRestaurantToBook() {
        System.out.println("Enter the name of the restaurant you would like to book!");
        System.out.println(tried.viewAllRestaurants(tried.restaurantList));
        String name = input.next();
        for (Restaurant restaurant : tried.restaurantList) {
            if (restaurant.getRestaurantName().equals(name)) {
                System.out.println("Enter the year you would like to book on: ");
                int year = Integer.parseInt(input.next());
                System.out.println("Enter the month (1-12) you would like to book on: ");
                int month = Integer.parseInt(input.next());
                System.out.println("Enter the day you would like to book on: ");
                int day = Integer.parseInt(input.next());
                System.out.println("Enter the hour you would like to book at (24 hours): ");
                int hour = Integer.parseInt(input.next());
                System.out.println("Enter the number of seats you would like to book: ");
                int seats = Integer.parseInt(input.next());
                restaurant.getBooking().setYear(year);
                restaurant.getBooking().setMonth(month);
                restaurant.getBooking().setDay(day);
                restaurant.getBooking().setHour(hour);
                restaurant.getBooking().setSeats(seats);
                System.out.println("Booking has been made at " + restaurant.getRestaurantName() + " " + "on "
                        + String.valueOf(restaurant.getBooking().getYear()) + "/"
                        + String.valueOf(restaurant.getBooking().getMonth()) + "/"
                        + String.valueOf(restaurant.getBooking().getDay()) + " at time "
                        + String.valueOf(restaurant.getBooking().getHour()) + " for "
                        + String.valueOf(restaurant.getBooking().getSeats()) + " people.");

            }
        }
    }


    public void toTryOptionSelected() {
        RestaurantCollection selected = totry;

        String selection = "";

        while (!(selection.equals("v") || selection.equals("a") || selection.equals("b"))) {
            System.out.println("a ➳ add a restaurant");
            System.out.println("r ➳ remove a restaurant");
            System.out.println("v ➳ view restaurants");
            System.out.println("b ➳ make a booking for a restaurant");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("v")) {
            toTryViewOptions();
        } else if (selection.equals("a")) {
            addToTryRestaurant();
        } else if (selected.equals("r")) {
            removeToTryRestaurant();
        } else {
            toTryChooseRestaurantToBook();
        }
    }

    private void toTryViewOptions() {
        System.out.println(totry.viewAllRestaurants(totry.restaurantList));
    }

    private void addToTryRestaurant() {
        System.out.print("Enter the name of a restaurant you would like to try (underlines for spaces): ");
        String name = input.next();
        Restaurant newRestaurant = new Restaurant(name);
        totry.addRestaurant(newRestaurant);
    }

    // REQUIRES: collection must already have restaurants
    // EFFECTS: removes the specified restaurant in the ToTry Collection
    private void removeToTryRestaurant() {
        System.out.println("Here are the restaurants in your To-try Collection: ");
        System.out.println(totry.viewAllRestaurants(totry.restaurantList));
        System.out.println("Enter the name of the restaurant you would like to remove (underlines for spaces): ");
        String name = input.next();
        for (Restaurant restaurant : totry.restaurantList) {
            if (restaurant.getRestaurantName().equals(name)) {
                Restaurant removedRestaurant = restaurant;
                totry.restaurantList.remove(restaurant);
                System.out.println(removedRestaurant.getRestaurantName() + " has been removed from collection.");
            }
        }
    }

    private void toTryChooseRestaurantToBook() {
        System.out.println("Enter the name of the restaurant you would like to book!");
        System.out.println(totry.viewAllRestaurants(totry.restaurantList));
        String name = input.next();
        for (Restaurant restaurant : totry.restaurantList) {
            if (restaurant.getRestaurantName().equals(name)) {
                System.out.println("Enter the year you would like to book on: ");
                int year = Integer.parseInt(input.next());
                System.out.println("Enter the month (1-12) you would like to book on: ");
                int month = Integer.parseInt(input.next());
                System.out.println("Enter the day you would like to book on: ");
                int day = Integer.parseInt(input.next());
                System.out.println("Enter the hour you would like to book at (24 hours): ");
                int hour = Integer.parseInt(input.next());
                System.out.println("Enter the number of seats you would like to book: ");
                int seats = Integer.parseInt(input.next());
                restaurant.getBooking().setYear(year);
                restaurant.getBooking().setMonth(month);
                restaurant.getBooking().setDay(day);
                restaurant.getBooking().setHour(hour);
                restaurant.getBooking().setSeats(seats);
                System.out.println("Booking has been made at " + " " + restaurant.getRestaurantName() + " " + "on "
                        + String.valueOf(restaurant.getBooking().getYear()) + "/"
                        + String.valueOf(restaurant.getBooking().getMonth()) + "/"
                        + String.valueOf(restaurant.getBooking().getDay()) + " at time "
                        + String.valueOf(restaurant.getBooking().getHour()) + " for "
                        + String.valueOf(restaurant.getBooking().getSeats()) + " people.");
            }
        }
    }
}

