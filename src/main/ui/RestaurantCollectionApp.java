package ui;

import model.Restaurant;
import model.RestaurantCollection;
import persistence.Reader;
import persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class RestaurantCollectionApp {
    private static final String TRIED_FILE = "./data/triedCollection.txt";
    private static final String TO_TRY_FILE = "./data/toTryCollection.txt";
    protected RestaurantCollection tried;
    protected RestaurantCollection toTry;


    public RestaurantCollectionApp() {
        loadRestaurants();
    }

    // EFFECTS; initializes the tried collection and the to-try collection.
    private void init() {
        tried = new RestaurantCollection();
        toTry = new RestaurantCollection();
    }

    // MODIFIES: this
    // EFFECTS: loads restaurants from TRIED_FILE and TO_TRY_FILE, if those file exists
    // otherwise initializes accounts with default values
    void loadRestaurants() {
        try {
            tried = new RestaurantCollection();
            toTry = new RestaurantCollection();
            ArrayList<Restaurant> triedRestaurants = Reader.readRestaurants(new File(TRIED_FILE));
            ArrayList<Restaurant> toTryRestaurants = Reader.readRestaurants(new File(TO_TRY_FILE));
            tried.restaurantList = triedRestaurants;
            toTry.restaurantList = toTryRestaurants;
        } catch (IOException e) {
            init();
        }
    }

    // EFFECTS: saves state of restaurants to TRIED_FILE and TO_TRY_FILE
    protected void saveRestaurants() {
        try {
            Writer triedWriter = new Writer(new File(TRIED_FILE));
            triedWriter.write(tried);
            triedWriter.close();

            Writer toTryWriter = new Writer(new File(TO_TRY_FILE));
            toTryWriter.write(toTry);
            toTryWriter.close();
            System.out.println("Restaurants saved to files " + TRIED_FILE + " and " + TO_TRY_FILE);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to save accounts to file " + TRIED_FILE + " and " + TO_TRY_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    protected void addTriedRestaurant(String name, double tasteRating, double priceRating, double serviceRating) {
        System.out.print("Enter the name of restaurant (underlines for spaces): ");
        Restaurant newRestaurant = new Restaurant(name);
        tried.addRestaurant(newRestaurant);
        System.out.print("　"
                + " ∧＿∧\n"
                + "（｡･ω･｡)つ━☆・*。\n"
                + "⊂　　 ノ 　　　・゜+.\n"
                + "しーＪ　　　°。+ *´¨)\n"
                + "Give a star rating out of 5 for taste: ");
        newRestaurant.rateTaste(tasteRating);
        System.out.print("Give a star rating out of 5 for price: ");
        newRestaurant.ratePrice(priceRating);
        System.out.print("Give a star rating out of 5 for service: ");
        newRestaurant.rateService(serviceRating);
        System.out.println(newRestaurant.getRestaurantName() + " has been added to this collection.");
    }

    void addToTryRestaurant(String name) {
        Restaurant newRestaurant = new Restaurant(name);
        toTry.addRestaurant(newRestaurant);
    }


}
