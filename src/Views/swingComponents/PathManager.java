package Views.swingComponents;

import javax.swing.*;
import java.awt.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class PathManager{
    private Path path = Paths.get("");
    String currentDirectory = path.toAbsolutePath().toString();
    String[] directoryArray;
    String directoryName ="";

    public PathManager(){
        path = Paths.get("");
        currentDirectory = path.toAbsolutePath().toString();
    }

    public String setFileLink(String relativePath){

        directoryArray = currentDirectory.split("\\\\");
        for(int i = 0; i < directoryArray.length; i++){
            directoryName += directoryArray[i]+ "\\";
            if(directoryArray[i].equals("ProyectoIS2023_Grupo_2")){
                break;
            }
        }
        directoryName += relativePath;

        return directoryName;
    }
}
