package main.views.listeners;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.QuestionStatement;

public class AddQuestionListener extends MouseAdapter{

    Container cPane;
    int numberOfQuestions;
    CardLayout card;

    public AddQuestionListener(Container pane, CardLayout card){
        this.cPane = pane;
        this.card = card;
    }
    @Override public void mouseClicked(MouseEvent e){
        cPane.add(new QuestionStatement());
        card.next(cPane);
        numberOfQuestions++;
    }
}