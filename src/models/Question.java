package models;

public class Question {

    private int questionID;
    private String description;
    private String justification;
    private Answer userAnswer;
    private int questionType;
    private int questionNumber;

    public Question(String description, String justification, int questionType, int questionNumber){
        
        this.description = description;
        this.justification = justification;
        this.questionType = questionType;
        this.questionNumber = questionNumber;
    };

    public void addAnswer(Answer answer){};
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

    public Answer getAnswer(int answerNumber){
        //Borrador
        Answer aux = new Answer("Hola", 1, false, answerNumber);
        return aux;
    }
    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getQuestionID() {
        return questionID;
    }

}
