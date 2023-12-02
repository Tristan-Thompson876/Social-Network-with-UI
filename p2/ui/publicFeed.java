package p2.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import p2.ExternalLinkPost;
import p2.Post;
import p2.Socials;
import p2.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Represents the public feed interface in a social media application.
 */
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
 /**
     * Constructor for PublicFeed.
     *
     * @param name The name of the user.
     * @param loginFrame The frame of the login interface.
     * @param social The social media platform instance.
     */
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
    /*
     public void postToPanelForLoggedInUser() {
        postPanel.removeAll();  // Clear existing components from the postPanel
    
        User loggedInUser = social.getWhoIsLoggedIn();
    
        if (loggedInUser != null) {
            System.out.println(" I got greens");
            //ArrayList<Post> userPosts = new ArrayList<>(loggedInUser.getPosts());
            System.out.println("Beans");
    
            //userPosts
            for (Post post : loggedInUser.getPosts()) {
                System.out.println(post);
                JPanel postContentPanel = new JPanel();
                postContentPanel.setLayout(new BoxLayout(postContentPanel, BoxLayout.Y_AXIS));
    
                //post.getContent().setData();
                JLabel typeLabel = new JLabel("Type: " + post.getPostType());
                JLabel audienceLabel = new JLabel("Audience: " + post.getSharedWith());
                JLabel contentLabel;
    
                System.out.println(post);
                if (post.getPostType() == PostType.Text) {
                    TextPost textPost = (TextPost) post;
                    //post.getContent().setData();
                    //Post textContent = post;
                    Integer S = post.getID();
                    //String textContent = social.displayPost(S);
                    System.out.println(textPost.getContent()+ "sssss");

                    contentLabel = new JLabel("Content: " + textPost.getContent());
/* 
                    System.out.println(post);
                    if (textContent != null) {
                        System.out.println("The good block");
                        contentLabel = new JLabel("Content: " + textContent);
                    } else {
                        System.out.println(post + "So Why is it No text");
                        contentLabel = new JLabel("Content: [No text content]");
                    } 
                
                } else if (post.getPostType() == PostType.ExternalLink) {
                    ExternalLinkPost linkPost = (ExternalLinkPost) post;
                    String linkContent = linkPost.getContent();
                    if (linkContent != null) {
                        contentLabel = new JLabel("Content: " + linkContent);
                    } else {
                        contentLabel = new JLabel("Content: [No external link]");
                    }
                } else {
                    contentLabel = new JLabel("Content: [Unknown post type]");
                }
    
                postContentPanel.add(typeLabel);
                postContentPanel.add(audienceLabel);
                postContentPanel.add(contentLabel);
    
                postContentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
    
                postPanel.add(postContentPanel);
            }
    
            // Repaint the postPanel to reflect the changes
            postPanel.revalidate();
            postPanel.repaint();
        }
    }
    */

    
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