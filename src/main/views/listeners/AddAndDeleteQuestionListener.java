package main.views.listeners;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import main.views.components.createTestViewComponents.QuestionStatement;

public class AddAndDeleteQuestionListener extends MouseAdapter{

    private static AddAndDeleteQuestionListener instance;
    private static Container cPane;
    private static CardLayout card;
    private static int numberOfQuestions;
    private static int questionIndex;

    

    private AddAndDeleteQuestionListener(Container pane, CardLayout card){
        AddAndDeleteQuestionListener.cPane = pane;
        AddAndDeleteQuestionListener.card = card;
        AddAndDeleteQuestionListener.numberOfQuestions = 1;
    }

    public static AddAndDeleteQuestionListener getInstance(Container cPane, CardLayout card){
        if(instance == null){
            instance = new AddAndDeleteQuestionListener(cPane, card);
        }
        return instance;
    }

    public static void setQuestionIndex(int num){
        AddAndDeleteQuestionListener.questionIndex = num;
    }

    public static int getQuestionIndex(){
        return AddAndDeleteQuestionListener.questionIndex;
    }
    
    public static int getNumberOfQuestions(){
        return AddAndDeleteQuestionListener.numberOfQuestions;
    }

    @Override public void mouseClicked(MouseEvent e){
        JLabel button = new JLabel();
        button.setName(((JLabel) e.getSource()).getName());

        if(button.getName().equals("AddQuestion")){
            QuestionStatement question = new QuestionStatement();
            QuestionDataPanel.getQuestionList().add(AddAndDeleteQuestionListener.getQuestionIndex() + 1, question);
            cPane.add(question,AddAndDeleteQuestionListener.getQuestionIndex() + 1);
            QuestionDataPanel.getBox().setSelected(false);
            AddAndDeleteQuestionListener.questionIndex++;
            card.next(cPane);
            numberOfQuestions++;
            QuestionDataPanel.setStatementText(AddAndDeleteQuestionListener.getQuestionIndex()+1);

            

        }
        else if(button.getName().equals("DeleteQuestion")){
            if(numberOfQuestions > 1){
                card.previous(cPane);
                QuestionDataPanel.getQuestionList().remove(AddAndDeleteQuestionListener.questionIndex);
                cPane.remove(AddAndDeleteQuestionListener.questionIndex);
                AddAndDeleteQuestionListener.numberOfQuestions--;
                if(AddAndDeleteQuestionListener.questionIndex > 0){
                    AddAndDeleteQuestionListener.questionIndex -= 1;
                    QuestionDataPanel.setStatementText(AddAndDeleteQuestionListener.getQuestionIndex()+1);
                }
                else{
                    AddAndDeleteQuestionListener.questionIndex = AddAndDeleteQuestionListener.numberOfQuestions - 1;
                    QuestionDataPanel.setStatementText(AddAndDeleteQuestionListener.getQuestionIndex()+1);
                }

                if(QuestionDataPanel.getQuestionList().get(AddAndDeleteQuestionListener.getQuestionIndex()).code.getTextArea().isEditable()){
                    QuestionDataPanel.getBox().setSelected(true);
                }
                else{
                    QuestionDataPanel.getBox().setSelected(false);
                }
            }
        }
    }
}