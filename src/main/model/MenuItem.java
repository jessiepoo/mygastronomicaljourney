package model;

// A menu item that a restaurant offers, including a name, price, and rating.
public class MenuItem {

    private String itemName;
    private double itemPrice;
    private double itemRating;

    // REQUIRES: itemName is of non-zero length, price is non-zero, rating is from 0 to 5
    // EFFECTS: constructs a menu item with name and price
    public MenuItem(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        itemRating = 0.0;
    }

    // EFFECTS: gets the item's name
    public String getItemName() {
        return itemName;
    }

    // EFFECTS: gets the item's price
    public double getItemPrice() {
        return itemPrice;
    }

    // EFFECTS: gets the item's rating
    public double getItemRating() {
        return itemRating;
    }

    // REQUIRES: rating must be between 0 and 5
    // MODIFIES: this
    // EFFECTS: adds a rating for the menu item
    public void rateItem(double rating) {
        this.itemRating = rating;
    }

}


