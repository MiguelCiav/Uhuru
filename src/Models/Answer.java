package Models;

public class Answer {
    
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
}
