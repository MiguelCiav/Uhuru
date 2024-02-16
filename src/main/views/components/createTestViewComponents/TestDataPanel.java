package main.views.components.createTestViewComponents;

import javax.swing.*;

import main.views.components.JPanelRound;
import main.views.components.LargeTextPanels;

import java.awt.*;

import utils.ViewsStyles;

public class TestDataPanel extends JPanelRound{
    
    private JLabel testDataText;
    private LargeTextPanels testName = new LargeTextPanels("Ingrese el nombre del examen.", ViewsStyles.PALID_BLUE);
    private LargeTextPanels testDescription = new LargeTextPanels("Ingrese la descripcion del examen", ViewsStyles.PALID_BLUE);
    private JTextField minutes = new JTextField("Min", 7);
    private JPanelRound minutesPanel = new JPanelRound();
    private JPanelRound minutesTextPanel = new JPanelRound();
    private JTextArea minutesText = new JTextArea("Minutes");
    private GridBagConstraints constraints = new GridBagConstraints();

    public TestDataPanel(){

        setLayout(new GridBagLayout());
        setRoundBackgroundColor(Color.WHITE);

        addTestDataText();
        addTestName();
        addTestDescription();
        addMinutesPanel();
        addMinutesTextPanel();

    }

    public void addTestDataText(){
        
        testDataText = new JLabel();
        testDataText.setText("Datos del examen");
        testDataText.setFont(new Font("Futura", Font.BOLD, 32));
        testDataText.setForeground(ViewsStyles.DARK_BLUE);

        constraints.insets = new Insets(40, 100, 20, 100);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        add(testDataText, constraints);

    }

    public void addTestName(){

        constraints.insets = new Insets(0, 20, 30, 20);
        constraints.gridy = 1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;

        add(testName, constraints);

    }

    public void addTestDescription(){

        constraints.gridy = 2;
        constraints.weighty = 1.0;

        add(testDescription, constraints);

    }

    public void addMinutesPanel(){

        constraints.gridwidth = 1;
        constraints.gridy = 3;
        constraints.weighty = 0.1;
        constraints.weightx = 0.1;
        minutes.setBorder(null);
        minutes.setBackground(ViewsStyles.ULTRA_LIGHT_BLUE);         
        minutesPanel.setLayout(new GridBagLayout());
        minutesPanel.add(minutes);

        add(minutesPanel, constraints);

    }

    public void addMinutesTextPanel(){

        constraints.insets = new Insets(0, 0, 30, 20);

        minutesTextPanel.setRoundBackgroundColor(ViewsStyles.GRAPHITE);
        minutesText.setBackground(ViewsStyles.GRAPHITE);

        constraints.gridx = 1;
        constraints.weightx = 1.0;
        
        minutesTextPanel.setLayout(new GridBagLayout());
        minutesText.setEditable(false);
        minutesTextPanel.add(minutesText);

        add(minutesTextPanel, constraints);

    }
}
