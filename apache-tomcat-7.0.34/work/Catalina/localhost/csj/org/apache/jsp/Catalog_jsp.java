/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2016-02-18 12:59:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Catalog_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("import java.io.*;\r\n");
      out.write("\r\n");
      out.write("public class Catalog\r\n");
      out.write("{\r\n");
      out.write("   public static void CatalogItem(String [] args)\r\n");
      out.write("   {\r\n");
      out.write("      items DroidMAXX = new items();\r\n");
      out.write("      DroidMAXX.itemID = \"DroidMAXX\";\r\n");
      out.write("      DroidMAXX.shortDescription = \"Droid MAXX, US version (Gold) - by Motorola\";\r\n");
      out.write("      DroidMAXX.longDescription = \"Take your phone to the Maxx! It comes with charger and a headset. Made in China.\";\r\n");
      out.write("      DroidMAXX.cost = 239.95;\r\n");
      out.write("      \r\n");
      out.write("\t  items MotoX = new items();\r\n");
      out.write("      MotoX.itemID = \"MotoX\";\r\n");
      out.write("      MotoX.shortDescription = \"Moto X, 2016 version (Black) - by Motorola\";\r\n");
      out.write("      MotoX.longDescription = \"There is no phone like it! It comes with charger and bluetooth headset. Made in China.\";\r\n");
      out.write("      MotoX.cost = 149.99;\r\n");
      out.write("\t  \r\n");
      out.write("      try\r\n");
      out.write("      {\r\n");
      out.write("         FileOutputStream fileOut =\r\n");
      out.write("         new FileOutputStream(\"/tmp/items.ser\");\r\n");
      out.write("         ObjectOutputStream out = new ObjectOutputStream(fileOut);\r\n");
      out.write("         out.writeObject(e);\r\n");
      out.write("         out.close();\r\n");
      out.write("         fileOut.close();\r\n");
      out.write("         System.out.printf(\"Serialized data is saved in /tmp/items.ser\");\r\n");
      out.write("      }catch(IOException i)\r\n");
      out.write("      {\r\n");
      out.write("          i.printStackTrace();\r\n");
      out.write("      }\r\n");
      out.write("   }\r\n");
      out.write("}");
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