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

public class UserPopUps extends JPanelRound{

    JLabel title;
    JLabel userIcon;
    BlueButton saveButton;
    BlueButton eraseButton;
    BlueButton lightBlueButton;
    JLabel closeButton;
    JPanelRound fieldsPanel;
    GridBagConstraints constraints = new GridBagConstraints();

    public UserPopUps(int popUpID){

        setRoundBackgroundColor(Color.WHITE);
        setLayout(new GridBagLayout());
        setBorder(new LineBorder(ViewsStyles.CYAN, 20,true));
        setMinimumSize(new Dimension(863,550));

        setLayout(new GridBagLayout());

        addTitle(popUpID);
        addCloseButton();
        addFieldsPanel(popUpID);
        addLightBlueButton(popUpID);
        addEraseButton(popUpID);
        addSaveButton();
        addUserIcon();

        setVisible(true);

    }

    public void addTitle(int popUpID){
        title = new JLabel();

        switch (popUpID) {
            case 1:
                title.setText("Editar perfil");
                break;
        
            case 2:
                title.setText("Registro del usuario");
                break;
            case 3:
                title.setText("Modificación del usuario");
                break;
        }

        constraints.insets = new Insets(0, 0, 0, 20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.weighty = 0.2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        title.setFont(ViewsStyles.TITLE_FONT);
        title.setForeground(ViewsStyles.DARK_BLUE);

        add(title, constraints);
    }

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

    public void editPanel(boolean visible){

        fieldsPanel = new JPanelRound();
        fieldsPanel.setRoundBackgroundColor(Color.WHITE);
        LargeTextPanels email = new LargeTextPanels("Correo",ViewsStyles.ULTRA_LIGHT_BLUE);
        LargeTextPanels password = new LargeTextPanels("Contraseña",ViewsStyles.ULTRA_LIGHT_BLUE);
        LargeTextPanels name = new LargeTextPanels("Nombre",ViewsStyles.ULTRA_LIGHT_BLUE);

        email.setPreferredSize(new Dimension(500, 60));
        password.setPreferredSize(new Dimension(500, 60));
        name.setPreferredSize(new Dimension(500, 60));

        fieldsPanel.setLayout(new GridBagLayout());

        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 0.3;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;

        fieldsPanel.add(email, constraints);

        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.NORTH;

        fieldsPanel.add(password, constraints);

        constraints.gridy = 2;
        name.setVisible(visible);
        fieldsPanel.add(name, constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        
    }

    public void addFieldsPanel(int popUpID){

        if(popUpID == 2){
            editPanel(true);   
        }
        else{
            editPanel(false);  
        }

        constraints.insets = new Insets(0, 0, 0, 20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.weighty = 0.8;
        constraints.fill = GridBagConstraints.BOTH;

        add(fieldsPanel, constraints);
        
    }

    public void addLightBlueButton(int popUpID){

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 0.1;
        constraints.weightx = 0.3;
        constraints.fill = GridBagConstraints.NONE;
        lightBlueButton = new BlueButton("Cancelar", 170, 2);


        if(popUpID == 1){
            lightBlueButton.setText("Cerrar sesion");
        }

        add(lightBlueButton, constraints);

    }

    public void addEraseButton(int popUpID){

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.0;
        eraseButton = new BlueButton("Eliminar", 170, 1);

        if(popUpID == 3){
            eraseButton.setVisible(true);
        }
        else{
            eraseButton.setVisible(false);
        }
        add(eraseButton, constraints);

    }

    public void addSaveButton(){

        constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.3;
        saveButton = new BlueButton("Guardar", 170, 1);
        add(saveButton, constraints);

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