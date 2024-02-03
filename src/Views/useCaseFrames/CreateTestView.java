package Views.useCaseFrames;

import Views.swingComponents.*;
import javax.swing.*;
import java.awt.*;

public class CreateTest extends JFrame{

    private DoublePanel createTestPanel;
    private TestDataPanel testDataPanel = new TestDataPanel();
    private QuestionsAndAnswersPanel questionsAndAnswersPanel = new QuestionsAndAnswersPanel();


    public CreateTest(){
        super("Uhuru: Create test");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createTestPanel = new DoublePanel(testDataPanel, questionsAndAnswersPanel);
        add(createTestPanel);

        setVisible(true);
    }
}
