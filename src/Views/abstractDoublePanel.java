package Views;

import javax.swing.*;
import java.awt.*;

public abstract class abstractDoublePanel extends JFrame{
    
    protected GridBagConstraints constraints;
    protected PrincipalPanel principalPanel = new PrincipalPanel();
    protected JPanel containerPanel = new JPanel();

    abstractDoublePanel(){

        setTitle("Uhuru");
        setSize(new Dimension(1080,720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

    }

    protected abstract void addPanels();

    protected void setContainerPanel(){

        constraints = new GridBagConstraints();
        containerPanel.setBackground(new Color(61,90,128));
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