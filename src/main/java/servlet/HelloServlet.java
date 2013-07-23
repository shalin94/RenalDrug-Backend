package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.sql.*;
import javax.servlet.*;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Test
*/
@WebServlet(name = "HelloServlet", urlPatterns = {"/"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getParameter("sqltest") != null) {
			doSqlTest(req, res);
		} else  {
			ServletOutputStream out = res.getOutputStream();
			out.write("hello dude!".getBytes());
			out.flush();
			out.close();
		}
		
	}

	protected void doSqlTest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// select count(*) from medicines
		try {
         		Context ctx = new InitialContext();
	          	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/drugs");
	          	Connection conn = ds.getConnection();
        	  	Statement stat = conn.createStatement();
         	 	ResultSet rs = stat.executeQuery("select count(*) from medicines");
        	  	ServletOutputStream out = res.getOutputStream();
			out.println("You have " + rs.getString(1) + " entries in your database");
			out.flush();
			out.close();
    		} catch (Exception e) {
         		 System.err.println(e);
    		}
	}


}
