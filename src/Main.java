import views.useCaseFrames.*;
import views.swingComponents.*;
import controllers.FileReadingManager;
import models.User;

public class Main {
    public static void main (String args[]){
        
        //FileReadingManager file = FileReadingManager.getFileReadingManagerCourse("src/DataBase/User.txt");
        //User usuario = file.readUser("pablop@gmail.com");

        //file.setPath("src/DataBase/Course.txt");
        //file.readCourses();
        new MainFrame();
        //new TestListView();
        //new JFramePopUp(new LoginPopUp());
    }
}