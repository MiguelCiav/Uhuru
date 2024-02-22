package main.models;

import java.util.ArrayList;

public class Question {
    private final int TEXT=1;
    private final int CODE=2;

    private String questionID;
    private String testID;
    private String statement;
    private int questionType;
    private int questionNumber;
    private String codeText;
    private String imageURL;
    private String domain;
    private int correctAnswersAmount;

    private ArrayList<Answer> answerList = new ArrayList<Answer>();

    public Question(String testID, String questionID, String statement, String code, String imageURL,int questionType, String domain){
        
        this.statement = statement;
        this.questionType = questionType;
        this.questionID = questionID;
        this.testID = testID;
        this.codeText = code;
        this.domain = domain;

    }

    public boolean[] getCorrectArray(){
        boolean[] correctArray = new boolean[answerList.size()];

        for(int i = 0; i < answerList.size(); i++){
            correctArray[i] = answerList.get(i).isCorrect();
        }

        return correctArray;
    }

    public boolean[] getSelectedArray(){
        boolean[] selectedArray = new boolean[answerList.size()];

        for(int i = 0; i < answerList.size(); i++){
            selectedArray[i] = answerList.get(i).isSelected();
        }

        return selectedArray;
    }


    public void checkCorrectAnswersAmount(){

        correctAnswersAmount = 0;

        for(Answer answer : answerList){

            if(answer.isCorrect()){
                correctAnswersAmount++;
            }

        }

    }

    public int getCorrectAnswersAmount(){
        return correctAnswersAmount;
    }

    public void markAnswerAsSelected(String answerID, boolean selected){

        for(int i = 0; i < answerList.size(); i++){
            if(answerList.get(i).getAnswerID().equals(answerID)){
                answerList.get(i).setAsSelected(false);
            }
        }

    }

    public void addAnswer(Answer answer){

        answerList.add(answer);

    }

    public Answer[] getAnswersArray(){
        return answerList.toArray(new Answer[0]);
    }

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

    public String getDomain(){
        return domain;
    }

    public String getStatement(){
        return statement;
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
    public String getCodeText() {
        return codeText;
    }

    public void setCodeText(String codeText) {
        this.codeText = codeText;
    }
    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}
