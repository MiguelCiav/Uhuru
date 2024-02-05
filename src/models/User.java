package models;

import java.util.*;

import controllers.GenerateCertificateController;

public class User {

    private String name;
    private String lastName;
    private String eMail;
    private String password;
    private int []coursesID = new int[Course.MAX_COURSE];
    private int coursesCount = 0;
    private static User instance;

    private User(){}

    public static User getUserInstance (){
         if (instance == null){
            instance = new User();
        }
        return instance;
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

    public int getCoursesCount() {
        return coursesCount;
    }

    public String getPassword() {
        return password;
    }

}
