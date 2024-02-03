package Views.swingComponents;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class PathManager{
    private Path path = Paths.get("");
    private String currentDirectory;
    private String directoryName ="";
    //private File filePath = new File(path.toAbsolutePath().toString());
    private File filePath = new File(System.getProperty("user.dir"));

    PathManager(){
        currentDirectory = filePath.getParentFile().toString();
        System.out.println(currentDirectory);
    }

    public String setFileLink(String relativePath){

        directoryName += relativePath;

        return directoryName;
    }
}