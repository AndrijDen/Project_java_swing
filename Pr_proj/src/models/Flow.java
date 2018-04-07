package models;
import java.math.BigDecimal;
import java.sql.*;

//Ðóõ êîøò³â
public class Flow {
	private long id;
	private Date date;
	private BigDecimal sum;
	private int year;
	private int month;
	private int idStaff;
	private int idStage;
	private int idBalance;
	private FlowType flowType;
	
	public Flow(int id, int idStaff,Date date, BigDecimal sum, int year, int month,int idStage,int idBalance, FlowType flowType) {
		this.setId(id);
		this.setDate(date);
		this.setSum(sum);
		this.setYear(year);
		this.setMonth(month);
		this.setIdBalance(idBalance);
		this.setIdStage(idStage);
		this.setFlowType(flowType);
		this.setIdStaff(idStaff);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getIdStage() {
		return idStage;
	}

	public void setIdStage(int idStage) {
		this.idStage = idStage;
	}
	
	public void  setIdStaff(int idStaff) {
		this.idStaff = idStaff;
			
		}
		
		public int getIdStaff() {
			return idStaff;
		}

	public int getIdBalance() {
		return idBalance;
	}

	public void setIdBalance(int idBalance) {
		this.idBalance = idBalance;
	}

	public FlowType getFlowType() {
		return flowType;
	}

	public void setFlowType(FlowType flowType2) {
		this.flowType = flowType2;
	}

	public String toString() {

		return "Id: " + id + ", Date: " + date +", Sum: "
				+ sum + ", Year: " + year + ", Month: " + month + ", idStage: " + idStage + ", idStaff: " + idStaff+ ", idBalance: " + idBalance + ", FlowType: " + flowType ;
	}
	

}
