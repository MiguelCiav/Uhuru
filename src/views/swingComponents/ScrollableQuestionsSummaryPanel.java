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
            add(new LabelPanelWithTitle(i, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce quis odio vitae velit pretium ultrices. Nam ut velit ac dui elementum pharetra. Morbi id egestas ex. Proin ac iaculis orci, at viverra ex. Vestibulum eget feugiat ligula, et ultrices purus. Aliquam dignissim ligula nibh, sed gravida mi mollis eget. Morbi."));
            add(Box.createRigidArea(new Dimension(0,20)));
        }
    }
    
}
