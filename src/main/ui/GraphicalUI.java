package ui;

import model.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,0));
        panel.add(new JLabel("Welcome To Your Gastronomical Journey", SwingConstants.CENTER));
        panel.add(enterButton);
        jframe.add(panel);
        jframe.setVisible(true);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayChooseCollectionScreen(jframe);

                enterButton.setVisible(false);
                panel.setVisible(false);
            }
        });
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
        jframe.setVisible(true);
        triedButtonPressed(jframe, panel, triedButton, toTryButton);
        toTryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displayChooseFromToTryOptions(jframe);
         //
            }
        });
    }


    private void triedButtonPressed(JFrame jframe, JPanel panel, JButton triedButton, JButton toTryButton) {
        triedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayChooseFromTriedOptions(jframe);
                triedButton.setVisible(false);
                toTryButton.setVisible(false);
                panel.setVisible(false);
         //       chooseCollectionLabel.setVisible(false);
            }
        });
    }


    public void displayChooseFromTriedOptions(JFrame jframe) {
   //     chooseCollectionLabel.setVisible(false);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,0));
        JLabel triedRestaurantTitle = new JLabel("Restaurants You Have Tried");
        triedRestaurantTitle.setHorizontalAlignment(JLabel.CENTER);
        JButton addRestaurantButton = new JButton("Add a restaurant to this collection");
        JButton viewRestaurantsButton = new JButton("View restaurants in this collection");
        JButton makeBookingButton = new JButton("Make a booking for a restaurant");
        JButton backButton = new JButton("Back");
        addTriedElements(panel, triedRestaurantTitle, addRestaurantButton, viewRestaurantsButton, makeBookingButton,
                backButton);
        jframe.add(panel);
        setTriedVisibility(jframe, addRestaurantButton, viewRestaurantsButton, makeBookingButton);

        addRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panel.setVisible(false);
                displayAddTriedRestaurant(jframe);
//                addRestaurantButton.setVisible(false);
//                viewRestaurantsButton.setVisible(false);
//                makeBookingButton.setVisible(false);
//                backButton.setVisible(false);
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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayChooseCollectionScreen(jframe);
                panel.setVisible(false);
            }
        });
    }

    public void displayChooseFromToTryOptions(JFrame jframe) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 0));
        JLabel toTryRestaurantTitle = new JLabel("Restaurants To Try:");
        toTryRestaurantTitle.setHorizontalAlignment(JLabel.CENTER);
        JButton addRestaurantButton = new JButton("Add a restaurant to this collection");
        JButton viewRestaurantsButton = new JButton("View restaurants in this collection");
        JButton makeBookingButton = new JButton("Make a booking for a restaurant");
        JButton backButton = new JButton("Back");
        addTriedElements(panel, toTryRestaurantTitle, addRestaurantButton, viewRestaurantsButton, makeBookingButton,
                backButton);
        jframe.add(panel);
        setTriedVisibility(jframe, addRestaurantButton, viewRestaurantsButton, makeBookingButton);

        addRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panel.setVisible(false);
                displayAddToTryRestaurant(jframe);
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

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayChooseCollectionScreen(jframe);
                panel.setVisible(false);
            }
        });
    }




    private void setTriedVisibility(JFrame jframe, JButton addRestaurantButton, JButton viewRestaurantsButton, JButton makeBookingButton) {
        jframe.setVisible(true);
        addRestaurantButton.setVisible(true);
        viewRestaurantsButton.setVisible(true);
        makeBookingButton.setVisible(true);
    }

    private void addTriedElements(JPanel panel, JLabel triedRestaurantTitle, JButton addRestaurantButton, JButton viewRestaurantsButton, JButton makeBookingButton, JButton backButton) {
        panel.add(triedRestaurantTitle);
        panel.add(addRestaurantButton);
        panel.add(viewRestaurantsButton);
        panel.add(makeBookingButton);
        panel.add(backButton);
    }

    public void displayAddTriedRestaurant(JFrame jframe) {
        JLabel restaurantNameLabel = new JLabel("      Restaurant name: ");
        JLabel tasteRatingLabel = new JLabel("      Rate taste: ");
        JLabel priceRatingLabel = new JLabel("      Rate price: ");
        JLabel serviceRatingLabel = new JLabel("     Rate service: ");

        JTextField textRestaurantName = new JTextField(8);
        JTextField textTasteRating = new JTextField(8);
        JTextField textPriceRating = new JTextField(8);
        JTextField textServiceRating = new JTextField(8);

        JButton buttonDone = new JButton("Done");
        JButton buttonBack = new JButton("Go back");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));

        panel.add(restaurantNameLabel);
        panel.add(textRestaurantName);
        panel.add(tasteRatingLabel);
        panel.add(textTasteRating);
        panel.add(priceRatingLabel);
        panel.add(textPriceRating);
        panel.add(serviceRatingLabel);
        panel.add(textServiceRating);
        panel.add(buttonBack);
        panel.add(buttonDone);

        jframe.add(panel);
        jframe.setVisible(true);

        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonDone.setVisible(false);
                String name = textRestaurantName.getText();
                Double taste = Double.parseDouble(textTasteRating.getText());
                Double price = Double.parseDouble(textPriceRating.getText());
                Double service = Double.parseDouble(textServiceRating.getText());
                myApp.addTriedRestaurant(name,taste,price,service);
                displayAddedTriedRestaurant(jframe, name);
                panel.setVisible(false);
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayChooseFromTriedOptions(jframe);
                panel.setVisible(false);
            }
        });
    }

    public void displayAddToTryRestaurant(JFrame jframe) {
        JLabel labelRestaurantName = new JLabel("Restaurant name: ");
        JTextField textRestaurantName = new JTextField(10);
        JButton buttonDone = new JButton("Done");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,0));
        panel.add(labelRestaurantName);
        panel.add(textRestaurantName);
        panel.add(buttonDone);

        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                String name = textRestaurantName.getText();
                myApp.addToTryRestaurant(name);

            }
        });
    }

    public void displayAddedTriedRestaurant(JFrame jframe, String restaurantName) {
        String name;
        Double taste;
        Double price;
        Double service;
        Double overall;
        JLabel labelRestaurantName = new JLabel();
        JLabel labelOverallRating = new JLabel();
        JLabel labelTasteRating = new JLabel();
        JLabel labelPriceRating = new JLabel();
        JLabel labelServiceRating = new JLabel();
        JButton buttonBack = new JButton("Back");


        for (Restaurant r : myApp.tried.restaurantList) {
            if (restaurantName == r.getRestaurantName()) {
                name = r.getRestaurantName();
                taste = r.getTasteRating();
                price = r.getPriceRating();
                service = r.getServiceRating();
                overall = r.getOverallRating();

                labelRestaurantName.setText(String.valueOf(new StringBuilder().append("   Restaurant ").append(name)
                        .append(" has been added to collection.")));
                labelOverallRating.setText(String.valueOf(new StringBuilder().append("   Overall rating: ")
                        .append(overall)));
                labelTasteRating.setText(String.valueOf(new StringBuilder().append("   Taste rating: ").append(taste)));
                labelPriceRating.setText(String.valueOf(new StringBuilder().append("   Price rating: ").append(price)));
                labelServiceRating.setText(String.valueOf(new StringBuilder().append("   Service rating: ")
                        .append(service)));
            }
            JPanel panel = new JPanel(new GridLayout(6,0));
            panel.add(labelRestaurantName);
            panel.add(labelOverallRating);
            panel.add(labelTasteRating);
            panel.add(labelPriceRating);
            panel.add(labelServiceRating);
            panel.add(buttonBack);

            jframe.add(panel);

            buttonBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setVisible(false);
                    displayChooseFromTriedOptions(jframe);
                }
            });
        }
    }

    void displayAddedToTryRestaurant(JFrame jframe, String restaurantName) {

    }


}
