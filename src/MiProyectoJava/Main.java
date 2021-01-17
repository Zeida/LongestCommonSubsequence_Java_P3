package MiProyectoJava;

import LongestCommonSubsequence.*;
import java.io.File;
import java.util.Arrays;
import org.apache.commons.cli.*;

public class Main {

    public static void main(String[] args) {

        Options options = new Options();

        Option help = new Option("h", "help", false, "Show help message");
        options.addOption(help);
        
        //Dataset options
        Option cmd_f = new Option("f", "file", true, "Input data from a file");
        cmd_f.setArgName("filename");
        options.addOption(cmd_f);
        
        Option cmd_d = new Option("d", "directory", true, "Input data from a directory");
        cmd_d.setArgName("directory");
        options.addOption(cmd_d);
        
        
        
        //Estrategies
        Option cmd_sm = new Option("sm", "Memoization");
        options.addOption(cmd_sm);
        Option cmd_st = new Option("st", "Tabulation");
        options.addOption(cmd_st);
        
        //Options
        Option cmd_check = new Option("check", "Check Solutions_Is the same solution in tabulation and memoization?");
        options.addOption(cmd_check);
        Option cmd_show = new Option("show", "Show the content of the file");
        options.addOption(cmd_show);
        Option cmd_input = new Option("input", "Allow to introduce the words on the console");
        options.addOption(cmd_input);
        Option cmd_t = new Option("t", "time", false, "Display time in seconds");
        options.addOption(cmd_t);
        Option cmd_lcs = new Option("lcs", "Show the longest common subsequence");
        options.addOption(cmd_lcs);
        
        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();
        
        
        long inicio;
        long fin;
        String [] data = null;
        File [] path ;
        
        try {
            CommandLine cmd = parser.parse(options, args);
            
            if (cmd.hasOption("help") || cmd.hasOption("h")) {
                formatter.printHelp( "The Longest Common Subsequence Problem (Not required to occupy consecutive positions) options:","", options,"", true );
                System.exit(0);
            }
            
            if (cmd.hasOption("f")) {
                ReadFile input = new ReadFile();
                data = input.readFile(cmd.getOptionValue("f"));
                boolean lcscontrol=false;
                if (cmd.hasOption("sm")){
                    if (cmd.hasOption("lcs")) {
                        lcscontrol=true;
                    }

                    inicio = System.currentTimeMillis();
                    System.out.println("################### Memoization solution #####################");
                    int solsm = LCS_Memoization.lcs(data[0], data[1], lcscontrol);
                    System.out.println("The longest common subsequence has size: " + Integer.toString(solsm));
                    fin = System.currentTimeMillis();
                    

                    if (cmd.hasOption("t")){
                        double tiempo = (double) (fin - inicio)/1000;  
                        System.out.println("Memoization: " + tiempo + " seconds");
                    }

                    System.out.println("#############################################################");
                    System.out.println("\n");
                }

                if (cmd.hasOption("st")) {
                    inicio = System.currentTimeMillis();
                    int m=data[0].length();
                    int n=data[1].length();
                    int[][] LCS_ST= new int[m+1][n+1];
                    int sol = LCS_Tabulation.LCSLength(data[0], data[1], m, n, LCS_ST);
                    fin = System.currentTimeMillis();
                    System.out.println("################### Tabulation solution #####################");
                    if (cmd.hasOption("lcs")) {
                        String lcs=LCS_Tabulation.LCS(data[0], data[1], m, n, LCS_ST);
                                System.out.println("The LCS is: " + lcs);
                    }
                    System.out.println("The longest common subsequence has size: " + sol);
                    if (cmd.hasOption("t")){
                        double tiempo = (double) (fin - inicio)/1000;  
                        System.out.println("Tabulation: " + tiempo + " seconds");
                    }

                    System.out.println("#############################################################");
                    System.out.println("\n");
                } 
            }
            
            if (cmd.hasOption("d")) {
                ReadDirectory dir = new ReadDirectory();
                path = dir.readDirectory(cmd.getOptionValue("d"));
                ReadFile input = new ReadFile();
                
                for(File file: path){
                    data=input.readFile(file);
                    boolean lcscontrol=false;
                    if (cmd.hasOption("sm")){ 
                        if (cmd.hasOption("lcs")) {
                            lcscontrol=true;
                        }
                        inicio = System.currentTimeMillis();
                        System.out.println("################### Memoization solution #####################");
                        int solsm = LCS_Memoization.lcs(data[0], data[1], lcscontrol);
                        System.out.println("Memoization solution of "+ file.getName() +" has size: " + Integer.toString(solsm));
                        fin = System.currentTimeMillis();
                        if (cmd.hasOption("t")){
                            double tiempo = (double) (fin - inicio)/1000;  
                            System.out.println("Memoization: " + tiempo + " seconds");
                            
                        }
                        System.out.println("#############################################################");
                        System.out.println("\n");
                    }
            
                    if (cmd.hasOption("st")) {
                        inicio = System.currentTimeMillis();
                        int m=data[0].length();
                        int n=data[1].length();
                        int[][] LCS_ST = new int[m+1][n+1];
                        int sol = LCS_Tabulation.LCSLength(data[0], data[1], m, n, LCS_ST);
                        fin = System.currentTimeMillis();
                        System.out.println("################### Tabulation solution #####################");
                        if (cmd.hasOption("lcs")) {
                            String lcs=LCS_Tabulation.LCS(data[0], data[1], m, n, LCS_ST);
                                    System.out.println("The LCS is: " + lcs);
                        }
                        System.out.println("Solution of "+ file.getName() +" has size: " + sol);
                        if (cmd.hasOption("t")){
                            double tiempo = (double) (fin - inicio)/1000;  
                            System.out.println("Tabulation: " + tiempo + " seconds");
                        }

                        System.out.println("############################################################");
                        System.out.println("\n");
                    }
                }
            }
            if (cmd.hasOption("show")) {
                System.out.println("##### ... El contenido del fichero es el siguiente: ... #####");
                System.out.println(Arrays.toString(data));
                System.out.println("##############################################################");
                System.out.println("\n");
            }
            
            if (cmd.hasOption("input")) {
                String auxiliar="";
                System.out.println("Enter the first word:");
                auxiliar += System.console().readLine();
                System.out.println("Enter the second word:");
                auxiliar += " "+ System.console().readLine();
                data = auxiliar.split(" ");
                boolean lcscontrol=false;
                if (cmd.hasOption("sm")){
                    if (cmd.hasOption("lcs")) {
                            lcscontrol=true;
                    }
               
                    inicio = System.currentTimeMillis();
                    System.out.println("################### Memoization solution #####################");
                    int solsm = LCS_Memoization.lcs(data[0], data[1], lcscontrol);
                    System.out.println("The longest common subsequence has size: " + Integer.toString(solsm));
                    fin = System.currentTimeMillis();
                    
                    
                  
                    
                    if (cmd.hasOption("t")){
                        double tiempo = (double) (fin - inicio)/1000;  
                        System.out.println("Memoization: " + tiempo + " seconds");
                    }
                  
                    
                    System.out.println("#############################################################");
                    System.out.println("\n");
                }

                if (cmd.hasOption("st")) { 
                    inicio = System.currentTimeMillis();
                    int m=data[0].length();
                    int n=data[1].length();
                    int[][] LCS = new int[m+1][n+1];
                    int sol = LCS_Tabulation.LCSLength(data[0], data[1], m, n, LCS);
                    fin = System.currentTimeMillis();
                    System.out.println("################### Tabulation solution #####################");
                    if (cmd.hasOption("lcs")) {
                        String lcs=LCS_Tabulation.LCS(data[0], data[1], m, n, LCS);
                                System.out.println("The LCS is: " + lcs);
                    }
                    System.out.println("The longest common subsequence has size: " + sol);
                    if (cmd.hasOption("t")){
                        double tiempo = (double) (fin - inicio)/1000;  
                        System.out.println("Tabulation: " + tiempo + " seconds");
                    }


                    System.out.println("#############################################################");
                    System.out.println("\n");
                }
            }
            
            
            if (cmd.hasOption("check")) {
                int m=data[0].length();
                int n=data[1].length();
                int[][] LCS_ST = new int[m+1][n+1];
                int soltabulation = LCS_Tabulation.LCSLength(data[0], data[1], m, n, LCS_ST);
                boolean lcscontrol = false;
                int solmemoization = LCS_Memoization.lcs(data[0], data[1], lcscontrol);
                if(soltabulation == solmemoization){
                    System.out.println("##########################CHECK##############################");
                    System.out.println("Tabulation and Memoization has the same solution. ");
                    System.out.println("Memoization solution is: " + solmemoization);
                    System.out.println("and Tabulation solution is: " + soltabulation);
                    System.out.println("#############################################################");
                }else{
                    System.out.println("Solutions dont match. There must be a mistake.");
                }
                
            }
            
        } catch (ParseException e) {
            System.out.println("Parsing failed. Reason: " + e.getMessage());
            formatter.printHelp("utility-name", options, true);
            System.exit(1);
        }
    }    
}
