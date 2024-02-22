package main.views.listeners;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import utils.PathManager;

public class NextQuestionListener extends MouseAdapter{

    private static NextQuestionListener instance;

    private NextQuestionListener(){
    }

    public static NextQuestionListener getInstance(){
        if(instance == null){
            instance = new NextQuestionListener();
        }
        return instance;
    }

    private void changeIndex(){
        if(QuestionDataPanel.getQuestionIndex() < QuestionDataPanel.getQuestionList().size() - 1){
            QuestionDataPanel.setQuestionIndex(QuestionDataPanel.getQuestionIndex() + 1);
        }
        else{
            QuestionDataPanel.setQuestionIndex(0);
        }
        QuestionDataPanel.setStatementText(QuestionDataPanel.getQuestionIndex()+1);
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

    private void addDomain(){
        QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).setDomain(QuestionDataPanel.getDomain());
    }

    private void setDomain(){
        QuestionDataPanel.setDomain(QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionIndex()).getDomain());
    }


    @Override public void mouseClicked(MouseEvent e){

        addDomain();
        QuestionDataPanel.getCardLayout().next(QuestionDataPanel.getContainer());
        changeIndex();
        setDomain();
        allowCode();
        addOptionsToContainer();
    }
}
