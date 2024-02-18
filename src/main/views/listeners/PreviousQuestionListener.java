package main.views.listeners;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        }
        else{
            AddAndDeleteQuestionListener.setQuestionIndex(AddAndDeleteQuestionListener.getNumberOfQuestions() - 1);
        }
        
        card.previous(cPane);
    }
}