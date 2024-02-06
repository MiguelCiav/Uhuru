package controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import models.Course;
import models.Test;
import models.User;

public class JSONReader {

    private static JSONReader instance;
    private JSONArray[] list = new JSONArray[4];
    
    private JSONReader(){}

    public static JSONReader getInstance(){

        if(instance == null){
            instance = new JSONReader();
        }

        return instance;

    }

    public void readCourses(){

        readFile("src/DataBase/Courses.json", 0);
        
        for(Object object : list[0]){

            JSONObject course = (JSONObject) object;
            String courseName = (String) course.get("courseName");
            String courseID = (String) course.get("courseID");

            Course.setInstanceCourse(courseName, courseID);

            readTest(courseID);

        }

    }

    @SuppressWarnings("unused")
    public void readTest(String courseID){

        readFile("src/DataBase/Tests.json", 1);

        for(Object object : list[1]){

            JSONObject test = (JSONObject) object;
            String testID = (String) test.get("testID");
            String courseTestID = (String) test.get("courseID");

            if(courseTestID.equals(courseID)){

                String testName = (String) test.get("testName");
                String type = (String) test.get("type");
                int duration = Integer.valueOf(test.get("duration").toString());

                Test loadedTest = new Test(testName,type,duration,testID);
                Course.getInstanceCourse(courseID).addTest(loadedTest);

                readQuestions(testID);

            }
        }

    }

    private void readQuestions(String testID){

        readFile("src/DataBase/Questions.json", 2);

        for(Object object : list[2]){

            JSONObject question = (JSONObject) object;
            String questionID = (String) question.get("questionID");
            String questionTestID = (String) question.get("testID");

            if(questionTestID.equals(testID)){

                readAnswers(questionID);

            }
        }

    }

    private void readAnswers(String questionID){

        readFile("src/DataBase/Answers.json", 3);

        for(Object object : list[3]){

            JSONObject answer = (JSONObject) object;
            String answerID = (String) answer.get("answerID");
            String answerQuestionID = (String) answer.get("questionID");

            if(answerQuestionID.equals(questionID)){
                
            }
        }

    }

    public boolean readUser(String email, String password){

        readFile("src/DataBase/Users.json",0);
        
        for(Object object : list[0]){

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

                return true;

            }

        }

        return false;
    }

    private void readApprovedCourses(JSONArray approvedCourses){

        for(Object object : approvedCourses){

            String courseID = object.toString();
            User.getUserInstance().addCourse(courseID);

        }

    }

    private void readFile(String path, int listIndex){

        JSONParser jsonParser = new JSONParser();
        
        try(FileReader reader = new FileReader(path)){

            Object object = jsonParser.parse(reader);

            list[listIndex] = (JSONArray) object;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

    }

}
