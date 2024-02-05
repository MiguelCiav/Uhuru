package views.swingComponents;

import javax.swing.*;

import utils.ViewsStyles;
import views.listeners.OpenCertificatePopUp;
import java.awt.*;

public class TestListPanel extends JPanelRound{

    GridBagConstraints constraints = new GridBagConstraints();
    JLabel answersTitle;
    ScrollablePanel testPanel;
    
    public TestListPanel(){

        setLayout(new GridBagLayout());
        setRoundBackgroundColor(Color.WHITE);

        addTestTitle();
        addTestPanel();
        addButton();

    }

    private void addTestTitle(){

        answersTitle = new JLabel("Examenes Disponibles");

        answersTitle.setFont(new Font("Futura", Font.BOLD, 32));
        answersTitle.setForeground(ViewsStyles.DARK_BLUE);

        constraints.insets = new Insets(16, 20, 16, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.WEST;

        add(answersTitle, constraints);

    }

    private void addTestPanel(){

        testPanel = new ScrollableTestPanel();

        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 20, 20, 20);

        add(testPanel, constraints);

    }

    private void addButton(){

        BlueButton certificateButton = new BlueButton("Obtener Certificado", 250, 1);

        constraints.gridy = 2;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(0, 20, 20, 20);

        certificateButton.addActionListener(new OpenCertificatePopUp());

        add(certificateButton,constraints);
    }
}