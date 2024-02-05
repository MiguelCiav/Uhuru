import views.swingComponents.JFramePopUp;
import views.useCaseFrames.CreateTestView;
import views.useCaseFrames.TestListView;
import views.useCaseFrames.UserPopUps;
import controllers.FileReadingManager;
import models.User;

public class Main {
    public static void main (String args[]){
        
        FileReadingManager file = FileReadingManager.getFileReadingManagerCourse("src/DataBase/User.txt");
        User usuario = file.readUser("pablop@gmail.com");

        file.setPath("src/DataBase/Course.txt");
        file.readCourses();
        //new TestListView();
        new JFramePopUp(new UserPopUps(1));
        new JFramePopUp(new UserPopUps(2));
        new JFramePopUp(new UserPopUps(3));
        
    }
}