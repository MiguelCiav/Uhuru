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
    private LargeTextPanels statement = new LargeTextPanels("Ingrese la opcion", ViewsStyles.ULTRA_LIGHT_BLUE);
    private LargeTextPanels justification = new LargeTextPanels("Ingrese la justificacion", ViewsStyles.ULTRA_LIGHT_BLUE);

    public AnswerStatement(){
        setLayout(new GridBagLayout());
        setBackground(Color.white);

        addOptionStatement();
        addJustification();
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

    public void addJustification(){

        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.4;
        constraints.fill = GridBagConstraints.BOTH;

        add(justification, constraints);
    }

    public LargeTextPanels getStatement(){
        return statement;
    }

    public LargeTextPanels getJustification(){
        return justification;
    }
}