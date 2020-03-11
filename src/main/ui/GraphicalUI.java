package ui;

import model.RestaurantCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;

public class GraphicalUI {
    RestaurantCollectionApp myApp;
   // JLabel welcomeLabel = new JLabel("Welcome To Your Gastronomical Journey", SwingConstants.CENTER);
   // JLabel chooseCollectionLabel = new JLabel("Choose from your collections", SwingConstants.CENTER);



    public GraphicalUI() {
        myApp = new RestaurantCollectionApp();
    }


    public void displayJFrame(JFrame jframe) {
        // set the jframe title
        jframe.setSize(600,500);
        jframe.setLocationRelativeTo(null);
 //       jframe.setLayout(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton enterButton = new JButton("Start");
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayChooseCollectionScreen(jframe);
                enterButton.setVisible(false);
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,0));
        panel.add(new JLabel("Welcome To Your Gastronomical Journey", SwingConstants.CENTER));
        panel.add(enterButton);
        jframe.add(panel);
        jframe.setVisible(true);
    }

    public void displayChooseCollectionScreen(JFrame jframe) {
      //  welcomeLabel.setVisible(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 0));
        JButton triedButton = new JButton("Restaurants you have tried");
        JButton toTryButton = new JButton("Restaurants you want to try");
        panel.add(new JLabel("Choose from your collections", SwingConstants.CENTER));
        panel.add(triedButton);
        panel.add(toTryButton);
        jframe.add(panel);
      //  chooseCollectionLabel.setVisible(true);
        toTryButton.setVisible(true);
        triedButton.setVisible(true);




        triedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFromTriedOptions(jframe);
                triedButton.setVisible(false);
                toTryButton.setVisible(false);
         //       chooseCollectionLabel.setVisible(false);
            }
        });
        toTryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                triedButton.setVisible(false);
                toTryButton.setVisible(false);
         //       chooseCollectionLabel.setVisible(false);
            }
        });
    }

    public void chooseFromTriedOptions(JFrame jframe) {
   //     chooseCollectionLabel.setVisible(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,0));
        JButton addRestaurantButton = new JButton("Add a restaurant to this collection");
        JButton viewRestaurantsButton = new JButton("View restaurants in this collection");
        JButton makeBookingButton = new JButton("Make a booking for a restaurant");
        panel.add(addRestaurantButton);
        panel.add(viewRestaurantsButton);
        panel.add(makeBookingButton);
        jframe.add(panel);
        jframe.setVisible(true);
        addRestaurantButton.setVisible(true);
        viewRestaurantsButton.setVisible(true);
        makeBookingButton.setVisible(true);

        addRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displayAddTriedRestaurant(jframe);
                addRestaurantButton.setVisible(false);
                viewRestaurantsButton.setVisible(false);
                makeBookingButton.setVisible(false);
            }
        });
        viewRestaurantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        makeBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void displayAddTriedRestaurant(JFrame jframe) {
        JLabel restaurantNameLabel = new JLabel("Restaurant name ");
        JLabel tasteRatingLabel = new JLabel("Rate taste ");
        JLabel priceRatingLabel = new JLabel("Rate price ");
        JLabel serviceRatingLabel = new JLabel("Rate service ");

        JTextField textRestaurantName = new JTextField("Restaurant name", 10);
        textRestaurantName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFromTriedOptions(jframe);
            }
        });
        JTextField textTasteRating = new JTextField("Taste rating", 10);
        JTextField textPriceRating = new JTextField("Price rating", 10);
        JTextField textServiceRating = new JTextField("Service rating", 10);

        JButton buttonDone = new JButton("Done");

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new BoxLayout(newPanel, BoxLayout.Y_AXIS));
        newPanel.add(buttonDone);
        newPanel.add(restaurantNameLabel);
        newPanel.add(textRestaurantName);
        newPanel.add(tasteRatingLabel);
        newPanel.add(textRestaurantName);
        newPanel.add(textTasteRating);
        newPanel.add(priceRatingLabel);
        newPanel.add(textPriceRating);
        newPanel.add(serviceRatingLabel);
        newPanel.add(textServiceRating);


        jframe.add(newPanel);
        jframe.setVisible(true);
        
    }
}
