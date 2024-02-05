package models;

import java.util.*;

public class Test {

    private int courseID;
    private int testID;
    private int duration;
    private float calification;
    private String dominio;
    private String name;

    private ArrayList<Question> questionList = new ArrayList<Question>();

    public Test(){}
    
    public Test(int courseID,int testID,int duration, String dominio){
        this.courseID= courseID;
        this.testID = testID;
        this.duration = duration;
        this.dominio= dominio;
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
   
}
