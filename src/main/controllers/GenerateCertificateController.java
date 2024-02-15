package main.controllers;
import main.models.Course;
import main.models.User;
import utils.GenerateCertificate;

public class GenerateCertificateController {
    private static GenerateCertificateController instance;
    public static Course[] courseList = new Course[Course.MAX_COURSE];

    private GenerateCertificateController(){}

    public static GenerateCertificateController getInstace(){
        if (instance == null){
            instance = new GenerateCertificateController();
            getUserCourses();
        }
        return instance;
    }

    private static void getUserCourses(){;

        String [] coursesID = User.getUserInstance().getCourses();
        

        for (int i = 0; i < User.getUserInstance().getCoursesCount(); i++){
            courseList[i] = Course.getInstanceCourse(coursesID[i]);
        }

    }

    public static Course[] getUserCourseList (){
        return courseList;
    }

    public static void generatePDF(String inputcourse){
        User activeUser = User.getUserInstance();
        GenerateCertificate PDF = new GenerateCertificate(activeUser.getName(), activeUser.getLastName(), "Febrero 2024", inputcourse);
        PDF.newPDF();
    }
}
