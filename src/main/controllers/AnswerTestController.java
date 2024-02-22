package main.controllers;

import main.models.Course;
import main.models.Question;
import main.models.Test;

public class AnswerTestController {
    
    private static AnswerTestController answerTestController;
    private boolean isOnTest;
    private static String currentCourseID;
    private static String currentTestID;
    private Course[] courseArray;

    private AnswerTestController(){

        courseArray = Course.getCourseArray();

    }

    public void calculateCalification(){
        Course.getInstanceCourse(currentCourseID).getTest(currentTestID).calculateCalification();
    }

    public int getCalification(){
        return Course.getInstanceCourse(currentCourseID).getTest(currentTestID).getCalification();
    }

    public static AnswerTestController getInstance(){

        if(answerTestController == null){
            answerTestController = new AnswerTestController();
        }

        return answerTestController;

    }

    public String[] getCourseIDsArray(){

        String[] courseIDs = new String[Course.MAX_COURSE];

        for(int i = 0; i < Course.MAX_COURSE; i++){

            if(courseArray[i] != null){
                courseIDs[i] = courseArray[i].getID();
            } else {
                courseIDs[i] = "NULL";
            }
        
        }

        return courseIDs;
    }

    public String[] getCourseNamesArray(){

        String[] courseNames = new String[Course.MAX_COURSE];

        for(int i = 0; i < Course.MAX_COURSE; i++){

            if(courseArray[i] != null){
                courseNames[i] = courseArray[i].getCourseName();
            } else {
                courseNames[i] = "NULL COURSE";
            }
        
        }

        return courseNames;
    }

    public String[] getTestNamesArray(String courseID){

        Test[] testArray = Course.getTestArray(courseID);
        String[] testNames = new String[Course.amountOfTest(courseID)];

        for(int i = 0; i < testArray.length; i++){

            if(courseArray[i] != null){
                testNames[i] = testArray[i].getName();
            } else {
                testNames[i] = "NULL COURSE";
            }
        
        }

        return testNames;
    }

    public String[] getQuestionIDsArray(String courseID, String testID){
        
        return Course.getInstanceCourse(courseID).getTest(testID).getQuestionIDs();
    }

    public String[] getQuestionDesciptionsArray(String courseID, String testID){
        return Course.getInstanceCourse(courseID).getTest(testID).getQuestionDescriptionsArray();
    }

    public String getQuestionDescription(String courseID, String testID, String questionID){

        Course loadedCourse = Course.getInstanceCourse(courseID);
        Test loadedTest = loadedCourse.getTest(testID);
        Question loadedQuestion = loadedTest.getQuestion(questionID);

        if(loadedQuestion != null){
            return loadedQuestion.getStatement();
        }

        return "NULL QUESTION";

    }

    public String getTestName(String courseID, String testID){
        return Course.getTest(courseID,testID).getName();
    }

    public static String getCurrentCourseID(){
        return currentCourseID;
    }
    
    public static String getCurrentTestID(){
        return currentTestID;
    }

    public static String getCurrentTestName(){
        return Course.getInstanceCourse(currentCourseID).getTest(currentTestID).getName();
    }

    public static int getCurrentTestTime(){
        return Course.getInstanceCourse(currentCourseID).getTest(currentTestID).getDuration();
    }

    public static int getCurrentTestQuestionsAmount(){
        return Course.getInstanceCourse(currentCourseID).getTest(currentTestID).getQuestionsAmount();
    }

    public String[] getTestID(String courseID){

        Course loadedCourse = Course.getInstanceCourse(courseID);
        Test[] testArray = loadedCourse.getTestArray();
        String[] testIDs = new String[loadedCourse.amountOfTest()];

        
        
        

        for(int i = 0; i < loadedCourse.amountOfTest(); i++){

            if(testArray[i] != null){
                testIDs[i] = testArray[i].getTestID();
            } else {
                testIDs[i] = "NULL TEST";
            }
        
        }

        return testIDs;
    }

    public String[] getAnswersDescriptions(String courseID, String testID, String questionID){
        return Course.getTest(courseID,testID).getQuestion(questionID).getAnswerDescriptions();
    }

    public String[] getAnswersIDs(String courseID, String testID, String questionID){
        return Course.getTest(courseID,testID).getQuestion(questionID).getAnswerIDs();
    }

    public String getAnswerDescription(String courseID, String testID, String questionID, String answerID){
        return Course.getTest(courseID,testID).getQuestion(questionID).getAnswer(answerID).getAnswerText();
    }

    public static void setCurrentTest(String courseID, String testID){

        currentCourseID = courseID;
        currentTestID = testID;

    }

    public void answerQuestion(String questionID, String answerID){
        Course.getInstanceCourse(currentCourseID).getTest(currentTestID).getQuestion(questionID).markAnswerAsSelected(answerID);
    }
}
