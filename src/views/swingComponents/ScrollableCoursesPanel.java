package views.swingComponents;

import javax.swing.Box;

import controllers.AnswerTestController;
import models.Course;

import java.awt.Dimension;

public class ScrollableCoursesPanel extends ScrollablePanel{
    
    String[] courseNames = AnswerTestController.getInstance().getCourseNames();
    int[] courseIDs = AnswerTestController.getInstance().getCourseIDs();

    public ScrollableCoursesPanel(){
        super();
        addScrollableElements();
    }

    @Override
    protected void addScrollableElements(){
        for(int i = 0; i < Course.MAX_COURSE; i++) {

            if(courseIDs[i] != -1){
                add(new LabelPanelCourse(courseNames[i],courseIDs[i]));
                add(Box.createRigidArea(new Dimension(0,20)));
            }

        }
    }

}
