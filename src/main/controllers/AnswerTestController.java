package main.controllers;

import main.models.Course;

public class AnswerTestController {
    
    private static AnswerTestController answerTestController;
    private Course[] coursesList;

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

        String[] testNames = new String[Course.MAX_COURSE];

        return testNames;
    }

    public void answerQuestion(String questionID){
        
    }
}
