package ui;

import model.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static com.sun.tools.internal.xjc.reader.Ring.add;

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

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myApp.saveRestaurants();
                displaySavedRestaurants();

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
                panel.setVisible(false);
                displayToTryRestaurants(jframe, myApp.toTry.restaurantList);
            }
        });

        makeBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displayChooseBookingToTry(jframe, myApp.toTry.restaurantList);

            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myApp.saveRestaurants();
                displaySavedRestaurants();
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

    private void addTriedElements(JPanel panel, JLabel triedRestaurantTitle, JButton addRestaurantButton, JButton viewRestaurantsButton, JButton makeBookingButton, JButton saveButton, JButton backButton) {
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
                myApp.addTriedRestaurant(name, taste, price, service);
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
            JPanel panel = new JPanel(new GridLayout(6, 0));
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

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displayChooseFromToTryOptions(jframe);
            }
        });
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
        panel.add(labelSort);
        panel.add(buttonName);
        panel.add(buttonOverall);
        panel.add(buttonTaste);
        panel.add(buttonPrice);
        panel.add(buttonService);
        panel.add(buttonBack);
        jframe.add(panel);

        buttonName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displaySortedNameRestaurants(jframe, myApp.tried.getSortedRestaurantsByName());
            }
        });

        buttonOverall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displaySortedOverallRestaurants(jframe, myApp.tried.getSortedRestaurantOverall());
            }
        });

        buttonTaste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displaySortedTasteRestaurants(jframe, myApp.tried.getSortedRestaurantsByTaste());
            }
        });

        buttonPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displaySortedPriceRestaurants(jframe, myApp.tried.getSortedRestaurantsByPrice());
            }
        });

        buttonService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displaySortedServiceRestaurants(jframe, myApp.tried.getSortedRestaurantsByService());
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                displayChooseFromTriedOptions(jframe);
            }
        });
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

        buttonDone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displayChooseFromToTryOptions(jframe);
            }
        });

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
        fourthPanel.add(buttonBack);

        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);
        mainPanel.add(fourthPanel);

        jframe.add(mainPanel);

        buttonMakeBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                displayPopUpMenu(restaurantList.getSelectedValue());
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displayChooseFromTriedOptions(jframe);
            }
        });

    }

    public void displayPopUpMenu(String name) {
        JFrame framePopUp = new JFrame("Make a booking for " + name);
        framePopUp.setLocationRelativeTo(null);
        framePopUp.setSize(new Dimension(500,300));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel firstPanel = new JPanel();
        firstPanel.setMaximumSize(new Dimension(500,50));
        JLabel labelChooseTime = new JLabel("Choose a reservation time:");
        firstPanel.add(labelChooseTime);

        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(dateModel);
        spinner.setEditor(new JSpinner.DateEditor(spinner, "dd.MM.yyyy"));
        Calendar calendar = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        spinner.setValue(calendar.getTime());
        JPanel secondPanel = new JPanel();
        secondPanel.setMaximumSize(new Dimension(500, 50));
        secondPanel.add(spinner);

        JPanel thirdPanel = new JPanel();
        thirdPanel.setMaximumSize(new Dimension(500,50));
        JLabel labelChooseSeats = new JLabel("For how many people: ");
        thirdPanel.add(labelChooseSeats);
        thirdPanel.setMaximumSize(new Dimension(500, 50));

        JComboBox<Integer> comboBoxInteger = new JComboBox<>();
        for (Integer i = 1; i <= 100; i++) {
            comboBoxInteger.addItem(i);
        }
        JPanel fourthPanel = new JPanel();
        fourthPanel.setMaximumSize(new Dimension(500,50));
        fourthPanel.add(comboBoxInteger);

        JPanel fifthPanel = new JPanel();
        fifthPanel.setMaximumSize(new Dimension(500, 50));
        JButton buttonNext = new JButton("Next");
        fifthPanel.add(buttonNext);

        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);
        mainPanel.add(fourthPanel);
        mainPanel.add(fifthPanel);
        framePopUp.add(mainPanel);
        framePopUp.setVisible(true);

        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);

                Date bookingDate = dateModel.getDate();

                LocalDate localDate = bookingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year  = localDate.getYear();
                int month = localDate.getMonthValue();
                int day   = localDate.getDayOfMonth();
                int hour = calendar.get(Calendar.HOUR);

                Integer seats = comboBoxInteger.getSelectedIndex();

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
        JLabel labelConfirmedBooking = new JLabel("Your reservation has been made at "
                + r.getRestaurantName() + " on " + r.getBooking().getYear() + " " + r.getBooking().getMonth()
                + r.getBooking().getDay() + r.getBooking().getHour() + " for " + r.getBooking().getSeats());
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

        for (Restaurant r : restaurants) {
            listModel.addElement(r.getRestaurantName());
        }

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
        fourthPanel.add(buttonBack);

        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);
        mainPanel.add(fourthPanel);

        jframe.add(mainPanel);

        buttonMakeBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayPopUpToTryMenu(restaurantList.getSelectedValue());
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);
                displayChooseFromToTryOptions(jframe);
            }
        });

    }

    public void displayPopUpToTryMenu(String name) {
        JFrame framePopUp = new JFrame("Make a booking for " + name);
        framePopUp.setLocationRelativeTo(null);
        framePopUp.setSize(new Dimension(500,300));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel firstPanel = new JPanel();
        firstPanel.setMaximumSize(new Dimension(500,50));
        JLabel labelChooseTime = new JLabel("Choose a reservation time:");
        firstPanel.add(labelChooseTime);

        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner spinner = new JSpinner(dateModel);
        spinner.setEditor(new JSpinner.DateEditor(spinner, "dd.MM.yyyy"));
        Calendar calendar = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        spinner.setValue(calendar.getTime());
        JPanel secondPanel = new JPanel();
        secondPanel.setMaximumSize(new Dimension(500, 50));
        secondPanel.add(spinner);

        JPanel thirdPanel = new JPanel();
        thirdPanel.setMaximumSize(new Dimension(500,50));
        JLabel labelChooseSeats = new JLabel("For how many people: ");
        thirdPanel.add(labelChooseSeats);
        thirdPanel.setMaximumSize(new Dimension(500, 50));

        JComboBox<Integer> comboBoxInteger = new JComboBox<>();
        for (Integer i = 1; i <= 100; i++) {
            comboBoxInteger.addItem(i);
        }
        JPanel fourthPanel = new JPanel();
        fourthPanel.setMaximumSize(new Dimension(500,50));
        fourthPanel.add(comboBoxInteger);

        JPanel fifthPanel = new JPanel();
        fifthPanel.setMaximumSize(new Dimension(500, 50));
        JButton buttonNext = new JButton("Next");
        fifthPanel.add(buttonNext);

        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);
        mainPanel.add(fourthPanel);
        mainPanel.add(fifthPanel);
        framePopUp.add(mainPanel);
        framePopUp.setVisible(true);

        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setVisible(false);

                Date bookingDate = dateModel.getDate();

                LocalDate localDate = bookingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int year  = localDate.getYear();
                int month = localDate.getMonthValue();
                int day   = localDate.getDayOfMonth();
                int hour = calendar.get(Calendar.HOUR);

                Integer seats = comboBoxInteger.getSelectedIndex();

                Restaurant bookedRestaurant = null;
                for (Restaurant r : myApp.toTry.restaurantList) {
                    if (r.getRestaurantName() == name) {
                        bookedRestaurant = r;
                        r.getBooking().setAll(year,month,day,hour,seats);
                    }
                }

                displayConfirmBooking(framePopUp, bookedRestaurant);
            }
        });
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
}






