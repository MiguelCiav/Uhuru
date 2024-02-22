package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import utils.PathManager;

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
            AnswerDataPanel.setOptionIndex(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().size() - 1);
        }
        AnswerDataPanel.setStatementText(AnswerDataPanel.getOptionIndex()+1);
    }

    public void allowJustification(){
        if(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().get(AnswerDataPanel.getOptionIndex()).getJustification().getTextArea().isEditable()){
            AnswerDataPanel.getBox().setSelected(true);
            AnswerDataPanel.getBox().setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/solutionsView/correctAnswer.png")));
        }
        else{
            AnswerDataPanel.getBox().setSelected(false);
            AnswerDataPanel.getBox().setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
        }
    }

    @Override public void mouseClicked(MouseEvent e){

        AnswerDataPanel.getCardLayout().previous(AnswerDataPanel.getContainer());
        changeIndex();
        allowJustification();
        QuestionDataPanel.getInstance().repaint();
        AnswerDataPanel.getInstance().repaint();
    }
}