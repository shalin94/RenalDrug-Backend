package dao;

import java.sql.*;
import java.io.*;
import javax.sql.*;
import javax.servlet.*;
import javax.naming.*;
import java.util.*;

public class DBHelper{
	private Context ctx;
	private DataSource ds;
	private static DBHelper instance = null;

	protected DBHelper() throws Exception {
		ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/drugs");
	}

	public static DBHelper getInstance(){
		if(instance == null){
			try{
			instance = new DBHelper();
			} catch (Exception e){
				System.err.println(e);
			}
		}
		return instance;
	}

	protected Connection getConnection() throws Exception {
		return ds.getConnection();
	}

	public List<Medicine> getRecentMedicines(){
		List<Medicine> medlist = null;
		Connection conn = null;
		String query = "select m.medicine_name, d.description, dst.dosage_sub_type_description,md.dosage_value, m.date_created, m.date_modified from medicine_dosage md, medicines m, dosage_types d, dosage_sub_types dst where md.medicine_id = m._id and md.dosage_type_id = d._id and md.dosage_sub_type_id = dst._id order by m.date_modified DESC";
		try{
			conn = this.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()){
				Medicine med = new Medicine();
				med.setName(rs.getString("medicine_name"));
				med.setDosageType(rs.getString("description"));
				med.setDosageSubType(rs.getString("dosage_sub_type_description"));
				med.setDosageValue(rs.getString("dosage_value"));
				med.setDateCreated(rs.getString("date_created"));
				med.setDateModified(rs.getString("date_modified"));
				if(medlist == null)
					medlist = new ArrayList<Medicine>();
				medlist.add(med);	
			}
		} catch(Exception e){
			System.err.println("Could not execute query: " + query + ":" + e);
		} finally {
			if (conn != null){
				try{
					conn.close();
				}catch(Exception e){
					System.err.println("Could not close connection" + e);
				}
			}
		}
		return medlist;
	}
}
