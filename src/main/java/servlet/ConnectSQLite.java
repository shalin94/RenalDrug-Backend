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
@WebServlet("/sqltest")
public class ConnectSQLite extends HttpServlet{


	public ConnectSQLite() {
		super();
	}

	Connection connection = null;
	ResultSet resultSet = null;
	public Statement statement = null;
	ServletContext servletContext = getServletContext();
/*	try {
		URL resU = servletContext.getResource("drugs.db");
	}catch (Exception e) {
		System.err.println("Unable to get database: " + e);
	}
*/	String path = getServletContext().getRealPath("WEB-INF/classes/drugs.db");
	/*try {
		Class.forName("org.sqlite.JDBC");
		connection = DriverManager.getConnection("jdbc:sqlite:"+string);
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
	}*/
	public void ConnectDatabase()	{
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+path);
			statement = connection.createStatement();
		}catch(Exception e) {
			System.err.println("Failed to make connection with database: " + e);
		}		
	}	
	public void CloseConnection()	{
		try{
			statement.close();
			connection.close();
		}catch(Exception e){
			System.err.println("Failed to close database: " + e);
		}
	}
	
	/*public ResultSet Query(String query) {
		ConnectDatabase();
		try{
			ResultSet rs = statement.executeQuery(query);
			return rs;
			rs.close();
		}catch (Exception e) {
			System.err.println("Failed to run query: " + e);
		} 
		CloseConnection();
	}*/
}
