package main.views.components.solutionsViewComponents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckAnswers extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        
        LabelPanelQuestionSummary source = (LabelPanelQuestionSummary) e.getSource();
        ScrollableQuestionsSummaryPanel.getInstance().selectQuestion(source.getQuestionID());

    }
    
}
