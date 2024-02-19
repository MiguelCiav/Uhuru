package main.views.listeners;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.createTestViewComponents.AnswerDataPanel;
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

    private void addOptionsToContainer(){
        AnswerDataPanel.getContainer().removeAll();
        for(int i = 0; i < QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().size(); i++){
            AnswerDataPanel.getContainer().add(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().get(i));
        }

        AnswerDataPanel.setOptionIndex(0);
        AnswerDataPanel.setStatementText(AnswerDataPanel.getOptionIndex() + 1);
    }

    @Override public void mouseClicked(MouseEvent e){

        QuestionDataPanel.getCardLayout().previous(QuestionDataPanel.getContainer());
        changeIndex();
        addOptionsToContainer();
        allowCode();
    }
}