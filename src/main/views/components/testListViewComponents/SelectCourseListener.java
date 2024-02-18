package main.views.components.testListViewComponents;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectCourseListener extends MouseAdapter{

    @Override
    public void mouseClicked(MouseEvent e) {
        LabelPanelCourse source = (LabelPanelCourse) e.getSource();
        ScrollableCoursesPanel.getInstance().selectCourse(source.getCourseID());
    }

}
