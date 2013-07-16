package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.*;
@WebServlet(name = "sqltest", urlPatterns={"/"})
public class ConnectSQLite extends HttpServlet {


	public ConnectSQLite() {
		super();
	}


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		ServletContext servletContext = getServletContext();
		URL resU = servletContext.getResource("drugs.db");
		PrintWriter out=res.getWriter();

		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+resU);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM medicines");
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			while (resultSet.next()) {
			out.println("<h1> Medicine Name: " + resultSet.getString("medicine_name") + "</h1>"); 
			}
			out.println("</body>");
			out.println("</html>");
		}catch(Exception e) {
			System.err.println("Failed to make connection with database: "+ e);
		} finally {
			try{
				resultSet.close();
				statement.close();
				connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
