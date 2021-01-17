package MiProyectoJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadFile {
    
    int i = 0;
    public String[] readFile(String filename) {        
        File fichero = new File(filename);
        Scanner s = null;
        String linea="";
        try {
            
            s = new Scanner(fichero);

            while (s.hasNextLine()) {
                    linea += s.nextLine()+" "; 	
            }
            String[] palabras = linea.split(" ");
            s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            return palabras;

        } catch (FileNotFoundException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            try {
                    if (s != null)
                            s.close();
            } catch (Exception ex2) {
                    System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
        return null;
    }

    String[] readFile(File file) {
        Scanner s = null;
        String linea="";
        try {
            
            s = new Scanner(file);

            while (s.hasNextLine()) {
                    linea += s.nextLine()+" "; 	
            }
            String[] palabras = linea.split(" ");

            return palabras;

        } catch (FileNotFoundException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            try {
                    if (s != null)
                            s.close();
            } catch (Exception ex2) {
                    System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
        return null;
    }
}
