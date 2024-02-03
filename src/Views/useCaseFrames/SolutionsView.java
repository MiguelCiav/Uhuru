package Views.useCaseFrames;

import java.awt.Dimension;
import javax.swing.JFrame;

import Views.swingComponents.AnswersSummaryPanel;
import Views.swingComponents.DoublePanel;
import Views.swingComponents.LabelContainer;

public class SolutionsView extends JFrame{
    
    private LabelContainer questionsSummaryPanel;
    private AnswersSummaryPanel answersSummaryPanel = new AnswersSummaryPanel();
    private DoublePanel doublePanel;

    public SolutionsView (){
        questionsSummaryPanel = new LabelContainer("Preguntas", LabelContainer.QUESTIONS_CONTAINER);
        doublePanel = new DoublePanel(questionsSummaryPanel, answersSummaryPanel);

        setTitle("Uhuru: Solutions");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(doublePanel);

        setVisible(true);
    }

}