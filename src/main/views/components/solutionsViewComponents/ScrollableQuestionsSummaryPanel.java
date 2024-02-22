package main.views.components.solutionsViewComponents;

import java.awt.Dimension;
import javax.swing.Box;

import main.controllers.AnswerTestController;
import main.views.components.genericComponents.ScrollablePanel;
import main.views.components.testListViewComponents.ScrollableTestPanel;
import utils.ViewsStyles;


public class ScrollableQuestionsSummaryPanel extends ScrollablePanel{

    private static ScrollableQuestionsSummaryPanel instance;
    private String[] questionIDsArray;
    private LabelPanelQuestionSummary[] labelPanelArray;

    private ScrollableQuestionsSummaryPanel(){
        super();

        String currentCourseID = AnswerTestController.getCurrentCourseID();
        String currentTestID = AnswerTestController.getCurrentTestID();

        questionIDsArray = AnswerTestController.getInstance().getQuestionIDsArray(currentCourseID, currentTestID);
        addScrollableElements();        

    }

    public static ScrollableQuestionsSummaryPanel getInstance(){

        if(instance == null){
            instance = new ScrollableQuestionsSummaryPanel();
        }

        return instance;
    }

    public void selectQuestion(String questionID){

        for(int i = 0; i < questionIDsArray.length; i++) {

            if(questionIDsArray[i].equals(questionID)){
                labelPanelArray[i].setRoundBackgroundColor(ViewsStyles.LIGHT_BLUE);
                ScrollableAnswersPanel.getInstance().updateInfo(questionID);
            } else {
                labelPanelArray[i].setRoundBackgroundColor(ViewsStyles.ULTRA_LIGHT_BLUE);
            }

        }

        repaint();

    }

    @Override
    protected void addScrollableElements() {

        labelPanelArray = new LabelPanelQuestionSummary[questionIDsArray.length];

        for(int i = 0; i < questionIDsArray.length; i++){

            labelPanelArray[i] = new LabelPanelQuestionSummary(questionIDsArray[i],i);

            add(labelPanelArray[i]);
            add(Box.createRigidArea(new Dimension(0,20)));
        }
    }
    
}
