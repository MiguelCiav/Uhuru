package main.views.components.testListViewComponents;

import javax.swing.Box;

//! COMUNICACIÓN ENTRE MODELO Y VISTA, CORREGIR

import main.controllers.AnswerTestController;
import main.models.Course;
import main.views.components.ScrollablePanel;

import java.awt.Dimension;

public class ScrollableCoursesPanel extends ScrollablePanel{
    
    String[] courseNames = AnswerTestController.getInstance().getCourseNames();
    String[] courseIDs = AnswerTestController.getInstance().getCourseIDs();

    public ScrollableCoursesPanel(){
        super();
        addScrollableElements();
    }

    @Override
    protected void addScrollableElements(){
        for(int i = 0; i < Course.MAX_COURSE; i++) {

            if(courseIDs[i] != "NULL"){
                add(new LabelPanelCourse(courseNames[i],courseIDs[i]));
                add(Box.createRigidArea(new Dimension(0,20)));
            }

        }
    }

}
