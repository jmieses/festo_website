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

/**
 *
 * @author Cesarito
 */
@WebServlet(urlPatterns = {"/Festo_shapeObject"})
public class Festo_shapeObject extends HttpServlet {
        public static final double MAX_WEIGHT = 5;
        public static final double MAX_SPEED = 3;
        public static final double MAX_ACCELERATION = 5;
        public static final double MAX_XOFFSET = 100;
        public static final double MAX_YOFFSET = 100;
        public static final double MAX_ZOFFSET = 100;
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
    
    protected String checkShape(String shape) 
    throws ServletException, IOException{
        // This function stores the different shapes that the user can select.
        // Once a match has been made it returns a string page.  
        String[] shapesParallelGripper = {"Cylindrical", "cylindrical", "cylinder", "Cylinder",
                                                       "Rectangular","rectangular","Rectangle","rectangle"};
        
        String[] shapesThreePointGripper = {"Spherical", "spherical", "sphere", "Sphere"};
        
        for (String shapesParallelGripper1 : shapesParallelGripper) {
            if (shapesParallelGripper1.equals(shape)) {
                return "Festo_parallelGripper.jsp";
            }
        }
        for (String shapesThreePointGripper1 : shapesThreePointGripper) {
            if (shapesThreePointGripper1.equals(shape)) {
                return "Festo_threePointGripper.jsp";
            }
        }
    
        return "index.jsp";
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

       // String selectedShape = request.getParameter("shapeObject");
     
        double weight = Double.parseDouble(request.getParameter("weight"));
        double speed = Double.parseDouble(request.getParameter("speed"));
        double acceleration = Double.parseDouble(request.getParameter("acceleration"));
        double xOffset = Double.parseDouble(request.getParameter("x_component"));
        double yOffset = Double.parseDouble(request.getParameter("y_component"));
        double zOffset = Double.parseDouble(request.getParameter("z_component"));
        
        if(weight>MAX_WEIGHT){
            response.sendRedirect("index.jsp");
        }else if(speed > MAX_SPEED){
            response.sendRedirect("index.jsp");
        }else if(acceleration > MAX_ACCELERATION){
             response.sendRedirect("index.jsp");
        }else if(xOffset > MAX_XOFFSET){
             response.sendRedirect("index.jsp");
        }else if(yOffset > MAX_YOFFSET){
             response.sendRedirect("index.jsp");
        }else if(zOffset > MAX_ZOFFSET){
             response.sendRedirect("index.jsp");
        }
        
        String [][] msg = {
            {"Weight ","String.toString(weight)"}  
        };
      try{            
            String selectedShape = request.getParameter("shapeObject");
          switch (selectedShape) {
              case "Cylindrical":
                  response.sendRedirect("Festo_Cylinder_Properties.jsp");
                  break;
              case "Spherical":
                  response.sendRedirect("Festo_Spherical_Properties.jsp");
                  break;
              case "Rectangular":
                  response.sendRedirect("Festo_Rectangular_Properties.jsp");
                  break;
              case "Square":
                  response.sendRedirect("Festo_Square_Properties.jsp");
              default:
                  break;               
          }
      }catch(Exception e){
          e.printStackTrace();
      }
      
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
