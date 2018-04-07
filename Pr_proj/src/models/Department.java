package models;
import java.sql.Date;

import database.DbAccess;

public class Department {

	private int idDepartment;
	private String name;
	private String phoneNum;



	public Department(int idDepartment, String name, String phoneNum) {
		this.idDepartment = idDepartment;
		this.name = name;
		this.phoneNum = phoneNum;
		
	}

	public Department(DbAccess db, int idDepartment, String name, String phoneNum) {
		this.idDepartment = db.addDepartment(name, phoneNum);
		this.name = name;
		this.phoneNum = phoneNum;
		
	}

	public int getIdDepartment() {
		return idDepartment;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	@SuppressWarnings("deprecation")
	public String toString() {
		return "Id: " + idDepartment + ", Department name: " + name + ", Phone number: " + phoneNum;
	}

	public void delete(DbAccess db) {
		if (idDepartment != 0)
			db.delStaff(idDepartment);
		idDepartment = 0;
	}

}
