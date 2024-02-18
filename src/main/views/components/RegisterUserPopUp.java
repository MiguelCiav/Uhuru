package main.views.components;
import main.controllers.AddNewUserController;
import main.views.components.genericComponents.BlueButton;
import main.views.components.genericComponents.JPanelRound;
import main.views.components.genericComponents.LargeTextPanels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import utils.ViewsStyles;

public class RegisterUserPopUp extends UserPopUps implements ActionListener{
    
    private LargeTextPanels name;
    private LargeTextPanels email;
    private LargeTextPanels password;
    private LargeTextPanels lastname;

    public RegisterUserPopUp(){
        
        super();

        addTitle();
        addCloseButton();
        editPanel();
        addFieldsPanel();
        addLightBlueButton();
        addSaveButton();
        addUserIcon();

    }

	@Override
	public void addTitle() {
        title = new JLabel();
        title.setText("Registro del usuario");

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

	@Override
	public void addSaveButton() {

		constraints.gridx = 3;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.3;
        saveButton = new BlueButton("Guardar", 170, 1);

        saveButton.addActionListener(this);
        add(saveButton, constraints);

	}

    public void editPanel(){

        fieldsPanel = new JPanelRound();
        fieldsPanel.setRoundBackgroundColor(Color.WHITE);
        email = new LargeTextPanels("Correo",ViewsStyles.ULTRA_LIGHT_BLUE);
        password = new LargeTextPanels("Contraseña",ViewsStyles.ULTRA_LIGHT_BLUE);
        name = new LargeTextPanels("Nombre",ViewsStyles.ULTRA_LIGHT_BLUE);
        lastname = new LargeTextPanels("Apellido",ViewsStyles.ULTRA_LIGHT_BLUE);

        email.setPreferredSize(new Dimension(500, 60));
        password.setPreferredSize(new Dimension(500, 60));
        name.setPreferredSize(new Dimension(500, 60));
        lastname.setPreferredSize(new Dimension(500, 60));

        fieldsPanel.setLayout(new GridBagLayout());

        constraints.insets = new Insets(5, 10, 0, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
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

        constraints.gridy = 3;
        fieldsPanel.add(lastname, constraints);

        constraints.anchor = GridBagConstraints.CENTER;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AddNewUserController.addUserToDatabase(name.getText(),lastname.getText(),email.getText(),password.getText());
        name.setText(null);
        lastname.setText(null);
        email.setText(null);
        password.setText(null);
        name.requestFocus();
    }
}
