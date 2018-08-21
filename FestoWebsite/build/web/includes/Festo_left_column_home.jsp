<%-- 
    Document   : Festo_left_column_home
    Created on : Jan 14, 2018, 10:17:31 PM
    Author     : Cesarito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="row">
    <aside id="sidebarA">
    <nav>
      <ul style="font-size: 12px">
          <li><a href="<c:url value='index.jsp' />">
                  Home</a></li>
          <li><a href="<c:url value='Festo_catalog.jsp' />">
                  Browse Catalog</a></li>
          <li><a href="<c:url value='#' />">
                  Join Email List</a></li>
          <li><a href="<c:url value='Festo_scale_step.jsp' />">
                  STEP file demo</a></li>
      </ul>
    </nav>
</aside>

