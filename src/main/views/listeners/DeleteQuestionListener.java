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
            QuestionDataPanel.getBox().setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/solutionsView/correctAnswer.png")));
        }
        else{
            QuestionDataPanel.getBox().setSelected(false);
            QuestionDataPanel.getBox().setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
        }
    }

    private void allowJustification(){
        if(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getOptionList().get(AnswerDataPanel.getOptionIndex()).getJustification().getTextArea().isEditable()){
            AnswerDataPanel.getBox().setSelected(true);
            AnswerDataPanel.getBox().setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/solutionsView/correctAnswer.png")));
        }
        else{
            AnswerDataPanel.getBox().setSelected(false);
            AnswerDataPanel.getBox().setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
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
    private void addDomain(){
        QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).setDomain(QuestionDataPanel.getDomain());
    }

    private void setDomain(){
        QuestionDataPanel.setDomain(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getDomain());
    }

    @Override public void mouseClicked(MouseEvent e){

        if(QuestionDataPanel.getQuestionList().size() > 1){
            addDomain();
            QuestionDataPanel.getCardLayout().previous(QuestionDataPanel.getContainer());
            QuestionDataPanel.deleteQuestionInContainer(QuestionDataPanel.getQuestionIndex());
            changeIndex();
            QuestionDataPanel.setStatementText(QuestionDataPanel.getQuestionIndex() + 1);
            addOptionsToContainer();
            setDomain();
            allowCode();
            NextQuestionListener.getInstance().allowJustification();
            QuestionDataPanel.getInstance().repaint();
            AnswerDataPanel.getInstance().repaint();
        }
    }
}
