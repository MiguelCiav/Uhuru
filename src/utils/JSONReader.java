package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import main.models.Answer;
import main.models.Course;
import main.models.Question;
import main.models.Test;
import main.models.User;

public class JSONReader {

    private static JSONReader instance;
    private JSONArray[] list = new JSONArray[4];
    private String actualCourseID;
    private String actualTestID;
    private String actualQuestionID;
    
    private JSONReader(){}

    public static JSONReader getInstance(){

        if(instance == null){
            instance = new JSONReader();
        }

        return instance;

    }

    public void readCourses(){

        readFile(PathManager.getInstance().getStringURL("/src/data/Courses.json"), 0);
        
        for(Object object : list[0]){

            JSONObject course = (JSONObject) object;
            String courseName = (String) course.get("courseName");
            actualCourseID = (String) course.get("courseID");

            Course.setInstanceCourse(courseName, actualCourseID);

            readTest();

        }

    }

    @SuppressWarnings("unused")
    public void readTest(){

        readFile(PathManager.getInstance().getStringURL("/src/data/Tests.json"), 1);

        for(Object object : list[1]){

            JSONObject test = (JSONObject) object;
            String courseTestID = (String) test.get("courseID");
            actualTestID = (String) test.get("testID");

            if(courseTestID.equals(actualCourseID)){

                String description = (String) test.get("description");
                int duration = Integer.valueOf(test.get("duration").toString());
                String testName = (String) test.get("testName");
                Test loadedTest = new Test(testName,description,duration,actualTestID);

                Course.loadTest(actualCourseID, loadedTest);

                readQuestions();

            }
        }

    }

    private void readQuestions(){

        readFile(PathManager.getInstance().getStringURL("/src/data/Questions.json"), 2);

        for(Object object : list[2]){

            JSONObject question = (JSONObject) object;
            String questionTestID = (String) question.get("testID");
            actualQuestionID = (String) question.get("questionID");
            String questionStatement = (String) question.get("statement");
            String questionCode = (String) question.get("code");
            String imageURL = (String) question.get("imageURL");
            String questionType = (String) question.get("questionType");
            String domain = (String) question.get("domain");

            if(questionTestID.equals(actualTestID)){

                Question loadedQuestion = new Question(questionStatement, questionCode, questionType, domain,Integer.valueOf(questionType),actualQuestionID,questionTestID);
                
                Course.loadQuestion(actualCourseID, questionTestID, loadedQuestion);
                readAnswers();

            }
        }

    }

    private void readAnswers(){

        readFile(PathManager.getInstance().getStringURL("/src/data/Answers.json"), 3);

        for(Object object : list[3]){

            JSONObject answer = (JSONObject) object;
            String answerID = (String) answer.get("answerID");
            String answerQuestionID = (String) answer.get("questionID");
            String statement = (String) answer.get("statement");
            String justification = (String) answer.get("justification");
            String isCorrect = (String) answer.get("isCorrect");

            if(answerQuestionID.equals(actualQuestionID)){
                
                Answer loadedAnswer = new Answer(answerText,Integer.valueOf(answerType),isCorrect,answerID,answerQuestionID,justification);

                Course.loadAnswer(actualCourseID, actualTestID, actualQuestionID, loadedAnswer);
                
            }
        }

    }

    public boolean readUser(String email, String password){

        readFile(PathManager.getInstance().getStringURL("/src/data/Users.json"),0);
        
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
