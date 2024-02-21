package main.views.components.testListViewComponents;

import java.awt.Dimension;
import java.awt.SystemTray;
import java.util.ArrayList;

import javax.swing.Box;

import main.controllers.AnswerTestController;
import main.views.components.genericComponents.ScrollablePanel;

public class ScrollableTestPanel extends ScrollablePanel{

    private static ScrollableTestPanel instance;
    private static String[] testIDs;
    private static String courseID;

    private ScrollableTestPanel(){
        super();
    }

    public static ScrollableTestPanel getInstance(){

        if(instance == null){
            instance = new ScrollableTestPanel();
        }

        return instance;
    }

    public static void loadExams(){

        courseID = AnswerTestController.getInstance().getCourseIDsArray()[0];
        testIDs = AnswerTestController.getInstance().getTestID(courseID);
        instance.addScrollableElements();

    }

    public static void loadExams(String newCourseID){

        ;
        testIDs = AnswerTestController.getInstance().getTestID(newCourseID);
        courseID = newCourseID;
        instance.addScrollableElements();

    }

    @Override
    public void addScrollableElements(){

        removeAll();

        for(int i = 0; i < testIDs.length; i++){
            ;
            add(new LabelPanelTest(courseID, testIDs[i]));
            add(Box.createRigidArea(new Dimension(0,20)));
        }

        ;

        validate();
        
    }
}
