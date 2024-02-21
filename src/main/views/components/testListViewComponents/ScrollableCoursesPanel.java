package main.views.components.testListViewComponents;

import javax.swing.Box;
import javax.swing.text.View;

//! COMUNICACIÓN ENTRE MODELO Y VISTA, CORREGIR

import main.controllers.AnswerTestController;
import main.models.Course;
import main.views.components.genericComponents.ScrollablePanel;
import utils.ViewsStyles;

import java.awt.Dimension;
import java.util.ArrayList;

public class ScrollableCoursesPanel extends ScrollablePanel{
    
    private static ScrollableCoursesPanel instance;
    private ArrayList<LabelPanelCourse> coursePanels = new ArrayList<LabelPanelCourse>();
    String[] courseNames = AnswerTestController.getInstance().getCourseNamesArray();
    String[] courseIDs = AnswerTestController.getInstance().getCourseIDsArray();
    
    private ScrollableCoursesPanel(){
        super();
        addScrollableElements();
    }

    public static ScrollableCoursesPanel getInstance(){

        if(instance == null){
            instance = new ScrollableCoursesPanel();
        }

        return instance;
    }

    public void selectCourse(String courseID){

        for(int i = 0; i < courseIDs.length - 1; i++) {

            if(coursePanels.get(i).getCourseID().equals(courseID)){
                coursePanels.get(i).setRoundBackgroundColor(ViewsStyles.LIGHT_BLUE);
                ScrollableTestPanel.loadExams(courseID);
            } else {
                coursePanels.get(i).setRoundBackgroundColor(ViewsStyles.ULTRA_LIGHT_BLUE);
            }

        }

        repaint();
        //resetScrollableElements();
        
    }

    @Override
    protected void addScrollableElements(){
        for(int i = 0; i < Course.MAX_COURSE; i++) {

            if(courseIDs[i] != "NULL"){
                coursePanels.add(new LabelPanelCourse(courseNames[i],courseIDs[i]));
                coursePanels.get(i).addMouseListener(new SelectCourseListener());
                add(coursePanels.get(i));
                add(Box.createRigidArea(new Dimension(0,20)));
            }

        }
    }

}
