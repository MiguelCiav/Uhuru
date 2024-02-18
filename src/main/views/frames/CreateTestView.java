package main.views.frames;

import javax.swing.*;

import main.views.components.*;
import main.views.components.createTestViewComponents.QuestionsAndAnswersPanel;
import main.views.components.createTestViewComponents.TestDataPanel;
import main.views.components.genericComponents.DoublePanel;
import main.views.components.genericComponents.PrincipalPanel;
import java.awt.*;

public class CreateTestView extends JFrame{

    private static CreateTestView instance;

    private PrincipalPanel mainPanel = new PrincipalPanel();
    private TestDataPanel testDataPanel = new TestDataPanel();


    public CreateTestView(){

        super("Uhuru: Create test");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        testDataPanel.setMaximumSize(new Dimension(500,500));
        mainPanel.setContentPanelWithoutExpansion(testDataPanel);
        add(mainPanel);

        setVisible(true);
    }

    public static CreateTestView getInstance(){

        if(instance == null){
            instance = new CreateTestView();
        }

        return instance;
    }

    public void disposeFrame(){

        instance.dispose();   
    }
}
