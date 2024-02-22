package main.views.components;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import main.views.components.genericComponents.BlueButton;
import main.views.components.genericComponents.JPanelRound;
import main.views.components.genericComponents.LargeTextPanels;
import utils.PathManager;
import utils.ViewsStyles;


public class AnswerDataPanel extends JPanelRound implements ActionListener{

    GridBagConstraints constraints = new GridBagConstraints();
    private LargeTextPanels questionOption = new LargeTextPanels("Introduzca la opción", ViewsStyles.ULTRA_LIGHT_BLUE);
    private JCheckBox correctOption = new JCheckBox(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
    private LargeTextPanels justification;
    
    public AnswerDataPanel(){
        setLayout(new GridBagLayout());
        setRoundBackgroundColor(Color.WHITE);

        addStatementText();
        addOptions();
        addJustification();
        addArrowButtons();
        addDeleteOptionButton();
        addNewOptionButton();
        addCreateTestButton();
    }

    public void addStatementText(){
        JLabel statement = new JLabel("Respuestas");
        statement.setFont(ViewsStyles.TITLE_FONT);
        statement.setForeground(ViewsStyles.DARK_BLUE);

        constraints.insets = new Insets(20, 20, 20, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 5;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        add(statement, constraints);
    }

    public void addOptions(){
        Container cPane = new Container();
        cPane.setLayout(new CardLayout());

        constraints.insets = new Insets(0, 0, 0, 10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.0;
        correctOption.setBackground(ViewsStyles.ULTRA_LIGHT_BLUE);
        correctOption.addActionListener(this);

        questionOption.add(correctOption, constraints);

        cPane.add(questionOption);

        constraints.insets = new Insets(20, 20, 20, 20);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 5;
        constraints.weightx = 0.0;
        constraints.weighty = 0.6;
        constraints.fill = GridBagConstraints.BOTH;

        add(cPane, constraints);
    }

    public void addJustification(){
        justification = new LargeTextPanels("Ingrese la justificacion", ViewsStyles.ULTRA_LIGHT_BLUE);

        constraints.insets = new Insets(20, 20, 10, 20);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridheight = 1;
        constraints.gridwidth = 5;
        constraints.weighty = 0.4;
        constraints.fill = GridBagConstraints.BOTH;

        add(justification, constraints);

    }

    public void addArrowButtons(){
        JLabel leftArrow = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/LeftArrow.png")));
        JLabel rightArrow = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/RightArrow.png")));

        constraints.insets = new Insets(20, 20, 20, 0);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 0.0;
        constraints.weighty = 0.0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;

        add(leftArrow, constraints);

        constraints.gridx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(20, 10, 20, 0);

        add(rightArrow, constraints);
    }

    public void addDeleteOptionButton(){
        JLabel deleteOptionButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/DeleteQuestion.png")));
        
        constraints.gridx = 2;
        constraints.insets = new Insets(20, 20, 20,0);
        constraints.anchor = GridBagConstraints.EAST;
        constraints.weightx = 0.3;

        add(deleteOptionButton, constraints);
    }

    public void addNewOptionButton(){
        JLabel newOptionButton = new JLabel(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/NewQuestion.png")));
        
        constraints.gridx = 3;
        constraints.insets = new Insets(20, 10, 20, 20);
        constraints.anchor = GridBagConstraints.WEST;

        add(newOptionButton, constraints);
    }

    public void addCreateTestButton(){
        BlueButton createTestButton = new BlueButton("Crear examen", 250, 1);

        constraints.gridx = 4;
        constraints.insets = new Insets(20, 20, 20,20);
        constraints.anchor = GridBagConstraints.EAST;
        constraints.weightx = 0.0;

        add(createTestButton, constraints);
    }

    
    @Override public void actionPerformed(ActionEvent e){

        JCheckBox box = (JCheckBox) e.getSource();

        if(box.isSelected()){
            correctOption.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/solutionsView/correctAnswer.png")));
        }
        else{
            correctOption.setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
        }
    }
}
