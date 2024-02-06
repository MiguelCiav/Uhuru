package models;

import java.util.*;

public class Test {

<<<<<<< HEAD
    private String type;
    private String name;
=======
    private int courseID;
    private int testID;
>>>>>>> answerTestController
    private int duration;
    private float calification;
    private String dominio;
    private String name;

    private ArrayList<Question> questionList = new ArrayList<Question>();
    private String testID;
    private String courseID;

<<<<<<< HEAD
    public Test(String name, String type, int duration){

        this.type = type;
        this.duration = duration;
        this.testID = testID;

=======
    public Test(){}
    
    public Test(int courseID,int testID,int duration, String dominio){
        this.courseID= courseID;
        this.testID = testID;
        this.duration = duration;
        this.dominio= dominio;
>>>>>>> answerTestController
    }

    public void addQuestion(Question question){

        questionList.add(question);

    };

    public Question getQuestion(Question question){
        Question foundQuestion = null;
        for(int i = 0; i < questionList.size(); i++){
            if (question.getQuestionNumber() == questionList.get(i).getQuestionNumber()) {
                foundQuestion = questionList.get(i);
                break;
            }
        }  
        return foundQuestion;
    };
<<<<<<< HEAD
    
    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public int getDuration(){
        return duration;
    }

    public float calification(){
        return calification;
    }

    public String getID(){
        return testID;
    }

=======

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getCalification() {
        return calification;
    }

    public void setCalification(float calification) {
        this.calification = calification;
    }
    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public int getTestID(){
        return testID;
    }
   
>>>>>>> answerTestController
}
