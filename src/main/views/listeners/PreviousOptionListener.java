package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main.views.components.createTestViewComponents.AnswerDataPanel;

public class PreviousOptionListener extends MouseAdapter{

    private static PreviousOptionListener instance;

    private PreviousOptionListener(){
    }

    public static PreviousOptionListener getInstance(){
        if(instance == null){
            instance = new PreviousOptionListener();
        }

        return instance;
    }

    private void changeIndex(){
        if(AnswerDataPanel.getOptionIndex() > 0){
            AnswerDataPanel.setOptionIndex(AnswerDataPanel.getOptionIndex() - 1);
        }
        else{
            AnswerDataPanel.setOptionIndex(AnswerDataPanel.getAnswerList().size() - 1);
        }
        AnswerDataPanel.setStatementText(AnswerDataPanel.getOptionIndex()+1);
    }

    @Override public void mouseClicked(MouseEvent e){

        AnswerDataPanel.getCardLayout().previous(AnswerDataPanel.getContainer());
        changeIndex();
    }
}