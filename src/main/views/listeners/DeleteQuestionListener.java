package main.views.listeners;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.QuestionStatement;

public class DeleteQuestionListener extends MouseAdapter{

    Container cPane;
    CardLayout card;

    public DeleteQuestionListener(Container pane, CardLayout card){
        this.card = card;
        this.cPane = pane;
    }
    @Override public void mouseClicked(MouseEvent e){
        cPane.remove(0);
        card.previous(cPane);
    }
}