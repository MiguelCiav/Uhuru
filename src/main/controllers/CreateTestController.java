package main.controllers;

import utils.JSONWriter;

public class CreateTestController {

    private static CreateTestController instance;
    
    private CreateTestController(){}

    public static CreateTestController getInstance(){

        if(instance == null){
            instance = new CreateTestController();
        }

        return instance;
    }

    public static boolean validateData(String testName, String testDescription, String minutes){

        if(validateTestName(testName)){
            return false;
        }
        
        else if(validateTestDescription(testDescription)){
            return false;
        }
        else if(validateMinutes(minutes)){
            return false;
        }

        JSONWriter.getInstance();
        JSONWriter.addTest(testDescription, Integer.parseInt(minutes), "1", "1", testName);

        return true;
    }

    public static boolean validateTestName(String testName){
        if(testName.equals("Ingrese el nombre del examen.") || testName.equals("ERROR: Dato invalido") || testName.matches("\s*")){
            return true;
        }
        return false;
    }

    public static boolean validateTestDescription(String testDescription){
        if(testDescription.equals("Ingrese la descripcion del examen.") || testDescription.equals("ERROR: Dato invalido") || testDescription.matches("\s*")){
            return true;
        }
        return false;
    }

    public static boolean validateMinutes(String minutes){
        if(!minutes.matches("\\d+")){
            return true;
        }

        return false;
    }

}
