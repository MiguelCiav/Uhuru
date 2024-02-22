package main.views.frames;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.views.components.genericComponents.DoublePanel;
import main.views.components.genericComponents.ScrollContainer;
import main.views.components.solutionsViewComponents.ScrollableAnswersPanel;
import main.views.components.solutionsViewComponents.ScrollableQuestionsSummaryPanel;

public class SolutionsView extends JFrame{
    
    private ScrollContainer scrollContainer;
    private ScrollContainer scrollableAnswers;
    private DoublePanel doublePanel;

    public SolutionsView (){
        scrollContainer = new ScrollContainer("Preguntas", ScrollableQuestionsSummaryPanel.getInstance());
        scrollableAnswers = new ScrollContainer("Respuestas", ScrollableAnswersPanel.getInstance());
        doublePanel = new DoublePanel(scrollContainer, scrollableAnswers);

        setTitle("Uhuru: Solutions");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800,600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(doublePanel);

        setVisible(true);
    }

}