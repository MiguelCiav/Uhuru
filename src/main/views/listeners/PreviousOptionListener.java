package main.views.listeners;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.createTestViewComponents.AnswerDataPanel;

public class PreviousOptionListener extends MouseAdapter{

    private Container cPane;
    private CardLayout card;

    public PreviousOptionListener(Container pane, CardLayout card){
        this.cPane = pane;
        this.card = card;
    }
    @Override public void mouseClicked(MouseEvent e){
        AddAndDeleteOptionsListener.getInstance(cPane, card);
        if(AddAndDeleteOptionsListener.getOptionIndex() > 0){
            AddAndDeleteOptionsListener.setOptionIndex(AddAndDeleteOptionsListener.getOptionIndex() - 1);
            AnswerDataPanel.setStatementText(AddAndDeleteOptionsListener.getOptionIndex()+1);
        }
        else{
            AddAndDeleteOptionsListener.setOptionIndex(AddAndDeleteOptionsListener.getNumberOfOptions() - 1);
            AnswerDataPanel.setStatementText(AddAndDeleteOptionsListener.getOptionIndex()+1);
        }

        card.previous(cPane);
    }
}