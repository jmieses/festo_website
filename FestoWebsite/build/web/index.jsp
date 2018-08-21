<%-- 
    Document   : index
    Created on : Jan 12, 2018, 9:36:16 PM
    Author     : Cesarito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/includes/Festo_header.jsp"/>
<jsp:include page="/includes/Festo_left_column_home.jsp"/>


<!DOCTYPE html>

    

<section class="column_center">

    <p>This website provides different gripper types and gripper fingers based 
    on the shape of the object that you need to pick in your application.

    <br/>
    <br/>
    To begin, choose the shape of the object that you need to pick by the 
    gripper finger system:</p>
    <br/>
    
        
       <form action="Festo_shapeObject" method="post">
           <h3>Information about the object</h3>
        <label>Select a shape: </label>
       
        <select name="shapeObject">
            <option    value="Cylindrical">   Cylindrical </option>
            <option    value="Rectangular">   Rectangular </option>
            <option    value="Square">        Square      </option> 
            <option      value="Spherical">   Spherical   </option>
            
        </select>
        <br/>
        
     
        <label>Weight:</label>
       <input type="number" name="weight" min="1" max="5" value="1" step="any" >
       <span style="margin-left:10px;">kg</span><br/>
   
        <label>Speed:</label>
        <input type="number" name="speed" min="1" max="3" value="1" step="any">
        <span style="margin-left:10px;">m/s</span><br/>
        
        <label>Acceleration:</label>
        <input type="number" name="acceleration" min="1" max="5" value="1" step="any">
        <span style="margin-left:10px;">m/s^2</span><br/>
        <br/>
        <label><strong>Gripper offset X direction:</strong></label>
        <input type="number" name="x_component" min = "1" max="100" value="1" step="any">
        <span style="margin-left:10px;">mm</span><br/>
        
        <label><strong>Gripper offset Y direction:</strong></label>
        <input type="number" name="y_component" min ="1" max="100" value="1" step="any">
        <span style="margin-left:10px;">mm</span><br/>
        
        <label><strong>Gripper offset Z direction:</strong></label>
        <input type="number" name="z_component" min="1" max="100"  value="1" step="any ">
        <span style="margin-left:10px;">mm</span><br/>
        
        <label>&nbsp</label>
        <input type="submit" value="Submit" id="next"/>
       </form>
    </section>
    

    <jsp:include page="/includes/Festo_right_column.jsp"/>

    <jsp:include page="/includes/Festo_footer.jsp"/>
