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
    Socials social;

    JButton publicFeedButton = new JButton("feed");
    JButton createPost = new JButton("create post");
    JButton submit = new JButton("Submit");

    JLabel postype = new JLabel("Post type: ");
    JCheckBox pstype = new JCheckBox("Text");
    JCheckBox pstype1 = new JCheckBox("External Link");
    
    ButtonGroup postTypeGroup = new ButtonGroup();

    JLabel audience = new JLabel("Audience: ");
    JCheckBox aud = new JCheckBox("Private");
    JCheckBox aud2 = new JCheckBox("Public");
    JCheckBox aud3 = new JCheckBox("Subscribers");

    ButtonGroup audienceGroup = new ButtonGroup();


    JLabel content = new JLabel("Content");
    JTextField postContenTextField = new JTextField(11);

    String nme;
    JLabel uname = new JLabel("Username: ");
    JLabel postLabel = new JLabel("Post: ");
    
    public Profile(String name, Socials social){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nme = name;
        this.social = social;
        profilePanel.setSize(700, 500);
        this.setSize(800, 800);
        profilePanel.setBackground(Color.decode("#00001a"));

        uname.setText("User: " + nme);

      
        postTypeGroup.add(pstype);
        postTypeGroup.add(pstype1);

        audienceGroup.add(aud);
        audienceGroup.add(aud2);
        audienceGroup.add(aud3);

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

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (creating) {
                    // Use isSelected to check which checkbox is selected for post type
                    String postType = "";
                    if (pstype.isSelected()) {
                        postType = PostType.Text.name();
                    } else if (pstype1.isSelected()) {
                        postType = PostType.ExtrenalLink.name();
                    }
        
                    String audience = "";
                    if (aud.isSelected()) {
                        audience = PostAudience.Private.name();
                    } else if (aud2.isSelected()) {
                        audience = PostAudience.Public.name();
                    } else if (aud3.isSelected()) {
                        audience = PostAudience.Subscribers.name();
                    }
                    String content = postContenTextField.getText();
        
                    if (postType != null && !postType.isEmpty()) {
                        PostType type = PostType.valueOf(postType);
                        PostAudience postAudience = PostAudience.valueOf(audience);
        
                        social.addNewPost(type, postAudience, content);
                        System.out.println("post successfully");
                        postToPanelForLoggedInUser();
                    } else {
                        System.out.println("Invalid post type");
                    }
                } else {
                    // Handle other actions if not in creating mode
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
    System.out.println("second"); 
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
        postPanel.add(pstype1);
        postPanel.add(audience);
        postPanel.add(aud);
        postPanel.add(aud2);
        postPanel.add(aud3);
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
