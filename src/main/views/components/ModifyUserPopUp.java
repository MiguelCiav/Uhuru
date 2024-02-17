package main.views.components;

import javax.swing.*;

import main.views.components.genericComponents.BlueButton;
import main.views.components.genericComponents.JPanelRound;
import main.views.components.genericComponents.LargeTextPanels;

import java.awt.*;
import utils.ViewsStyles;

public class ModifyUserPopUp extends UserPopUps {

    private LargeTextPanels name;
    private LargeTextPanels email;
    private LargeTextPanels password;

    public ModifyUserPopUp(){
        
        super();

        addTitle();
        addCloseButton();
        addFieldsPanel();
        addLightBlueButton();
        addEraseButton();
        addSaveButton();
        addUserIcon();

    }

	@Override
	public void addTitle() {

		title.setText("Modificación del usuario");

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

    public void editPanel(){

        fieldsPanel = new JPanelRound();
        fieldsPanel.setRoundBackgroundColor(Color.WHITE);
        email = new LargeTextPanels("Correo",ViewsStyles.ULTRA_LIGHT_BLUE);
        password = new LargeTextPanels("Contraseña",ViewsStyles.ULTRA_LIGHT_BLUE);

        email.setPreferredSize(new Dimension(500, 60));
        password.setPreferredSize(new Dimension(500, 60));

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
        fieldsPanel.add(name, constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        
    }

	@Override
	public void addFieldsPanel() {  

        constraints.insets = new Insets(0, 0, 0, 20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.weighty = 0.8;
        constraints.fill = GridBagConstraints.BOTH;

        add(fieldsPanel, constraints);
		
	}

	@Override
	public void addLightBlueButton() {

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 0.1;
        constraints.weightx = 0.3;
        constraints.fill = GridBagConstraints.NONE;
        lightBlueButton = new BlueButton("Cancelar", 170, 2);

        add(lightBlueButton, constraints);
		
	}

    public void addEraseButton(){

        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.0;
        eraseButton = new BlueButton("Eliminar", 170, 1);

        add(eraseButton, constraints);

    }

	@Override
	public void addSaveButton() {
		constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.3;
        saveButton = new BlueButton("Guardar", 170, 1);
        add(saveButton, constraints);
	}
}