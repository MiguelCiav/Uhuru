package views.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import views.swingComponents.TestInfoPanel;

public class UpdateAnswerAmount extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e){
        TestInfoPanel.getTestInfoPanel().increaseAnswers();
    }

}
