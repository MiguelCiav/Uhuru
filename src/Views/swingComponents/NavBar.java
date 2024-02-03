package Views.swingComponents;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import org.w3c.dom.events.MouseEvent;

import Views.listeners.TestListViewAction;

//NAVBAR

public class NavBar extends JPanel{

    //CONSTRUCTOR

    public NavBar(){

        //Define el color del navbar
        setBackground(Color.white);

        //Define el layout
        setLayout(new GridBagLayout());
        
        //CONSTRAINST
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(0,20,0,0);
        constraints.ipady = 20;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.WEST;

        JLabel Logo = new JLabel(new ImageIcon(getClass().getResource("../img/NavBar/iconDarkMini.png")));
        Logo.addMouseListener(new TestListViewAction());

        add(Logo, constraints);

        constraints.insets = new Insets(0,0,0,20);
        constraints.gridx = 1;
        constraints.weightx = 0.0;
        constraints.anchor = GridBagConstraints.EAST;

        add(new JLabel(new ImageIcon(getClass().getResource("../img/NavBar/FaQ.png"))), constraints);

        constraints.gridx = 2;

        add(new JLabel(new ImageIcon(getClass().getResource("../img/NavBar/user.png"))), constraints);
    }

}