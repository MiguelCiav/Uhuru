package main.views.components.loginViewComponents;

import javax.swing.*;

import main.controllers.LogInController;
import utils.ViewsStyles;
import main.views.components.BlueButton;
import main.views.components.JPanelRound;
import main.views.components.LargeTextPanels;
import main.views.frames.TestListView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPopUp extends JPanelRound implements ActionListener{

    JLabel welcome;
    JLabel login;
    LargeTextPanels email;
    LargeTextPanels password;
    BlueButton loginButton;
    JLabel forgottenPassword;
    GridBagConstraints constraints = new GridBagConstraints();

    public LoginPopUp(){

        setRoundBackgroundColor(Color.WHITE);
        setLayout(new GridBagLayout());
        setMinimumSize(new Dimension(863,550));

        setLayout(new GridBagLayout());

        addWelcome();
        addLogin();
        addFieldsPanel();
        addLoginButton();
        addForgottenPassword();

        setVisible(true);
    }

    public void addWelcome(){
        welcome = new JLabel("Bienvenido");
        welcome.setFont(ViewsStyles.EXTRALARGE_TITLE_FONT);
        welcome.setForeground(ViewsStyles.DARK_BLUE);

        constraints.insets = new Insets(10, 20, 0, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.16;
        constraints.fill = GridBagConstraints.BOTH;

        add(welcome, constraints);
    }

    public void addLogin(){
        login = new JLabel("Inicia Sesión");
        login.setFont(ViewsStyles.SMALL_TITLE_FONT);
        constraints.insets = new Insets(10, 30, 20, 20);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 0.0;
        constraints.fill = GridBagConstraints.BOTH;

        add(login, constraints);
    }

    public void addFieldsPanel(){
        email = new LargeTextPanels("Ingrese su correo",ViewsStyles.ULTRA_LIGHT_BLUE);
        password = new LargeTextPanels("Ingrese su contraseña",ViewsStyles.ULTRA_LIGHT_BLUE);

        constraints.insets = new Insets(0, 20, 10, 20);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        email.setPreferredSize(new Dimension(500, 60));

        add(email, constraints);

        constraints.gridy = 3;
        password.setPreferredSize(new Dimension(500, 60));
        
        add(password, constraints);
    }

    public void addLoginButton(){
        loginButton = new BlueButton("INICIAR SESION", 500, 1);

        constraints.insets = new Insets(10, 20, 10, 20);
        constraints.gridy = 4;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weighty = 0.16;
        loginButton.addActionListener(this);
        add(loginButton, constraints);
    }

    public void addForgottenPassword(){
        forgottenPassword = new JLabel("¿Olvidó su contraseña?");
        forgottenPassword.setForeground(ViewsStyles.DARK_BLUE);
        forgottenPassword.setFont(ViewsStyles.TEXT_FONT);

        constraints.insets = new Insets(10, 0, 40, 0);
        constraints.gridy = 5;
        constraints.weighty = 0.16;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.NORTH;

        add(forgottenPassword, constraints);
    }

    @Override public void actionPerformed(ActionEvent e){
        
        if(LogInController.validateUser(email.textArea.getText(), password.textArea.getText())){
            new TestListView();
        }
        else{
            new WrongPassword();
        }
    }
}