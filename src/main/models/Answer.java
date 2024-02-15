package main.models;

public class Answer {
    private final int TEXT=1;
    private final int CODE=2;
    
    private int answerID;
    private int questionID;
    
    private String answerText;
    private int answerType;
    private boolean isCorrect;
    private int answerNumber;

    public Answer(String answeText, int answerType, boolean isCorrect, int answerNumber){
        
        this.answerText = answeText;
        this.answerType = answerType;
        this.isCorrect = isCorrect;
        this.answerNumber = answerNumber;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getAnswerType() {
        return answerType;
    }

    public void setAnswerType(int answerType) {
        this.answerType = answerType;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    
}
