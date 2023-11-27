package p2.ui;

import java.awt.*;
import javax.swing.*;

import p2.Post;
import p2.Socials;

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
    Socials social = new Socials("social");

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

        
        
        this.add(feedPanel);
        this.setVisible(true);
    }

    public void displayposts(){
        for (Post post : social.getPosts()) {
        // Create a JLabel for each post
        JLabel postLabel = new JLabel("Post ID: " + post.getID() + ", Content: " + post.getContent());
        
        // Add the JLabel to the postPanel
        postPanel.add(postLabel);
    }

    // Refresh the display
    postPanel.revalidate();
    postPanel.repaint();
    }
}
