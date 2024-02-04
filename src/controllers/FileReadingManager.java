package controllers;
import models.Course;
import models.User;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReadingManager {
    private BufferedReader buffer;
    private String Path;
    private User userData = User.getUserInstance();
    private Pattern regexString;
    private Matcher comparator;
    private static FileReadingManager instance;

    private FileReadingManager(String FilePath){
        Path=FilePath;
    }

    public static FileReadingManager getFileReadingManagerCourse (String FilePath){
        if (instance == null){
            instance = new FileReadingManager(FilePath);
            return instance;
        }
        else{
            instance.setPath(FilePath);
            return instance;
        }
    }

    public User readUser(String email){
        try (FileReader file = new FileReader(Path)){
            buffer=new BufferedReader(file);
            String textLine;
            while ((textLine=buffer.readLine())!=null) {            
               //lectura de email
                regexString = Pattern.compile("@(\\w*)@(gmail.com|hotmail.com|outlook.com)" , Pattern.CASE_INSENSITIVE);
                comparator= regexString.matcher(textLine);

                if(comparator.find() && email.equals(comparator.group(1)+"@"+comparator.group(2))){
                    userData.seteMail(comparator.group(1)+"@"+comparator.group(2));
                    System.out.println(userData.geteMail());
                    
                    textLine=buffer.readLine();
                    readUserPassword(textLine);

                    textLine=buffer.readLine();
                    readUserName(textLine);

                    readUserCourseId(textLine);
                    int []aux=userData.getCourses();
                    for(int i=0; i<userData.getCoursesCount(); i++){
                        System.out.println(aux[i]);
                    }
                    file.close();
                    return userData;
                }
                
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }

    private void readUserPassword(String textLine){
        regexString = Pattern.compile("&(.*)" , Pattern.CASE_INSENSITIVE);
        comparator= regexString.matcher(textLine);
    }

    private void readUserName(String textLine){
        regexString = Pattern.compile("(\\w*)-(\\w*)" , Pattern.CASE_INSENSITIVE);
        comparator= regexString.matcher(textLine);
        if(comparator.find()){
            userData.setName(comparator.group(1));
            userData.setLastName(comparator.group(2));
            System.out.println(userData.getName() + ", " + userData.getLastName());
        }
        else{
            System.out.println("Sin match");
        }
    }

    private void readUserCourseId (String textLine){
        try {
            while ((textLine=buffer.readLine())!=null) {
                regexString = Pattern.compile("#(\\d*)" , Pattern.CASE_INSENSITIVE);
                comparator= regexString.matcher(textLine);
                if(comparator.find()){
                    userData.addCourse((Integer.valueOf(comparator.group(1))));
                }
                else{
                    return;
                }
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readCourses(){
        try (FileReader file = new FileReader(Path)){
            buffer=new BufferedReader(file);
            String textLine;
            while ((textLine=buffer.readLine())!=null) {     
               regexString = Pattern.compile("&([\\w\\s]*)#(\\d*)" , Pattern.CASE_INSENSITIVE);
               comparator= regexString.matcher(textLine);

                if(comparator.find()){
                    Course.setInstanceCourse(comparator.group(1), Integer.valueOf(comparator.group(2)));
                }
                else{
                    System.out.println("Sin match");
                }
            }

            for (int i=0; i<Course.MAX_COURSE; i++){
                System.out.println((Course.getCourseList())[i].getCourseName() + "id:"+ (Course.getCourseList())[i].getID());
            }
            
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPath(String path) {
        Path = path;
    }
    
}
