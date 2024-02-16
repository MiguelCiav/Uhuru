package main.views.frames;

import java.awt.Dimension;
import javax.swing.JFrame;

import main.views.components.DoublePanel;
import main.views.components.ScrollContainer;
import main.views.components.solutionsViewComponents.AnswersSummaryPanel;
import main.views.components.solutionsViewComponents.ScrollableQuestionsSummaryPanel;

public class SolutionsView extends JFrame{
    
    private ScrollContainer scrollContainer;
    private AnswersSummaryPanel answersSummaryPanel = new AnswersSummaryPanel();
    private DoublePanel doublePanel;

    public SolutionsView (){
        scrollContainer = new ScrollContainer("Preguntas", new ScrollableQuestionsSummaryPanel());
        doublePanel = new DoublePanel(scrollContainer, answersSummaryPanel);

        setTitle("Uhuru: Solutions");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(doublePanel);

        setVisible(true);
    }

}