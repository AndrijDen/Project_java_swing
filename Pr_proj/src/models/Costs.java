package models;

import java.sql.Date;

import database.DbAccess;

public class Costs {

	private int id;
	private int stage_id;
	private Date date;
	private double sum;
	
	public Costs(int id, int stage_id, Date date, double sum) {
		this.id = id;
		this.stage_id = stage_id;
		this.date = date;
		this.sum = sum;
	}

	public Costs(DbAccess db, int id, int stage_id, Date date, double sum) {
		this.stage_id = stage_id;
		this.date = date;
		this.sum = sum;
		//this.id = db.addProject_costs(stage_id, date, sum);
	}

	public int getId() {
		return id;
	}

	public int getStage_id() {
		return stage_id;
	}

	public Date getDate() {
		return date;
	}

	public double getSum() {
		return sum;
	}

	@SuppressWarnings("deprecation")
	public String toString() {
		return "Id: " + id + ", Stage_id: " + stage_id + ", Date: " + date + ", Sum: " + sum;
	}
}
