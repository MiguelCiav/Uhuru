package main.controllers;

import utils.JSONWriter;

public class CreateTestController {

    private static CreateTestController instance;
    
    private CreateTestController(){}

    public static CreateTestController getInstance(){

        if(instance == null){
            instance = new CreateTestController();
        }

        return instance;
    }

    public static void addTestToDataBase(String type, int duration, String courseID, String testID, String testName){
        JSONWriter.addTest(type, duration, courseID, testID, testName);
    }

    public static void addQuestionToTest(String testID, String questionID, String description, String justification, String questionType){
        JSONWriter.addQuestion(testID, questionID, description, justification, questionType);
    }

    public static void addOption(String answerText, String answerType, Boolean isCorrect){
        JSONWriter.addAnswer(answerText, answerType, isCorrect);
    }

}
