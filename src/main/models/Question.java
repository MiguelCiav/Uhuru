package main.models;

import java.util.ArrayList;

public class Question {
    private final int TEXT=1;
    private final int CODE=2;

    private String questionID;
    private String testID;
    private String statement;
    private Answer userAnswer;
    private int questionType;
    private int questionNumber;
    private String codeText;
    private String imageURL;

    private ArrayList<Answer> answerList = new ArrayList<Answer>();

    public Question(String statement, int questionType, String questionID, String testID){
        
        this.statement = statement;
        this.questionType = questionType;
        this.questionID = questionID;
        this.testID = testID;

    }

    public void markAnswerAsSelected(String answerID){

        for(int i = 0; i < answerList.size(); i++){
            if(answerList.get(i).getAnswerID().equals(answerID)){
                answerList.get(i).setAsSelected(true);
                
            } else {
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

    public String getStatement(){
        return statement;
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

    public Object getJustificacion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getJustificacion'");
    }

    public Object getDescription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescription'");
    }

}
