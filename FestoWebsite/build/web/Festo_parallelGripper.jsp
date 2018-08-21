<%-- 
    Document   : Festo_gripper
    Created on : Jan 13, 2018, 3:18:36 PM
    Author     : Cesarito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/includes/Festo_header.jsp"/>
<jsp:include page="/includes/Festo_left_column_home.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <section class="column_center">
            <span ><img src="images/ParallelGripper.jpg"/>
               
                <a href="images/parallelGripper.pdf">PDF Drawing</a></span>
               
            <span  >
        <form action="Festo_gripperSize" method="post">
        Select a size: <br/>
        <select  name="gripperSize">
            
            <option selected="true" disabled="disable">Please select</option>
            
            <option value="6" selected>6</option>
            <option value="10" selected>10</option>
            <option value="16" selected>16</option>
            <option value="20" selected>20</option>
            <option value="25" selected>25</option>
            <option value="35" selected>35</option>
        </select>
        <input type="submit" value="Submit"/>
     
            </span>
        </form>
      
<jsp:include page="/includes/Festo_right_column.jsp"/>
<jsp:include page = "/includes/Festo_footer.jsp" />