package main.views.frames;

import javax.swing.*;

import main.views.components.*;

import java.awt.*;

public class AddQuestionsFrame extends JFrame{

    DoublePanel mainPanel;
    QuestionDataPanel questionStatement = new QuestionDataPanel();
    AnswerDataPanel answersStatement = new AnswerDataPanel();
    
    public AddQuestionsFrame(){
        super("Uhuru: Add Questions");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new DoublePanel(questionStatement, answersStatement);
        add(mainPanel);

        setVisible(true);
    }
}
