package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import models.Course;
import models.User;

public class JSONReader {

    private static JSONReader instance;
    private JSONArray list;
    
    private JSONReader(){

    }

    public static JSONReader getInstance(){

        if(instance == null){
            instance = new JSONReader();
        }

        return instance;

    }

    public void readCourses(){

        readFile("src/DataBase/Courses.json");
        
        for(Object object : list){

            JSONObject course = (JSONObject) object;
            String courseName = (String) course.get("courseName");
            int courseID = (int) course.get("courseID");

            Course.setInstanceCourse(courseName, courseID);

        }

    }

    public void readUser(String email, String password){

        readFile("src/DataBase/Users.json");
        
        for(Object object : list){

            JSONObject user = (JSONObject) object;
            String userEmail = (String) user.get("email");
            String userPassword = (String) user.get("password");

            if(userEmail.equals(email) && userPassword.equals(password)){

                User.getUserInstance().seteMail(userEmail);
                User.getUserInstance().setPassword(userPassword);

                String name = (String) user.get("name");
                User.getUserInstance().setName(name);

                String lastname = (String) user.get("lastname");
                User.getUserInstance().setLastName(lastname);

                JSONArray approvedCourses = (JSONArray) user.get("approvedCourses");
                readApprovedCourses(approvedCourses);

            }

        }

    }

    private void readApprovedCourses(JSONArray approvedCourses){

        for(Object object : approvedCourses){

            int courseID = Integer.valueOf(object.toString());
            User.getUserInstance().addCourse(courseID);

        }

    }

    public void readFile(String path){

        JSONParser jsonParser = new JSONParser();
        
        try(FileReader reader = new FileReader(path)){

            Object object = jsonParser.parse(reader);
            list = (JSONArray) object;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

    }

}
