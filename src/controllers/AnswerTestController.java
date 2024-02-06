package controllers;

import models.Course;

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

    public int[] getCourseIDs(){

        int[] courseIDs = new int[Course.MAX_COURSE];

        for(int i = 0; i < Course.MAX_COURSE; i++){

            if(coursesList[i] != null){
                courseIDs[i] = coursesList[i].getID();
            } else {
                courseIDs[i] = -1;
            }
        
        }

        return courseIDs;
    }
}
