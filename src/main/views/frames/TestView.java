package main.views.frames;

import javax.swing.*;

import main.views.components.PrincipalPanel;
import main.views.components.testViewComponents.QuestionsListPanel;

import java.awt.*;

public class TestView extends JFrame{

    PrincipalPanel principalPanel = new PrincipalPanel();
    QuestionsListPanel questionsListPanel = new QuestionsListPanel();

    public TestView(){

        super("Uhuru");
        setMinimumSize(new Dimension(800,600));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        principalPanel.setContentPanel(questionsListPanel);
        add(principalPanel);

        setVisible(true);

    }
}

