package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import main.models.Answer;
import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import utils.PathManager;

public class AddQuestionListener extends MouseAdapter{
 
    private static AddQuestionListener instance;

    private AddQuestionListener(){

    }

    public static AddQuestionListener getInstance(){
        if(instance == null){
            instance = new AddQuestionListener();
        }

        return instance;
    }

    private void changeIndex(){
        QuestionDataPanel.setQuestionIndex(QuestionDataPanel.getQuestionIndex() + 1);
        QuestionDataPanel.setStatementText(QuestionDataPanel.getQuestionIndex() + 1);
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

    private void removeElementsFromAnswerList(){
        AnswerDataPanel.getContainer().removeAll();
        AnswerDataPanel.addOptionToContainer(0);
        AnswerDataPanel.setOptionIndex(0);
        AnswerDataPanel.setStatementText(AnswerDataPanel.getOptionIndex() + 1);
        AnswerDataPanel.getContainer().repaint();
    }

    private void addDomain(){
        QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).setDomain(QuestionDataPanel.getDomain());
        QuestionDataPanel.setDomain("Dominio");
    }

    @Override public void mouseClicked(MouseEvent e){

        addDomain();
        changeIndex();
        QuestionDataPanel.addQuestionToContainer(QuestionDataPanel.getQuestionIndex());
        QuestionDataPanel.getCardLayout().next(QuestionDataPanel.getContainer());
        allowCode();
        AnswerDataPanel.getBox().setSelected(false);
        AnswerDataPanel.getBox().setIcon(new ImageIcon(PathManager.getInstance().getStringURL("/src/img/createTestView/incorrectAnswer.png")));
        removeElementsFromAnswerList();
        QuestionDataPanel.getInstance().repaint();
        AnswerDataPanel.getInstance().repaint();
    }
}