/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2016-03-15 20:45:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Contact_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<center><img src=\"telecom.png\" alt=\"WideCast Telecom\" width=\"128\" height=\"128\"></center>\r\n");
      out.write("    <title>WideCast Cable</title> \r\n");
      out.write("\t <link rel=\"stylesheet\" type=\"text/css\" href=\"stylesheet.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"topright\">\r\n");
      out.write("<a href=\"Main.jsp\">Home&nbsp;</a>\r\n");
      out.write("<a href=\"About.jsp\">About Us&nbsp;</a>\r\n");
      out.write("<a href=\"Contact.jsp\">Contact Us&nbsp;</a>\r\n");
      out.write("<a href=\"http://www.tvguide.com/\">TV Guide</a>\r\n");
      out.write("</nav>\t\r\n");
      out.write("<H1 ALIGN=\"CENTER\">WideCast Cable</H1>\r\n");
      out.write("<H3 ALIGN=\"CENTER\"><i>We provide Entertainment for more</i></H3>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<H3 ALIGN=\"CENTER\">Contact Us</H3>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<p>\r\n");
      out.write("For technical support please contact us at 1-800-977-0316. \r\n");
      out.write("<br>\r\n");
      out.write("You may also e-mail us at: <a href=\"mailto:support@widecast.com?Subject=Customer Request/Incident\" target=\"_top\">support@widecast.com</a>\r\n");
      out.write("<br>\r\n");
      out.write("If you would like to open a service request, please contact one of our Customer Service Specialists. \r\n");
      out.write("<br>\t\r\n");
      out.write("</p>\r\n");
      out.write("<img src=\"contactus.png\" alt=\"contact\" width=\"200\" height=\"200\">\r\n");
      out.write("<br>\r\n");
      out.write("Customer Service is our #1 goal. Your satisfaction is important to us. \r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
