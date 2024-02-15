package main.controllers;

import java.awt.Dimension;

import main.views.components.JFramePopUp;
import main.views.components.WrongPassword;
import main.views.frames.LoginFrame;
import main.views.frames.TestListView;
import utils.JSONReader;

public class LogInController{

    private static LogInController instance;

    private LogInController(){
    }

    public static void validateUser(String email, String password){

        if(JSONReader.getInstance().readUser(email, password)){
            JSONReader.getInstance().readCourses();
            new TestListView();
            LoginFrame.getInstance().disposeFrame();
        } else {
            new JFramePopUp(new WrongPassword(), new Dimension(650,300));
        }

    }

    public static LogInController getInstance(){
        if(instance == null){
            instance = new LogInController();
        }

        return instance;
    }
}
