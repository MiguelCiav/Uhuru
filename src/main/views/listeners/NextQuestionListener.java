package main.views.listeners;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.createTestViewComponents.QuestionDataPanel;

public class NextQuestionListener extends MouseAdapter{

    private static NextQuestionListener instance;

    private NextQuestionListener(){
    }

    public static NextQuestionListener getInstance(){
        if(instance == null){
            instance = new NextQuestionListener();
        }
        return instance;
    }

    private void changeIndex(){
        if(QuestionDataPanel.getQuestionIndex() < QuestionDataPanel.getQuestionList().size() - 1){
            QuestionDataPanel.setQuestionIndex(QuestionDataPanel.getQuestionIndex() + 1);
        }
        else{
            QuestionDataPanel.setQuestionIndex(0);
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

        QuestionDataPanel.getCardLayout().next(QuestionDataPanel.getContainer());
        changeIndex();
        allowCode();
    }
}
