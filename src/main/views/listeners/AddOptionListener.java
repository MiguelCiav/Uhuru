package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;

public class AddOptionListener extends MouseAdapter{
 
    private static AddOptionListener instance;

    private AddOptionListener(){

    }

    public static AddOptionListener getInstance(){
        if(instance == null){
            instance = new AddOptionListener();
        }

        return instance;
    }

    private void changeIndex(){
        AnswerDataPanel.setOptionIndex(AnswerDataPanel.getOptionIndex() + 1);
        AnswerDataPanel.setStatementText(AnswerDataPanel.getOptionIndex() + 1);
    }

    @Override public void mouseClicked(MouseEvent e){

        changeIndex();
        AnswerDataPanel.addOptionToContainer(AnswerDataPanel.getOptionIndex());
        AnswerDataPanel.getCardLayout().next(AnswerDataPanel.getContainer());
    }
}