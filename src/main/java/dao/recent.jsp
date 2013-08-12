<%@ page language = "java" contentType = "text/html" import = "dao.*, java.io.*, java.sql.*,java.util.*" %>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
if (document.images) {
    img1 = new Image();
    img1.src = "http://idratherbewriting.com/wp-content/uploads/2013/03/plus3.jpg";
    img2 = new Image();
    img2.src = "http://idratherbewriting.com/wp-content/uploads/2013/03/minusb.jpg";
}


$(document).ready(function () {
    $('.section').hide();
    $('h4').click(function () {
        $(this).toggleClass("open");
        $(this).next().toggle();
    }); //end toggle

    $('#expandall').click(function () {
        $('.section').show();
        $('h4').addClass("open");
    });

    $('#collapseall').click(function () {
        $('.section').hide();
        $('h4').removeClass("open");
    });

});
</script>
<style type="text/css">
	h4 {
		cursor: pointer;
		font-weight:bold;
		background-image:url('http://idratherbewriting.com/wp-content/uploads/2013/03/plus3.jpg');
		background-repeat:no-repeat;
		text-indent:23px;
		background-position:4px;	
	}.open {
		background-image:url('http://idratherbewriting.com/wp-content/uploads/2013/03/minusb.jpg');
	}
</style>
</head>
	<body>
		<TABLE border = "1" align="center" cellpadding="10">
		<TR>
			<td><b>Medicine Name</b></td>
			<td><b>Date Created</b></td>
			<td><b>Date Modified</b></td>
		</TR>
		<%
			DBHelper db = DBHelper.getInstance();
			List<Medicine> list = db.getRecentMedicines();
			int count = 10;
			if(list.size()<10)
				count = list.size();
			int[] id = new int[count];
			for(int i=0;i<count;i++){
				Medicine med = list.get(i);
				out.println("<TR>");
				out.println("<td><h4>"+med.getName()+"</h4><td colspan =\"3\"><div class=\"section\">"+id[i]+"</div></td>");
				out.println("<td>"+med.getDateCreated()+"</td>");
				out.println("<td>"+med.getDateModified()+"</td>");
				out.println("</TR>");
				id[i] = Integer.parseInt(med.getID());
				//out.println("<TR><td colspan =\"3\"><div class=\"section\">"+id[i]+"</div></td></TR>");
			} 
		%>
		</TABLE>
		<%
			String time = db.getCurrentTimeStamp();
			out.println("<h1>"+time+"</h1>");
		%>
	</body>
</html>
