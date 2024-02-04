package Models;

import java.util.*;

public class User {

    private String name;
    private String lastName;
    private String eMail;
    private String password;
    private int []coursesID = new int[Course.MAX_COURSE];
    private int coursesCount = 0;

    public User(){

    }
    public User(String name, String lastName, String eMail, String password){
        
        this.name = name;
        this.lastName = lastName;
        this.eMail = eMail;
        this.password = password;
    }

    public void addCourse(int Id){
        if(coursesCount!=Course.MAX_COURSE){
            coursesID[coursesCount]=Id;
            coursesCount++;
        }
    }

    public int[] getCourses() {
        return coursesID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String geteMail() {
        return eMail;
    }

}
