package views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import views.swingComponents.TestInfoPanel;

public class AnswersAmountAction extends MouseAdapter{

    private int amount = 0;

    @Override
    public void mouseClicked(MouseEvent e){
        TestInfoPanel.getTestInfoPanel().increaseAnswers();
    }

}
