<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/includes/Festo_header.jsp"/>
<jsp:include page="/includes/Festo_left_column_home.jsp"/>


       <section class="column_center">
                     

<br>
<br>
<form action="Festo_Object_Properties" method="post">
   <label>Scale demo STEP file:</label>
           <input type="number" name="scale" min ="1" max="5" value="1" step="any">

           <input type="hidden" name="page" value="final_page">

    <input  type="submit" value="Submit" id="next"/>
</form>
 </section>
 <jsp:include page="/includes/Festo_right_column.jsp"/>
    <jsp:include page="/includes/Festo_footer.jsp"/>