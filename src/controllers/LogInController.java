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

    private LogInController(){
    }

    public static void validateUser(String email, String password){

        if(JSONReader.getInstance().readUser(email, password)){
            new TestListView();
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
