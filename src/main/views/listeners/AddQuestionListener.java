package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.createTestViewComponents.AnswerDataPanel;
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

    private void addOptionToQuestion(){
        for(int i = 0; i < AnswerDataPanel.getAnswerList().size(); i++){
            QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().add(AnswerDataPanel.getAnswerList().get(i));
        }
        removeElementsFromAnswerList();
    }

    private void removeElementsFromAnswerList(){
        AnswerDataPanel.getContainer().removeAll();
        for(int i = 0; i < AnswerDataPanel.getAnswerList().size(); i++){
            AnswerDataPanel.getAnswerList().removeAll(AnswerDataPanel.getAnswerList());
        }
        AnswerDataPanel.addOptionToContainer(0);
        AnswerDataPanel.setOptionIndex(0);
        AnswerDataPanel.setStatementText(AnswerDataPanel.getOptionIndex() + 1);
    }

    @Override public void mouseClicked(MouseEvent e){

        addOptionToQuestion();
        changeIndex();
        QuestionDataPanel.addQuestionToContainer(QuestionDataPanel.getQuestionIndex());
        QuestionDataPanel.getCardLayout().next(QuestionDataPanel.getContainer());
        allowCode();
    }
}