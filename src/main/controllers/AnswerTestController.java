package main.controllers;

import main.models.Course;
import main.models.Test;

public class AnswerTestController {
    
    private static AnswerTestController answerTestController;
    private Course[] coursesList;
    private Test[] testList;

    private AnswerTestController(){

        coursesList = Course.getCourseList();

    }

    public static AnswerTestController getInstance(){

        if(answerTestController == null){
            answerTestController = new AnswerTestController();
        }

        return answerTestController;

    }

    public String[] getCourseNames(){

        String[] courseNames = new String[Course.MAX_COURSE];

        for(int i = 0; i < Course.MAX_COURSE; i++){

            if(coursesList[i] != null){
                courseNames[i] = coursesList[i].getCourseName();
            } else {
                courseNames[i] = "NULL COURSE";
            }
        
        }

        return courseNames;
    }

    public String[] getCourseIDs(){

        String[] courseIDs = new String[Course.MAX_COURSE];

        for(int i = 0; i < Course.MAX_COURSE; i++){

            if(coursesList[i] != null){
                courseIDs[i] = coursesList[i].getID();
            } else {
                courseIDs[i] = "NULL";
            }
        
        }

        return courseIDs;
    }

    public String[] getTestNames(String courseID){

        Course loadedCourse = Course.getInstanceCourse(courseID);
        Test[] testArray = loadedCourse.getTestArray();
        String[] testNames = new String[loadedCourse.amountOfTest()];

        for(int i = 0; i < loadedCourse.amountOfTest(); i++){

            if(coursesList[i] != null){
                testNames[i] = testArray[i].getName();
            } else {
                testNames[i] = "NULL COURSE";
            }
        
        }

        return testNames;
    }

    public String[] getTestID(String courseID){

        Course loadedCourse = Course.getInstanceCourse(courseID);
        Test[] testArray = loadedCourse.getTestArray();
        String[] testIDs = new String[loadedCourse.amountOfTest()];

        for(int i = 0; i < loadedCourse.amountOfTest(); i++){

            if(coursesList[i] != null){
                testIDs[i] = testArray[i].getTestID();
            } else {
                testIDs[i] = "NULL COURSE";
            }
        
        }

        return testIDs;
    }

    public void answerQuestion(String questionID){
        
    }
}
