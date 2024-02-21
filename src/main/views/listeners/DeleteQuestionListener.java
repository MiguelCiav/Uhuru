package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import utils.PathManager;

public class DeleteQuestionListener extends MouseAdapter{
 
    private static DeleteQuestionListener instance;

    private DeleteQuestionListener(){

    }

    public static DeleteQuestionListener getInstance(){
        if(instance == null){
            instance = new DeleteQuestionListener();
        }

        return instance;
    }

    private static void changeIndex(){
        if(QuestionDataPanel.getQuestionIndex() > 0){
            QuestionDataPanel.setQuestionIndex(QuestionDataPanel.getQuestionIndex() - 1);
        }
        else{
            QuestionDataPanel.setQuestionIndex(QuestionDataPanel.getQuestionList().size() - 1);
        }
    }

    private void allowCode(){
        if(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getCode().getTextArea().isEditable()){
            QuestionDataPanel.getBox().setSelected(true);
            QuestionDataPanel.getBox().setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/solutionsView/answerCheckBox.png")));
        }
        else{
            QuestionDataPanel.getBox().setSelected(false);
            QuestionDataPanel.getBox().setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
        }
    }

    private void addOptionsToContainer(){
        AnswerDataPanel.getContainer().removeAll();
        for(int i = 0; i < QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().size(); i++){
            AnswerDataPanel.addOptionToContainerFromList(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().get(i));
        }
        AnswerDataPanel.setOptionIndex(0);
        AnswerDataPanel.setStatementText(1);
        AnswerDataPanel.getContainer().repaint();
    }

    @Override public void mouseClicked(MouseEvent e){

        if(QuestionDataPanel.getQuestionList().size() > 1){
            QuestionDataPanel.getCardLayout().previous(QuestionDataPanel.getContainer());
            QuestionDataPanel.deleteQuestionInContainer(QuestionDataPanel.getQuestionIndex());
            changeIndex();
            QuestionDataPanel.setStatementText(QuestionDataPanel.getQuestionIndex() + 1);
            addOptionsToContainer();
            allowCode();
        }
    }
}
