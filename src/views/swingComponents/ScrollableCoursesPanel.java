package views.swingComponents;

import javax.swing.Box;
import java.awt.Dimension;

public class ScrollableCoursesPanel extends ScrollablePanel{
    
    public ScrollableCoursesPanel(){
        super();
        addScrollableElements();
    }

    @Override
    protected void addScrollableElements(){
        for(int i = 0; i < 5; i++) {
            add(new LabelPanelWithTitle(i, "Curso de Ejemplo", "Curso"));
            add(Box.createRigidArea(new Dimension(0,20)));
        }
    }

}
