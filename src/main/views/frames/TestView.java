package main.views.frames;

import javax.swing.*;

import main.views.components.genericComponents.PrincipalPanel;
import main.views.components.testViewComponents.QuestionsListPanel;

import java.awt.*;

public class TestView extends JFrame{

    PrincipalPanel principalPanel;
    QuestionsListPanel questionsListPanel;

    public TestView(){

        super("Uhuru");

        principalPanel = new PrincipalPanel();
        questionsListPanel = new QuestionsListPanel();

        setMinimumSize(new Dimension(800,600));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        principalPanel.setContentPanel(questionsListPanel);
        add(principalPanel);

        setVisible(true);

    }
}

