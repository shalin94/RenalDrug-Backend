/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2013-07-31 04:49:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public final class recent_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("<html>\n");
      out.write("\t<body>\n");
      out.write("\t\t<TABLE border = \"1\" align=\"center\" cellpadding=\"10\">\n");
      out.write("\t\t<TR>\n");
      out.write("\t\t\t<td><b>Medicine Name</b></td>\n");
      out.write("\t\t\t<td><b>Dosage Type</b></td>\n");
      out.write("\t\t\t<td><b>Dosage Sub Type</b></td>\n");
      out.write("\t\t\t<td><b>Dosage Value</b></td>\n");
      out.write("\t\t\t<td><b>Date Created</b></td>\n");
      out.write("\t\t\t<td><b>Date Modified</b></td>\n");
      out.write("\t\t</TR>\n");
      out.write("\t\t");

			DBHelper db = DBHelper.getInstance();
			List<Medicine> list = db.getRecentMedicines();
			for(int i=0;i<list.size();i++){
				Medicine med = list.get(i);
				out.println("<TR>");
				out.println("<td>"+med.getName()+"</td>");
				out.println("<td>"+med.getDosageType()+"</td>");
				out.println("<td>"+med.getDosageSubType()+"</td>");
				out.println("<td>"+med.getDosageValue()+"</td>");
				out.println("<td>"+med.getDateCreated()+"</td>");
				out.println("<td>"+med.getDateModified()+"</td>");
				out.println("</TR>");
			} 
		
      out.write("\n");
      out.write("\t\t</TABLE>\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
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
