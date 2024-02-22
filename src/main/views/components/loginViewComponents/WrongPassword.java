package main.views.components.loginViewComponents;

import javax.swing.*;

import main.views.components.genericComponents.CloseWindow;
import main.views.components.genericComponents.JPanelRound;
import main.views.components.genericComponents.LargeTextPanels;
import utils.PathManager;
import utils.ViewsStyles;

import java.awt.*;

public class WrongPassword extends JPanelRound{
    
    LargeTextPanels errorMessage;
    GridBagConstraints constraints = new GridBagConstraints();

    public WrongPassword(){

        setRoundBackgroundColor(Color.WHITE);
        setLayout(new GridBagLayout());
        addCloseButton();
        addErrorMessage();

    }

    public void addCloseButton(){

        JLabel closeButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/testListView/close.png")));
        closeButton.setPreferredSize(new Dimension(50, 50));
        constraints.insets = new Insets(20, 20, 20, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.EAST;
        closeButton.addMouseListener(new CloseWindow());
        add(closeButton, constraints);

    }

    public void addErrorMessage(){

        errorMessage = new LargeTextPanels("Para recuperar su contraseña, comuníquese con\nel administrador del sistema", Color.WHITE);
        errorMessage.getTextArea().setEditable(false);
        errorMessage.getTextArea().setFont(ViewsStyles.SMALL_TITLE_FONT);
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;

        add(errorMessage, constraints);
        
    }
}
