package models;
import java.sql.Date;

import database.DbAccess;

public class Staff {

	private int idStaff;
	private String surname;
	private Date birthDate;
	private String sex;



	public Staff(int idStaff, String surname, String sex, Date birthDate) {
		this.idStaff = idStaff;
		this.surname = surname;
		this.sex = sex;
		this.birthDate = birthDate;
		
	}

	public Staff(DbAccess db, int idStaff, String surname, String sex, Date birthDate) {
		this.surname = surname;
		this.sex = sex;
		this.birthDate = birthDate;
		this.idStaff = db.addStaff(surname, sex, birthDate);
	}

	public int getId() {
		return idStaff;
	}

	public String getSurname() {
		return surname;
	}

	public String getSex() {
		return sex;
	}

	public Date getBirth() {
		return birthDate;
	}

	@SuppressWarnings("deprecation")
	public String toString() {
		return "Id: " + idStaff + ", Surname: " + surname + ", Sex: " + sex + ", BirthDate: "
				+ birthDate;
	}

	public void delete(DbAccess db) {
		if (idStaff != 0)
			db.delStaff(idStaff);
		idStaff = 0;
	}

}
