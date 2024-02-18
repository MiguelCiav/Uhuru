package main.views.components.genericComponents;
import javax.swing.*;

import utils.ViewsStyles;

import java.awt.*;

public class PrincipalPanel extends JPanel{

    public PrincipalPanel(){

        setBackground(ViewsStyles.DARK_BLUE);
        setLayout(new GridBagLayout());
        initializePanel();

    }

    protected void initializePanel(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;

        add(NavBar.getNavBar(), constraints);

    }

    public void setContentPanel(JPanel contentPanel){

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(20, 20, 20, 20);
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(contentPanel, constraints);
        
    }

    public void setContentPanelWithoutExpansion(JPanel contentPanel){
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.VERTICAL;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(20, 20, 20, 20);
        constraints.anchor = GridBagConstraints.CENTER;

        this.add(contentPanel, constraints);
    }

}
