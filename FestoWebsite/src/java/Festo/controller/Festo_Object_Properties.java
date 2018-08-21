/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Festo.controller;

import Festo.business.Festo_STEP;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * @author cesar
 */
@WebServlet(name = "Festo_Object_Properties", urlPatterns = {"/Festo_Object_Properties"})
public class Festo_Object_Properties extends HttpServlet {

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
            out.println("<title>Servlet Festo_Object_Properties</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Festo_Object_Properties at " + request.getContextPath() + "</h1>");
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
    
    public static void CopyBinaryFileWithStreams(String input, String output){
        String sourceFile = input;
        String destFile = output;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        Path dirPath2 = Paths.get(output);
        Path dirPath = Paths.get(input);
        
        
        try{
            if(Files.notExists(dirPath2)){
            Files.createFile(dirPath2);
        }
       
        if(Files.notExists(dirPath)){
                    Files.createFile(dirPath);
        }
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);
            
            byte[] buffer = new byte[1024];
            int noOfBytes = 0;
            
            while((noOfBytes = fis.read(buffer))!=-1){
                fos.write(buffer,0,noOfBytes);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found" + e);
            
        }catch(IOException e){
            System.out.println("Exception while copying file: " + e);
        }finally{
            try{
                if(fis != null){
                    fis.close();
                }
                if(fos != null){
                    fos.close();
                }
            }catch(IOException e){
                System.out.println("Error while closing stream: " + e);
            }
        }    
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
          String parallelCylinderDesigns = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\STL_files\\CAD_STL_files\\Parallel_Cylindrical_Designs";
           try{            
            String page = request.getParameter("page");
          switch (page) {
              case "Cylinder":
                  //12mm_x_30mm.stl
                  String inputFileCylinder  = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\STL_files\\12mm_x_30mm.stl";
                      String outputFileCylinder = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\Copy_STL_files\\copy_12mm_x_30mm.stl";
                 double diameterCylinder = Double.parseDouble("diameter");
                 double lengthSpherical = Double.parseDouble("length");
                 if(diameterCylinder > 0 && diameterCylinder < 12){
                    CopyBinaryFileWithStreams(inputFileCylinder, outputFileCylinder);
                  response.sendRedirect("Festo_finger.jsp");

                 }else{
                     response.sendRedirect("Festo_Cylinder_Properties.jsp");
                 }
          
                  break;
              case "Spherical":
                  double diameterSpherical = Double.parseDouble(request.getParameter("diameter"));
             if(diameterSpherical > 0 && diameterSpherical < 10){
//                      String inputFileSpherical  = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\STL_files\\10mm_x_20mm.stl";
//                      String outputFileSpherical = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\Copy_STL_files\\copy_10mm_x_20mm.stl";
//                      CopyBinaryFileWithStreams(inputFileSpherical, outputFileSpherical);
                      response.sendRedirect("threePointFinger.jsp");
                  }else{
                      response.sendRedirect("Festo_Spherical_Properties.jsp");
                  }
                 
                  break;
              case "Rectangular":
                  //rec_a and rec_c
                  String inputFileRectangle  = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\STL_files\\10mm_x_20mm.stl";
                  String outputFilerectangle = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\Copy_STL_files\\copy_10mm_x_20mm.stl";


                  double widthRectangle = Double.parseDouble("width");
                  double lengthRectangle = Double.parseDouble("length");
                  double thicknessRectangle = Double.parseDouble("thickness");
                  if(lengthRectangle > 20 && lengthRectangle < 30){
                      
                  }
                  response.sendRedirect("Festo_finger.jsp");
                  break;
              case "Square":
                  response.sendRedirect("threePointFinger.jsp");
                  break;
              case "final_page":
                 // String inputFileSpherical  = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\STL_files\\10mm_x_20mm.stl";
                   //   String outputFileSpherical = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\Copy_STL_files\\copy_10mm_x_20mm.stl";
                      String inputFileSpherical  = ".\\FestoWebsite\\web\\STL_files\\10mm_x_20mm.stl";
                      String outputFileSpherical = ".\\FestoWebsite\\web\\Copy_STL_files\\copy_10mm_x_20mm.stl";
                      CopyBinaryFileWithStreams(inputFileSpherical, outputFileSpherical);
                      response.sendRedirect("Festo_Submitted.jsp");
                      Festo_STEP stp = new Festo_STEP("3d_three_point_finger.stp","output.stp");
                      double scale = Double.parseDouble(request.getParameter("scale"));
                      stp.newSTEPfile(scale);
              default:
                  break;               
          }
      }catch(Exception e){
          e.printStackTrace();
            }

}

}