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

	public List<MedicineDosage> getRecentMedicines(){
		List<MedicineDosage> medlist = null;
		Connection conn = null;
		String query = "select m.medicine_name, d.description, dst.dosage_sub_type_description,md.dosage_value, md.date_created, md.date_modified from medicine_dosage md, medicines m, dosage_types d, dosage_sub_types dst where md.medicine_id = m._id and md.dosage_type_id = d._id and md.dosage_sub_type_id = dst._id order by md.date_modified DESC";
		try{
			conn = this.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()){
				MedicineDosage md = new MedicineDosage();
				md.setName(rs.getString("medicine_name"));
				md.setDosageType(rs.getString("description"));
				md.setDosageSubType(rs.getString("dosage_sub_type_description"));
				md.setDosageValue(rs.getString("dosage_value"));
				md.setDateCreated(rs.getString("date_created"));
				md.setDateModified(rs.getString("date_modified"));
				if(medlist == null)
					medlist = new ArrayList<MedicineDosage>();
				medlist.add(md);	
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

	public String getCurrentTimeStamp(){
		Connection conn = null;
		String time = null;
		try{
			conn = this.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT datetime('now')");
			while(rs.next()){
				time = rs.getString(1);
			}
		}catch(Exception e){
			System.err.println("Could not get date time" + e);
		}finally{
			if (conn != null){
				try{
					conn.close();
				}catch(Exception e){
					System.err.println("Could not close connection" + e);
				}
			}
		}
		return time;
	}
	
	public String getID(String table,String field,String value){
		Connection conn = null;
		int id=0;
		String query = "SELECT _id FROM "+table+" where "+field+"='"+value+"'";
		try{
			conn= this.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()) {
				id = rs.getInt(1);
			}
		}catch(Exception e){
			System.err.println("Could not get id for "+field+" = "+ value + " from " + table + " : "+e);
		}finally{
			if (conn != null){
				try{
					conn.close();
				}catch(Exception e){
					System.err.println("Could not close connection" + e);
				}
			}
		}
		return Integer.toString(id);
	}
	public int insertData(String table,String field1, String field2,String field3,String field4,String date){
		Connection conn = null;
		String query;
		int status = 0;
		try{
			conn = this.getConnection();
			conn.setAutoCommit(false);
			if(table.equals("medicines")){
				query = "INSERT INTO medicines VALUES(null,?,?,?)";
				PreparedStatement stat = conn.prepareStatement(query);
				stat.setString(1,field1);
				stat.setString(2,date);
				stat.setString(3,date);
				status = stat.executeUpdate();
				conn.commit();
			}
			else if(table.equals("medicine_dosage")){
				query = "INSERT INTO medicine_dosage VALUES(null,?,?,?,?,?,?)";
				PreparedStatement stat = conn.prepareStatement(query);
				stat.setString(1,field1);
				stat.setString(2,field2);
				stat.setString(3,field3);
				stat.setString(4,field4);
				stat.setString(5,date);
				stat.setString(6,date);
				status = stat.executeUpdate();
				conn.commit();
				stat.close();
			}	
		}catch(Exception e){
			System.err.println(e);
		}finally{
			try{
				conn.setAutoCommit(true);
				conn.close();
			}catch(Exception e){
				System.err.println(e);
			}
		}
		return status;
		
	}	
	public List<DosageSubType> getDosageSubTypes(int dosage_type){
		List<DosageSubType> dstlist = null;
		Connection conn = null;
		String query = "SELECT dosage_sub_type_description from dosage_sub_types where dosage_type='"+Integer.toString(dosage_type)+"'";
		try{
			conn = this.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);
			while(rs.next()){
				DosageSubType dst = new DosageSubType();
				dst.setDosageSubType(rs.getString("dosage_sub_type_description"));
				if (dstlist == null)
					dstlist = new ArrayList<DosageSubType>();
				dstlist.add(dst);
			}
		}catch(Exception e){
			System.err.println("Could not get list of DosageSubTypes :" + e);
		}finally{
			if (conn != null){
				try{
					conn.close();
				}catch(Exception e){
					System.err.println("Could not close connection" + e);
				}
			}
		}
		return dstlist;
	}
}
