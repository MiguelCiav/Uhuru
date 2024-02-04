package views.swingComponents;

import javax.swing.*;
import java.awt.*;

public class TestDataPanel extends JPanelRound{
    
    private JLabel testDataText;
    private LargeTextPanels testName = new LargeTextPanels("Ingrese el nombre del examen.", new Color(237, 246, 249));
    private LargeTextPanels testDescription = new LargeTextPanels("Ingrese la descripcion del examen", new Color(237, 246, 249));
    private JTextField minutes = new JTextField("Min", 7);
    private JPanelRound minutesPanel = new JPanelRound();
    private JPanelRound minutesTextPanel = new JPanelRound();
    private JTextArea minutesText = new JTextArea("Minutes");

    public TestDataPanel(){
        setLayout(new GridBagLayout());

        setRoundBackgroundColor(new Color(255,255,255));
        testDataText = new JLabel();
        testDataText.setText("Datos del examen");
        testDataText.setFont(new Font("Futura", Font.BOLD, 32));
        testDataText.setForeground(new Color(61,90,128));

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(40, 100, 20, 100);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        add(testDataText, constraints);

        constraints.insets = new Insets(0, 20, 30, 20);
        constraints.gridy = 1;
        constraints.weighty = 0.1;
        constraints.fill = GridBagConstraints.BOTH;

        add(testName, constraints);

        constraints.gridy = 2;
        constraints.weighty = 1.0;

        add(testDescription, constraints);

        constraints.gridwidth = 1;
        constraints.gridy = 3;
        constraints.weighty = 0.1;
        constraints.weightx = 0.1;
        minutes.setBorder(null);
        minutes.setBackground(new Color(217,233,241));         
        minutesPanel.setLayout(new GridBagLayout());
        minutesPanel.add(minutes);

        add(minutesPanel, constraints);

        constraints.insets = new Insets(0, 0, 30, 20);

        minutesTextPanel.setRoundBackgroundColor(new Color(106,106,106));
        minutesText.setBackground(new Color(106, 106, 106));

        constraints.gridx = 1;
        constraints.weightx = 1.0;
        
        minutesTextPanel.setLayout(new GridBagLayout());
        minutesText.setEditable(false);
        minutesTextPanel.add(minutesText);

        add(minutesTextPanel, constraints);
    }
}
