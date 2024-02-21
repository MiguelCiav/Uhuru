package main.views.components.testViewComponents;
import javax.swing.*;

import main.controllers.AnswerTestController;

import java.awt.*;

public class ScrollableQuestionsPanel extends JPanel {

    private GridBagConstraints constraints;
    private String[] questionIDs;

    public ScrollableQuestionsPanel(){

        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        setBorder(null);
        constraints = new GridBagConstraints();
        setQuestionIDs();
        addQuestions();

    }

    private void setQuestionIDs(){

        String actualCourseID = AnswerTestController.getActualCourseID();
        String actualTestID = AnswerTestController.getActualTestID();

        questionIDs = AnswerTestController.getInstance().getQuestionIDs(actualCourseID, actualTestID);

    }

    private void addQuestions(){

        String actualCourseID = AnswerTestController.getActualCourseID();
        String actualTestID = AnswerTestController.getActualTestID();
 
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets= new Insets(0,20,25,20);

        for (int i = 0; i < questionIDs.length; i++) {
            constraints.gridy = i;

            QuestionPanel auxiliarQuestionPanel = new QuestionPanel(String.valueOf(i+1),actualCourseID,actualTestID,questionIDs[i]);

            if(i == 5){
                constraints.weighty = 1.0;
            }
            
            this.add(auxiliarQuestionPanel, constraints);
        }
        
    }

}
