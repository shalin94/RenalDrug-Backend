<jsp:useBean id="data" class="dao.FormData" scope="session"/>
<jsp:setProperty name="data" property="*"/>
<HTML>
<BODY>
<TABLE border="0" cellpadding="10" align="center">
<TR><TD colspan="2"align="center"><H1>Please check if the data entered below is correct!</H1></TD></TR>
<%
	out.println("<TR><TD>Medicine Name:</TD><TD>" + data.getName()+"</TD></TR>");
	out.println("<TR bgcolor=\"BLACK\"><TD align=\"center\" colspan=\"2\"><font color=\"WHITE\">Dose in Normal Function: </font></TD></TR><TR><TD colspan=\"2\">" + data.getDv1()+"</TD></TR>");
	out.println("<TR bgcolor=\"BLACK\"><TD align=\"center\" colspan=\"2\"><font color=\"WHITE\">Dose in Renal Impairment:</font></TD></TR><TR><TD>"+ data.getDst1() + ": </TD><TD>" + data.getDv2()+"</TD></TR>");
	out.println("<TR><TD>"+ data.getDst2() + ": </TD><TD>" + data.getDv3()+"</TD></TR>");
	out.println("<TR><TD>"+ data.getDst3() + ": </TD><TD>" + data.getDv4()+"</TD></TR>");
	out.println("<TR bgcolor=\"BLACK\"><TD align=\"center\" colspan=\"2\"><font color=\"WHITE\">Dose in Renal Replacement Therapy:</font> </TD></TR><TR><TD>"+ data.getDst4() + ": </TD><TD>" + data.getDv5()+"</TD></TR>");
	out.println("<TR><TD>"+ data.getDst5() + ": </TD><TD>" + data.getDv6()+"</TD></TR>");
	out.println("<TR><TD>"+ data.getDst6() + ": </TD><TD>" + data.getDv7()+"</TD></TR>");
	out.println("<TR><TD>"+ data.getDst7() + ": </TD><TD>" + data.getDv8()+"</TD></TR>");
	out.println("<TR><TD>"+ data.getDst8() + ": </TD><TD>" + data.getDv9()+"</TD></TR>");
%>
</TABLE>
<CENTER>
<FORM METHOD=POST ACTION="InsertData.jsp">
<INPUT ALIGN="CENTER"TYPE="SUBMIT" VALUE="Save">
<INPUT TYPE="Button" ALIGN="CENTER" VALUE="Back" onClick="history.go(-1);return true;">
</FORM>
</CENTER>
</BODY>
</HTML>
