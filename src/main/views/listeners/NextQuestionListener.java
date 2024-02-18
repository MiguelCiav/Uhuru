package main.views.listeners;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NextQuestionListener extends MouseAdapter{

    private Container cPane;
    private CardLayout card;

    public NextQuestionListener(Container pane, CardLayout card){
        this.cPane = pane;
        this.card = card;
    }
    @Override public void mouseClicked(MouseEvent e){
        card.next(cPane);
    }
}
