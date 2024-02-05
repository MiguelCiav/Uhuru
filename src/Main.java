import views.useCaseFrames.CreateTestView;
import views.useCaseFrames.TestListView;
import controllers.FileReadingManager;
import models.User;

public class Main {
    public static void main (String args[]){
        
        FileReadingManager file = FileReadingManager.getFileReadingManagerCourse("src/DataBase/User.txt");
        User usuario = file.readUser("pablop@gmail.com");

        file.setPath("src/DataBase/Course.txt");
        file.readCourses();
        new TestListView();
        new CreateTestView();
        
    }
}