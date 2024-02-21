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

    };

    public String[] getAnswerDescriptions(){
        String[] answers = new String[answerList.size()];

        for(int i = 0; i < answers.length; i++){
            answers[i] = answerList.get(i).getAnswerText();
        }

        return answers;
    }

    public String[] getAnswerIDs(){
        String[] answers = new String[answerList.size()];

        for(int i = 0; i < answers.length; i++){
            answers[i] = answerList.get(i).getAnswerID();
        }

        return answers;
    }

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
        Answer foundAnswer;

        for(int i = 0; i < answerList.size(); i++){

            ;
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
