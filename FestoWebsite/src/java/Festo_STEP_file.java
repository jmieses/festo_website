/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;

/**
 *
 * @author cesar
 */
@WebServlet(urlPatterns = {"/Festo_STEP_file"})
public class Festo_STEP_file extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Festo_STEP_file</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Festo_STEP_file at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public static void copySTEPfile(String step1, String step2){
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
              String subline =  line.substring(0,4);
              //System.out.println(subline);
              if(subline.equals("#267")){
                  check = true;
              }else if(subline.equals("#318")){
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
   public static void main(String args[]) throws IOException{
   
       FileOutputStream test = null;
       
       String inputFile = "3d_three_point_finger.stp";
       String outputFile = "3d_three_point_finger_modified.stp";
       
       copySTEPfile(inputFile,outputFile);
       ArrayList<String> blockSTEPfile = readBlockSTEPfile(outputFile); 
       ArrayList<Double> listDouble = new ArrayList<>();
       
//       for(String str:blockSTEPfile)
//           System.out.println(str);

        String sentence = blockSTEPfile.get(25);
        System.out.println(sentence);
        listDouble = getDoubleFromString(sentence);
        
        for(Double t:listDouble)
            System.out.println(t);

   }
}
