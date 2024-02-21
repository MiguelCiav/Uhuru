package main.controllers;

import main.models.Course;
import main.models.Question;
import main.models.Test;

public class AnswerTestController {
    
    private static AnswerTestController answerTestController;
    private Course[] coursesList;

    public static AnswerTestController getInstance(){

        if(answerTestController == null){
            answerTestController = new AnswerTestController();
        }

        return answerTestController;

    }

    private AnswerTestController(){

        coursesList = Course.getCourseList();

    }

    public String[] getQuestionIDs(String courseID, String testID){

        Course loadedCourse = Course.getInstanceCourse(courseID);
        Test loadedTest = loadedCourse.getTest(testID);

        return loadedTest.getQuestionIDs();

    }

    public String getTestName(String courseID, String testID){
        ;
        return Course.getInstanceCourse(courseID).getTest(testID).getName();
    }

    public static void setActualTest(String courseID, String testID){
        Course.setActualTest(courseID, testID);
    }

    public static String getActualCourseID(){
        return Course.getActualCourseID();
    }
    
    public static String getActualTestID(){
        return Course.getActualTestID();
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

    public String getQuestionDescription(String courseID, String testID, String questionID){

        Course loadedCourse = Course.getInstanceCourse(courseID);
        Test loadedTest = loadedCourse.getTest(testID);
        Question loadedQuestion = loadedTest.getQuestion(questionID);

        if(loadedQuestion != null){
            return loadedQuestion.getDescription();
        }

        return "NULL QUESTION";

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

    public String[] getAnswersDescriptions(String courseID, String testID, String questionID){
        return Course.getInstanceCourse(courseID).getTest(testID).getQuestion(questionID).getAnswerDescriptions();
    }

    public String[] getAnswersIDs(String courseID, String testID, String questionID){
        return Course.getInstanceCourse(courseID).getTest(testID).getQuestion(questionID).getAnswerIDs();
    }

    public String getAnswerDescription(String courseID, String testID, String questionID, String answerID){
        return Course.getInstanceCourse(courseID).getTest(testID).getQuestion(questionID).getAnswer(answerID).getAnswerText();
    }

    public void answerQuestion(String questionID){
        
    }
}
