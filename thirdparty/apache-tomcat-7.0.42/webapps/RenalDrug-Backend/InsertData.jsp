<%@ page language = "java" contentType = "text/html" import = "dao.*,java.io.*,java.sql.*,java.util.*" %>
<jsp:useBean id="data" class="dao.FormData" scope="session"/>
<HTML>
<BODY>
<%
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
	if (status == 1) out.println("Successful in  inserting all data");
%>
<BODY>
</HTML>
