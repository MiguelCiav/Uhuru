package main.views.components;

import javax.swing.*;
import javax.swing.border.LineBorder;

import main.views.components.genericComponents.BlueButton;
import main.views.components.genericComponents.CloseWindow;
import main.views.components.genericComponents.JPanelRound;
import main.views.components.genericComponents.LargeTextPanels;
import utils.PathManager;
import utils.ViewsStyles;

import java.awt.*;

public abstract class UserPopUps extends JPanelRound{

    protected JLabel title;
    protected JLabel userIcon;
    protected BlueButton saveButton;
    protected BlueButton eraseButton; 
    protected BlueButton lightBlueButton;
    protected JLabel closeButton;
    protected JPanelRound fieldsPanel;
    protected GridBagConstraints constraints = new GridBagConstraints();

    public UserPopUps(){

        setRoundBackgroundColor(Color.WHITE);
        setLayout(new GridBagLayout());
        setBorder(new LineBorder(ViewsStyles.CYAN, 20,true));
        setMinimumSize(new Dimension(863,550));

    }

    public abstract void addTitle();

    public abstract void addFieldsPanel();

    public abstract void addLightBlueButton();

    public abstract void addSaveButton();

    public void addCloseButton(){

        closeButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/testListView/close.png")));
        closeButton.setPreferredSize(new Dimension(50, 50));
        constraints.insets = new Insets(20, 0, 0, 20);
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.anchor = GridBagConstraints.NORTHEAST;
        closeButton.addMouseListener(new CloseWindow());
        add(closeButton, constraints);

    }

    public void addUserIcon(){

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.weightx = 0.3;
        constraints.weighty = 0.8;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        userIcon = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/userPopUps/userIcon.png")));

        add(userIcon, constraints);

    }

    
}