package models;

import java.math.BigDecimal;
import java.sql.Date;


public class FlowSalary extends Flow{
	
	public FlowSalary(int id,  int idStaff, Date date, BigDecimal sum, int year, int month,int idStage,int idBalance) {
		super(id, idStaff, date, sum, year,month,idStage,idBalance, FlowType.SALARY_MANAGER);
	}

}
