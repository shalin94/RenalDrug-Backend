package dao;

public class Medicine{
	private String name;
	private String dosage_type;
	private String dosage_sub_type_description;
	private String dosage_value;
	private String date_created;
	private String date_modified;
	public String getName(){
		return name;
	}
	public String getDosageType(){
		return dosage_type;
	}	
	public String getDosageSubType(){
		return dosage_sub_type_description;
	}
	public String getDosageValue(){
		return dosage_value;
	}
	public String getDateCreated(){
		return date_created;
	}
	public String getDateModified(){
		return date_modified;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setDosageType(String dosage_type){
		this.dosage_type=dosage_type;
	}
	public void setDosageSubType(String dosage_sub_type_description){
		this.dosage_sub_type_description = dosage_sub_type_description;
	}
	public void setDosageValue(String dosage_value){
		this.dosage_value=dosage_value;
	}
	public void setDateCreated(String date_created){
		this.date_created=date_created;
	}
	public void setDateModified(String date_modified){
		this.date_modified=date_modified;
	}
}
