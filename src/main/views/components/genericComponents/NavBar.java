package main.views.components.genericComponents;
import java.awt.*;
import javax.swing.*;

import utils.PathManager;

//NAVBAR

public class NavBar extends JPanel{

    private GridBagConstraints constraints;
    private static NavBar navBar;

    private NavBar(){

        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();

        addLogo();
        addFAQ();
        addUser();

    }

    public static NavBar getNavBar(){
        
        if(navBar == null){
            navBar = new NavBar();
        }

        return navBar;
    }

    private void addLogo(){

        constraints.insets = new Insets(0,20,0,0);
        constraints.ipady = 20;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.WEST;

        JLabel Logo = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/NavBar/iconDarkMini.png")));
        Logo.addMouseListener(new GoToTestListView());

        add(Logo, constraints);

    }

    private void addFAQ(){

        constraints.insets = new Insets(0,0,0,20);
        constraints.gridx = 1;
        constraints.weightx = 0.0;
        constraints.anchor = GridBagConstraints.EAST;

        add(new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/NavBar/FaQ.png"))), constraints);

    }

    private void addUser(){

        constraints.gridx = 2;

        add(new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/NavBar/user.png"))), constraints);
    }

}