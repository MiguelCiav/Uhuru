package controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import views.swingComponents.PathManager;

public class JSONWriter {
    
    private static JSONWriter instance;
    private JSONArray[] list = new JSONArray[4];

    private JSONWriter(){}

    @SuppressWarnings("unchecked")
    public static void addUser(String name, String lastname, String email, String password){

        JSONWriter.getInstance().readActualInfo(PathManager.getInstance().getStringURL("/src/DataBase/Users.json"), 0);

        System.out.println("Cargando datos");

        JSONObject user = new JSONObject();
        user.put("name", name);
        user.put("lastname", lastname);
        user.put("email", email);
        user.put("password", password);

        JSONWriter.getInstance().list[0].add(user);
        JSONWriter.getInstance().writeNewInfo(PathManager.getInstance().getStringURL("/src/DataBase/Users.json"), 0);

    }

    @SuppressWarnings("unchecked")
    public static void addTest(String type, int duration, String courseID, String testID, String testName){

        JSONWriter.getInstance().readActualInfo(PathManager.getInstance().getStringURL("/src/DataBase/Tests.json"), 0);

        JSONObject test = new JSONObject();
        test.put("type", type);
        test.put("duration", duration);
        test.put("courseID", courseID);
        test.put("testID", testID);
        test.put("testName", testName);

        JSONWriter.getInstance().list[0].add(test);
        JSONWriter.getInstance().writeNewInfo(PathManager.getInstance().getStringURL("/src/DataBase/Tests.json"), 0);

    }

    @SuppressWarnings("unchecked")
    public static void addQuestion(String testID, String questionID, String description, String justification, String questionType){

        JSONWriter.getInstance().readActualInfo(PathManager.getInstance().getStringURL("/src/DataBase/Questions.json"), 0);

        JSONObject test = new JSONObject();
        test.put("testID", testID);
        test.put("questionID", questionID);
        test.put("description", description);
        test.put("justification", justification);
        test.put("questionType", questionType);

        JSONWriter.getInstance().list[0].add(test);
        JSONWriter.getInstance().writeNewInfo(PathManager.getInstance().getStringURL("/src/DataBase/Questions.json"), 0);

    }

    @SuppressWarnings("unchecked")
    public static void addAnswer(String answerText, String answerType, Boolean isCorrect){

        JSONWriter.getInstance().readActualInfo(PathManager.getInstance().getStringURL("/src/DataBase/Answers.json"), 0);

        JSONObject answer = new JSONObject();
        answer.put("answerText", answerText);
        answer.put("answerType", answerType);
        answer.put("isCorrect", isCorrect);

        JSONWriter.getInstance().list[0].add(answer);
        JSONWriter.getInstance().writeNewInfo(PathManager.getInstance().getStringURL("/src/DataBase/Answers.json"), 0);

    }

    public static JSONWriter getInstance(){

        if(instance == null){
            instance = new JSONWriter();
        }

        return instance;
    }

    private void writeNewInfo(String path, int listIndex){

        try(FileWriter file = new FileWriter(path)){
            
            file.write(list[listIndex].toJSONString());
            file.flush();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    private void readActualInfo(String path, int listIndex){

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
