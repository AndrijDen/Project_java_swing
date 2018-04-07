package models;

import java.math.BigDecimal;
import java.sql.Date;



public class Balance {
	
	private int id;
	private Date date;
	//Доходи
	private BigDecimal profit;
	//Витрати
	private BigDecimal spending;
	//залишок
	private BigDecimal remainder;
	
	public Balance(int id, Date date, BigDecimal spending,BigDecimal profit,BigDecimal remainder) {
		this.setId(id);
		this.setDate(date);
		this.setSpending(spending);
		this.setProfit(profit);
		this.setRemainder(remainder);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getSpending() {
		return spending;
	}

	public void setSpending(BigDecimal spending) {
		this.spending = spending;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public BigDecimal getRemainder() {
		return remainder;
	}

	public void setRemainder(BigDecimal remainder) {
		this.remainder = remainder;
	}

	public String toString() {		
		return "Id: " + id + ", Date: " + date.toString() + ", Spending: " + spending + ", Profit: " + profit + ", Remainder: "
		+ remainder ;
	}
}
