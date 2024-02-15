package main.views.components;

import javax.swing.*;

import utils.ViewsStyles;

import java.awt.*;
import java.awt.event.*;
import utils.ViewsStyles;

public class AddQuestionsPanel extends JPanelRound implements ActionListener{

    private LargeTextPanels questionStatement = new LargeTextPanels("Ingrese el enunciado de la pregunta", Color.WHITE);
    private LargeTextPanels questionOption = new LargeTextPanels("Introduzca la opción", Color.WHITE);
    private LargeTextPanels questionJustification = new LargeTextPanels("Ingrese la justificacion de la respuesta", Color.WHITE);
    private JPanelRound addOptionPanel = new JPanelRound();
    private JButton addOptionButton = new JButton(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/Add_Ico.png")));
    private JLabel addOptionLabel = new JLabel("Añadir opcion");
    private JCheckBox correctOption = new JCheckBox(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));

    AddQuestionsPanel(){
        setRoundBackgroundColor(ViewsStyles.PALID_BLUE);

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(20, 20, 10, 20);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        
        add(questionStatement, constraints);

        constraints.insets = new Insets(0, 0, 0, 10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.0;
        correctOption.setBackground(Color.WHITE);
        correctOption.addActionListener(this);

        questionOption.add(correctOption, constraints);

        constraints.insets = new Insets(10, 20, 10, 20);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        add(questionOption, constraints);

        addOptionPanel.setLayout(new GridBagLayout());
        addOptionPanel.setRoundBackgroundColor(ViewsStyles.LIGHT_BLUE);
        constraints.insets = new Insets(0, 20, 0, 20);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 2;
        constraints.weighty = 0.5;
        constraints.weightx = 1.0;
        
        addOptionPanel.add(addOptionLabel, constraints);

        constraints.gridx = 2;
        constraints.gridwidth = 1;
        constraints.weightx = 0.0;
        addOptionButton.setBackground(ViewsStyles.LIGHT_BLUE);
        addOptionButton.setBorder(null);
        
        addOptionPanel.add(addOptionButton, constraints);

        constraints.insets = new Insets(10, 20, 10, 20);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1.0;
        constraints.weighty = 0.4;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = GridBagConstraints.BOTH;

        add(addOptionPanel, constraints);

        constraints.insets = new Insets(10, 20, 20, 20);
        constraints.gridy = 3;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        questionJustification.textArea.setEditable(false);

        add(questionJustification, constraints);
    }

    @Override public void actionPerformed(ActionEvent e){

        JCheckBox box = (JCheckBox) e.getSource();

        if(box.isSelected()){
            correctOption.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/solutionsView/answerCheckBox.png")));
            questionJustification.textArea.setEditable(true);
        }
        else{
            correctOption.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
            questionJustification.textArea.setEditable(false);
        }
    }
}
