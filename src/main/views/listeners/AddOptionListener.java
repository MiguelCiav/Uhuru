package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import main.models.Answer;
import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import utils.PathManager;

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

        changeIndex();
        AnswerDataPanel.addOptionToContainer(AnswerDataPanel.getOptionIndex());
        AnswerDataPanel.getCardLayout().next(AnswerDataPanel.getContainer());
        allowJustification();
        QuestionDataPanel.getInstance().repaint();
        AnswerDataPanel.getInstance().repaint();
    }
}