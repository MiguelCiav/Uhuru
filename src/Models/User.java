package Models;

import java.util.*;

public class User {

    private String name;
    private String lastName;
    private String eMail;
    private String password;
    private ArrayList<Course> courses = new ArrayList<Course>();

    public User(String name, String lastName, String eMail, String password){
        
        this.name = name;
        this.lastName = lastName;
        this.eMail = eMail;
        this.password = password;
    }

    public void addCourse(Course course){
        courses.add(course);
    }
}
