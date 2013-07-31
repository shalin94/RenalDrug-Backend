<%@ page language = "java" contentType = "text/html" import = "servlet.*, java.io.*, java.sql.*,java.util.*" %>
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
			DatabaseBean db = new DatabaseBean();
			ArrayList<MedicineBean> list = db.connect();
			for(int i=0;i<list.size();i++){
				MedicineBean mb = list.get(i);
				out.println("<TR>");
				out.println("<td>"+mb.getName()+"</td>");
				out.println("<td>"+mb.getDosageType()+"</td>");
				out.println("<td>"+mb.getDosageSubType()+"</td>");
				out.println("<td>"+mb.getDosageValue()+"</td>");
				out.println("<td>"+mb.getDateCreated()+"</td>");
				out.println("<td>"+mb.getDateModified()+"</td>");
				out.println("</TR>");
			} 
		%>
		</TABLE>
	</body>
</html>
