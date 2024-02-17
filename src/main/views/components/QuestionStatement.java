package main.views.components;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import utils.ViewsStyles;

public class QuestionStatement extends JPanel{
    GridBagConstraints constraints = new GridBagConstraints();
    LargeTextPanels statement = new LargeTextPanels("Ingrese el enunciado de la pregunta", ViewsStyles.ULTRA_LIGHT_BLUE);
    LargeTextPanels code = new LargeTextPanels("Ingrese el codigo", ViewsStyles.LIGHT_BLACK);

    public QuestionStatement(){
        setLayout(new GridBagLayout());
        setBackground(Color.white);

        addQuestionStatement();
        addCode();
    }

    public void addQuestionStatement(){
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
        code.textArea.setForeground(Color.WHITE);
        code.textArea.setEditable(false);

        add(code, constraints);
    }
}
