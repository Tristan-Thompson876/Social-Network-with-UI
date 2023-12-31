package p2.ui;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import p2.Post;
import p2.Socials;
//import p2.User;

//import java.util.ArrayList;
//import java.util.HashMap;

public class LoginScreen extends JFrame {
    //protected HashMap<String, String> LoginInfo = new HashMap<String, String>();
    protected JFrame frame;
    Socials social;
    


    
    JPanel loginPanelInfo = new JPanel();
    JPanel loginButtoPanel = new JPanel();
    JPanel loginPanel = new JPanel();
    JPanel Su_Panel = new JPanel();
    JButton Signup = new JButton("sign up");
    JButton bButton = new JButton("Back");
    JButton submit = new JButton("login");

    //labels
    JLabel username = new JLabel("UserName");
    JLabel password = new JLabel("Password");
    
    JLabel errorLabel = new JLabel("");

    //text fields
    JTextField unameText = new JTextField(11);
    JTextField passwordText = new JTextField(11);
    JTextField Su_unameText = new JTextField(11);
    JTextField Su_passwordText = new JTextField(11);

    //private ArrayList<User> user = new ArrayList<User>();
    private boolean isSignUp = false;
   

    /**
     * 
     * @param social
     * constructor for loginscreen
     */
    public LoginScreen(Socials social){
        this.frame = this;
        this.social = social;
        /*this.LoginInfo = LoginInfo;*/

        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // loginPanelInfo.setSize(700, 500);
        //loginPanelInfo.setBackground(Color.decode("#00001a")); 

        loginPanel.add(username);
        loginPanel.add(unameText);
        loginPanel.add(password);
        loginPanel.add(passwordText);
        //loginPanel.add(loginPanelInfo);
        loginPanel.add(loginButtoPanel);
        //loginButtoPanel.add(logon);
        loginButtoPanel.add(submit);
        loginButtoPanel.add(Signup);
        loginPanel.add(Su_Panel);

        BoxLayout boxlayout = new BoxLayout(loginPanel, BoxLayout.Y_AXIS);
        loginPanel.setBorder(new EmptyBorder(new Insets(100, 300, 200, 300))); 
        setTitle("Sweet mail");
        

        bButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToLogin();
            }
        });

        // Add a label to display error messages
        
        // Add the label to your panel
        loginPanel.add(errorLabel);

        Signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToSignUp();

                String uname = Su_unameText.getText();
                String mpassword = Su_passwordText.getText();

                try {
                    // Input Validation
                    if (uname.isEmpty() || mpassword.isEmpty()) {
                        throw new IllegalArgumentException("Username and or password cannot be empty.");
                    }

                    // Check if username already exists
                    if (social.getAllSocialsUsers().contains(uname)) {
                        throw new IllegalArgumentException("Username already in use. Please choose a different username.");
                    }

                    // Clear any previous error messages
                    errorLabel.setText("");

                    // Perform signup logic here
                    social.addNewSocialsUser(uname, mpassword);
                    System.out.println("Signed up");

                } catch (IllegalArgumentException ex) {
                    // Display the error message on the label
                    errorLabel.setText("Error: " + ex.getMessage());
                }
            }
        });

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSignUp == false){
                    String uname = unameText.getText();
                    String mpassword = passwordText.getText();
                    if(social.isSocialsUser(uname) == true){
                        social.login(uname, mpassword);
                        System.out.println(social.getWhoIsLoggedIn().getUname()+" thank you");
                        //social.isSocialsUser(uname);
                        System.out.println("logged in");
                        new PublicFeed(uname, frame, social);
                    }
                
                }
                else{

                }
            }
        });

        this.add(loginPanel);
        this.setVisible(true);

    }

    /**
     * method to swith elements on panel
     */
    private void switchToSignUp() {
        isSignUp = true;
        loginPanel.setBorder(new EmptyBorder(new Insets(100, 300, 200, 300))); 
        loginPanel.remove(username);
        loginPanel.remove(unameText);
        loginPanel.remove(password);
        loginPanel.remove(passwordText);
        loginPanel.remove(errorLabel);
        //loginButtoPanel.remove(logon);
        loginButtoPanel.remove(submit);
        loginPanel.remove(Signup);

        loginButtoPanel.add(errorLabel);
        loginPanel.add(Su_Panel);
        Su_Panel.add(username);
        Su_Panel.add(Su_unameText);
        Su_Panel.add(password);
        Su_Panel.add(Su_passwordText);
        loginPanel.add(bButton);
        loginPanel.add(Signup);
        //loginPanel.add(submit);
        

        loginPanel.revalidate();
        loginPanel.repaint();
    }

    private void switchToLogin() {
        isSignUp = false;
        loginPanel.remove(Su_Panel);
        loginPanel.remove(username);
        loginPanel.remove(Su_unameText);
        loginPanel.remove(password);
        loginPanel.remove(Su_passwordText);
        loginPanel.remove(bButton);

        
        loginPanel.add(username);
        loginPanel.add(unameText);
        loginPanel.add(password);
        loginPanel.add(passwordText);
        loginPanel.add(submit);
        loginPanel.add(loginButtoPanel);
        //loginButtoPanel.add(logon);
        loginButtoPanel.add(Signup);
        
        
    
        loginPanel.revalidate();
        loginPanel.repaint();
    }

    public void logOnInfo(){
        String uname = unameText.getText();
        String mpassword = passwordText.getText();
        System.out.println("in login");
        if(social.isRestricted(uname)){
            System.out.println("okay");
            if (social.login(uname, mpassword)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed. Please check your credentials.");
                System.out.println("names:" + social.getAllSocialsUsers());
            }
        }
    }

    public static void main(String[] args) {
        Socials social = new Socials("social");
        new LoginScreen(social);
    }

}
