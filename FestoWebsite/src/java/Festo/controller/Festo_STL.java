 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Festo.controller;

import Festo.business.Festo_STEP;
import Festo.business.SendEmail;
import static Festo.business.SendEmail.sendFromGMail;
import static Festo.controller.Festo_Object_Properties.CopyBinaryFileWithStreams;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

/**
 *
 * @author cesar
 */
@WebServlet(name = "Festo_STL", urlPatterns = {"/Festo_STL"})
public class Festo_STL extends HttpServlet {

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
            out.println("<title>Servlet Festo_STL</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Festo_STL at " + request.getContextPath() + "</h1>");
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
        doPost(request, response);
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
        //processRequest(request, response);
        
         String parallelCylinderDesigns = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\STL_files\\CAD_STL_files\\Parallel_Cylindrical_Designs";
           try{            
            String page = request.getParameter("page");
          switch (page) {
              case "Cylinder":
                  //12mm_x_30mm.stl
                  String inputFileCylinder  = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\Cad Files\\Parallel Cylindrical Designs\\";
                  String baseOutputFileCylinder = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\build\\web\\Copy_STL_files\\Copy Parallel Cylindrical Designs\\";
                
                    String copySTL = "copy_12mm_x_30mm.stl";
                    List<String> stlFileNamesCylinder = Arrays.asList("copy_12mm_x_30mm.stl","copy_12mm_x_60mm.stl" ,"copy_12mm_x_90mm.stl","copy_12mm_x_120mm.stl",
                    "copy_16mm_x_30mm.stl","copy_16mm_x_60mm.stl","copy_16mm_x_90mm.stl","copy_12mm_x_120mm.stl",
                    "copy_20mm_x_30mm.stl","copy_20mm_x_60mm.stl","copy_20mm_x_90mm.stl","copy_20mm_x_120mm.stl",
                    "copy_24mm_x_30mm.stl","copy_24mm_x_60mm.stl","copy_24mm_x_90mm.stl","copy_24mm_x_120mm.stl",
                    "copy_28mm_x_30mm.stl","copy_28mm_x_60mm.stl","copy_28mm_x_90mm.stl","copy_28mm_x_120mm.stl",
                    "copy_32mm_x_30mm.stl","copy_32mm_x_60mm.stl","copy_32mm_x_90mm.stl","copy_32mm_x_120mm.stl",
                    "copy_40mm_x_30mm.stl","copy_40mm_x_60mm.stl","copy_40mm_x_90mm.stl","copy_40mm_x_120mm.stl",
                    "copy_48mm_x_30mm.stl","copy_48mm_x_60mm.stl","copy_48mm_x_90mm.stl","copy_48mm_x_120mm.stl",
                    "copy_55mm_x_30mm.stl","copy_55mm_x_60mm.stl","copy_55mm_x_90mm.stl","copy_55mm_x_120mm.stl");
                    
                    
                    String totalOutputFile = baseOutputFileCylinder + copySTL;
                  double diameterCylinder = Double.parseDouble(request.getParameter("diameterCylinder"));
                 double lengthCylinder = Double.parseDouble(request.getParameter("lengthCylinder"));
                // int j = 0;
                 if(diameterCylinder > 0 && diameterCylinder < Double.parseDouble(stlFileNamesCylinder.get(0).substring(5,7))){
                   CopyBinaryFileWithStreams(inputFileCylinder + stlFileNamesCylinder.get(0).substring(5), baseOutputFileCylinder + stlFileNamesCylinder.get(0));  
                  sendFromGMail("STL file", baseOutputFileCylinder + stlFileNamesCylinder.get(0),stlFileNamesCylinder.get(0));  
                   response.sendRedirect("Festo_finger.jsp");

                 }else{
                 for(int i = 1; i < stlFileNamesCylinder.size(); i ++){
                     if(diameterCylinder > Double.parseDouble(stlFileNamesCylinder.get(i-1).substring(5,7))&& diameterCylinder < Double.parseDouble(stlFileNamesCylinder.get(i).substring(5,7))){
                        for(int j = 1; j < stlFileNamesCylinder.size();j++){
                            if(lengthCylinder > Double.parseDouble(stlFileNamesCylinder.get(j-1).substring(12,14))&& lengthCylinder < Double.parseDouble(stlFileNamesCylinder.get(j).substring(12,14))){
                            CopyBinaryFileWithStreams(inputFileCylinder + stlFileNamesCylinder.get(j).substring(5), baseOutputFileCylinder + stlFileNamesCylinder.get(j));  
                            sendFromGMail("STL file", baseOutputFileCylinder + stlFileNamesCylinder.get(j),stlFileNamesCylinder.get(j));  
                           
                          response.sendRedirect("Festo_finger.jsp");
                            break;
                         } 
                        }
                     }
                 }
                 }
                 

                 
//                 if(diameterCylinder> 0 && diameterCylinder < 12){
//                     if(lengthCylinder > 0 && lengthCylinder < 30){
//                         CopyBinaryFileWithStreams(inputFileCylinder, baseOutputFileCylinder + copySTL);
//                  response.sendRedirect("Festo_finger.jsp");
//                     }else if(lengthCylinder > 30 && lengthCylinder < 60){
//                         CopyBinaryFileWithStreams(inputFileCylinder, baseOutputFileCylinder + copySTL);
//                  response.sendRedirect("Festo_finger.jsp");
//                     }
//                 }else{
//                     response.sendRedirect("Festo_Cylinder_Properties.jsp");
//                 }
          
                  break;
              case "Spherical":
                  double diameterSpherical = Double.parseDouble(request.getParameter("diameter"));
                  
                   List<String> stlFileNamesSpherical = Arrays.asList("copy_12mm_x_30mm.stl","copy_12mm_x_60mm.stl" ,"copy_12mm_x_90mm.stl","copy_12mm_x_120mm.stl",
                    "copy_16mm_x_30mm.stl","copy_16mm_x_60mm.stl","copy_16mm_x_90mm.stl","copy_12mm_x_120mm.stl",
                    "copy_20mm_x_30mm.stl","copy_20mm_x_60mm.stl","copy_20mm_x_90mm.stl","copy_20mm_x_120mm.stl",
                    "copy_24mm_x_30mm.stl","copy_24mm_x_60mm.stl","copy_24mm_x_90mm.stl","copy_24mm_x_120mm.stl",
                    "copy_28mm_x_30mm.stl","copy_28mm_x_60mm.stl","copy_28mm_x_90mm.stl","copy_28mm_x_120mm.stl",
                    "copy_32mm_x_30mm.stl","copy_32mm_x_60mm.stl","copy_32mm_x_90mm.stl","copy_32mm_x_120mm.stl",
                    "copy_40mm_x_30mm.stl","copy_40mm_x_60mm.stl","copy_40mm_x_90mm.stl","copy_40mm_x_120mm.stl",
                    "copy_48mm_x_30mm.stl","copy_48mm_x_60mm.stl","copy_48mm_x_90mm.stl","copy_48mm_x_120mm.stl",
                    "copy_55mm_x_30mm.stl","copy_55mm_x_60mm.stl","copy_55mm_x_90mm.stl","copy_55mm_x_120mm.stl");
                      String inputFileSpherical  = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\build\\web\\Cad Files\\3 - Point Spherical Object Designs\\";
                      String baseOutputFileSpherical = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\build\\web\\Copy_STL_files\\Copy 3 - Point Spherical Object Designs\\";

             if(diameterSpherical > 0 && diameterSpherical < 12){
                      CopyBinaryFileWithStreams(inputFileSpherical + stlFileNamesSpherical.get(0).substring(5), baseOutputFileSpherical + stlFileNamesSpherical.get(0));
                      response.sendRedirect("threePointFinger.jsp");
                  }else{
             for(int i = 1; i < stlFileNamesSpherical.size();i++){
             if(diameterSpherical > Double.parseDouble(stlFileNamesSpherical.get(i-1).substring(5,7))&& diameterSpherical < Double.parseDouble(stlFileNamesSpherical.get(i).substring(5,7))){
                      CopyBinaryFileWithStreams(inputFileSpherical + stlFileNamesSpherical.get(i), baseOutputFileSpherical + stlFileNamesSpherical.get(i));
                      response.sendRedirect("threePointFinger.jsp");
             }
             }
             }
              break;   
              case "Rectangular":
                  //rec_a and rec_c
                  //response.sendRedirect("Festo_finger.jsp");

                   List<String> stlFileNamesRectangular = Arrays.asList("copy_12mm_x_30mm.stl","copy_12mm_x_60mm.stl" ,"copy_12mm_x_90mm.stl","copy_12mm_x_120mm.stl",
                    "copy_16mm_x_30mm.stl","copy_16mm_x_60mm.stl","copy_16mm_x_90mm.stl","copy_12mm_x_120mm.stl",
                    "copy_20mm_x_30mm.stl","copy_20mm_x_60mm.stl","copy_20mm_x_90mm.stl","copy_20mm_x_120mm.stl",
                    "copy_24mm_x_30mm.stl","copy_24mm_x_60mm.stl","copy_24mm_x_90mm.stl","copy_24mm_x_120mm.stl",
                    "copy_28mm_x_30mm.stl","copy_28mm_x_60mm.stl","copy_28mm_x_90mm.stl","copy_28mm_x_120mm.stl",
                    "copy_32mm_x_30mm.stl","copy_32mm_x_60mm.stl","copy_32mm_x_90mm.stl","copy_32mm_x_120mm.stl",
                    "copy_40mm_x_30mm.stl","copy_40mm_x_60mm.stl","copy_40mm_x_90mm.stl","copy_40mm_x_120mm.stl",
                    "copy_48mm_x_30mm.stl","copy_48mm_x_60mm.stl","copy_48mm_x_90mm.stl","copy_48mm_x_120mm.stl",
                    "copy_55mm_x_30mm.stl","copy_55mm_x_60mm.stl","copy_55mm_x_90mm.stl","copy_55mm_x_120mm.stl");
                   
                  String inputFileRectangle  = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\build\\web\\Cad Files\\Rectangular Object Designs\\";
                  String baseOutputFileRectangle = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\build\\web\\Copy_STL_files\\Copy Rectangular Object Designs\\";


                  double widthRectangle = Double.parseDouble(request.getParameter("width"));
                  double lengthRectangle = Double.parseDouble(request.getParameter("length"));
                  double thicknessRectangle = Double.parseDouble("thickness");
                  if(widthRectangle > 0 && widthRectangle < 12){
                  CopyBinaryFileWithStreams(inputFileRectangle + stlFileNamesRectangular.get(0).substring(5), baseOutputFileRectangle + stlFileNamesRectangular.get(0));  
                    response.sendRedirect("Festo_finger.jsp");
                  }else{
                      for(int i = 1; i < stlFileNamesRectangular.size(); i ++){
                     if(widthRectangle > Double.parseDouble(stlFileNamesRectangular.get(i-1).substring(5,7))&& widthRectangle < Double.parseDouble(stlFileNamesRectangular.get(i).substring(5,7))){
                        for(int j = 1; j < stlFileNamesRectangular.size();j++){
                            if(lengthRectangle > Double.parseDouble(stlFileNamesRectangular.get(j-1).substring(12,14))&& lengthRectangle < Double.parseDouble(stlFileNamesRectangular.get(j).substring(12,14))){
                            CopyBinaryFileWithStreams(inputFileRectangle + stlFileNamesRectangular.get(j).substring(5), baseOutputFileRectangle + stlFileNamesRectangular.get(j));  
                            response.sendRedirect("Festo_finger.jsp");
                            break;
                         } 
                       }
                     }
                   }
                 }
                  
                  break;
              case "Square":
                      List<String> stlFileNamesSquare = Arrays.asList("copy_12mm_x_30mm.stl","copy_12mm_x_60mm.stl" ,"copy_12mm_x_90mm.stl","copy_12mm_x_120mm.stl",
                    "copy_16mm_x_30mm.stl","copy_16mm_x_60mm.stl","copy_16mm_x_90mm.stl","copy_12mm_x_120mm.stl",
                    "copy_20mm_x_30mm.stl","copy_20mm_x_60mm.stl","copy_20mm_x_90mm.stl","copy_20mm_x_120mm.stl",
                    "copy_24mm_x_30mm.stl","copy_24mm_x_60mm.stl","copy_24mm_x_90mm.stl","copy_24mm_x_120mm.stl",
                    "copy_28mm_x_30mm.stl","copy_28mm_x_60mm.stl","copy_28mm_x_90mm.stl","copy_28mm_x_120mm.stl",
                    "copy_32mm_x_30mm.stl","copy_32mm_x_60mm.stl","copy_32mm_x_90mm.stl","copy_32mm_x_120mm.stl",
                    "copy_40mm_x_30mm.stl","copy_40mm_x_60mm.stl","copy_40mm_x_90mm.stl","copy_40mm_x_120mm.stl",
                    "copy_48mm_x_30mm.stl","copy_48mm_x_60mm.stl","copy_48mm_x_90mm.stl","copy_48mm_x_120mm.stl",
                    "copy_55mm_x_30mm.stl","copy_55mm_x_60mm.stl","copy_55mm_x_90mm.stl","copy_55mm_x_120mm.stl");
                   
                  String inputFileSquare  = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\build\\web\\Cad Files\\Rectangular Object Designs\\";
                  String baseOutputFileSquare = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\build\\web\\Copy_STL_files\\Copy Square Object\\";
                  double side = Double.parseDouble(request.getParameter("side"));
                  
                   if(side > 0 && side < 12){
                      CopyBinaryFileWithStreams(inputFileSquare + stlFileNamesSquare.get(0).substring(5), baseOutputFileSquare + stlFileNamesSquare.get(0));
                      response.sendRedirect("Festo_finger.jsp");
                  }else{
             for(int i = 1; i < stlFileNamesSquare.size();i++){
             if(side > Double.parseDouble(stlFileNamesSquare.get(i-1).substring(5,7))&& side< Double.parseDouble(stlFileNamesSquare.get(i).substring(5,7))){
                      CopyBinaryFileWithStreams(inputFileSquare + stlFileNamesSquare.get(i), baseOutputFileSquare + stlFileNamesSquare.get(i));
                      response.sendRedirect("Festo_finger.jsp");
             }
             }
             }
                  
              
                  break;
              case "final_step":
                   //inputFileSpherical  = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\STL_files\\10mm_x_20mm.stl";
                     // String outputFileSpherical = "C:\\Users\\cesar\\repos\\senior_design\\FestoWebsite\\web\\Copy_STL_files\\copy_10mm_x_20mm.stl";
                      //CopyBinaryFileWithStreams(inputFileSpherical, outputFileSpherical);
                      response.sendRedirect("Festo_Submitted.jsp");
                      Festo_STEP stp = new Festo_STEP("3d_three_point_finger.stp","output.stp");
                     // stp.newSTEPfile(2.);
              default:
                  break;               
          }
   
           }catch(Exception e){
          e.printStackTrace();
            }
    }

  
}
