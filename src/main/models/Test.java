package main.models;

import java.util.*;

public class Test {

    private String description;
    private String name;
    private int duration;
    private int calification;

    private ArrayList<Question> questionList = new ArrayList<Question>();
    private String testID;
    private String courseID;

    public Test(String name, String description, int duration, String testID){

        this.name = name;
        this.description = description;
        this.duration = duration;
        this.testID = testID;

    }

    public void calculateCalification(){

        int calculatedCalification = 0;

        for(Question question : questionList){

            

            if(approveQuestion(question)){
                calculatedCalification++;
            }

        }

        calification = calculatedCalification;

    }

    private boolean approveQuestion(Question question){

        Answer[] answerList = question.getAnswersArray();
        boolean approved = false;

        for(Answer answer : answerList){

            

            if(answer.isCorrect() && answer.isSelected()){
                approved = true;
            }
        }

        return approved;
        
    }

    public String[] getQuestionIDs(){

        String[] questionIDs = new String[questionList.size()];

        for(int i = 0; i < questionList.size(); i++){
            questionIDs[i] = questionList.get(i).getQuestionID();
        }

        return questionIDs;
    }

    public String[] getQuestionDescriptionsArray(){

        String[] questionDescriptions = new String[questionList.size()];

        for(int i = 0; i < questionList.size(); i++){
            questionDescriptions[i] = questionList.get(i).getStatement();
        }

        return questionDescriptions;

    }

    public void addQuestion(Question question){

        questionList.add(question);

    };

    public Question getQuestion(String questionID){
        Question foundQuestion = null;

        for(int i = 0; i < questionList.size(); i++){
            if (questionID.equals(questionList.get(i).getQuestionID())) {
                foundQuestion = questionList.get(i);
                return foundQuestion;
            }
        }  

        return null;
    };

    public int getQuestionsAmount(){
        return questionList.size();
    }

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

    public int getCalification() {
        return calification;
    }

    public String getTestID(){
        return testID;
    }

    public Object getType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }
   
}
