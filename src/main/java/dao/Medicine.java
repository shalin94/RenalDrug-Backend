package dao;

public class Medicine{
	private String id;
	private String name;
	private String date_created;
	private String date_modified;	
	public String getName(){
		return name;
	}
	public String getID(){
		return id;
	}
	public String getDateCreated(){
		return date_created;
	}
	public String getDateModified(){
		return date_modified;
	}
	public void setID(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDateCreated(String date_created){
		this.date_created = date_created;
	}
	public void setDateModified(String date_modified){
		this.date_modified = date_modified;
	}
}
