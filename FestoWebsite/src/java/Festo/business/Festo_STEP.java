/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Festo.business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author cesar
 */
public class Festo_STEP {
   public static String originalFile;
   public static String newFile;
    public Festo_STEP(String originalFile, String newFile){
        this.originalFile = originalFile;
        this.newFile = newFile;
    }
    public static void copySTEPfile(String step1, String step2){
        // This method copy the step1 file to the a step2. 
        // I think step2 is overwritten with step1 in the 
        // case that step2 file has some info. 
        try{
        FileInputStream in = new FileInputStream(step1);
        FileOutputStream out = new FileOutputStream(step2);
        
        int c;
        while((c = in.read())!= -1){
            out.write(c);
        }
        in.close();
        out.close();
        
        }catch(IOException e){
        }
    }
    
    public static ArrayList<String> readBlockSTEPfile(String input){
            //This method reads and saved a block of strings from the STEP file
            // starting from line #267 to #318. These two numbers are hardcoded
            // should let the lines to be variables (if possible).
          // Start reading from the input file. 
           ArrayList<String> savedLines = new ArrayList<>();

          try{
          BufferedReader bufferedIn = new BufferedReader(new FileReader(input));
          
          String line = null;
          boolean check = false;
          
          while((line = bufferedIn.readLine())!= null){
               if(line.length()>4){
              String subline =  line.substring(1,4);
              //System.out.println(subline);
              if(subline.equals("267")){
                  check = true;
              }else if(subline.equals("318")){
                  check = false;
              }
              if(check)
              {
                  savedLines.add(line);
                  //System.out.println(line);
              }
               
                }
          }
          bufferedIn.close();
          }catch(IOException e){}
         
          return savedLines;
    }
    
    public static ArrayList<Double> getDoubleFromString(String t){
        // This get floats numbers representing the x y z coordinates
        // as enter by the input string. 
        Scanner scanString = new Scanner(t);
        // use delimiter to read double from string input. 
        scanString.useDelimiter("[,\\(\\)]");
        
        // store the numbers from the string.
        ArrayList<Double> storeDoubles = new ArrayList<>(); 
        
        while(true){
            if(scanString.hasNextInt()){
                scanString.nextInt();
            }else if(scanString.hasNextDouble()){
                storeDoubles.add(scanString.nextDouble());
            }else if(scanString.hasNext()){
                scanString.next();
            }else
                break;
        }
        return storeDoubles;
    }
    
    public static String setDoubleToString(ArrayList<Double> listDoubles, ArrayList<Double> scale, String str){
          int i;
          if(!listDoubles.isEmpty() && !scale.isEmpty()){ // check if the lists are not empty. 
            for(i = 0; i < listDoubles.size();i++){ // loop to scale the values. 
                listDoubles.set(i, scale.get(i)*listDoubles.get(i));
            }
          }
        // Find the index of the first comma.
            int indexOfStr = str.indexOf(',');
        //  get a substring before the comma. 
            String subStr = str.substring(0,indexOfStr);
            String newComponents = listDoubles.get(0) + "," + listDoubles.get(1) + "," + listDoubles.get(2);
            
            String newStr = subStr + ",(" + newComponents + "));";
            
            return newStr;
    }
    
    public static ArrayList<String> scaleSTEPfile(ArrayList<String> blockSTEPfile, double number){
        
        ArrayList <ArrayList<Double>> floatComponents = new ArrayList<>();
        ArrayList<String> newSTEPblock = new ArrayList<>();
        String tempString;
        ArrayList <Double> scales = new ArrayList<>();
//        scales.add(2.);
//        scales.add(2.);
//        scales.add(2.);
        scales.add(number);
        scales.add(number);
        scales.add(number);
        for(int i = 0; i < blockSTEPfile.size(); i++){
            ArrayList <Double> temp = new ArrayList<>();
            temp = getDoubleFromString(blockSTEPfile.get(i));
 
            floatComponents.add(temp);
        }
        for(int i = 0; i < blockSTEPfile.size();i++){
        tempString = setDoubleToString(floatComponents.get(i),scales,blockSTEPfile.get(i));
        newSTEPblock.add(tempString);
        }
        return newSTEPblock;
        
    }
    
    public static void insertBlockToFile(ArrayList<String> originalFile, ArrayList<String> newBlockFile){
        int i;
        String subString = null;
        boolean check = false;
        int index = 0;
        for(i=0; i< originalFile.size();i++){
            if(originalFile.get(i).length()>4){
                subString = originalFile.get(i).substring(0,4);
            }
            
            if(subString.equals("#267")){
                check = true;
            }else if(subString.equals("#318")){
                check = false;
            }
            
            if(check){
                originalFile.set(i,newBlockFile.get(index));
                index++;
            }
        }
      
    }
    
    public static void newSTEPfile(double number){
           try{
        //String input = originalFile;
       // String output = newFile;
        String input = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\3d_three_point_finger.stp";
        String output = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\output.stp";
        Path dirPath2 = Paths.get(output);
        Path dirPath = Paths.get(input);
        
        if(Files.notExists(dirPath2)){
            Files.createFile(dirPath2);
        }
       
        if(Files.notExists(dirPath)){
                    Files.createFile(dirPath);
        }
        
        BufferedReader file = new BufferedReader(new FileReader(input));
       
        String line; 
        ArrayList<String> originalSTEPfile = new ArrayList<>();
        ArrayList<String> blockSTEPfile = new ArrayList<>();
        ArrayList<String> newSTEPblock = new ArrayList<>();
        while((line = file.readLine())!= null){
            originalSTEPfile.add(line);
        }
        
        blockSTEPfile = readBlockSTEPfile(input);
        newSTEPblock = scaleSTEPfile(blockSTEPfile, number);
            
        insertBlockToFile(originalSTEPfile,newSTEPblock);
        
        for(String str:originalSTEPfile)
            System.out.println(str);
        file.close();
     
       
           
        PrintWriter out = new PrintWriter(
                          new BufferedWriter(
                          new FileWriter(output)));
        for(String str:originalSTEPfile)
        out.println(str);
        out.close();
           }catch(IOException e){
           System.out.println(e);
           }
                 
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
       double number = 2.;
     newSTEPfile(number);
       // System.out.println(inputStr.size());
       
    }
}
