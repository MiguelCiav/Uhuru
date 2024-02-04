package views.swingComponents;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

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