<%@ page language = "java" contentType = "text/html" import = "dao.*, java.io.*, java.sql.*,java.util.*" %>
<HTML>
<HEAD>
<script  src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
var addDiv = $('#addinput');
var i = $('#addinput p').size() + 1;

$('#addNew').live('click', function() {
$('<tr><td><input type="text" id="p_new" size="50" name="p_new_' + i +'" value="" placeholder="I am New" /><a href="#" id="remNew">Remove</a> </p>').appendTo(addDiv);
i++;

return false;
});

$('#remNew').live('click', function() {
if( i > 2 ) {
$(this).parents('p').remove();
i--;
}
return false;
});
});

</script>
</HEAD>
<BODY>
<CENTER>
<FORM METHOD=POST ACTION="SaveData.jsp">
<TABLE border="0" cellpadding="10" align="center">
<TR><TD>Medicine Name:</TD><TD><INPUT TYPE=TEXT NAME=name SIZE=50></TD></TR>
<TR bgcolor="BLACK" ><TD align="center"colspan="2"><FONT COLOR="WHITE">Dose in Normal Renal Function:</FONT></TD></TR>
<TR><TD colspan="2"><INPUT TYPE=TEXT NAME=dv1 SIZE=50></TD></TR>
<TR bgcolor="BLACK" ><TD align="center"colspan="2"><FONT COLOR="WHITE">Dose in Renal Impairment:</FONT></TD></TR>
<TR><TD align="CENTER"><SELECT name=dst1>
<%
	DBHelper db = DBHelper.getInstance();
	List<DosageSubType> list = db.getDosageSubTypes(2);
	int count = list.size();
	for(int i=0;i<count;i++){
		DosageSubType dst = list.get(i);
		out.println("<option value=\""+dst.getDosageSubType()+"\">"+dst.getDosageSubType()+"</option>");
	}
%>
</SELECT>
</TD><TD><INPUT TYPE=TEXT NAME=dv2 SIZE=50></TD></TR>
<TR><TD align = "CENTER"><SELECT name=dst2>
<%
	for(int i=0;i<count;i++){
		DosageSubType dst = list.get(i);
		out.println("<option value=\""+dst.getDosageSubType()+"\">"+dst.getDosageSubType()+"</option>");
	}
%>
</SELECT>
</TD><TD><INPUT TYPE=TEXT NAME=dv3 SIZE=50></TD></TR>
<TR><TD align = "CENTER"><SELECT name=dst3>
<%
	for(int i=0;i<count;i++){
		DosageSubType dst = list.get(i);
		out.println("<option value=\""+dst.getDosageSubType()+"\">"+dst.getDosageSubType()+"</option>");
	}
%>
</SELECT>
</TD><TD><INPUT TYPE=TEXT NAME=dv4 SIZE=50></TD></TR>
<TR bgcolor="black"><TD colspan="2" align="center"><FONT color="white">Dose In Patients Undergoing Renal Replacement Therapy:</FONT></TD></TR>
<TR><TD><SELECT name=dst4>
<%
	List<DosageSubType> rtlist = db.getDosageSubTypes(3);
	int count2= rtlist.size();
	for(int i=0;i<count2;i++){
		DosageSubType dst = rtlist.get(i);
		out.println("<option value=\""+dst.getDosageSubType()+"\">"+dst.getDosageSubType()+"</option>");
	}
%>
</SELECT>
</TD><TD><INPUT TYPE=TEXT NAME=dv5 SIZE=50></TD></TR>
<TR><TD><SELECT name=dst5>
<%
	for(int i=0;i<count2;i++){
		DosageSubType dst = rtlist.get(i);
		out.println("<option value=\""+dst.getDosageSubType()+"\">"+dst.getDosageSubType()+"</option>");
	}
%>
</SELECT>
</TD><TD><INPUT TYPE=TEXT NAME=dv6 SIZE=50></TD></TR>
<TR><TD><SELECT name=dst6>
<%
	for(int i=0;i<count2;i++){
		DosageSubType dst = rtlist.get(i);
		out.println("<option value=\""+dst.getDosageSubType()+"\">"+dst.getDosageSubType()+"</option>");
	}
%>
</SELECT>
</TD><TD><INPUT TYPE=TEXT NAME=dv7 SIZE=50></TD></TR>
<TR><TD><SELECT name=dst7>
<%
	for(int i=0;i<count2;i++){
		DosageSubType dst = rtlist.get(i);
		out.println("<option value=\""+dst.getDosageSubType()+"\">"+dst.getDosageSubType()+"</option>");
	}
%>
</SELECT>
</TD><TD><INPUT TYPE=TEXT NAME=dv8 SIZE=50></TD></TR>

<TR><TD><SELECT name=dst8>
<%
	for(int i=0;i<count2;i++){
		DosageSubType dst = rtlist.get(i);
		out.println("<option value=\""+dst.getDosageSubType()+"\">"+dst.getDosageSubType()+"</option>");
	}
%>
</SELECT>
</TD><TD><INPUT TYPE=TEXT NAME=dv9 SIZE=50></TD></TR>
<TR><TD colspan="2" align="center"><INPUT TYPE="SUBMIT" Value="Submit"></TD></TR>
</TABLE>
</FORM>
</CENTER>
</BODY>
</HTML>
