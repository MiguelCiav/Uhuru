package main.models;

public class Answer {
    private String answerID;
    private String questionID;
    private String answerText;
    private boolean isSelected;
    private boolean isCorrect;
    private String justification;

    public Answer(String answerID, String questionID, String answerText, String justification, boolean isCorrect){
        
        this.answerText = answerText;
        this.isCorrect = isCorrect;
        this.answerID = answerID;
        this.justification = justification;

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

    public String getJustification(){
        return justification;
    }
}
