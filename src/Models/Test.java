package Models;

import java.util.*;

public class Test {

    private String type;
    private int duration;
    private float calification;
    private ArrayList<Question> questionList = new ArrayList<Question>();

    public Test(String type, int duration){

        this.type = type;
        this.duration = duration;
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
   
}
