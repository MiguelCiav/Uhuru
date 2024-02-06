package models;

import java.util.*;

public class Test {

    private String type;
    private String name;
    private int duration;
    private float calification;
    private String dominio;

    private ArrayList<Question> questionList = new ArrayList<Question>();
    private String testID;
    private String courseID;

    public Test(String name, String type, int duration){

        this.type = type;
        this.duration = duration;
        this.testID = testID;

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
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
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

    public String getTestID(){
        return testID;
    }
   
}
