package p2.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import p1.enums.PostAudience;
import p1.enums.PostType;
import p2.ExternalLinkPost;
import p2.Post;
import p2.Socials;
import p2.TextPost;
import p2.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Profile extends JFrame{

    Boolean creating = false;
    JPanel profilePanel = new JPanel();
    JPanel aboutPanel = new JPanel();
    JPanel postPanel = new JPanel();
    JPanel navPanel = new JPanel();
    JPanel m1 = new JPanel();
    JPanel m2 = new JPanel();
    Socials social = new Socials("social");

    JButton publicFeedButton = new JButton("feed");
    JButton createPost = new JButton("create post");
    JButton submit = new JButton("Submit");

    JLabel postype = new JLabel("Post type(Text/ExtrenalLink): ");
    JTextField pstype = new JTextField(11);
    //JCheckBox textCheckBox = new JCheckBox("Text");
    //JCheckBox externalLinkCheckBox = new JCheckBox("External URL");

    JLabel audience = new JLabel("Audience(Private/Public/Subscribers): ");
    JTextField aud = new JTextField(11);
    //JCheckBox privateCheckBox = new JCheckBox("Only Owner");
    //JCheckBox publicCheckBox = new JCheckBox("Public, except restricted");
    //JCheckBox subscribersCheckBox = new JCheckBox("Subscribers");

    JLabel content = new JLabel("Content");
    JTextField postContenTextField = new JTextField(11);

    String nme;
    JLabel uname = new JLabel("Username: ");
    JLabel postLabel = new JLabel("Post: ");
    
    public Profile(String name){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nme = name;
        profilePanel.setSize(700, 500);
        this.setSize(800, 800);
        profilePanel.setBackground(Color.decode("#00001a"));

        uname.setText("User: " + nme);

      
        aboutPanel.add(createPost);
        aboutPanel.add(publicFeedButton);
        profilePanel.add(aboutPanel);
        profilePanel.add(postPanel);
        aboutPanel.add(uname);


        postPanel.add(postLabel);

        BoxLayout boxlayout = new BoxLayout(profilePanel, BoxLayout.Y_AXIS);
        profilePanel.setBorder(new EmptyBorder(new Insets(100, 200, 100, 200))); 
       
        

       

        createPost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToMakePost();
            }
        });

        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(creating){
                    String posType = pstype.getText();
                    String audience = aud.getText();
                    String content = postContenTextField.getText();

                    PostType type = PostType.valueOf(posType);
                    PostAudience postAudience = PostAudience.valueOf(audience);
                    

                    social.addNewPost(type, postAudience, content);
                    System.out.println("post sucessfully");
                    postToPanelForLoggedInUser();
                
                }
                else{

                }
            }
        });

        
        setTitle("Sweet mail");
                
        this.add(profilePanel);
        this.setVisible(true);
       
    }
    //method to post each post created by the user on the panel
    public void postToPanelForLoggedInUser() {
        System.out.println("first");
    postPanel.removeAll();  // Clear existing components from the postPanel
    User loggedInUser = social.getWhoIsLoggedIn();

    System.out.println("second");
    if (loggedInUser != null) {
        ArrayList<Post> userPosts = loggedInUser.getPosts();

        System.out.println("third");
        for (Post post : userPosts) {
            JPanel postContentPanel = new JPanel();
            BoxLayout boxlayout = new BoxLayout(aboutPanel, BoxLayout.Y_AXIS);
            postContentPanel.setLayout(new BoxLayout(postContentPanel, BoxLayout.Y_AXIS));

            JLabel typeLabel = new JLabel("Type: " + post.getPostType());
            JLabel audienceLabel = new JLabel("Audience: " + post.getSharedWith());
            JLabel contentLabel;

            if (post.getPostType() == PostType.Text) {
                contentLabel = new JLabel("Content: " + ((TextPost) post).getContent());
            } else if (post.getPostType() == PostType.ExtrenalLink) {
                contentLabel = new JLabel("Content: " + ((ExternalLinkPost) post).getUrl());
            } else {
                contentLabel = new JLabel("Content: [Unknown post type]");
            }
            Showposts();

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

    public void Showposts(){
        for (Post post : social.getPosts()) {
        // Create a JLabel for each post
        JLabel postLabel = new JLabel("Post ID: " + post.getID() + ", Content: " + post.getContent());
        
        // Add the JLabel to the postPanel
        postPanel.add(postLabel);}
    }


    private void switchToMakePost() {
        creating = true;
       
        postPanel.remove(postLabel);
        profilePanel.setLayout(new BorderLayout());
        profilePanel.add(aboutPanel, BorderLayout.PAGE_START);
        profilePanel.add(postPanel, BorderLayout.CENTER);

        /*
        BoxLayout boxlayout1 = new BoxLayout(aboutPanel, BoxLayout.Y_AXIS);
        aboutPanel.setBorder(new EmptyBorder(new Insets(100, 300, 200, 300))); 
        BoxLayout boxlayout2 = new BoxLayout(postPanel, BoxLayout.Y_AXIS);
        postPanel.setBorder(new EmptyBorder(new Insets(100, 300, 200, 300))); 
*/
        postPanel.add(postype);
        postPanel.add(pstype);
        postPanel.add(audience);
        postPanel.add(aud);
        postPanel.add(content);
        postPanel.add(postContenTextField);
        postPanel.add(submit);
        
        

        postPanel.revalidate();
        postPanel.repaint();
        }



        private void switchBack() {
        creating = false;
        postPanel.remove(postype);
        postPanel.remove(pstype);
        postPanel.remove(audience);
        postPanel.remove(aud);
        postPanel.remove(content);
        postPanel.remove(postContenTextField);
        postPanel.remove(submit);

        postPanel.add(postLabel);
        

        postPanel.revalidate();
        postPanel.repaint();
        }
}
