package main.views.listeners;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.createTestViewComponents.QuestionDataPanel;

public class NextQuestionListener extends MouseAdapter{

    private Container cPane;
    private CardLayout card;

    public NextQuestionListener(Container pane, CardLayout card){
        this.cPane = pane;
        this.card = card;
    }
    @Override public void mouseClicked(MouseEvent e){

        AddAndDeleteQuestionListener.getInstance(cPane, card);
        if(AddAndDeleteQuestionListener.getQuestionIndex() < AddAndDeleteQuestionListener.getNumberOfQuestions() - 1){
            AddAndDeleteQuestionListener.setQuestionIndex(AddAndDeleteQuestionListener.getQuestionIndex() + 1);
            QuestionDataPanel.setStatementText(AddAndDeleteQuestionListener.getQuestionIndex()+1);
        }
        else{
            AddAndDeleteQuestionListener.setQuestionIndex(0);
            QuestionDataPanel.setStatementText(AddAndDeleteQuestionListener.getQuestionIndex()+1);
        }
        card.next(cPane);

        if(QuestionDataPanel.getQuestionList().get(AddAndDeleteQuestionListener.getQuestionIndex()).code.getTextArea().isEditable()){
            QuestionDataPanel.getBox().setSelected(true);
        }
        else{
            QuestionDataPanel.getBox().setSelected(false);
        }
    }
}
