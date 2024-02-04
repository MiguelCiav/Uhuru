package Models;

import java.util.*;

public class Course {
    
    private String courseName;
    private boolean isApprovedCourse;
    private ArrayList<Test> registerTest = new ArrayList<Test>();

    public Course(String courseName){       
        this.courseName = courseName;
        isApprovedCourse = false;
    }

    public void addTest(Test test){
        registerTest.add(test);
    }

}
