package main.controllers;

import main.views.components.createTestViewComponents.QuestionDataPanel;
import main.views.components.createTestViewComponents.TestDataPanel;
import utils.JSONWriter;

public class CreateTestController {

    private static CreateTestController instance;
    private static int createdTestsCounter;
    
    private CreateTestController(){
        createdTestsCounter = 3;
    }

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
        JSONWriter.addTest(testDescription, Integer.parseInt(minutes), "1", Integer.toString(createdTestsCounter), testName);
        createdTestsCounter++;

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

    public static void addQuestions(){

        String questionID = "";
        String statement = "";
        String code = "";
        String imageURL = "";
        String questionType = "";
        String domain = "";

        for(int i = 0; i < QuestionDataPanel.getQuestionList().size(); i++){
            questionID = Integer.toString(QuestionDataPanel.getQuestionIndex());
            statement = QuestionDataPanel.getQuestionList().get(i).getStatement().getTextArea().getText();
            code = QuestionDataPanel.getQuestionList().get(i).getCode().getTextArea().getText();
            imageURL = QuestionDataPanel.getQuestionList().get(i).getImagePath();
            if(QuestionDataPanel.getQuestionList().get(i).getCode().getTextArea().isEditable()){
                questionType = Integer.toString(2);
            }
            else{
                questionType = Integer.toString(1);
            }
            domain = QuestionDataPanel.getQuestionList().get(i).getDomain();
            JSONWriter.addQuestion(Integer.toString(createdTestsCounter - 1), questionID, statement, code, imageURL, questionType, domain);

            for(int j = 0; j < QuestionDataPanel.getQuestionList().get(i).getOptionList().size(); j++){
                if(QuestionDataPanel.getQuestionList().get(i).getOptionList().get(j).getJustification().getTextArea().isEditable()){
                    addAnswer(QuestionDataPanel.getQuestionList().get(i).getOptionList().get(j).getStatement().getTextArea().getText(),
                    QuestionDataPanel.getQuestionList().get(i).getOptionList().get(j).getJustification().getTextArea().getText(), true);
                }
                else{
                    addAnswer(QuestionDataPanel.getQuestionList().get(i).getOptionList().get(j).getStatement().getTextArea().getText(),
                    QuestionDataPanel.getQuestionList().get(i).getOptionList().get(j).getJustification().getTextArea().getText(), false);
                }
            }
        }
    }

    public static void addAnswer(String statement, String justification, boolean isCorrect){
        JSONWriter.addAnswer(statement, justification, isCorrect);
    }
    
}
