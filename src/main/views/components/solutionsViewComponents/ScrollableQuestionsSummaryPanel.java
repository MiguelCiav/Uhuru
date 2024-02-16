package main.views.components.solutionsViewComponents;

import java.awt.Dimension;
import javax.swing.Box;

import main.views.components.ScrollablePanel;


public class ScrollableQuestionsSummaryPanel extends ScrollablePanel{

    public ScrollableQuestionsSummaryPanel(){
        super();
        addScrollableElements();
    }

    @Override
    protected void addScrollableElements() {
        for(int i = 0; i < 5; i++){
            add(new LabelPanelQuestionSummary("Descripción de ejemplo",i));
            add(Box.createRigidArea(new Dimension(0,20)));
        }
    }
    
}
