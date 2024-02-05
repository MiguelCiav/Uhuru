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

}
