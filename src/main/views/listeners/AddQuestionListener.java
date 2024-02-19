package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main.views.components.createTestViewComponents.QuestionDataPanel;

public class AddQuestionListener extends MouseAdapter{
 
    private static AddQuestionListener instance;

    private AddQuestionListener(){

    }

    public static AddQuestionListener getInstance(){
        if(instance == null){
            instance = new AddQuestionListener();
        }

        return instance;
    }

    private void changeIndex(){
        QuestionDataPanel.setQuestionIndex(QuestionDataPanel.getQuestionIndex() + 1);
        QuestionDataPanel.setStatementText(QuestionDataPanel.getQuestionIndex() + 1);
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

        changeIndex();
        QuestionDataPanel.addQuestionToContainer(QuestionDataPanel.getQuestionIndex());
        QuestionDataPanel.getCardLayout().next(QuestionDataPanel.getContainer());
        allowCode();
    }
}