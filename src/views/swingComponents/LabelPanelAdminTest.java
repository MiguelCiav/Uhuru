package views.swingComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;

public class LabelPanelAdminTest extends LabelPanel{

    private JLabel textLabel;
    private String testName;

    public LabelPanelAdminTest(String testName){

        constraints = new GridBagConstraints();
        this.testName = testName;

        setLayout(new GridBagLayout());
        setBackground(new Color(216,233,241));
        setLabel();
        addLabel();

    }

    @Override
    protected void setLabel() {

        textLabel = new JLabel();

        textLabel.setBackground(new Color(216,233,241));
        textLabel.setOpaque(true);
        textLabel.setFont(new Font("Futura", Font.PLAIN, 12));
        textLabel.setFocusable(false);
        textLabel.setText(testName);

    }

    @Override
    protected void addLabel() {

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(16, 16, 16, 16);

        add(textLabel, constraints);
        
    }
    
}
