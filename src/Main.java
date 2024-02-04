import Views.useCaseFrames.TestListView;
import Controller.FileReadingManager;
import Models.User;

public class Main {
    public static void main (String args[]){
        //new TestListView();
        FileReadingManager file = new FileReadingManager("src/DataBase/User.txt");
        User usuario = file.readUser();
    }

}