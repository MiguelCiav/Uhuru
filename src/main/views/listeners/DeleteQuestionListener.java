package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.createTestViewComponents.AnswerDataPanel;
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

    private void addOptionsToContainer(){
        AnswerDataPanel.getContainer().removeAll();
        for(int i = 0; i < QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().size(); i++){
            AnswerDataPanel.getContainer().add(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().get(i));
        }

        AnswerDataPanel.setOptionIndex(0);
        AnswerDataPanel.setStatementText(AnswerDataPanel.getOptionIndex() + 1);
    }

    @Override public void mouseClicked(MouseEvent e){

        if(QuestionDataPanel.getQuestionList().size() > 1){
            QuestionDataPanel.getCardLayout().previous(QuestionDataPanel.getContainer());
            QuestionDataPanel.deleteQuestionInContainer(QuestionDataPanel.getQuestionIndex());
            changeIndex();
            QuestionDataPanel.setStatementText(QuestionDataPanel.getQuestionIndex() + 1);
            addOptionsToContainer();
        }

        allowCode();
    }
}
