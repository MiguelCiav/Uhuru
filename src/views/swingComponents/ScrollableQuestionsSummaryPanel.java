package views.swingComponents;

import java.awt.Dimension;
import javax.swing.Box;


public class ScrollableQuestionsSummaryPanel extends ScrollablePanel{

    public ScrollableQuestionsSummaryPanel(){
        super();
        addScrollableElements();
    }

    @Override
    protected void addScrollableElements() {
        for(int i = 0; i < 5; i++){
            add(new LabelPanelWithTitle(i, "Texto de la pregunta", "Pregunta"));
            add(Box.createRigidArea(new Dimension(0,20)));
        }
    }
    
}
