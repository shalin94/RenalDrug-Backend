<%@ page language = "java" contentType = "text/html" import = "dao.*, java.io.*, java.sql.*,java.util.*" %>
<html>
	<body>
		<TABLE border = "1" align="center" cellpadding="10">
		<TR>
			<td><b>Medicine Name</b></td>
			<td><b>Dosage Type</b></td>
			<td><b>Dosage Sub Type</b></td>
			<td><b>Dosage Value</b></td>
			<td><b>Date Created</b></td>
			<td><b>Date Modified</b></td>
		</TR>
		<%
			DBHelper db = DBHelper.getInstance();
			List<MedicineDosage> list = db.getRecentMedicines();
			int count = 10;
			if(list.size()<10)
				count = list.size();
			for(int i=0;i<count;i++){
				MedicineDosage med = list.get(i);
				out.println("<TR>");
				out.println("<td>"+med.getName()+"</td>");
				out.println("<td>"+med.getDosageType()+"</td>");
				out.println("<td>"+med.getDosageSubType()+"</td>");
				out.println("<td>"+med.getDosageValue()+"</td>");
				out.println("<td>"+med.getDateCreated()+"</td>");
				out.println("<td>"+med.getDateModified()+"</td>");
				out.println("</TR>");
			} 
		%>
		</TABLE>
		<%
			String time = db.getCurrentTimeStamp();
			out.println("<h1>"+time+"</h1>");
		%>
	</body>
</html>
