package main.views.listeners;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.AnswerStatement;

public class AddAndDeleteOptionsListener extends MouseAdapter{

    private static AddAndDeleteOptionsListener instance;
    private static Container cPane;
    private static CardLayout card;
    private static int numberOfOptions;
    private static int optionsIndex;

    private AddAndDeleteOptionsListener(Container pane, CardLayout card){
        AddAndDeleteOptionsListener.cPane = pane;
        AddAndDeleteOptionsListener.card = card;
        AddAndDeleteOptionsListener.numberOfOptions = 1;
    }

    public static AddAndDeleteOptionsListener getInstance(Container cPane, CardLayout card){
        if(instance == null){
            instance = new AddAndDeleteOptionsListener(cPane, card);
        }
        return instance;
    }

    public static void setOptionIndex(int num){
        AddAndDeleteOptionsListener.optionsIndex = num;
    }

    public static int getOptionIndex(){
        return AddAndDeleteOptionsListener.optionsIndex;
    }
    
    public static int getNumberOfOptions(){
        return AddAndDeleteOptionsListener.numberOfOptions;
    }

    @Override public void mouseClicked(MouseEvent e){
        JLabel button = new JLabel();
        button.setName(((JLabel) e.getSource()).getName());

        if(button.getName().equals("AddOption")){
            AnswerStatement option = new AnswerStatement();
            AnswerDataPanel.getOptionList().add(AddAndDeleteOptionsListener.getOptionIndex() + 1, option);
            cPane.add(option,AddAndDeleteOptionsListener.getOptionIndex() + 1);
            AnswerDataPanel.getBox().setSelected(false);
            AddAndDeleteOptionsListener.optionsIndex++;
            card.next(cPane);
            numberOfOptions++;
            AnswerDataPanel.setStatementText(AddAndDeleteOptionsListener.getOptionIndex()+1);
        }
        else if(button.getName().equals("DeleteOption")){
            if(numberOfOptions > 1){
                card.previous(cPane);
                AnswerDataPanel.getOptionList().remove(AddAndDeleteOptionsListener.optionsIndex);
                cPane.remove(AddAndDeleteOptionsListener.optionsIndex);
                AddAndDeleteOptionsListener.numberOfOptions--;
                if(AddAndDeleteOptionsListener.optionsIndex > 0){
                    AddAndDeleteOptionsListener.optionsIndex -= 1;
                    AnswerDataPanel.setStatementText(AddAndDeleteOptionsListener.getOptionIndex()+1);
                }
                else{
                    AddAndDeleteOptionsListener.optionsIndex = AddAndDeleteOptionsListener.numberOfOptions - 1;
                    AnswerDataPanel.setStatementText(AddAndDeleteOptionsListener.getOptionIndex()+1);
                }

                if(AnswerDataPanel.getOptionList().get(AddAndDeleteOptionsListener.getOptionIndex()).justification.getTextArea().isEditable()){
                    AnswerDataPanel.getBox().setSelected(true);
                }
                else{
                    AnswerDataPanel.getBox().setSelected(false);
                }
            }
        }
    }
}