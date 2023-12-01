package p2.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import p2.Post;
import p2.Socials;
import p2.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PublicFeed extends JFrame{
    String nme;
    String name;
    String id;
    JPanel postPanel = new JPanel();
    JPanel navPanel = new JPanel();
    JPanel feedPanel = new JPanel();
    JButton profile = new JButton("profile");
    JButton refresh = new JButton("refresh");
    JButton upVote = new JButton("Upvote");
    JButton downVote = new JButton("Downvote");
    

    //labels
    JLabel searchLabel = new JLabel("Search");
    JLabel username = new JLabel("User:");
    JLabel post = new JLabel("Post");
    JLabel extra = new JLabel();
    JButton extraButton = new JButton("back");
    

    Socials social = new Socials("social");

    JTextField search = new JTextField(11);

    JFrame loginFrame;
    public PublicFeed(String name, JFrame loginFrame, Socials social){
        this.loginFrame = loginFrame;
        this.name = name;
        this.social = social;
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
        feedPanel.add(searchLabel);
        feedPanel.add(search);
       
        feedPanel.add(postPanel);
        feedPanel.add(navPanel);
        postPanel.add(post);
        postPanel.add(upVote);
        postPanel.add(downVote);
        navPanel.add(profile);
        navPanel.add(refresh);


        BoxLayout boxlayout = new BoxLayout(feedPanel, BoxLayout.Y_AXIS);
        feedPanel.setBorder(new EmptyBorder(new Insets(100, 300, 100, 300))); 

        setTitle("Sweet mail");

        
        
        this.add(feedPanel);
        this.setVisible(true);


        profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Profile(name, social, loginFrame);
            }
        });

        extraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchBack();
            }
        });

        search.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Searching");
                    String searchText = search.getText();
                    System.out.println(searchText);
                    //if(social.isSocialsUser(getName()) == true){
                       
                    for(User u: social.getUsers()){
                        System.out.println("Searching....");
                        if(u.getUname() == (searchText));
                        extra.setText(u.getUname());
                        System.out.println("find....");
                        switchToSearchedUserPage();
                    }
                        
                    //}
            }
        }
    });
    
    }

    public void Showposts(){
        for (Post post : social.getPosts()) {
    }

    // Refresh the display
    postPanel.revalidate();
    postPanel.repaint();
    }

    
    private void switchToSearchedUserPage() {
        System.out.println("new page");
       
        postPanel.remove(post);
        postPanel.remove(upVote);
        postPanel.remove(downVote);
        
        BoxLayout boxlayout2 = new BoxLayout(postPanel, BoxLayout.Y_AXIS);
        postPanel.setBorder(new EmptyBorder(new Insets(100, 300, 200, 300))); 
        
        postPanel.add(extra);
        postPanel.add(upVote);
        postPanel.add(downVote);
        postPanel.add(extraButton);

        postPanel.revalidate();
        postPanel.repaint();
        }

        
        private void switchBack() {
            postPanel.remove(extra);
            postPanel.remove(upVote);
            postPanel.remove(downVote);
            postPanel.remove(extraButton);

        
            postPanel.add(post);
            postPanel.add(upVote);
            postPanel.add(downVote);

        
        

        postPanel.revalidate();
        postPanel.repaint();
        }
    
}