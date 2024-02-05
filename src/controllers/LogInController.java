package controllers;

import javax.swing.JTextArea;

import java.awt.Dimension;

import javax.swing.*;
import models.User;
import views.swingComponents.JFramePopUp;
import views.swingComponents.WrongPassword;
import views.useCaseFrames.TestListView;

public class LogInController{
    private static LogInController instance;

    public LogInController(){
    }

    public static void validateUser(JTextArea email, JTextArea password){
        FileReadingManager file = FileReadingManager.getFileReadingManagerCourse("src/DataBase/User.txt");

        if(!file.readUser(email.getText().toString())){
            new JFramePopUp(new WrongPassword(), new Dimension(650,300));
        }else{
            new TestListView();
        }
    }

    public static LogInController getInstance(){
        if(instance == null){
            instance = new LogInController();
        }

        return instance;
    }
}
