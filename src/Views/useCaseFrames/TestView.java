package views.useCaseFrames;

import javax.swing.*;

import views.swingComponents.PrincipalPanel;
import views.swingComponents.QuestionsListPanel;

import java.awt.*;

public class TestView extends JFrame{

    PrincipalPanel testViewPanel = new PrincipalPanel();
    QuestionsListPanel questionsListPanel = new QuestionsListPanel();

    public TestView(){
        super("Uhuru");
        setMinimumSize(new Dimension(800,600));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        //questionsListPanel.add(new BlueButton("Hola",500));
        testViewPanel.setContentPanel(questionsListPanel);
        add(testViewPanel);

        setVisible(true);
    }
}

