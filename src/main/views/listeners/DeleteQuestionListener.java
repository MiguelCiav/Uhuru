package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main.views.components.createTestViewComponents.QuestionDataPanel;

public class DeleteQuestionListener extends MouseAdapter{
 
    private static DeleteQuestionListener instance;

    private DeleteQuestionListener(){

    }

    public static DeleteQuestionListener getInstance(){
        if(instance == null){
            instance = new DeleteQuestionListener();
        }

        return instance;
    }

    private static void changeIndex(){
        if(QuestionDataPanel.getQuestionIndex() > 0){
            QuestionDataPanel.setQuestionIndex(QuestionDataPanel.getQuestionIndex() - 1);
        }
        else{
            QuestionDataPanel.setQuestionIndex(QuestionDataPanel.getQuestionList().size() - 1);
        }
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

        if(QuestionDataPanel.getQuestionList().size() > 1){
            QuestionDataPanel.getCardLayout().previous(QuestionDataPanel.getContainer());
            QuestionDataPanel.deleteQuestionInContainer(QuestionDataPanel.getQuestionIndex());
            changeIndex();
            QuestionDataPanel.setStatementText(QuestionDataPanel.getQuestionIndex() + 1);
        }

        allowCode();
    }
}
