/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cesarito
 */

import java.sql.*;

public class Festo_DB {
    public static void main(String[] args) throws Exception{
   try{
        String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "johnny";
            String query = "select * from employees where id=100";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("It is connected!");
            Statement statement = con.createStatement();
    
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            String name = rs.getString("first");
            
            System.out.println(name);
            statement.close();
            con.close();
   }catch(SQLException e){
       System.err.println(e);
   }
   }
    }       
    

