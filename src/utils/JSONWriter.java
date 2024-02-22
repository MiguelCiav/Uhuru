package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONWriter {
    
    private static JSONWriter instance;
    private JSONArray[] list = new JSONArray[4];

    private JSONWriter(){}

    @SuppressWarnings("unchecked")
    public static void addUser(String name, String lastname, String email, String password){

        JSONWriter.getInstance().readActualInfo(PathManager.getInstance().getStringURL("/src/data/Users.json"), 0);

        JSONObject user = new JSONObject();
        user.put("name", name);
        user.put("lastname", lastname);
        user.put("email", email);
        user.put("password", password);
        user.put("approvedCourses", "");

        
        JSONWriter.getInstance().list[0].add(user);
        JSONWriter.getInstance().writeNewInfo(PathManager.getInstance().getStringURL("/src/data/Users.json"), 0);

    }

    @SuppressWarnings("unchecked")
    public static void addTest(String description, int duration, String courseID, String testID, String testName){

        JSONWriter.getInstance().readActualInfo(PathManager.getInstance().getStringURL("/src/data/Tests.json"), 0);

        JSONObject test = new JSONObject();
        test.put("courseID", courseID);
        test.put("testID", testID);
        test.put("description", description);
        test.put("duration", duration);
        test.put("testName", testName);

        JSONWriter.getInstance().list[0].add(test);
        JSONWriter.getInstance().writeNewInfo(PathManager.getInstance().getStringURL("/src/data/Tests.json"), 0);

    }

    @SuppressWarnings("unchecked")
    public static void addQuestion(String testID, String questionID, String statement, String code, String imageURL, String questionType, String domain){

        JSONWriter.getInstance().readActualInfo(PathManager.getInstance().getStringURL("/src/data/Questions.json"), 0);

        JSONObject test = new JSONObject();
        test.put("testID", testID);
        test.put("questionID", questionID);
        test.put("statement", statement);
        test.put("code", code);
        test.put("imageURL", imageURL);
        test.put("questionType", questionType);
        test.put("domain", domain);

        JSONWriter.getInstance().list[0].add(test);
        JSONWriter.getInstance().writeNewInfo(PathManager.getInstance().getStringURL("/src/data/Questions.json"), 0);

    }

    @SuppressWarnings("unchecked")
    public static void addAnswer(String statement, String justification, Boolean isCorrect){

        JSONWriter.getInstance().readActualInfo(PathManager.getInstance().getStringURL("/src/data/Answers.json"), 0);

        JSONObject answer = new JSONObject();
        answer.put("statement", statement);
        answer.put("justification", justification);
        answer.put("isCorrect", isCorrect);

        JSONWriter.getInstance().list[0].add(answer);
        JSONWriter.getInstance().writeNewInfo(PathManager.getInstance().getStringURL("/src/data/Answers.json"), 0);

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
