/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2016-02-17 23:27:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp_002dexamples;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Expressions_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\r\n");
      out.write("<!-- \r\n");
      out.write("Example of JSP Expressions. \r\n");
      out.write("   \r\n");
      out.write("Taken from Core Servlets and JavaServer Pages 2nd Edition\r\n");
      out.write("from Prentice Hall and Sun Microsystems Press,\r\n");
      out.write("http://www.coreservlets.com/.\r\n");
      out.write("(C) 2003 Marty Hall; may be freely used or adapted.\r\n");
      out.write("-->\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>JSP Expressions</TITLE>\r\n");
      out.write("<META NAME=\"keywords\"\r\n");
      out.write("      CONTENT=\"JSP,expressions,JavaServer Pages,servlets\">\r\n");
      out.write("<META NAME=\"description\"\r\n");
      out.write("      CONTENT=\"A quick example of JSP expressions.\">\r\n");
      out.write("<LINK REL=STYLESHEET\r\n");
      out.write("      HREF=\"JSP-Styles.css\"\r\n");
      out.write("      TYPE=\"text/css\">\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("<H2>JSP Expressions</H2>\r\n");
      out.write("<UL>\r\n");
      out.write("  <LI>Current time: ");
      out.print( new java.util.Date() );
      out.write("\r\n");
      out.write("  <LI>Server: ");
      out.print( application.getServerInfo() );
      out.write("\r\n");
      out.write("  <LI>Session ID: ");
      out.print( session.getId() );
      out.write("\r\n");
      out.write("  <LI>The <CODE>testParam</CODE> form parameter:\r\n");
      out.write("      ");
      out.print( request.getParameter("testParam") );
      out.write("\r\n");
      out.write("</UL>\r\n");
      out.write("</BODY></HTML>");
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
