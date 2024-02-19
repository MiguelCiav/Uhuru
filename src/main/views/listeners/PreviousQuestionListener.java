package main.views.listeners;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.createTestViewComponents.QuestionDataPanel;

public class PreviousQuestionListener extends MouseAdapter{

    private static PreviousQuestionListener instance;

    private PreviousQuestionListener(){
    }

    public static PreviousQuestionListener getInstance(){
        if(instance == null){
            instance = new PreviousQuestionListener();
        }

        return instance;
    }

    private void changeIndex(){
        if(QuestionDataPanel.getQuestionIndex() > 0){
            QuestionDataPanel.setQuestionIndex(QuestionDataPanel.getQuestionIndex() - 1);
        }
        else{
            QuestionDataPanel.setQuestionIndex(QuestionDataPanel.getQuestionList().size() - 1);
        }
        QuestionDataPanel.setStatementText(QuestionDataPanel.getQuestionIndex()+1);
    }
    
    private void allowCode(){
        if(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).code.getTextArea().isEditable()){
            QuestionDataPanel.getBox().setSelected(true);
        }
        else{
            QuestionDataPanel.getBox().setSelected(false);
        }
    }

    @Override public void mouseClicked(MouseEvent e){

        QuestionDataPanel.getCardLayout().previous(QuestionDataPanel.getContainer());
        changeIndex();
        allowCode();
    }
}