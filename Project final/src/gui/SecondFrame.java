package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondFrame {
    private JFrame frame;
    private JButton backButton;
    private JLabel label;

    public SecondFrame(String text) {
        frame = new JFrame("Show Result");
        backButton = new JButton("back");
        label = new JLabel("<html><pre>" + text + "</pre></html>");
        frame.add(backButton, BorderLayout.WEST);
        frame.add(label, BorderLayout.CENTER);

        frame.setSize(600, 300);
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                close();
            }
        });
    }

    private void close() {
        frame.setVisible(false);
        frame.dispose();
    }
}
