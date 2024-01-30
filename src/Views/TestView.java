package Views;

import javax.swing.*;
import java.awt.*;

public class TestView extends JFrame{

    PrincipalPanel testViewPanel = new PrincipalPanel();
    QuestionsListPanel questionsListPanel = new QuestionsListPanel();

    TestView(){
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
