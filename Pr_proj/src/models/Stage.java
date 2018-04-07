package models;
import java.sql.Date;

import database.DbAccess;

public class Stage {

	private int idStaged;
	private int number;
	private int idProject;
	private Date beginning;
	private Date endingPlanned;
	private Date endingFact;
	private double price;
	private double costs;

	public Stage(int id, int number, int project_id, Date start, Date planned_end, Date real_end,
			double price, double costs) {
		this.idStaged = id;
		this.number = number;
		this.idProject = project_id;
		this.beginning = start;
		this.endingPlanned = planned_end;
		this.endingFact = real_end;
		this.price = price;
		this.costs = costs;
	}

	public Stage(DbAccess db, int id, int number, int project_id, Date start, Date planned_end, double price) {
		this.number = number;
		this.idProject = project_id;
		this.beginning = start;
		this.endingPlanned = planned_end;
		this.endingFact = null;
		this.price = price;
		this.costs = 0;
		this.idStaged = db.addStage(number, project_id, start, planned_end, price);
	}

	public int getIdStaged() {
		return idStaged;
	}

	public int getNumber() {
		return number;
	}

	public int getDepartmentId() {
		return idProject;
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

	public double getCosts() {
		return costs;
	}

	public double getPrice() {
		return price;
	}

	@SuppressWarnings("deprecation")
	public String toString() {
		if (endingFact == null) endingFact = new Date(0000, 0, 0);
		return "Id: " + idStaged + ", Number: " + number + ", Project id: " + idProject + ", Start: "
				+ beginning + ", Planned end: " + endingPlanned + ", Real end: " + endingFact + ", Price: " + price
				+ ", Costs: " + costs;
	}

	public void delete(DbAccess db) {
		if (idStaged != 0)
			db.delStage(idStaged);
		idStaged = 0;
	}

}
