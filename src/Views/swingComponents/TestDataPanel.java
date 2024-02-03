package Views.swingComponents;

import javax.swing.*;
import java.awt.*;

public class TestDataPanel extends JPanelRound{
    
    private JLabel testDataText;
    private JPanelRound testName = new JPanelRound();
    private JPanelRound testDescription = new JPanelRound();
    private JPanelRound minutes = new JPanelRound();
    private JPanelRound minutesText = new JPanelRound();

    public TestDataPanel(){
        setLayout(new GridBagLayout());

        setRoundBackgroundColor(new Color(255,255,255));
        testDataText = new JLabel();
        testDataText.setText("Datos del examen");
        testDataText.setFont(new Font("Futura", Font.BOLD, 32));
        testDataText.setForeground(new Color(61,90,128));

        GridBagConstraints constraints = new GridBagConstraints();

        testName.setRoundBackgroundColor(new Color(152,193,217));
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        add(testDataText, constraints);

        testDescription.setRoundBackgroundColor(new Color(152,193,217));
        constraints.gridy = 1;
        
        add(testDescription, constraints);

        minutes.setRoundBackgroundColor(new Color(152,193,217));
        constraints.gridy = 2;
        constraints.weightx = 1;

        add(minutes, constraints);

        minutesText.setRoundBackgroundColor(new Color(106, 106, 106));
        constraints.gridx = 1;

        add(minutesText, constraints);
    }
}
