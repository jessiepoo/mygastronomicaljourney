package ui;

import model.RestaurantCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalUI {
    RestaurantCollectionApp myApp;
    JLabel welcomeLabel = new JLabel("Welcome To Your Gastronomical Journey", SwingConstants.CENTER);
    JLabel chooseCollectionLabel = new JLabel("Choose from your collections", SwingConstants.CENTER);


    public GraphicalUI() {
        myApp = new RestaurantCollectionApp();
    }


    public void displayJFrame(JFrame jframe) {
        // set the jframe title
        jframe.setSize(600,500);
        jframe.setLocationRelativeTo(null);
//        jframe.setLayout(null);
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
        GridLayout welcomeLayout = new GridLayout(2,0);
        panel.setLayout(welcomeLayout);
        panel.add(welcomeLabel);
        panel.add(enterButton);
        jframe.add(panel);
        jframe.setVisible(true);
    }

    public void displayChooseCollectionScreen(JFrame jframe) {
        welcomeLabel.setVisible(false);
        GridLayout chooseCollectionLayout = new GridLayout(3, 0);
        jframe.add(chooseCollectionLabel);
        JPanel panel = new JPanel();
        JButton triedButton = new JButton("Restaurants you have tried");
        JButton toTryButton = new JButton("Restaurants you want to try");
        panel.setLayout(chooseCollectionLayout);
        panel.add(chooseCollectionLabel);
        panel.add(triedButton);
        panel.add(toTryButton);
        toTryButton.setVisible(true);
        triedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                triedButton.setVisible(false);
                toTryButton.setVisible(false);
                chooseCollectionLabel.setVisible(false);
            }
        });

        jframe.add(panel);
    }

    public void chooseFromTriedOptions(JFrame jframe) {
        jframe.remove(chooseCollectionLabel);
        JButton addRestaurantButton = new JButton("add a restaurant to this collection");
        JButton viewRestaurantsButton = new JButton("view restaurants in this collection");
        JButton makeBookingButton = new JButton("make a booking for a restaurant");

    }
}
