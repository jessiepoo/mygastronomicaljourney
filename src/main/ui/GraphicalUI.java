package ui;

import model.Restaurant;
import model.RestaurantCollection;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
// import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

// import static com.sun.tools.internal.xjc.reader.Ring.add;

public class GraphicalUI {
    RestaurantCollectionApp myApp;
    // JLabel welcomeLabel = new JLabel("Welcome To Your Gastronomical Journey", SwingConstants.CENTER);
    // JLabel chooseCollectionLabel = new JLabel("Choose from your collections", SwingConstants.CENTER);


    public GraphicalUI() {
        myApp = new RestaurantCollectionApp();
    }

    public void displayJFrame(JFrame jframe) {
        // set the jframe title
        jframe.setSize(1000, 750);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton enterButton = new JButton("Enter");
        enterButton.setPreferredSize(new Dimension(50,20));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 0));
        panel.add(new JLabel("Welcome To Your Gastronomical Journey", SwingConstants.CENTER));
        panel.add(enterButton);
        jframe.add(panel);
        jframe.setVisible(true);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMusic("src/main/alina baraz feat. khalid - floating (lyrics) filous remix.wav");
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
        toTryBackButtonCommand(jframe, panel, toTryButton);
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
        panel.setLayout(new GridLayout(6, 0));
        JLabel triedRestaurantTitle = new JLabel("Restaurants You Have Tried");
        triedRestaurantTitle.setHorizontalAlignment(JLabel.CENTER);
        JButton addRestaurantButton = new JButton("Add a restaurant to this collection");
        JButton viewRestaurantsButton = new JButton("View restaurants in this collection");
        JButton makeBookingButton = new JButton("Make a booking for a restaurant");
        JButton saveButton = new JButton("Save");
        JButton backButton = new JButton("Back");
        addTriedElements(panel, triedRestaurantTitle, addRestaurantButton, viewRestaurantsButton, makeBookingButton,
                saveButton, backButton);
        jframe.add(panel);
        setTriedVisibility(jframe, addRestaurantButton, viewRestaurantsButton, makeBookingButton);

        buttonCommands(jframe, panel, addRestaurantButton, viewRestaurantsButton, makeBookingButton, saveButton,
                backButton);
    }

    private void buttonCommands(JFrame jframe, JPanel panel, JButton addRestaurantButton,
                                JButton viewRestaurantsButton,
                                JButton makeBookingButton, JButton saveButton, JButton backButton) {
        addRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panel.setVisible(false);
                displayAddTriedRestaurant(jframe);
            }
        });
        viewRestaurantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displaySortRestaurants(jframe);
            }
        });
        makeBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displayChooseBookingTried(jframe, myApp.tried.restaurantList);
            }
        });
        saveButtonCommand(saveButton);
        backButtonCommand(jframe, panel, backButton);
    }

    private void saveButtonCommand(JButton saveButton) {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myApp.saveRestaurants();
                displaySavedRestaurants();
            }
        });
    }

    private void backButtonCommand(JFrame jframe, JPanel panel, JButton backButton) {
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
        panel.setLayout(new GridLayout(6, 0));
        JLabel toTryRestaurantTitle = new JLabel("Restaurants To Try:");
        toTryRestaurantTitle.setHorizontalAlignment(JLabel.CENTER);
        JButton addRestaurantButton = new JButton("Add a restaurant to this collection");
        JButton viewRestaurantsButton = new JButton("View restaurants in this collection");
        JButton makeBookingButton = new JButton("Make a booking for a restaurant");
        JButton saveButton = new JButton("Save");
        JButton backButton = new JButton("Back");
        addTriedElements(panel, toTryRestaurantTitle, addRestaurantButton, viewRestaurantsButton,
                makeBookingButton, saveButton, backButton);
        jframe.add(panel);
        setTriedVisibility(jframe, addRestaurantButton, viewRestaurantsButton, makeBookingButton);
        addTriedRestaurantCommand(jframe, panel, addRestaurantButton);
        viewTriedRestaurantCommand(jframe, panel, viewRestaurantsButton);
        makeBookingButtonCommand(jframe, panel, makeBookingButton);
        saveButtonCommand(saveButton);
        triedbackButtonCommand(jframe, panel, backButton);
    }

    private void triedbackButtonCommand(JFrame jframe, JPanel panel, JButton backButton) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayChooseCollectionScreen(jframe);
                panel.setVisible(false);
            }
        });
    }

    private void makeBookingButtonCommand(JFrame jframe, JPanel panel, JButton makeBookingButton) {
        makeBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displayChooseBookingToTry(jframe, myApp.toTry.restaurantList);

            }
        });
    }

    private void viewTriedRestaurantCommand(JFrame jframe, JPanel panel, JButton viewRestaurantsButton) {
        viewRestaurantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displayToTryRestaurants(jframe, myApp.toTry.restaurantList);
            }
        });
    }

    private void addTriedRestaurantCommand(JFrame jframe, JPanel panel, JButton addRestaurantButton) {
        addRestaurantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displayAddToTryRestaurant(jframe);
            }
        });
    }


    private void setTriedVisibility(JFrame jframe, JButton addRestaurantButton, JButton viewRestaurantsButton,
                                    JButton makeBookingButton) {
        jframe.setVisible(true);
        addRestaurantButton.setVisible(true);
        viewRestaurantsButton.setVisible(true);
        makeBookingButton.setVisible(true);
    }

    private void addTriedElements(JPanel panel, JLabel triedRestaurantTitle, JButton addRestaurantButton,
                                  JButton viewRestaurantsButton, JButton makeBookingButton, JButton saveButton,
                                  JButton backButton) {
        panel.add(triedRestaurantTitle);
        panel.add(addRestaurantButton);
        panel.add(viewRestaurantsButton);
        panel.add(makeBookingButton);
        panel.add(saveButton);
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
        panel.setLayout(new GridLayout(5, 1));

        addElementsToPanel(restaurantNameLabel, tasteRatingLabel, priceRatingLabel, serviceRatingLabel,
                textRestaurantName, textTasteRating, textPriceRating, textServiceRating, buttonDone, buttonBack, panel);
        jframe.add(panel);
        jframe.setVisible(true);
        buttonDoneCommand(jframe, textRestaurantName, textTasteRating, textPriceRating, textServiceRating, buttonDone,
                panel);
        buttonBackCommand2(jframe, buttonBack, panel);
    }

    private void buttonBackCommand2(JFrame jframe, JButton buttonBack, JPanel panel) {
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayChooseFromTriedOptions(jframe);
                panel.setVisible(false);
            }
        });
    }

    private void buttonDoneCommand(JFrame jframe, JTextField textRestaurantName, JTextField textTasteRating,
                                   JTextField textPriceRating, JTextField textServiceRating, JButton buttonDone,
                                   JPanel panel) {
        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonDone.setVisible(false);
                String name = textRestaurantName.getText();
                Double taste = Double.parseDouble(textTasteRating.getText());
                Double price = Double.parseDouble(textPriceRating.getText());
                Double service = Double.parseDouble(textServiceRating.getText());
                myApp.addTriedRestaurant(name, taste, price, service);
                displayAddedTriedRestaurant(jframe, name);
                panel.setVisible(false);
            }
        });
    }

    private void addElementsToPanel(JLabel restaurantNameLabel, JLabel tasteRatingLabel, JLabel priceRatingLabel,
                                    JLabel serviceRatingLabel, JTextField textRestaurantName,
                                    JTextField textTasteRating, JTextField textPriceRating,
                                    JTextField textServiceRating, JButton buttonDone, JButton buttonBack,
                                    JPanel panel) {
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
    }

    public void displayAddToTryRestaurant(JFrame jframe) {
        JLabel labelRestaurantName = new JLabel("Restaurant name: ");
        JTextField textRestaurantName = new JTextField(10);
        JButton buttonDone = new JButton("Done");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 0));
        panel.add(labelRestaurantName);
        panel.add(textRestaurantName);
        panel.add(buttonDone);

        jframe.add(panel);

        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                String name = textRestaurantName.getText();
                myApp.addToTryRestaurant(name);
                displayAddedToTryRestaurant(jframe, name);

            }
        });
    }

    public void displayAddedTriedRestaurant(JFrame jframe, String restaurantName) {
        JLabel labelRestaurantName = new JLabel();
        JLabel labelOverallRating = new JLabel();
        JLabel labelTasteRating = new JLabel();
        JLabel labelPriceRating = new JLabel();
        JLabel labelServiceRating = new JLabel();
        JButton buttonBack = new JButton("Back");
        for (Restaurant r : myApp.tried.restaurantList) {
            if (restaurantName == r.getRestaurantName()) {
                String name = r.getRestaurantName();
                Double taste = r.getTasteRating();
                Double price = r.getPriceRating();
                Double service = r.getServiceRating();
                Double overall = r.getOverallRating();
                setAllLabels(labelRestaurantName, labelOverallRating, labelTasteRating, labelPriceRating,
                        labelServiceRating, name, taste, price, service, overall);
            }
            JPanel panel = new JPanel(new GridLayout(6, 0));
            addElementsToPanel2(jframe, labelRestaurantName, labelOverallRating, labelTasteRating, labelPriceRating,
                    labelServiceRating, buttonBack, panel);
            buttonBackCommand3(jframe, buttonBack, panel);
        }
    }

    private void buttonBackCommand3(JFrame jframe, JButton buttonBack, JPanel panel) {
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displayChooseFromTriedOptions(jframe);
            }
        });
    }

    private void addElementsToPanel2(JFrame jframe, JLabel labelRestaurantName, JLabel labelOverallRating,
                                    JLabel labelTasteRating, JLabel labelPriceRating, JLabel labelServiceRating,
                                    JButton buttonBack, JPanel panel) {
        panel.add(labelRestaurantName);
        panel.add(labelOverallRating);
        panel.add(labelTasteRating);
        panel.add(labelPriceRating);
        panel.add(labelServiceRating);
        panel.add(buttonBack);
        jframe.add(panel);
    }

    private void setAllLabels(JLabel labelRestaurantName, JLabel labelOverallRating, JLabel labelTasteRating,
                              JLabel labelPriceRating, JLabel labelServiceRating, String name, Double taste,
                              Double price, Double service, Double overall) {
        labelRestaurantName.setText(String.valueOf(new StringBuilder().append("   Restaurant ").append(name)
                .append(" has been added to collection.")));
        labelOverallRating.setText(String.valueOf(new StringBuilder().append("   Overall rating: ")
                .append(Math.round(overall * 100.0) / 100.0)));
        labelTasteRating.setText(String.valueOf(new StringBuilder().append("   Taste rating: ")
                .append(Math.round(taste * 100.0) / 100.0)));
        labelPriceRating.setText(String.valueOf(new StringBuilder().append("   Price rating: ")
                .append(Math.round(price * 100.0) / 100.0)));
        labelServiceRating.setText(String.valueOf(new StringBuilder().append("   Service rating: ")
                .append(Math.round(service * 100.0) / 100.0)));
    }

    void displayAddedToTryRestaurant(JFrame jframe, String restaurantName) {
        JLabel labelRestaurant = new JLabel();
        JButton buttonBack = new JButton("Back");
        String name;

        for (Restaurant r : myApp.toTry.restaurantList) {
            name = r.getRestaurantName();
            if (r.getRestaurantName() == restaurantName) {
                labelRestaurant.setText("Restaurant " + name + " has been added to collection.");
            }
        }

        JPanel panel = new JPanel(new GridLayout(2, 0));
        panel.add(labelRestaurant);
        panel.add(buttonBack);
        jframe.add(panel);

        toTryBackButtonCommand(jframe, panel, buttonBack);
    }

    public void displaySortRestaurants(JFrame jframe) {
        JPanel panel = new JPanel(new GridLayout(7, 0));
        JLabel labelSort = new JLabel("Sort by...");
        labelSort.setHorizontalAlignment(JLabel.CENTER);
        JButton buttonName = new JButton("Name");
        JButton buttonOverall = new JButton("Overall rating");
        JButton buttonTaste = new JButton("Taste rating");
        JButton buttonPrice = new JButton("Price rating");
        JButton buttonService = new JButton("Service rating");
        JButton buttonBack = new JButton("Back");
        addStuffToPanel(jframe, panel, labelSort, buttonName, buttonOverall, buttonTaste, buttonPrice, buttonService,
                buttonBack);
        buttonNameCommand(jframe, panel, buttonName);
        buttonOverallCommand(jframe, panel, buttonOverall);
        buttonTasteCommand(jframe, panel, buttonTaste);
        buttonPriceCommand(jframe, panel, buttonPrice);
        buttonServiceCommand(jframe, panel, buttonService);

        buttonBackCommand3(jframe, buttonBack, panel);
    }

    private void buttonServiceCommand(JFrame jframe, JPanel panel, JButton buttonService) {
        buttonService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displaySortedServiceRestaurants(jframe, myApp.tried.getSortedRestaurantsByService());
            }
        });
    }

    private void buttonPriceCommand(JFrame jframe, JPanel panel, JButton buttonPrice) {
        buttonPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displaySortedPriceRestaurants(jframe, myApp.tried.getSortedRestaurantsByPrice());
            }
        });
    }

    private void buttonTasteCommand(JFrame jframe, JPanel panel, JButton buttonTaste) {
        buttonTaste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displaySortedTasteRestaurants(jframe, myApp.tried.getSortedRestaurantsByTaste());
            }
        });
    }

    private void buttonOverallCommand(JFrame jframe, JPanel panel, JButton buttonOverall) {
        buttonOverall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displaySortedOverallRestaurants(jframe, myApp.tried.getSortedRestaurantOverall());
            }
        });
    }

    private void buttonNameCommand(JFrame jframe, JPanel panel, JButton buttonName) {
        buttonName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displaySortedNameRestaurants(jframe, myApp.tried.getSortedRestaurantsByName());
            }
        });
    }

    private void addStuffToPanel(JFrame jframe, JPanel panel, JLabel labelSort, JButton buttonName,
                                 JButton buttonOverall, JButton buttonTaste, JButton buttonPrice,
                                 JButton buttonService, JButton buttonBack) {
        panel.add(labelSort);
        panel.add(buttonName);
        panel.add(buttonOverall);
        panel.add(buttonTaste);
        panel.add(buttonPrice);
        panel.add(buttonService);
        panel.add(buttonBack);
        jframe.add(panel);
    }

    public void displaySortedNameRestaurants(JFrame jframe, ArrayList<Restaurant> restaurants) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JButton buttonDone = new JButton("Done");
        for (Restaurant r : restaurants) {
            listModel.addElement(r.getRestaurantName());
        }
        JList<String> restaurantList = new JList<>(listModel);

        JPanel mainPanel = setUpSortedPanels(jframe, buttonDone, restaurantList);

        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displaySortRestaurants(jframe);
            }
        });
    }

    public void displaySortedOverallRestaurants(JFrame jframe, ArrayList<Restaurant> restaurants) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JButton buttonDone = new JButton("Done");
        for (Restaurant r : restaurants) {
            listModel.addElement(r.getRestaurantName() + ": " + Math.round(r.getOverallRating() * 100.0) / 100.0);
        }
        JList<String> restaurantList = new JList<>(listModel);

        JPanel mainPanel = setUpSortedPanels(jframe, buttonDone, restaurantList);

        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displaySortRestaurants(jframe);
            }
        });
    }

    public void displaySortedTasteRestaurants(JFrame jframe, ArrayList<Restaurant> restaurants) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JButton buttonDone = new JButton("Done");
        for (Restaurant r : restaurants) {
            listModel.addElement(r.getRestaurantName() + ": " + Math.round(r.getTasteRating() * 100.0) / 100.0);
        }
        JList<String> restaurantList = new JList<>(listModel);

        JPanel mainPanel = setUpSortedPanels(jframe, buttonDone, restaurantList);

        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displaySortRestaurants(jframe);
            }
        });
    }

    private JPanel setUpSortedPanels(JFrame jframe, JButton buttonDone, JList<String> restaurantList) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel firstPanel = new JPanel();
        firstPanel.setMaximumSize(new Dimension(1000, 600));
        JScrollPane scrollPane = new JScrollPane(restaurantList);
        scrollPane.setPreferredSize(new Dimension(800, 500));
        firstPanel.add(scrollPane);

        JPanel secondPanel = new JPanel();
        secondPanel.setMaximumSize(new Dimension(1000, 150));
        secondPanel.add(buttonDone);

        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        jframe.add(mainPanel);
        return mainPanel;
    }

    public void displaySortedPriceRestaurants(JFrame jframe, ArrayList<Restaurant> restaurants) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JButton buttonDone = new JButton("Done");
        for (Restaurant r : restaurants) {
            listModel.addElement(r.getRestaurantName() + ": " + Math.round(r.getPriceRating() * 100.0) / 100.0);
        }
        JList<String> restaurantList = new JList<>(listModel);

        JPanel mainPanel = setUpSortedPanels(jframe, buttonDone, restaurantList);

        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displaySortRestaurants(jframe);
            }
        });
    }

    public void displaySortedServiceRestaurants(JFrame jframe, ArrayList<Restaurant> restaurants) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JButton buttonDone = new JButton("Done");
        for (Restaurant r : restaurants) {
            listModel.addElement(r.getRestaurantName() + ": " + Math.round(r.getServiceRating() * 100.0) / 100.0);
        }

        JList<String> restaurantList = new JList<>(listModel);

        JPanel mainPanel = setUpSortedPanels(jframe, buttonDone, restaurantList);

        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displaySortRestaurants(jframe);
            }
        });
    }

    public void displayToTryRestaurants(JFrame jframe, ArrayList<Restaurant> restaurants) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JButton buttonDone = new JButton("Done");
        for (Restaurant r : restaurants) {
            listModel.addElement(r.getRestaurantName());
        }

        JList<String> restaurantList = new JList<>(listModel);

        JPanel mainPanel = setUpSortedPanels(jframe, buttonDone, restaurantList);

        toTryBackButtonCommand(jframe, mainPanel, buttonDone);

    }



    public void displayChooseBookingTried(JFrame jframe, ArrayList<Restaurant> restaurants) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Restaurant r : restaurants) {
            listModel.addElement(r.getRestaurantName());
        }
        JList<String> restaurantList = new JList<>(listModel);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel firstPanel = new JPanel();
        firstPanel.setMaximumSize(new Dimension(1000, 100));
        JLabel labelChooseBookRestaurant = new JLabel("Choose from restaurants to book:");


        JPanel secondPanel = new JPanel();
        secondPanel.setMaximumSize(new Dimension(1000, 500));
        JScrollPane scrollPane = new JScrollPane(restaurantList);
        scrollPane.setPreferredSize(new Dimension(800, 500));


        JPanel thirdPanel = new JPanel();
        secondPanel.setMaximumSize(new Dimension(1000, 25));
        JButton buttonMakeBooking = new JButton("Make Booking");


        JPanel fourthPanel = new JPanel();
        fourthPanel.setMaximumSize(new Dimension(1000, 125));
        JButton buttonBack = new JButton("Back");

        addElementsToFirstPanel(firstPanel, labelChooseBookRestaurant, secondPanel, scrollPane, buttonMakeBooking);
        addAllElementsToPanel2(jframe, restaurantList, mainPanel, firstPanel, secondPanel, thirdPanel,
                buttonMakeBooking, fourthPanel, buttonBack);

    }

    private void addElementsToFirstPanel(JPanel firstPanel, JLabel labelChooseBookRestaurant, JPanel secondPanel,
                                         JScrollPane scrollPane, JButton buttonMakeBooking) {
        firstPanel.add(labelChooseBookRestaurant);
        firstPanel.add(scrollPane);
        secondPanel.add(buttonMakeBooking);
    }

    private void addAllElementsToPanel2(JFrame jframe, JList<String> restaurantList, JPanel mainPanel,
                                        JPanel firstPanel, JPanel secondPanel, JPanel thirdPanel,
                                        JButton buttonMakeBooking, JPanel fourthPanel, JButton buttonBack) {
        fourthPanel.add(buttonBack);
        addToMainPanel2(mainPanel, firstPanel, secondPanel, thirdPanel, fourthPanel);
        jframe.add(mainPanel);

        makeBookingButtonCommand2(restaurantList, buttonMakeBooking);

        buttobBackCommand4(jframe, mainPanel, buttonBack);
    }

    private void buttobBackCommand4(JFrame jframe, JPanel mainPanel, JButton buttonBack) {
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displayChooseFromTriedOptions(jframe);
            }
        });
    }

    private void makeBookingButtonCommand2(JList<String> restaurantList, JButton buttonMakeBooking) {
        buttonMakeBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                displayPopUpMenu(restaurantList.getSelectedValue());
            }
        });
    }

    private void addToMainPanel2(JPanel mainPanel, JPanel firstPanel, JPanel secondPanel, JPanel thirdPanel,
                                 JPanel fourthPanel) {
        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);
        mainPanel.add(fourthPanel);
    }

    public JFrame setUpPopUpFrame(String name) {
        JFrame framePopUp = new JFrame("Make a booking for " + name);
        framePopUp.setLocationRelativeTo(null);
        framePopUp.setSize(new Dimension(500,300));
        return framePopUp;
    }


    private JPanel setUpThirdPanel() {
        JPanel thirdPanel = new JPanel();
        thirdPanel.setMaximumSize(new Dimension(500,50));
        return thirdPanel;
    }


    private JPanel setUpFourthPanel() {
        JPanel fourthPanel = new JPanel();
        fourthPanel.setMaximumSize(new Dimension(500,50));
        return fourthPanel;
    }

    private JSpinner setUpSpinner2() {
        Date today = new Date();
        SpinnerDateModel dateModel = new SpinnerDateModel(today, null, null, Calendar.MONTH);
        JSpinner spinner = new JSpinner(dateModel);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yy");
        spinner.setEditor(editor);
        return spinner;
    }

    private JPanel setUpMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        return mainPanel;
    }

    private JComboBox<Integer> setUpComboBox() {
        JComboBox<Integer> comboBoxInteger = new JComboBox<>();
        for (Integer i = 1; i <= 100; i++) {
            comboBoxInteger.addItem(i);
        }
        return comboBoxInteger;
    }


    public void displayPopUpMenu(String name) {
        JFrame framePopUp = setUpPopUpFrame(name);

        JPanel mainPanel = setUpMainPanel();

        JPanel firstPanel = new JPanel();
        firstPanel.setMaximumSize(new Dimension(500,50));
        JLabel labelChooseTime = new JLabel("Choose reservation date and time:");

        SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.MONTH);
        JSpinner spinner = setUpSpinner2();

        JPanel secondPanel = new JPanel();
        secondPanel.setMaximumSize(new Dimension(500, 50));

        String[] choices = {"6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};

        final JComboBox<String> cb = new JComboBox<>(choices);
        secondPanel.add(cb);

        JPanel thirdPanel = setUpThirdPanel();
        JLabel labelChooseSeats = new JLabel("For how many people: ");

        JComboBox<Integer> comboBoxInteger = setUpComboBox();
        JPanel fourthPanel = setUpFourthPanel();

        JPanel fifthPanel = new JPanel();
        fifthPanel.setMaximumSize(new Dimension(500, 50));
        JButton buttonNext = new JButton("Next");

        addAllElementsToPanels(firstPanel, labelChooseTime, spinner, secondPanel, thirdPanel, labelChooseSeats,
                comboBoxInteger, fourthPanel, fifthPanel, buttonNext);

        addToMainPanel(framePopUp, mainPanel, firstPanel, secondPanel, thirdPanel, fourthPanel, fifthPanel);

        popUpButtonNextCommand(name, framePopUp, mainPanel, dateModel, cb, comboBoxInteger, buttonNext);
    }

    private void addAllElementsToPanels(JPanel firstPanel, JLabel labelChooseTime, JSpinner spinner,
                                        JPanel secondPanel, JPanel thirdPanel, JLabel labelChooseSeats,
                                        JComboBox<Integer> comboBoxInteger, JPanel fourthPanel, JPanel fifthPanel,
                                        JButton buttonNext) {
        firstPanel.add(labelChooseTime);
        secondPanel.add(spinner);
        thirdPanel.add(labelChooseSeats);
        fourthPanel.add(comboBoxInteger);
        fifthPanel.add(buttonNext);
    }

    private void popUpButtonNextCommand(String name, JFrame framePopUp, JPanel mainPanel, SpinnerDateModel dateModel,
                                        JComboBox<String> cb, JComboBox<Integer> comboBoxInteger, JButton buttonNext) {
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);

                Date bookingDate = dateModel.getDate();

                LocalDate localDate = bookingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year  = localDate.getYear();
                int month = localDate.getMonthValue();
                int day   = localDate.getDayOfMonth();
                int hour = Integer.parseInt(cb.getSelectedItem().toString());
                Integer seats =  Integer.parseInt(comboBoxInteger.getSelectedItem().toString());

                Restaurant bookedRestaurant = null;
                for (Restaurant r : myApp.tried.restaurantList) {
                    if (r.getRestaurantName() == name) {
                        bookedRestaurant = r;
                        r.getBooking().setAll(year,month,day,hour,seats);
                    }
                }

                displayConfirmBooking(framePopUp, bookedRestaurant);
            }
        });
    }

    public void displayConfirmBooking(JFrame jframe, Restaurant r) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 0));
        JLabel labelConfirmedBooking = new JLabel("Booking has been made at "
                + r.getRestaurantName() + " on " + r.getBooking().getYear() + "/" + r.getBooking().getMonth()
                + "/" + r.getBooking().getDay() + " at " + r.getBooking().getHour() + " for "
                + r.getBooking().getSeats() + " people");
        panel.add(labelConfirmedBooking);
        JButton buttonDone = new JButton("Done");
        panel.add(buttonDone);
        jframe.add(panel);

        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.setVisible(false);
            }
        });

    }

    public void displayChooseBookingToTry(JFrame jframe, ArrayList<Restaurant> restaurants) {
        DefaultListModel<String> listModel = new DefaultListModel<>();

        addElementsToRestaurantList(restaurants, listModel);

        JList<String> restaurantList = new JList<>(listModel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel firstPanel = new JPanel();
        firstPanel.setMaximumSize(new Dimension(1000, 100));
        JLabel labelChooseBookRestaurant = new JLabel("Choose from restaurants to book:");
        firstPanel.add(labelChooseBookRestaurant);

        JPanel secondPanel = new JPanel();
        secondPanel.setMaximumSize(new Dimension(1000, 500));
        JScrollPane scrollPane = new JScrollPane(restaurantList);
        scrollPane.setPreferredSize(new Dimension(800, 500));
        firstPanel.add(scrollPane);

        JPanel thirdPanel = new JPanel();
        secondPanel.setMaximumSize(new Dimension(1000, 25));
        JButton buttonMakeBooking = new JButton("Make Booking");
        secondPanel.add(buttonMakeBooking);

        JPanel fourthPanel = new JPanel();
        fourthPanel.setMaximumSize(new Dimension(1000, 125));
        JButton buttonBack = new JButton("Back");
        addAllElementsToPanel(jframe, restaurantList, mainPanel, firstPanel, secondPanel, thirdPanel,
                buttonMakeBooking, fourthPanel, buttonBack);

    }

    private void addElementsToRestaurantList(ArrayList<Restaurant> restaurants, DefaultListModel<String> listModel) {
        for (Restaurant r : restaurants) {
            listModel.addElement(r.getRestaurantName());
        }
    }

    private void addAllElementsToPanel(JFrame jframe, JList<String> restaurantList, JPanel mainPanel,
                                       JPanel firstPanel, JPanel secondPanel, JPanel thirdPanel,
                                       JButton buttonMakeBooking, JPanel fourthPanel, JButton buttonBack) {
        fourthPanel.add(buttonBack);

        addToMainPanel2(mainPanel, firstPanel, secondPanel, thirdPanel, fourthPanel);

        jframe.add(mainPanel);

        toTryMakeBookingButtonCommand(restaurantList, buttonMakeBooking);

        toTryBackButtonCommand(jframe, mainPanel, buttonBack);
    }

    private void toTryBackButtonCommand(JFrame jframe, JPanel mainPanel, JButton buttonBack) {
        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displayChooseFromToTryOptions(jframe);

        }});
    }

    private void toTryMakeBookingButtonCommand(JList<String> restaurantList, JButton buttonMakeBooking) {
        buttonMakeBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPopUpToTryMenu(restaurantList.getSelectedValue());
            }
        });
    }

    private JFrame setUpFrame(String name) {
        JFrame framePopUp = new JFrame("Make a booking for " + name);
        framePopUp.setLocationRelativeTo(null);
        framePopUp.setSize(new Dimension(500, 300));
        return framePopUp;
    }

    public JSpinner setUpSpinner() {
        Date today = new Date();
        SpinnerDateModel dateModel = new SpinnerDateModel(today, null, null, Calendar.MONTH);
        JSpinner spinner = new JSpinner(dateModel);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yy");
        spinner.setEditor(editor);
        return spinner;
    }

    public void displayPopUpToTryMenu(String name) {
        JFrame framePopUp = setUpFrame(name);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel firstPanel = new JPanel();

        firstPanel.setMaximumSize(new Dimension(500,50));
        JLabel labelChooseTime = new JLabel("Choose a reservation time:");
        Date today = new Date();
        SpinnerDateModel dateModel = new SpinnerDateModel(today, null, null, Calendar.MONTH);
//        JSpinner spinner = new JSpinner(dateModel);
//        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yy");
        JPanel secondPanel = new JPanel();
        secondPanel.setMaximumSize(new Dimension(500, 50));
        String[] choices = {"6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
        final JComboBox<String> cb = new JComboBox<>(choices);
        JPanel thirdPanel = new JPanel();
        thirdPanel.setMaximumSize(new Dimension(500,50));
        JLabel labelChooseSeats = new JLabel("For how many people: ");
        JComboBox<Integer> comboBoxInteger = new JComboBox<>();
        JPanel fourthPanel = new JPanel();
        fourthPanel.setMaximumSize(new Dimension(500,50));
        JPanel fifthPanel = new JPanel();
        fifthPanel.setMaximumSize(new Dimension(500, 50));
        JButton buttonNext = new JButton("Next");
        addAndSetUpAllElements(name, framePopUp, mainPanel, firstPanel, labelChooseTime, dateModel, setUpSpinner(),
                secondPanel, cb, thirdPanel, labelChooseSeats, comboBoxInteger, fourthPanel, fifthPanel, buttonNext);
    }

    private void addAndSetUpAllElements(String name, JFrame framePopUp, JPanel mainPanel, JPanel firstPanel,
                                        JLabel labelChooseTime, SpinnerDateModel dateModel, JSpinner spinner,
                                        JPanel secondPanel, JComboBox<String> cb, JPanel thirdPanel,
                                        JLabel labelChooseSeats, JComboBox<Integer> comboBoxInteger,
                                        JPanel fourthPanel, JPanel fifthPanel, JButton buttonNext) {
        firstPanel.add(labelChooseTime);
        secondPanel.add(spinner);
        thirdPanel.add(labelChooseSeats);
        secondPanel.add(cb);
        for (Integer i = 1; i <= 100; i++) {
            comboBoxInteger.addItem(i);
        }
        fourthPanel.add(comboBoxInteger);
        fifthPanel.add(buttonNext);
        addToMainPanel(framePopUp, mainPanel, firstPanel, secondPanel, thirdPanel, fourthPanel, fifthPanel);
        buttonNextCommand(name, framePopUp, mainPanel, dateModel, cb, comboBoxInteger, buttonNext, myApp.toTry);
    }

    private void buttonNextCommand(String name, JFrame framePopUp, JPanel mainPanel, SpinnerDateModel dateModel,
                                   JComboBox<String> cb, JComboBox<Integer> comboBoxInteger,
                                   JButton buttonNext, RestaurantCollection toTry) {
        buttonNextCommand2(name, framePopUp, mainPanel, dateModel, cb, comboBoxInteger, buttonNext, toTry);
    }

    private void buttonNextCommand2(String name, JFrame framePopUp, JPanel mainPanel, SpinnerDateModel dateModel,
                                    JComboBox<String> cb, JComboBox<Integer> comboBoxInteger, JButton buttonNext,
                                    RestaurantCollection toTry) {
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);

                Date bookingDate = dateModel.getDate();

                LocalDate localDate = bookingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year = localDate.getYear();
                int month = localDate.getMonthValue();
                int day = localDate.getDayOfMonth();
                int hour = Integer.parseInt(cb.getSelectedItem().toString());
                Integer seats = Integer.parseInt(comboBoxInteger.getSelectedItem().toString());
                Restaurant bookedRestaurant = null;
                bookedRestaurant = toTryGetBooking(year, month, day, hour, seats, bookedRestaurant, toTry, name);
                displayConfirmBooking(framePopUp, bookedRestaurant);
            }
        });
    }

    private Restaurant toTryGetBooking(int year, int month, int day, int hour, Integer seats,
                                       Restaurant bookedRestaurant, RestaurantCollection toTry, String name) {
        for (Restaurant r : toTry.restaurantList) {
            if (r.getRestaurantName() == name) {
                bookedRestaurant = r;
                r.getBooking().setAll(year, month, day, hour, seats);
            }
        }
        return bookedRestaurant;
    }

    private void addToMainPanel(JFrame framePopUp, JPanel mainPanel, JPanel firstPanel, JPanel secondPanel,
                                JPanel thirdPanel, JPanel fourthPanel, JPanel fifthPanel) {
        addToMainPanel2(mainPanel, firstPanel, secondPanel, thirdPanel, fourthPanel);
        mainPanel.add(fifthPanel);
        framePopUp.add(mainPanel);
        framePopUp.setVisible(true);
    }

    public void displaySavedRestaurants() {
        JFrame framePopUp = new JFrame("Your information has been saved");
        framePopUp.setLocationRelativeTo(null);
        framePopUp.setSize(new Dimension(500,300));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel firstPanel = new JPanel();
        firstPanel.setMaximumSize(new Dimension(500, 200));
        JLabel labelSaved = new JLabel("Your information has been saved");
        firstPanel.add((labelSaved));

        JPanel secondPanel = new JPanel();
        secondPanel.setMaximumSize(new Dimension(500, 100));
        JButton buttonDone = new JButton("Done");
        secondPanel.add(buttonDone);

        framePopUp.add(firstPanel);
        framePopUp.add(secondPanel);

        framePopUp.setVisible(true);

        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                framePopUp.setVisible(false);
            }
        });
    }

    public void playMusic(String sound) {

        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(sound).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }

    }
}






