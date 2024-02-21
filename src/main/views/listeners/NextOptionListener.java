package main.views.listeners;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import utils.PathManager;

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

    private void allowJustification(){
        if(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().get(AnswerDataPanel.getOptionIndex()).getJustification().getTextArea().isEditable()){
            AnswerDataPanel.getBox().setSelected(true);
            AnswerDataPanel.getBox().setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/solutionsView/answerCheckBox.png")));
        }
        else{
            AnswerDataPanel.getBox().setSelected(false);
            AnswerDataPanel.getBox().setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
        }
    }

    @Override public void mouseClicked(MouseEvent e){

        AnswerDataPanel.getCardLayout().next(AnswerDataPanel.getContainer());
        changeIndex();
        allowJustification();
    }
}