package main.views.frames;

import javax.swing.*;
import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import main.views.components.genericComponents.DoublePanel;

import java.awt.*;

public class AddQuestionsFrame extends JFrame{

    DoublePanel mainPanel;
    
    public AddQuestionsFrame(){
        super("Uhuru: Add Questions");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new DoublePanel(QuestionDataPanel.getInstance(), AnswerDataPanel.getInstance());
        add(mainPanel);

        setVisible(true);
    }
}
