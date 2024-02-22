package main.views.components.solutionsViewComponents;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;

import main.controllers.AnswerTestController;
import main.views.components.genericComponents.ScrollablePanel;

public class ScrollableAnswersPanel extends ScrollablePanel {

    private static ScrollableAnswersPanel instance;
    private String[] answerIDs;
    private boolean[] correctArray;
    private boolean[] selectedArray;
    private String questionID;

    private ScrollableAnswersPanel(){
        super();
        setBackground(Color.WHITE);
    }

    public static ScrollableAnswersPanel getInstance(){

        if(instance == null){
            instance = new ScrollableAnswersPanel();
        }

        return instance;
    }

    public void updateInfo(String questionID){
        String currentTestID = AnswerTestController.getCurrentTestID();
        String currentCourseID = AnswerTestController.getCurrentCourseID();
        this.questionID = questionID;

        answerIDs = AnswerTestController.getInstance().getAnswersIDs(currentCourseID, currentTestID, questionID);

        addScrollableElements();
    }

    @Override
    protected void addScrollableElements() {

        correctArray = AnswerTestController.getInstance().getCorrectArray(questionID);
        selectedArray = AnswerTestController.getInstance().getSelectedArray(questionID);

        removeAll();
        
        LabelPanelQuestionDescription firstPanel = new LabelPanelQuestionDescription(questionID);
        add(firstPanel);
        add(Box.createRigidArea(new Dimension(0,20)));


        for(int i = 0; i < answerIDs.length; i++){
            add(new LabelPanelAnswer(questionID, answerIDs[i], correctArray[i]));
            add(Box.createRigidArea(new Dimension(0,20)));
        }

        revalidate();
        repaint();

    }
    
}
