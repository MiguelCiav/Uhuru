package Controller;
import Models.Course;
import Models.User;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReadingManager {
    private BufferedReader buffer;
    private String Path;
    private User userData = new User();
    private Pattern regexString;
    private Matcher comparator;

    public FileReadingManager(String FilePath){
        Path=FilePath;
    }

    public User readUser(){
        try (FileReader file = new FileReader(Path)){
            buffer=new BufferedReader(file);
            String textLine;
            if((textLine=buffer.readLine())!=null){
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
            while ((textLine=buffer.readLine())!=null) {
                regexString = Pattern.compile("#(.*)" , Pattern.CASE_INSENSITIVE);
                comparator= regexString.matcher(textLine);
                if(comparator.find()){
                    userData.addCourse((Integer.valueOf(comparator.group(1))));
                }
                else{
                    System.out.println("Sin match");
                }
            }

            

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userData;
    }



}
