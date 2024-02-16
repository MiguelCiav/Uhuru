package main.views.components.testViewComponents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateAnswerAmount extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e){
        TestInfoPanel.getTestInfoPanel().increaseAnswers();
    }

}
