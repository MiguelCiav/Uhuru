package main.views.components.solutionsViewComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JTextArea;

import main.controllers.AnswerTestController;
import main.views.components.genericComponents.LabelPanel;

public class LabelPanelQuestionDescription extends LabelPanel{

    String questionID;
    JTextArea questionDescriptionArea;

    public LabelPanelQuestionDescription(String questionID){
        setLayout(new GridBagLayout());
        this.questionID = questionID;

        setLabel();
        addLabel();

    }

    @Override
    protected void setLabel() {

        questionDescriptionArea = new JTextArea();

        String currentCourseID = AnswerTestController.getCurrentCourseID();
        String currentTestID = AnswerTestController.getCurrentTestID();
        String description = AnswerTestController.getInstance().getQuestionDescription(currentCourseID, currentTestID, questionID);

        questionDescriptionArea.setBackground(new Color(216,233,241));
        questionDescriptionArea.setFont(new Font("Futura", Font.PLAIN, 12));
        questionDescriptionArea.setEditable(false);
        questionDescriptionArea.setFocusable(false);
        questionDescriptionArea.setLineWrap(true);
        questionDescriptionArea.setText(description);
        
    }

    @Override
    protected void addLabel() {

        constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.insets = new Insets(16, 16, 16, 16);

        add(questionDescriptionArea,constraints);
        
    }
    
}
