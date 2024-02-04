package views.swingComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import views.listeners.GoToTestView;

public class LabelPanelWithIcon extends LabelPanel{

    private JLabel testLabel;
    private JLabel arrowLabel;
    private String testName;

    public LabelPanelWithIcon(String testName){

        constraints = new GridBagConstraints();
        this.testName = testName;

        setLayout(new GridBagLayout());
        setBackground(new Color(216,233,241));
        setLabel();
        addLabel();

    }

    @Override
    protected void setLabel() {

        testLabel = new JLabel();

        testLabel.setBackground(new Color(216,233,241));
        testLabel.setOpaque(true);
        testLabel.setFont(new Font("Futura", Font.PLAIN, 12));
        testLabel.setFocusable(false);
        testLabel.setText(testName);

        arrowLabel = new JLabel(new ImageIcon(getClass().getResource(new PathManager().setFileLink("../img/testListView/siguiente.png"))));

    }

    @Override protected void addLabel() {

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(16, 16, 16, 16);

        add(testLabel, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.EAST;

        add(arrowLabel, constraints);

        arrowLabel.addMouseListener(new GoToTestView());
        
    }
    
}
