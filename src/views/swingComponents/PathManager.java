package views.swingComponents;

import java.io.File;

public class PathManager{

    public PathManager(){}

    public String setFileLink(String relativePath){

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

        return directoryName;
    }
}