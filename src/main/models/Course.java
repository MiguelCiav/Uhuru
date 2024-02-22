package main.models;

import java.util.*;

public class Course {

    public static final int MAX_COURSE = 4;
    private String ID;
    private String courseName;
    private ArrayList<Test> testList = new ArrayList<Test>();
    private static Course[] courseList = new Course[MAX_COURSE];
    private static int courseCount = 0;

    private Course(String courseName, String ID){      

        this.courseName = courseName;
        this.ID=ID;

    }

    public static Course getInstanceCourse(String ID){

        for(int i = 0; i < MAX_COURSE; i++){
            if(courseList[i] != null && courseList[i].ID.equals(ID)){
                return courseList[i];
            }
        }

        return null;
    }

    public Test[] getTestArray(){
        return testList.toArray(new Test[0]);
    }

    public static Test[] getTestArray(String courseID){
        return getInstanceCourse(courseID).getTestArray();
    }

    public Test getTest(String testID){
        
        for(int i = 0; i < testList.size(); i++){
            if(testList.get(i).getTestID().equals(testID)){
                return testList.get(i);
            }
        }

        return null;
    }

    public static Test getTest(String courseID, String testID){
        return getInstanceCourse(courseID).getTest(testID);
    }
    
    public int amountOfTest(){
        return testList.size();
    }

    public static int amountOfTest(String courseID){
        return getInstanceCourse(courseID).amountOfTest();
    }

    public static void loadTest(String courseID, Test test){
        getInstanceCourse(courseID).addTest(test);
    }

    public static void loadQuestion(String courseID, String testID, Question question){
        getInstanceCourse(courseID).getTest(testID).addQuestion(question);
    }

    public static void loadAnswer(String courseID, String testID, String questionID, Answer answer){
        getInstanceCourse(courseID).getTest(testID).getQuestion(questionID).addAnswer(answer);
    }

    public static void setInstanceCourse(String courseName, String ID){

        if(courseList[courseCount] == null && courseCount < MAX_COURSE){
            courseList[courseCount]= new Course(courseName, ID);
            courseCount++;
        }

    } 

    public static Course[] getCourseArray(){
        return courseList;
    }

    public void addTest(Test test){
        testList.add(test);
    }

    public String getCourseName() {
        return courseName;
    }

    public String getID() {
        return ID;
    }

}
