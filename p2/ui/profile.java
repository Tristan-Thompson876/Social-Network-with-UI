package p2.ui;

import java.awt.*;
import javax.swing.*;

import p1.enums.PostAudience;
import p1.enums.PostType;
import p2.Socials;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    JLabel postype = new JLabel("Post type: ");
    JTextField pstype = new JTextField(11);
    //JCheckBox textCheckBox = new JCheckBox("Text");
    //JCheckBox externalLinkCheckBox = new JCheckBox("External URL");

    JLabel audience = new JLabel("Audience(): ");
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
                
                }
                else{

                }
            }
        });


        
        setTitle("Sweet mail");

        
        
        this.add(profilePanel);
        this.setVisible(true);


        
    }
    private void switchToMakePost() {
        creating = true;
        postPanel.remove(postLabel);

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
}
