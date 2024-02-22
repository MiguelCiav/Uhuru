package main.models;

public class Answer {
    private String answerID;
    private String questionID;
    private String answerText;
    private boolean isSelected;
    private boolean isCorrect;
    private int answerNumber;
    private String justification;

    public Answer(String answerText, int answerType, boolean isCorrect, String answerID, String questionID, String justification){
        
        this.answerText = answerText;
        this.isCorrect = isCorrect;
        this.answerNumber = answerNumber;
        this.answerID = answerID;
        isSelected = false;
        if(isCorrect){
            this.justification=justification;    
        }
        else{
            this.justification=""; 
        }
        

    }

    public String getQuestionID(){
        return questionID;
    }

    public String getAnswerID(){
        return answerID;
    }

    public static void setAsSelected(String courseID, String testID, String questionID, String answerID, boolean selected){
        Course.getInstanceCourse(courseID).getTest(testID).getQuestion(questionID).getAnswer(answerID).setAsSelected(selected);
    }

    public void setAsSelected(boolean selected){
        this.isSelected = selected;
    }

    public boolean isSelected(){
        return isSelected;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
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
