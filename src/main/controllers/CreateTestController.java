package main.controllers;

import main.views.components.createTestViewComponents.QuestionDataPanel;
import main.views.components.createTestViewComponents.TestDataPanel;
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

    public static boolean validateData(String testName, String testDescription, String minutes){

        if(validateTestName(testName)){
            return false;
        }
        
        else if(validateTestDescription(testDescription)){
            return false;
        }
        else if(validateMinutes(minutes)){
            return false;
        }

        JSONWriter.getInstance();
        JSONWriter.addTest(testDescription, Integer.parseInt(minutes), "1", "1", testName);

        return true;
    }

    public static boolean validateTestName(String testName){
        if(testName.equals("Ingrese el nombre del examen.") || testName.equals("ERROR: Dato invalido") || testName.matches("\s*")){
            return true;
        }
        return false;
    }

    public static boolean validateTestDescription(String testDescription){
        if(testDescription.equals("Ingrese la descripcion del examen.") || testDescription.equals("ERROR: Dato invalido") || testDescription.matches("\s*")){
            return true;
        }
        return false;
    }

    public static boolean validateMinutes(String minutes){
        if(!minutes.matches("\\d+")){
            return true;
        }

        return false;
    }

    public void addDomain(){
        QuestionDataPanel.getQuestionList().get(QuestionDataPanel.getQuestionList().size() - 1).setDomain(QuestionDataPanel.getDomain());
    }

    public static void createTest(){
        String testName = TestDataPanel.getInstance().getName();
        String type = TestDataPanel.getInstance().getDescription();
        int duration = TestDataPanel.getInstance().getMinutes();
        String courseID = "1";
        String testID = "1";
        JSONWriter.addTest(type, duration, courseID, testID, testName);
    }

    private static void addQuestions(String testID, String questionID, String description, String questionType){
        JSONWriter.addQuestion(testID, questionID, description, description, questionType);
    }
}
