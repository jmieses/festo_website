<%-- 
    Document   : Festo_gripperSize
    Created on : Jan 16, 2018, 5:03:16 PM
    Author     : Cesarito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/includes/Festo_header.jsp"/>
<jsp:include page="/includes/Festo_left_column_home.jsp"/>
<!DOCTYPE html>
<section>
    <div class="innerContent" id="gripperBox">
        <form action="Festo_gripperSize" method="post">
        Select a size: <br/>
        <select  name="gripperSize">
            <option value="6" selected>6</option>
            <option value="10" selected>10</option>
            <option value="16" selected>16</option>
            <option value="20" selected>20</option>
            <option value="25" selected>25</option>
            <option value="35" selected>35</option>
        </select>
        <input type="submit" value="Submit"/>
        </form>
    </div>

 <jsp:include page="/includes/Festo_footer.jsp"/>