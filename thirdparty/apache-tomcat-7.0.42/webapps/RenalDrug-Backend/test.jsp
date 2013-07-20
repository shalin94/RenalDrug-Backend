<%@ page language = "java" contentType = "text/html"
	import = "servlet.*, java.io.*,java.sql.*" %>

<html>
	<body>
		<%
			ConnectSQLite sql = new ConnectSQLite();
			ResultSet rs = null;
			sql.ConnectDatabase();
			rs = sql.statement.executeQuery("SELECT * FROM medicines");
			while(rs.next()) {
				int id = rs.getInt("_id");
				out.println(id);
			}
			rs.close();
			sql.CloseConnection();
		%>
	</body>
</html>
