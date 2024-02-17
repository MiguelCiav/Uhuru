package main.models;

public class Answer {
    private final int TEXT=1;
    private final int CODE=2;

    private String answerID;
    private String questionID;
    private String answerText;
    private boolean isSelected;
    private int answerType;
    private boolean isCorrect;
    private int answerNumber;

    public Answer(String answerText, int answerType, boolean isCorrect, String answerID, String questionID){
        
        this.answerText = answerText;
        this.answerType = answerType;
        this.isCorrect = isCorrect;
        this.answerNumber = answerNumber;
        this.answerID = answerID;
        isSelected = false;

    }

    public String getQuestionID(){
        return questionID;
    }

    public String getAnswerID(){
        return answerID;
    }

    public static void setAsSelected(String courseID, String testID, String questionID, String answerID, boolean selected){
        Course.getInstanceCourse(courseID).getTest(testID).getQuestion(questionID).getAnswer(answerID).setAsSelected(selected);
        
        System.out.println("Respuesta " + answerID + " marcada como " + selected);
    }

    private void setAsSelected(boolean selected){
        this.isSelected = true;
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
