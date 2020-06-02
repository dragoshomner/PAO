package gui;

import services.MarketplaceService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame {
    private JFrame frame;
    private JButton button,button1, button2, button3,button4;

    public FirstFrame(MarketplaceService marketplaceService) {
        frame = new JFrame("Action");
        button = new JButton("displayAll");
        button1 = new JButton("displayAllSortedByName");
        button2 = new JButton("displayAllSortedByNumberOfCustomers");
        button3 = new JButton("displayCustomers");
        button4 = new JButton("displayCustomersPerMarketplace");
        frame.add(button);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.setLayout(new GridLayout(2,3));
        frame.setSize(600,300);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SecondFrame(marketplaceService.displayAll());
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SecondFrame(marketplaceService.displayAllSortedByName());
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SecondFrame(marketplaceService.displayAllSortedByNumberOfCustomers());
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SecondFrame(marketplaceService.displayCustomers());
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SecondFrame(marketplaceService.displayCustomersPerMarketplace());
            }
        });
    }
}
