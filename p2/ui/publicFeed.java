package p2.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PublicFeed {
    JPanel postPanel = new JPanel();
    JPanel navPanel = new JPanel();
    JPanel feedPanel = new JPanel();
    JButton profile = new JButton();

    //labels
    JLabel username = new JLabel("User:");
    JLabel post = new JLabel("Post");

    public PublicFeed(){
        //this.setSize(800, 800);
        feedPanel.setSize(700, 500);
        this.setSize(800, 800);
        feedPanel.setBackground(Color.decode("#00001a")); 

        feedPanel.add(username);
        feedPanel.add(postPanel);
        feedPanel.add(navPanel);
    }
}
