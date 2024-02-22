package main.views.components.testViewComponents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

import main.controllers.AnswerTestController;

public class AnswerQuestion extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e){

        JRadioButton sourceButton = (JRadioButton) e.getSource();
        OptionBox sourcePanel = (OptionBox) sourceButton.getParent();
        QuestionPanel sourceQuestion = (QuestionPanel) sourcePanel.getParent();
        String questionID = sourcePanel.getQuestionID();
        String answerID = sourcePanel.getAnswerID();

        sourceQuestion.selectAnswer(sourcePanel.getAnswerID());

        TestInfoPanel.getTestInfoPanel().updateAnsweredQuestions(questionID);
    }

}
