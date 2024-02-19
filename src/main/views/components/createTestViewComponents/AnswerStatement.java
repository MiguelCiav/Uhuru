package main.views.components.createTestViewComponents;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

import main.views.components.genericComponents.LargeTextPanels;
import utils.ViewsStyles;

public class AnswerStatement extends JPanel{
    GridBagConstraints constraints = new GridBagConstraints();
    LargeTextPanels statement = new LargeTextPanels("Ingrese la opcion", ViewsStyles.ULTRA_LIGHT_BLUE);
    public LargeTextPanels justification = new LargeTextPanels("Ingrese la justificacion", ViewsStyles.ULTRA_LIGHT_BLUE);

    public AnswerStatement(){
        setLayout(new GridBagLayout());
        setBackground(Color.white);

        addOptionStatement();
        addCode();
    }

    public void addOptionStatement(){
        constraints.insets = new Insets(20, 0, 20, 0);
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 0.6;
        constraints.fill = GridBagConstraints.BOTH;

        add(statement, constraints);
    }

    public void addCode(){

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.4;
        constraints.fill = GridBagConstraints.BOTH;

        add(justification, constraints);
    }
}