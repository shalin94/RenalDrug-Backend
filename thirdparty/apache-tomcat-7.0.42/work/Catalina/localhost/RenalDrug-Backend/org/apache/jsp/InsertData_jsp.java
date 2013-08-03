/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.42
 * Generated at: 2013-08-03 05:25:24 UTC
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

public final class InsertData_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      dao.FormData data = null;
      synchronized (session) {
        data = (dao.FormData) _jspx_page_context.getAttribute("data", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (data == null){
          data = new dao.FormData();
          _jspx_page_context.setAttribute("data", data, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("<HTML>\n");
      out.write("<BODY>\n");

	DBHelper db = DBHelper.getInstance();
	int status = db.insertData("medicines",data.getName(),null,null,null,db.getCurrentTimeStamp());
	String medicine_id = db.getID("medicines","medicine_name",data.getName());
	String[] dst_id = new String[9];
	String[] dst = new String[9];
	dst[0] = "1";
	dst[1] = data.getDst1();
	dst[2] = data.getDst2();
	dst[3] = data.getDst3();
	dst[4] = data.getDst4();
	dst[5] = data.getDst5();
	dst[6] = data.getDst6();
	dst[7] = data.getDst7();
	dst[8] = data.getDst8();
	String[] dv = new String[9];
	dv[0] = data.getDv1();
	dv[1] = data.getDv2();
	dv[2] = data.getDv3();
	dv[3] = data.getDv4();
	dv[4] = data.getDv5();
	dv[5] = data.getDv6();
	dv[6] = data.getDv7();
	dv[7] = data.getDv8();
	dv[8] = data.getDv9();
	String[] dt = new String[]{"1","2","2","2","3","3","3","3","3"};
	for(int i=0;i<9;i++){
		if(i==0)
		dst_id[i] = dst[i];
		else dst_id[i] = db.getID("dosage_sub_types","dosage_sub_type_description",dst[i]);
	}
	if (status == 0){
		out.println("<Center><h1>Unsuccessful in inserting: "+ data.getName() + " into medicines table</h1></center>");
	}
	for (int i=0;i<9;i++){
		status = db.insertData("medicine_dosage",medicine_id,dt[i],dst_id[i],dv[i],db.getCurrentTimeStamp());
		if(status == 0){
			out.println("<Center><h1>Unsuccessful in inserting data into medicine_dosage id: "+ i + " </h1></center>");
		}
	}
	if (status == 1){
		out.println("<TABLE border=\"0\" align=\"center\" cellpadding=\"10\">");
		out.println("<TR><TD align=\"center\" colspan=\"2\">Successful in Inserting the Following Data:</TD></TR>");
		out.println("<TR><TD>Medicine Name:</TD>");
		out.println("<TD>"+data.getName()+"</TD></TR>");
		out.println("<TR bgcolor=\"BLACK\"><TD align=\"center\"colspan=\"2\"><font color=\"WHITE\">Dose in Normal Renal Function:</font></TD></TR>");
		out.println("<TR><TD colspan=\"2\">"+dv[0]+"</TD></TR>");	
		out.println("<TR bgcolor=\"BLACK\"><TD align=\"center\"colspan=\"2\"><font color=\"WHITE\">Dose in Renal Impairment:</font></TD></TR>");
		for(int i=1;i<4;i++){
			out.println("<TR><TD>"+dst[i]+"</TD><TD>"+dv[i]+"</TD></TR>");
		}
		out.println("<TR bgcolor=\"BLACK\"><TD align=\"center\"colspan=\"2\"><font color=\"WHITE\">Dose in Renal Replacement Therapy:</font></TD></TR>");
		for(int i=4;i<9;i++){
			out.println("<TR><TD>"+dst[i]+"</TD><TD>"+dv[i]+"</TD></TR>");
		}
		out.println("</TABLE>");
	}

      out.write("\n");
      out.write("<CENTER>\n");
      out.write("<FORM METHOD=POST ACTION=\"form.jsp\">\n");
      out.write("<INPUT ALIGN=\"CENTER\"TYPE=\"SUBMIT\" VALUE=\"Insert new Medicine\">\n");
      out.write("</FORM>\n");
      out.write("</CENTER>\n");
      out.write("\n");
      out.write("<BODY>\n");
      out.write("</HTML>\n");
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
