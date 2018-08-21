<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/includes/Festo_header.jsp"/>
<jsp:include page="/includes/Festo_left_column_home.jsp"/>


       <section class="column_center">
                       <span ><img src="images/threePointFingerSTL.JPG"/></span>

            <a href="images/10mm_x_20mmdrawing.pdf" target="_blank">PDF Drawing</a>
      
<br>
<br>
<form action="Festo_Object_Properties" method="post">
    <!--<label></label>
    <input type="number" name="number" />-->
           <input type="hidden" name="page" value="final_step">

    <input  type="submit" value="Submit" id="next"/>
</form>
 </section>
 <jsp:include page="/includes/Festo_right_column.jsp"/>
    <jsp:include page="/includes/Festo_footer.jsp"/>