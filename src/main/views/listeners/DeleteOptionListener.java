package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import utils.PathManager;

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
            AnswerDataPanel.setOptionIndex(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().size() - 1);
        }
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

        if(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().size() > 1){
            AnswerDataPanel.getCardLayout().previous(AnswerDataPanel.getContainer());
            AnswerDataPanel.deleteOptionInContainer(AnswerDataPanel.getOptionIndex());
            changeIndex();
            AnswerDataPanel.setStatementText(AnswerDataPanel.getOptionIndex() + 1);
            allowJustification();
        }
    }
}