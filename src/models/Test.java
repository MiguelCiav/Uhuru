package models;

import java.util.*;

public class Test {

    private String type;
    private String name;
    private int duration;
    private float calification;

    private ArrayList<Question> questionList = new ArrayList<Question>();
    private String testID;
    private String courseID;

    public Test(String name, String type, int duration, String testID){

        this.name = name;
        this.type = type;
        this.duration = duration;
        this.testID = testID;

    }

    public void addQuestion(Question question){

        questionList.add(question);

    };

    public Question getQuestion(String questionID){
        Question foundQuestion = null;

        for(int i = 0; i < questionList.size(); i++){
            if (questionID == questionList.get(i).getQuestionID()) {
                foundQuestion = questionList.get(i);
                return foundQuestion;
            }
        }  

        return null;
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

    public String getTestID(){
        return testID;
    }

    public String getType(){
        return type;
    }
   
}
