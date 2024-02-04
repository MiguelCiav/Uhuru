package Models;

import java.util.*;

public class Course {
    public static final int MAX_COURSE=4;
    private int ID;
    private String courseName;
    private boolean isApprovedCourse;
    private ArrayList<Test> registerTest = new ArrayList<Test>();
    private static Course[] courseList = new Course[MAX_COURSE];
    private static int courseCount=0;

    private Course(String courseName, int ID){       
        this.courseName = courseName;
        this.ID=ID;
        isApprovedCourse = false;
    }

    public static Course getInstanceCourse(int ID){
        for(int i=0; i<MAX_COURSE; i++){
            if(courseList[i]!=null && courseList[i].ID==ID){
                return courseList[i];
            }
        }
        return null;
    }

    public static void setInstanceCourse(String courseName, int ID){
        if(courseList[courseCount]==null && courseCount<MAX_COURSE){
            courseList[courseCount]= new Course (courseName, ID);
            courseCount++;
        }
    } 

    public static Course[] getCourseList(){
        return courseList;
    }

    public void addTest(Test test){
        registerTest.add(test);
    }

    public String getCourseName() {
        return courseName;
    }

    public int getID() {
        return ID;
    }

}
