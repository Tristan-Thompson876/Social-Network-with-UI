package p2.ui;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Profile extends JFrame{
    JPanel aboutPanel = new JPanel();
    JPanel postPanel = new JPanel();

    String nme;
    JLabel uname = new JLabel("Username: ");
    
    public Profile(String name){
        this.nme = name;
        aboutPanel.setSize(700, 500);
        this.setSize(800, 800);
        aboutPanel.setBackground(Color.decode("#00001a"));

        uname.setText("User: " + nme);
    }
}
