package main.controllers;

import utils.JSONWriter;

public class AddNewUserController {
    private static AddNewUserController instance;

    private AddNewUserController(){

    }

    public AddNewUserController getInstance(){
        if(instance == null){
            instance = new AddNewUserController();
        }
        
        return instance;
    }

    public static void addUserToDatabase(String name, String lastname, String email, String pass){
        JSONWriter.addUser(name,lastname,email,pass);
    }
}
