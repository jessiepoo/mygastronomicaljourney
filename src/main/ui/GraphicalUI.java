package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalUI {
    ConsoleUI myApp;
    JLabel welcomeLabel = new JLabel("Welcome To Your Gastronomical Journey", SwingConstants.CENTER);
    JLabel chooseCollectionLabel = new JLabel("Choose from your collections", SwingConstants.CENTER);


    public GraphicalUI() {
        myApp = new ConsoleUI();
        myApp.loadRestaurants();
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

        triedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });

        jframe.add(panel);


    }

}
