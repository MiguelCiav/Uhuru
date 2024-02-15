package test.controllers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import controllers.LogInController;

public class testLoginController {
    
    @Test public void testValidateUser(){

        LogInController.getInstance();
        Assertions.assertTrue(LogInController.validateUser("user", "user"));
    }
}