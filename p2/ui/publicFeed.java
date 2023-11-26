package p2.ui;

import java.awt.*;
import javax.swing.*;

public class PublicFeed extends JFrame{
    String nme;
    String id;
    JPanel postPanel = new JPanel();
    JPanel navPanel = new JPanel();
    JPanel feedPanel = new JPanel();
    JButton profile = new JButton("profile");
    JButton refresh = new JButton("refresh");

    //labels
    JLabel username = new JLabel("User:");
    JLabel post = new JLabel("Post");

    public PublicFeed(String name){
        //this.setSize(800, 800);
        this.nme = name;
        feedPanel.setSize(700, 500);
        this.setSize(800, 800);
        feedPanel.setBackground(Color.decode("#00001a")); 

        username.setText("User: " + nme);

        feedPanel.add(username);
        feedPanel.add(postPanel);
        feedPanel.add(navPanel);
        postPanel.add(post);
        navPanel.add(profile);
        navPanel.add(refresh);


        setTitle("Sweet mail");

        display posts;


        this.add(feedPanel);
        this.setVisible(true);
    }
}
