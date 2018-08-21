package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Festo_005fSquare_005fProperties_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/includes/Festo_header.jsp", out, false);
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/includes/Festo_left_column_home.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("<section class=\"column_center\">\n");
      out.write("\n");
      out.write("    <p> Specified the parameters of the square object </p>\n");
      out.write("    <br/>\n");
      out.write("    \n");
      out.write("        \n");
      out.write("       <form action=\"Festo_STL\" method=\"post\">\n");
      out.write("           <h3>Information about the object</h3>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("     \n");
      out.write("        <label>Side: </label>\n");
      out.write("       <input type=\"number\" name=\"side\" min=\"1\" max=\"60\" value=\"1\" step=\"any\" >\n");
      out.write("       <span style=\"margin-left:10px;\">mm</span><br/>\n");
      out.write("          \n");
      out.write("       <label>Thickness: </label>\n");
      out.write("       <input type=\"number\" name=\"thickness\" min=\"1\" max=\"60\" value=\"1\" step=\"any\" >\n");
      out.write("       <input type=\"hidden\" name=\"page\" value=\"Square\">\n");
      out.write("\n");
      out.write("       <span style=\"margin-left:10px;\">mm</span><br/>\n");
      out.write("          \n");
      out.write("      \n");
      out.write("        \n");
      out.write("      <label>&nbsp</label>\n");
      out.write("        <input type=\"submit\" value=\"Submit\" id=\"next\"/>\n");
      out.write("      \n");
      out.write("       </form>\n");
      out.write("    </section>\n");
      out.write("    \n");
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/includes/Festo_right_column.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/includes/Festo_footer.jsp", out, false);
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
