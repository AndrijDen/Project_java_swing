package models;
import java.sql.Date;

import database.DbAccess;

public class Position {

	private int idPosition;
	private String title;
	private Date beginning;
	private Date ending;
	private double pay;
	private int idDepartment;
	private int idStaff;
	

	public Position(int id, String title, Date beginning, Date ending, double pay, int idDepartment, int idStaff) {
		this.idPosition = id;
		this.idStaff = idStaff;
		this.idDepartment = idDepartment;
		this.title = title;
		this.beginning = beginning;
		this.ending = ending;
		this.pay = pay;
	}

	/*public Position(DbAccess db, String title, Date start, Date ending, double pay, int idDepartment, int idStaff) {
		this.title = title;
		this.beginning = start;
		this.ending = ending;
		this.pay = pay;
		this.idDepartment = idDepartment;
		this.idStaff = idStaff;
		this.idPosition = db.addPosition(title, start, ending, pay, idDepartment, idStaff);
	}*/

	public Position() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPosition() {
		return idPosition;
	}

	public String getTitle() {
		return title;
	}

	public int getDepartmentId() {
		return idDepartment;
	}
	public int getStaffId() {
		return idStaff;
	}

	public Date getBeginning() {
		return beginning;
	}

	public Date getEnding() {
		return ending;
	}

	public double getPay() {
		return pay;
	}

	@SuppressWarnings("deprecation")
	public String toString() {
		//if (ending == null) ending = new Date(0000, 0, 0);
		return "Id: " + idPosition +  ", Staff id: " + idStaff + ", Department id: " + idDepartment + ", Position: " + title +  ", Start: "
				+ beginning + ", End: " + ending + ", Pay: " + pay;
	}

	public void delete(DbAccess db) {
		if (idPosition != 0)
			db.delPosition(idPosition);
		idPosition = 0;
	}
	
	public void setId(Integer id) {
		this.idPosition = id;
	}

}
