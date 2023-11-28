package p2.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import p2.Post;
import p2.Socials;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublicFeed extends JFrame{
    String nme;
    String id;
    JPanel postPanel = new JPanel();
    JPanel navPanel = new JPanel();
    JPanel feedPanel = new JPanel();
    JButton profile = new JButton("profile");
    JButton refresh = new JButton("refresh");
    JButton upVote = new JButton("Upvote");
    JButton downVote = new JButton("Downvote");

    //labels
    JLabel username = new JLabel("User:");
    JLabel post = new JLabel("Post");
    Socials social = new Socials("social");

    JTextField search = new JTextField(11);

    JFrame loginFrame;
    public PublicFeed(String name, JFrame loginFrame){
        this.loginFrame = loginFrame;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(800, 800);
        loginFrame.getContentPane().removeAll();
        loginFrame.revalidate();
        loginFrame.repaint();

        this.nme = name;
        feedPanel.setSize(700, 500);
        this.setSize(800, 800);
        feedPanel.setBackground(Color.decode("#00001a")); 

        username.setText("User: " + nme);

        feedPanel.add(username);
        feedPanel.add(search);
        feedPanel.add(upVote);
        feedPanel.add(downVote);
        feedPanel.add(postPanel);
        feedPanel.add(navPanel);
        postPanel.add(post);
        navPanel.add(profile);
        navPanel.add(refresh);


        BoxLayout boxlayout = new BoxLayout(feedPanel, BoxLayout.Y_AXIS);
        feedPanel.setBorder(new EmptyBorder(new Insets(100, 300, 100, 300))); 

        setTitle("Sweet mail");

        
        
        this.add(feedPanel);
        this.setVisible(true);


       // Action listeners
       profile.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Profile(name);
        }
    });

    refresh.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayposts(); // Refresh the posts
        }
    });

    displayposts(); // Load posts when frame is initialized
}


    } 

   

    public void displayposts(){
         postPanel.removeAll();//clear existing panels
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
