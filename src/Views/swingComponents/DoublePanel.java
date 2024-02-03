package Views.swingComponents;

import javax.swing.*;

import java.awt.*;

public class DoublePanel extends JPanel{
    
    private GridBagConstraints constraints;
    private PrincipalPanel principalPanel = new PrincipalPanel();
    private JPanelRound containerPanel = new JPanelRound();

    public DoublePanel(JPanel firstPanel, JPanel secondPanel){

        constraints = new GridBagConstraints();
        setContainerPanel();
        addFirstPanel(firstPanel);
        addSecondPanel(secondPanel);
        addContainerPanel();

    }

    protected void setContainerPanel(){

        containerPanel.setRoundBackgroundColor(new Color(61,90,128));
        containerPanel.setLayout(new GridBagLayout());

    }

    protected void addFirstPanel(JPanel firstPanel){

        constraints.insets = new Insets(0, 0, 0, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;

        containerPanel.add(firstPanel, constraints);

    }

    protected void addSecondPanel(JPanel secondPanel){

        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.weightx = 1;
        constraints.gridx = 1;

        containerPanel.add(secondPanel, constraints);

    }

    protected void addContainerPanel(){

        principalPanel.setContentPanel(containerPanel);
        add(principalPanel);

    }
}