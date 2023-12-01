package p2.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import p1.enums.PostAudience;
import p1.enums.PostType;
import p2.Content;
import p2.ExternalLinkPost;
import p2.Post;
import p2.Socials;
import p2.TextPost;
import p2.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Represents the profile interface in a social media application.
 * This class manages the user's profile view and interaction with posts.
 */
public class Profile extends JFrame{
    

    Boolean creating = false;
    JPanel profilePanel = new JPanel();
    JPanel aboutPanel = new JPanel();
    JPanel postPanel = new JPanel();
    JPanel navPanel = new JPanel();
    JPanel m1 = new JPanel();
    JPanel m2 = new JPanel();
    Socials social;
    JFrame loginFrame;

    JButton publicFeedButton = new JButton("feed");
    JButton createPost = new JButton("create post");
    JButton submit = new JButton("Submit");
    JButton back = new JButton("Back");

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
/**
     * Constructor to create a Profile interface.
     * 
     * @param dname The display name of the user.
     * @param social The social media platform instance.
     * @param loginFrame The frame of the login interface.
     */
    
    public Profile(String dname, Socials social, JFrame loginFrame){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nme = dname;
        this.social = social;
        this.loginFrame = loginFrame;
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

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchBack();
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
                        postType = PostType.ExternalLink.name();
                    }
        
                    String audience = "";
                    if (aud.isSelected()) {
                        audience = PostAudience.Private.name();
                    } else if (aud2.isSelected()) {
                        audience = PostAudience.Public.name();
                    } else if (aud3.isSelected()) {
                        audience = PostAudience.Subscribers.name();
                    }
                    
                    String contentText = postContenTextField.getText();  // Get content from the text field
        
                    if (!postType.isEmpty()) {
                        PostType type = PostType.valueOf(postType);
                        PostAudience postAudience = PostAudience.valueOf(audience);
        
                        // Create Content object with the content from the text field
                        Content myContent = new Content(contentText);
        
                        // Pass Content object to addNewPost method
                        social.addNewPost(type, postAudience, contentText);
        
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
                    } */
                
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
    

    private void switchToMakePost() {
        creating = true;
       
        postPanel.remove(postLabel);
        postPanel.removeAll();
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
        postPanel.add(back);
        

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
        postPanel.remove(back);


        new PublicFeed(nme, loginFrame, social);
        

        postPanel.revalidate();
        postPanel.repaint();
        }
}
