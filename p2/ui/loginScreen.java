package p2.ui;
import java.awt.*;
import javax.swing.*;

import p2.Post;
import p2.Socials;
import p2.User;

import java.util.ArrayList;
import java.util.HashMap;

public class loginScreen extends JFrame {
    protected HashMap<String, String> LoginInfo = new HashMap<String, String>();

    JPanel loginPanelInfo = new JPanel();
    JPanel loginButtoPanel = new JPanel();
    JPanel loginPanel = new JPanel();
    JButton logon = new JButton();

    //labels
    JLabel username = new JLabel("UserName");
    JLabel password = new JLabel("Password");

    //text fields
    JTextField unameText = new JTextField(11);
    JTextField passwordText = new JTextField(11);

    private ArrayList<User> user = new ArrayList<User>();

    public loginScreen(HashMap<String,String> LoginInfo){
        this.LoginInfo = LoginInfo;

        this.setSize(800, 800);
        loginPanelInfo.setSize(700, 500);

        loginPanelInfo.setBackground(Color.decode("#00001a")); 

        loginPanel.add(loginPanelInfo);
        loginPanel.add(loginButtoPanel);
        loginButtoPanel.add(logon);

    }

    public void validInfo(String name, String password){
        if(Socials.isSocialsUser(name)){

        }
    }


}
