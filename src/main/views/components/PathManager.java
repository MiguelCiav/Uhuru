package main.views.components;

import java.io.File;

public class PathManager{

    private static PathManager instance;
    private String userDirectory = System.getProperty("user.dir");

    private PathManager(){}

    public static PathManager getInstance(){

        if(instance == null){
            instance = new PathManager();
        }

        return instance;
    }

    public String getStringURL(String relativePath){
        
        String directoryName = "";
        String[] relativePathArray = relativePath.split("/");

        for(int i = 0; i < relativePathArray.length; i++){
            if(i == relativePathArray.length - 1){
                directoryName += relativePathArray[i];
            }
            else{
                directoryName += relativePathArray[i] + File.separator;
            }
        }

        return userDirectory + directoryName;

    }
}