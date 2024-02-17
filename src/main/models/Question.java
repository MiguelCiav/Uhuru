package main.models;

import java.util.ArrayList;

public class Question {

    private String questionID;
    private String testID;
    private String description;
    private String justification;
    private Answer userAnswer;
    private int questionType;
    private int questionNumber;

    private ArrayList<Answer> answerList = new ArrayList<Answer>();

    public Question(String description, String justification, int questionType, String questionID, String testID){
        
        this.description = description;
        this.justification = justification;
        this.questionType = questionType;
        this.questionID = questionID;
        this.testID = testID;
        this.description = description;
        this.questionNumber = questionNumber;
    };

    public void addAnswer(Answer answer){

        answerList.add(answer);

        System.out.println("Respuesta " + answer.getAnswerID() + " añadida a " + questionID);

    };

    public void answerQuestion(Answer answer){};

    public String getDescription(){
        return description;
    }

    public String getJustificacion(){
        return justification;
    }

    public Answer getUserAnswer(){
        return userAnswer;
    }
    
    public int getQuestionType(){
        return questionType;
    }

    public int getQuestionNumber(){
        return questionNumber;
    }

    public Answer getAnswer(String answerID){
        Answer foundAnswer = null;

        for(int i = 0; i < answerList.size(); i++){
            if (answerID.equals(answerList.get(i).getAnswerID())) {
                foundAnswer = answerList.get(i);
                return foundAnswer;
            }
        }  

        return null;
    }
    
    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getQuestionID() {
        return questionID;
    }

    public String getTestID(){
        return testID;
    }

}
