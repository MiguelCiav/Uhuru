package main.views.listeners;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import main.views.components.QuestionStatement;
import utils.PathManager;

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
            cPane.add(new QuestionStatement());
            AddAndDeleteQuestionListener.questionIndex++;
            card.next(cPane);
            numberOfQuestions++;
        }
        else if(button.getName().equals("DeleteQuestion")){
            if(numberOfQuestions > 1){
                card.previous(cPane);
                cPane.remove(AddAndDeleteQuestionListener.questionIndex);
                AddAndDeleteQuestionListener.numberOfQuestions--;
                if(AddAndDeleteQuestionListener.questionIndex > 0){
                    AddAndDeleteQuestionListener.questionIndex -= 1;
                }
                else{
                    AddAndDeleteQuestionListener.questionIndex = AddAndDeleteQuestionListener.numberOfQuestions - 1;
                }
            }
        }
    }
}