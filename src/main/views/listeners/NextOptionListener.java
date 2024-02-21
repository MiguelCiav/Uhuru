package main.views.listeners;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;

public class NextOptionListener extends MouseAdapter{

    private static NextOptionListener instance;

    private NextOptionListener(){
    }

    public static NextOptionListener getInstance(){
        if(instance == null){
            instance = new NextOptionListener();
        }
        return instance;
    }

    private void changeIndex(){
        if(AnswerDataPanel.getOptionIndex() < QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().size() - 1){
            AnswerDataPanel.setOptionIndex(AnswerDataPanel.getOptionIndex() + 1);
        }
        else{
            AnswerDataPanel.setOptionIndex(0);
        }
        AnswerDataPanel.setStatementText(AnswerDataPanel.getOptionIndex() +1);
    }

    @Override public void mouseClicked(MouseEvent e){

        AnswerDataPanel.getCardLayout().next(AnswerDataPanel.getContainer());
        changeIndex();
    }
}