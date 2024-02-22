package main.views.components.solutionsViewComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import main.controllers.AnswerTestController;
import main.views.components.genericComponents.JBlueScrollPane;
import main.views.components.genericComponents.LabelPanel;
import utils.PathManager;
import utils.ViewsStyles;

public class LabelPanelAnswer extends LabelPanel{

    private String answerID;
    private String questionID;
    private String justification;
    private String description;
    private boolean isCorrect;
    private JTextArea questionDescriptionText;
    private JLabel answerIcon;
    private JTextArea justificationLabel;

    public LabelPanelAnswer(String questionID, String answerID, boolean isCorrect){

        setLayout(new GridBagLayout());
        this.questionID = questionID;
        this.answerID = answerID;
        this.isCorrect = isCorrect;

        setLabel();
        addLabel();

    }

    @Override
    protected void setLabel() {

        setDescription();
        setIcon();
        setJustification();
        
    }

    private void setDescription(){

        String currentCourseID = AnswerTestController.getCurrentCourseID();
        String currentTestID = AnswerTestController.getCurrentTestID();

        description = AnswerTestController.getInstance().getAnswerDescription(currentCourseID, currentTestID, questionID, answerID);

        questionDescriptionText = new JTextArea();
        questionDescriptionText.setBackground(Color.WHITE);
        questionDescriptionText.setFont(new Font("Futura", Font.PLAIN, 12));
        questionDescriptionText.setEditable(false);
        questionDescriptionText.setFocusable(false);
        questionDescriptionText.setLineWrap(true);
        questionDescriptionText.setText(description);

    }

    private void setIcon(){

        ImageIcon icono;
        answerIcon = new JLabel();

        if(isCorrect){
            icono = new ImageIcon(PathManager.getInstance().getStringURL("/src/img/solutionsView/correctAnswer.png"));
        } else {
            icono = new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png"));
        }

        answerIcon.setIcon(icono);

    }

    private void setJustification(){

        justificationLabel = new JTextArea();
        justification = "Justificación";
        justificationLabel.setBackground(ViewsStyles.ULTRA_LIGHT_BLUE);
        justificationLabel.setFont(new Font("Futura", Font.PLAIN, 12));
        justificationLabel.setEditable(false);
        justificationLabel.setFocusable(false);
        justificationLabel.setLineWrap(true);
        justificationLabel.setText(justification);

    }

    @Override
    protected void addLabel() {

        constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(16, 16, 16, 16);

        add(new JBlueScrollPane(questionDescriptionText), constraints);

        constraints.gridx = 1;
        constraints.weightx = 0;
        constraints.fill = GridBagConstraints.NONE;

        add(answerIcon, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.anchor = GridBagConstraints.NORTHWEST;
        constraints.fill = GridBagConstraints.BOTH;

        add(new JBlueScrollPane(justificationLabel), constraints);

    }
    
}
