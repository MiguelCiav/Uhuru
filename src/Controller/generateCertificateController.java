package Controller;
import Models.User;
import Models.Course;
import Views.swingComponents.CertificatePopUp;

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

    private static void getUserCourses(){
        User activeUser = User.getUserInstance();

        int []coursesID = activeUser.getCourses();
        for (int i=0; i<activeUser.getCoursesCount(); i++){
            courseList[i]=Course.getInstanceCourse(coursesID[i]);
        }
    }

    public static Course[] getUserCourseList (){
        return courseList;
    }



    //Puro pinche singleton

    //TODOS ESTATICOS
    //Obtenga la lista id de user
    //Obtenga los cursos desde la lista de id (Método de busqueda)
    //Retornar uno a uno los cursos y el numero de cursos aprobados.

    //Método para generar el certificado una vez activan el boton
}
