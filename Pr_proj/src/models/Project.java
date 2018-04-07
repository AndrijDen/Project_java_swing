package models;
import java.sql.Date;

import database.DbAccess;

public class Project {

	private int idProject;
	private String name;
	private int idDepartment;
	private String client;
	private Date beginning;
	private Date endingPlanned;
	private Date endingFact;
	private double cost;
	private double spending;
	private String rate;

	public Project(int id, String name, int idDepartment, String client, Date start, Date endingPlanned, Date endingFact,
			double price, double spending, String rate) {
		this.idProject = id;
		this.name = name;
		this.idDepartment = idDepartment;
		this.client = client;
		this.beginning = start;
		this.endingPlanned = endingPlanned;
		this.endingFact = endingFact;
		this.cost = price;
		this.spending = spending;
		this.rate = rate;
	}

	public Project(DbAccess db, int id, String name, int department_id, String owner, Date start, Date planned_end, double price) {
		this.name = name;
		this.idDepartment = department_id;
		this.client = owner;
		this.beginning = start;
		this.endingPlanned = planned_end;
		this.endingFact = null;
		this.cost = price;
		this.spending = 0;
		this.rate = null;
		this.idProject = db.addProject(name, department_id, owner, start, planned_end, price);
	}

	public int getId() {
		return idProject;
	}

	public String getName() {
		return name;
	}

	public int getIdDepartment() {
		return idDepartment;
	}

	public String getClient() {
		return client;
	}

	public Date getBeginning() {
		return beginning;
	}

	public Date getEndingPlanned() {
		return endingPlanned;
	}

	public Date getEndingFact() {
		return endingFact;
	}

	public double getSpending() {
		return spending;
	}

	public double getCost() {
		return cost;
	}

	public String getRate() {
		return rate;
	}

	@SuppressWarnings("deprecation")
	public String toString() {
		if (endingFact == null) endingFact = new Date(0000, 0, 0);
		if (rate == null) rate = "not defined";
		return "Id: " + idProject + ", Name: " + name + ", Department id: " + idDepartment + ", Owner: " + client + ", Start: "
				+ beginning + ", Planned end: " + endingPlanned + ", Real end: " + endingFact + ", Price: " + cost
				+ ", Costs: " + spending + ", Mark: " + rate;
	}

	public void delete(DbAccess db) {
		if (idProject != 0)
			db.delProject(idProject);
		idProject = 0;
	}

}
