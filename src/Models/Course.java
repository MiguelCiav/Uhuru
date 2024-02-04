package Models;

import java.util.*;

public class Course {
    public static final int MAX_COURSE=4;
    private int ID;
    private String courseName;
    private boolean isApprovedCourse;
    private ArrayList<Test> registerTest = new ArrayList<Test>();
    private static Course[] courseList = new Course[MAX_COURSE];

    private Course(String courseName, int ID){       
        this.courseName = courseName;
        isApprovedCourse = false;
    }

    public static Course getInstanceCourse(int ID){
        for(int i=0; i<4; i++){
            if(courseList[i]!=null && courseList[i].ID==ID){
                return courseList[i];
            }
        }
        return null;
    }

    public static void setInstanceCourse(String courseName, int ID){
        for(int i=0; i<4; i++){
            if(courseList[i]==null){
                courseList[i]= new Course (courseName, ID);
            }
        }
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
