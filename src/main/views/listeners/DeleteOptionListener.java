package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main.views.components.createTestViewComponents.AnswerDataPanel;

public class DeleteOptionListener extends MouseAdapter{
 
    private static DeleteOptionListener instance;

    private DeleteOptionListener(){

    }

    public static DeleteOptionListener getInstance(){
        if(instance == null){
            instance = new DeleteOptionListener();
        }

        return instance;
    }

    private static void changeIndex(){
        if(AnswerDataPanel.getOptionIndex() > 0){
            AnswerDataPanel.setOptionIndex(AnswerDataPanel.getOptionIndex() - 1);
        }
        else{
            AnswerDataPanel.setOptionIndex(AnswerDataPanel.getAnswerList().size() - 1);
        }
    }

    @Override public void mouseClicked(MouseEvent e){

        if(AnswerDataPanel.getAnswerList().size() > 1){
            AnswerDataPanel.getCardLayout().previous(AnswerDataPanel.getContainer());
            AnswerDataPanel.deleteOptionInContainer(AnswerDataPanel.getOptionIndex());
            changeIndex();
            AnswerDataPanel.setStatementText(AnswerDataPanel.getOptionIndex() + 1);
        }
    }
}