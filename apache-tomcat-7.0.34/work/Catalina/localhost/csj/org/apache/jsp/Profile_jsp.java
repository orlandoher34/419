/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2016-03-10 16:19:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Profile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<center><img src=\"telecom.png\" alt=\"Hercom Telecom\" width=\"128\" height=\"128\"></center>\r\n");
      out.write("    <title>Customer Profile</title> \r\n");
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
      out.write("<H3 ALIGN=\"CENTER\">Customer Profile</H3>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<a href=Profile.jsp>Account Profile&nbsp;|</a>\r\n");
      out.write("\t\t\t\t<a href=Pay.jsp>&nbsp;Pay my bill&nbsp;|</a>\r\n");
      out.write("\t\t\t\t<a href=Orderppv.jsp>&nbsp;Order a PPV&nbsp;|</a>\r\n");
      out.write("\t\t\t\t<a href=Cancelppv.jsp>&nbsp;Cancel a PPV&nbsp;|</a>\r\n");
      out.write("\t\t\t\t<a href=Manageaccount.jsp>&nbsp;Manage my TV/Internet plan</a>\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("Please review your account information and update if necessary. \r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("Update account information here:\r\n");
      out.write("<br>\r\n");
      out.write("<br>\r\n");
      out.write("<!--\r\n");
      out.write("The customer's address should be listed here from a hashmap maybe?\r\n");
      out.write("Name\r\n");
      out.write("Address\r\n");
      out.write("City\r\n");
      out.write("State\r\n");
      out.write("Zip code\r\n");
      out.write("tel#\r\n");
      out.write("email address\r\n");
      out.write("Credit card#\r\n");
      out.write("\r\n");
      out.write("There should be a button here to update the address and once clicked it should let the customer update everything except the name. \r\n");
      out.write("A button will let a user save the changes and be redirected to this page again to see the new changes. \r\n");
      out.write("-->\r\n");
      out.write(" \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
