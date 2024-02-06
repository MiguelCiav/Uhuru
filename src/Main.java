
import controllers.JSONReader;
import models.Course;
import views.useCaseFrames.*;

public class Main {
    public static void main (String args[]){
        
        JSONReader.getInstance().readCourses();

        String name = Course.getInstanceCourse("0").getTest("00").getName();

        String name2 = Course.getInstanceCourse("2").getTest("21").getName();

        System.out.println(name);
        System.out.println(name2);


    }
}