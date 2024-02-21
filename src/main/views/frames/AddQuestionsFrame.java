package main.views.frames;

import javax.swing.*;
import main.views.components.createTestViewComponents.AnswerDataPanel;
import main.views.components.createTestViewComponents.QuestionDataPanel;
import main.views.components.genericComponents.DoublePanel;

import java.awt.*;

public class AddQuestionsFrame extends JFrame{

    private static AddQuestionsFrame instance;

    DoublePanel mainPanel;
    
    private AddQuestionsFrame(){
        super("Uhuru: Add Questions");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new DoublePanel(QuestionDataPanel.getInstance(), AnswerDataPanel.getInstance());
        add(mainPanel);

        setVisible(true);
    }

    public static AddQuestionsFrame getInstance(){
        if(instance == null){
            instance = new AddQuestionsFrame();
        }

        return instance;
    }

    public void disposeFrame(){

        instance.dispose();   
    }
}
