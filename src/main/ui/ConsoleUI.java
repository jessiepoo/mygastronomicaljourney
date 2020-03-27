package ui;

import exceptions.EmptyRestaurantNameException;
import model.Restaurant;
import model.RestaurantCollection;
import persistence.Reader;
import persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;


// Restaurant collection application
public class ConsoleUI {

    RestaurantCollectionApp myApp;
    private static final String TRIED_FILE = "./data/triedCollection.txt";
    private static final String TO_TRY_FILE = "./data/toTryCollection.txt";
    private RestaurantCollection tried;
    private RestaurantCollection toTry;
    private Scanner input;

    // EFFECTS: runs the collection application
    public ConsoleUI() {
        myApp = new RestaurantCollectionApp();
        runCollection();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runCollection() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        System.out.println("Welcome to your gastronomical journey!");
        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("4")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nHappy eating! ꒰✩’ω`ૢ✩꒱");
    }



    // MODIFIES: this
    // EFFECTS: loads restaurants from TRIED_FILE and TO_TRY_FILE, if those file exists
    // otherwise initializes accounts with default values
//    void loadRestaurants() {
//        try {
//            tried = new RestaurantCollection();
//            toTry = new RestaurantCollection();
//            ArrayList<Restaurant> triedRestaurants = Reader.readRestaurants(new File(TRIED_FILE));
//            ArrayList<Restaurant> toTryRestaurants = Reader.readRestaurants(new File(TO_TRY_FILE));
//            tried.restaurantList = triedRestaurants;
//            toTry.restaurantList = toTryRestaurants;
//        } catch (IOException e) {
//            init();
//        }
//    }

//    // EFFECTS: saves state of restaurants to TRIED_FILE and TO_TRY_FILE
//    private void saveRestaurants() {
//        try {
//            Writer triedWriter = new Writer(new File(TRIED_FILE));
//            triedWriter.write(tried);
//            triedWriter.close();
//
//            Writer toTryWriter = new Writer(new File(TO_TRY_FILE));
//            toTryWriter.write(toTry);
//            toTryWriter.close();
//            System.out.println("Restaurants saved to files " + TRIED_FILE + " and " + TO_TRY_FILE);
//
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to save accounts to file " + TRIED_FILE + " and " + TO_TRY_FILE);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("1")) {
            triedOptionSelected();
        } else if (command.equals("2")) {
            toTryOptionSelected();
        } else if (command.equals("3")) {
            myApp.saveRestaurants();
        } else {
            System.out.println("Sorry, that is not an option...");
        }
    }

//    // EFFECTS; initializes the tried collection and the to-try collection.
//    private void init() {
//        tried = new RestaurantCollection();
//        toTry = new RestaurantCollection();
//    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\n Select from:");
        System.out.println("\t1 ➳ collection of tried restaurants");
        System.out.println("\t2 ➳ collection of to-try collections");
        System.out.println("\t3 ➳ save collections");
        System.out.println("\t4 ➳ quit application");
    }

    // REQUIRES: tried option must be selected
    // EFFECTS: when tried option is selected, brings user to viewing options
    private void triedOptionSelected() {
        RestaurantCollection selected = tried;

        String selection = "";

        while (!(selection.equals("v") || selection.equals("a") || selection.equals("b"))) {
            System.out.println("a ➳ add a restaurant to this collection");
            System.out.println("v ➳ view restaurants in this collection");
            System.out.println("b ➳ make a booking for a restaurant in this collection");
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

    // MODIFIES: tries
    // EFFECTS: allows users to add a restaurant to the tried collection.
    private void addTriedRestaurant() {
        System.out.print("Enter the name of restaurant (underlines for spaces): ");
        String name = input.next();
        Restaurant newRestaurant = null;
        try {
            newRestaurant = new Restaurant(name);
            tried.addRestaurant(newRestaurant);
        } catch (EmptyRestaurantNameException e) {
            System.out.println("name of restaurant must be a non-empty string");
        }

        System.out.print("　"
                + " ∧＿∧\n"
                + "（｡･ω･｡)つ━☆・*。\n"
                + "⊂　　 ノ 　　　・゜+.\n"
                + "しーＪ　　　°。+ *´¨)\n"
                + "Give a star rating out of 5 for taste: ");
        double tasteRating = Double.parseDouble(input.next());
        newRestaurant.rateTaste(tasteRating);
        System.out.print("Give a star rating out of 5 for price: ");
        double priceRating = Double.parseDouble(input.next());
        newRestaurant.ratePrice(priceRating);
        System.out.print("Give a star rating out of 5 for service: ");
        double serviceRating = Double.parseDouble(input.next());
        newRestaurant.rateService(serviceRating);
        System.out.println(newRestaurant.getRestaurantName() + " has been added to this collection.");
    }

    // REQUIRES: selection needs to be one of "n", "o", "t", "p" or "s"
    // EFFECTS: shows the list of restaurants corresponding to how the user chose to sort it.
    private void chooseViewOptions() {
        String selection = "";
        while (!(selection.equals("n") || selection.equals("o") || selection.equals("t") || selection.equals("p")
                || selection.equals("s"))) {
            printChooseViewOptions();
            selection = input.next();
            selection = selection.toLowerCase();
        }
        if (selection.equals("n")) {
            System.out.println(tried.viewAllRestaurants(tried.getSortedRestaurantsByName()));
        }
        if (selection.equals("o")) {
            System.out.println(tried.viewAllRestaurants(tried.getSortedRestaurantOverall()));
        }
        if (selection.equals("t")) {
            System.out.println(tried.viewAllRestaurants(tried.getSortedRestaurantsByTaste()));
        }
        if (selection.equals("p")) {
            System.out.println((tried.viewAllRestaurants(tried.getSortedRestaurantsByPrice())));
        }
        if (selection.equals("s")) {
            System.out.println(tried.viewAllRestaurants(tried.getSortedRestaurantsByService()));
        }
    }

    // EFFECTS: prints the viewing options for user to choose from
    private void printChooseViewOptions() {
        System.out.println("n ➳ view by name");
        System.out.println("o ➳ view by overall rating");
        System.out.println("t ➳ view by taste rating");
        System.out.println("p ➳ view by price rating");
        System.out.println("s ➳ view by service rating");
    }

    // REQUIRES: Another booking is not made during the same time
    // MODIFIES: tried
    // EFFECTS: Allows user to make a booking by entering necessary fields
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
                restaurant.getBooking().setAll(year, month, day, hour, seats);
                printBookingConfirmation(restaurant.getRestaurantName(), restaurant.getBooking().getYear(),
                        restaurant.getBooking().getMonth(), restaurant.getBooking().getDay(),
                        restaurant.getBooking().getHour(), restaurant.getBooking().getSeats());
            }
        }
    }

    // EFFECTS:  Displays options for the to try collection to the user.
    public void toTryOptionSelected() {

        String selection = "";

        while (!(selection.equals("v") || selection.equals("a") || selection.equals("r") || selection.equals("b"))) {
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
        } else if (selection.equals("r")) {
            removeToTryRestaurant();
        } else {
            toTryChooseRestaurantToBook();
        }
    }

    // EFFECTS: displays the to try collection restaurant list to the user
    private void toTryViewOptions() {
        System.out.println(toTry.viewAllRestaurants(toTry.restaurantList));
    }

    // MODIFIES: totry
    // EFFECTS: adds a restaurant to the to try restaurant list
    void addToTryRestaurant() {
        System.out.println("Enter the name of a restaurant you would like to try (underlines for spaces): ");
        String name = input.next();
        Restaurant newRestaurant = null;
        try {
            newRestaurant = new Restaurant(name);
            tried.addRestaurant(newRestaurant);
        } catch (EmptyRestaurantNameException e) {
            System.out.println("name of restaurant must be a non-empty string");
        }
        toTry.addRestaurant(newRestaurant);
        System.out.print(newRestaurant.getRestaurantName() + " has been added to collection");
    }

    // REQUIRES: collection must already have restaurants
    // MODIFIES: totry
    // EFFECTS: removes the specified restaurant in the ToTry Collection
    private void removeToTryRestaurant() {
        System.out.print("Here are the restaurants in your To-try Collection: ");
        System.out.println("\n" + toTry.viewAllRestaurants(toTry.restaurantList));
        System.out.println("Enter the name of the restaurant you would like to remove (underlines for spaces): ");
        String name = input.next();

        Restaurant removedRestaurant = null;
        for (Restaurant restaurant : toTry.restaurantList) {
            if (restaurant.getRestaurantName().equals(name)) {
                removedRestaurant = restaurant;
                System.out.println(removedRestaurant.getRestaurantName() + " has been removed from collection.");
            } else {
                System.out.println(name + " is not found in the collection");
            }
        }
        toTry.restaurantList.remove(removedRestaurant);
    }

    // MODIFIES: totry
    // EFFECTS: creates a booking for the specified restaurant
    private void toTryChooseRestaurantToBook() {
        System.out.println("Enter the name of the restaurant you would like to book!");
        System.out.println(toTry.viewAllRestaurants(toTry.restaurantList));
        String name = input.next();
        for (Restaurant restaurant : toTry.restaurantList) {
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
                restaurant.getBooking().setAll(year, month, day, hour, seats);
                printBookingConfirmation(restaurant.getRestaurantName(), restaurant.getBooking().getYear(),
                        restaurant.getBooking().getMonth(), restaurant.getBooking().getDay(),
                        restaurant.getBooking().getHour(), restaurant.getBooking().getSeats());
            }
        }
    }

    // REQUIRES: booking must be made
    // EFFECTS: prints out the booking confirmation
    private void printBookingConfirmation(String name, int year, int month, int day, int hour, int seats) {
        System.out.println("Booking has been made at " + name + " " + "on "
                + String.valueOf(year) + "/"
                + String.valueOf(month) + "/"
                + String.valueOf(day) + " at time "
                + String.valueOf(hour) + " for "
                + String.valueOf(seats) + " people.");
    }

}

