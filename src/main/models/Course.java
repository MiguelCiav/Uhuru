package main.models;

import java.util.*;

public class Course {

    public static final int MAX_COURSE = 4;
    private String ID;
    private String courseName;
    private ArrayList<Test> registerTest = new ArrayList<Test>();
    private static Course[] courseList = new Course[MAX_COURSE];
    private static int courseCount = 0;

    private Course(String courseName, String ID){      

        this.courseName = courseName;
        this.ID=ID;

    }

    public Test[] getTestArray(){
        return registerTest.toArray(new Test[0]);
    }
    
    public int amountOfTest(){
        return registerTest.size();
    }

    public static void loadTest(String courseID, Test test){
        getInstanceCourse(courseID).addTest(test);
    }

    public static void loadQuestion(String courseID, String testID, Question question){
        System.out.println("load en " + question.getQuestionID());
        getInstanceCourse(courseID).getTest(testID).addQuestion(question);
    }

    public static void loadAnswer(String courseID, String testID, String questionID, Answer answer){
        getInstanceCourse(courseID).getTest(testID).getQuestion(questionID).addAnswer(answer);
    }

    public static Course getInstanceCourse(String ID){

        for(int i = 0; i < MAX_COURSE; i++){
            if(courseList[i] != null && courseList[i].ID.equals(ID)){
                return courseList[i];
            }
        }

        return null;
    }

    public static void setInstanceCourse(String courseName, String ID){

        if(courseList[courseCount] == null && courseCount < MAX_COURSE){
            courseList[courseCount]= new Course(courseName, ID);
            courseCount++;
        }

    } 

    public static Course[] getCourseList(){
        return courseList;
    }

    public void addTest(Test test){
        registerTest.add(test);

        System.out.println("Examen " + test.getTestID() + " añadido a " + ID);
    }

    public Test getTest(String ID){
        
        for(int i = 0; i < registerTest.size(); i++){
            if(registerTest.get(i).getTestID().equals(ID)){
                return registerTest.get(i);
            }
        }

        return null;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getID() {
        return ID;
    }

}
