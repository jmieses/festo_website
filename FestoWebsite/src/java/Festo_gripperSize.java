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
@WebServlet(urlPatterns = {"/Festo_gripperSize"})
public class Festo_gripperSize extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
            String selectedSize = request.getParameter("gripperSize");
        switch(selectedSize){
            case "6":
                    response.sendRedirect("Festo_finger.jsp");
            case "10":
                    response.sendRedirect("Festo_finger.jsp");
            case "12":
                    response.sendRedirect("Festo_finger.jsp");
            case "20":
                    response.sendRedirect("Festo_finger.jsp");
            case "25":
                    response.sendRedirect("Festo_finger.jsp");
            case "35":
                    response.sendRedirect("Festo_finger.jsp"); 
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
