package main.views.listeners;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.createTestViewComponents.QuestionDataPanel;

public class PreviousQuestionListener extends MouseAdapter{

    private Container cPane;
    private CardLayout card;

    public PreviousQuestionListener(Container pane, CardLayout card){
        this.cPane = pane;
        this.card = card;
    }
    @Override public void mouseClicked(MouseEvent e){
        AddAndDeleteQuestionListener.getInstance(cPane, card);
        if(AddAndDeleteQuestionListener.getQuestionIndex() > 0){
            AddAndDeleteQuestionListener.setQuestionIndex(AddAndDeleteQuestionListener.getQuestionIndex() - 1);
            QuestionDataPanel.setStatementText(AddAndDeleteQuestionListener.getQuestionIndex()+1);
        }
        else{
            AddAndDeleteQuestionListener.setQuestionIndex(AddAndDeleteQuestionListener.getNumberOfQuestions() - 1);
            QuestionDataPanel.setStatementText(AddAndDeleteQuestionListener.getQuestionIndex()+1);
        }

        if(QuestionDataPanel.getQuestionList().get(AddAndDeleteQuestionListener.getQuestionIndex()).code.getTextArea().isEditable()){
            QuestionDataPanel.getBox().setSelected(true);
        }
        else{
            QuestionDataPanel.getBox().setSelected(false);
        }

        card.previous(cPane);
    }
}