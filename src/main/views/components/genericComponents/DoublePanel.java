package main.views.components.genericComponents;

import javax.swing.*;

import utils.ViewsStyles;

import java.awt.*;

public class DoublePanel extends PrincipalPanel{
    
    private JPanelRound containerPanel = new JPanelRound();
    GridBagConstraints constraints = new GridBagConstraints();

    public DoublePanel(JPanel firstPanel, JPanel secondPanel){

        super();

        setContainerPanel();
        addFirstPanel(firstPanel);
        addSecondPanel(secondPanel);
        setContentPanel(containerPanel);

    }

    protected void setContainerPanel(){

        containerPanel.setRoundBackgroundColor(ViewsStyles.DARK_BLUE);
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
}