package MiProyectoJava;

import java.io.File;

/**
 *
 * @author Zeida
 */
public class ReadDirectory {
    
    public File[] readDirectory(String filename) {        
        String path = filename;

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();


        return listOfFiles;
    }
    
}
