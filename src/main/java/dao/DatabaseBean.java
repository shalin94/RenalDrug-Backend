package dao;

import java.sql.*;
import java.io.*;
import javax.sql.*;
import javax.servlet.*;
import javax.naming.*;
import java.util.*;
public class DatabaseBean {
private ArrayList<Medicine> list =new ArrayList<Medicine>();
	public ArrayList<Medicine> connect(){
		try{
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/drugs");
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select m.medicine_name, d.description, dst.dosage_sub_type_description,md.dosage_value, m.date_created, m.date_modified from medicine_dosage md, medicines m, dosage_types d, dosage_sub_types dst where md.medicine_id = m._id and md.dosage_type_id = d._id and md.dosage_sub_type_id = dst._id order by m.date_modified DESC");
			while(rs.next()){
				Medicine mb = new Medicine();
				mb.setName(rs.getString("medicine_name"));
				mb.setDosageType(rs.getString("description"));
				mb.setDosageSubType(rs.getString("dosage_sub_type_description"));
				mb.setDosageValue(rs.getString("dosage_value"));
				mb.setDateCreated(rs.getString("date_created"));
				mb.setDateModified(rs.getString("date_modified"));
				list.add(mb);	
			}
		}catch (Exception e){
			System.err.println(e);
		}
		return list;
	}

}
