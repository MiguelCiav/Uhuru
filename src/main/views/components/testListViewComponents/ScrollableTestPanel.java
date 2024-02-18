package main.views.components.testListViewComponents;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;

import main.controllers.AnswerTestController;
import main.views.components.genericComponents.ScrollablePanel;

public class ScrollableTestPanel extends ScrollablePanel{

    private static ScrollableTestPanel instance;
    private static String[] testNames;
    private static String[] testIDs;

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

        String defaultCourse = AnswerTestController.getInstance().getCourseIDs()[0];

        testNames = AnswerTestController.getInstance().getTestNames(defaultCourse);
        testIDs = AnswerTestController.getInstance().getTestID(defaultCourse);
        instance.addScrollableElements();

    }

    public static void loadExams(String CourseID){

        testNames = AnswerTestController.getInstance().getTestNames(CourseID);
        testIDs = AnswerTestController.getInstance().getTestID(CourseID);
        instance.addScrollableElements();

    }

    @Override
    public void addScrollableElements(){

        removeAll();

        for(int i = 0; i < testNames.length; i++){
            add(new LabelPanelTest(testNames[i], testIDs[i]));
            add(Box.createRigidArea(new Dimension(0,20)));
        }

        validate();
        
    }
}
