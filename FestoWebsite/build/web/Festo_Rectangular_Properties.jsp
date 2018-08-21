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

    <p> Specified the parameters of the rectangular object </p>
    <br/>
    
        
       <form action="Festo_STL" method="post">
           <h3>Information about the object</h3>
        
        
     
        <label>Width:</label>
       <input type="number" name="width" min="1" max="100" value="1" step="any" >
       <input type="hidden" name="page" value="Rectangular">
       <span style="margin-left:10px;">mm</span><br/>
          
        <label>Length:</label>
 <input type="number" name="length" min="1" max="100" value="1" step="any">
                      <input type="hidden" name="page" value="Rectangular">
<span style="margin-left:10px;">mm</span><br/>
        
        <label>Thickness:</label>
        <input type="number" name="thickness" min="1" max="100" value="1" step="any">
               <input type="hidden" name="page" value="Rectangular">
<span style="margin-left:10px;">mm</span><br/>
        
      <label>&nbsp</label>
        <input type="submit" value="Submit" id="next"/>
      
       </form>
    </section>
    

    <jsp:include page="/includes/Festo_right_column.jsp"/>

    <jsp:include page="/includes/Festo_footer.jsp"/>
