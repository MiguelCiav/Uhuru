package main.views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.views.components.TestInfoPanel;

public class UpdateAnswerAmount extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e){
        TestInfoPanel.getTestInfoPanel().increaseAnswers();
    }

}
