package repositories;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import models.Balance;
import models. Balance;
import reposirory.interfaces.IBalanceRepository;
import reposirory.interfaces.IFlowRepository;
import reposirory.interfaces.IProjectRepository;

public class BalanceRepository implements IBalanceRepository {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String CONNECTION = "jdbc:mysql://localhost/Projects?useSSL=false";
		
	@Override
	public List< Balance> getAll() throws SQLException {
		Connection c =  DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;

		 }
		PreparedStatement s = c.prepareStatement("SELECT * FROM balance;");
        ResultSet rs = s.executeQuery();
       
		return toList(rs);

	}
	
	@Override
	public List< Balance> getAllBalanseInfo() throws SQLException {
		Connection c =  DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;

		 }
		PreparedStatement s = c.prepareStatement("SELECT * FROM balance where idBalance=1;");
        ResultSet rs = s.executeQuery();
       
		return toList(rs);

	}
	/*
	//Доходи
	private double profit;
	//Витрати
	private double spending;
	//залишок
	private double remainder;
	 */

	@Override
	public  Balance getById(int id) throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
		PreparedStatement s = c.prepareStatement("SELECT * FROM balance WHERE idBalance=?");
        s.setLong(1, id);
        ResultSet rs = s.executeQuery();
        
		return toObject(rs);
	}
	
	@Override
	public List< Balance> getBalanseByDate(Date d) throws SQLException {
		Connection c =  DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;

		 }
		 PreparedStatement s = c.prepareStatement("SELECT * FROM balance WHERE Date=?");
	        s.setDate(1, d);       
	        ResultSet rs = s.executeQuery();
       
		return toList(rs);

	}
	
	
	
	
		private  Balance toObject(ResultSet rs) throws SQLException {
	    	return new  Balance(rs.getInt("idBalance"),rs.getDate("Date"),rs.getBigDecimal("Spending"),rs.getBigDecimal("Profit"),rs.getBigDecimal("Remainder")); 
	}


		 private List<Balance> toList(ResultSet rs) throws SQLException {
		        List< Balance> list = new ArrayList< Balance>();
		        while (rs.next()) list.add(toObject(rs));
		        return list;
		    }


		 //
		@Override
		public void formSpendingAll() throws SQLException {
			// TODO Auto-generated method stub
			IFlowRepository flowRep = new FlowRepository();
			Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			BigDecimal spending_balanse = flowRep.getSumOfAllFlowFromProjects();
			
			try {
			    PreparedStatement sp = c.prepareStatement("update balance set Spending=? Where idBalance=1" );
			    sp.setBigDecimal(1, spending_balanse);
			    sp.executeUpdate();
			    c.close();
			    }catch (SQLException e){System.out.println("updatePrinting : " + e.getMessage());}			
		}

		
		//
		@Override
		public void formProfitAll() throws SQLException {
			// TODO Auto-generated method stub
			IProjectRepository prRep = new ProjectRepository();
			Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			BigDecimal cost_balanse = prRep.getSumOfCostFromAllProject();
			try {
			    PreparedStatement sp = c.prepareStatement("update balance set Profit=? Where idBalance=1" );
			    sp.setBigDecimal(1, cost_balanse);
			    sp.executeUpdate();
			    c.close();
			    }catch (SQLException e){System.out.println("updatePrinting : " + e.getMessage());}						
		}

		//
		@Override
		public void formRemainderAll() throws SQLException {
			// TODO Auto-generated method stub
			Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			try {
			    PreparedStatement sp = c.prepareStatement("update balance set Remainder = Profit - Spending" );
			    sp.executeUpdate();
			    c.close();
			    }catch (SQLException e){System.out.println("updatePrinting : " + e.getMessage());
			    }		
		}
		
		
		@Override
	   public void formBalanceByDay(Date d) throws SQLException{
			IFlowRepository flowRep = new FlowRepository();
			IProjectRepository prRep = new ProjectRepository();		
			BigDecimal spending_byDate = flowRep.getSumOfAllFlowFromProjectsBy_Date(d);	
			BigDecimal cost_balanse_byDate = prRep.getSumOfCostFromAllProject();
			
			Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			try {
			    PreparedStatement sp = c.prepareStatement("insert into balance (Spending, Profit, Remainder, Date ) Values (?, ?, Profit - Spending,?);");
			    sp.setBigDecimal(1, spending_byDate);
			    sp.setBigDecimal(2, cost_balanse_byDate);
			    sp.setDate(3, d);
			    sp.executeUpdate();
			    c.close();
			    }catch (SQLException e){System.out.println("updatePrinting : " + e.getMessage());
			    }	
	    }





		@Override
		public BigDecimal getSpendingByDate(Date d) throws SQLException {
			Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			PreparedStatement s = c.prepareStatement("SELECT Spending FROM balance WHERE Date=?");
	        s.setDate(1, d);
	        ResultSet rs = s.executeQuery();
	       
			return rs.getBigDecimal("Spending");
			
		}



		@Override
		public BigDecimal getRemainderByDate(Date d) throws SQLException {
			Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			PreparedStatement s = c.prepareStatement("SELECT Remainder FROM balance WHERE Date=?");
	        s.setDate(1, d);
	        ResultSet rs = s.executeQuery();
	       
			return rs.getBigDecimal("Remainder");
			
		}
			

		@Override
		public BigDecimal getProfitByDate(Date d) throws SQLException {
			Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			PreparedStatement s = c.prepareStatement("SELECT Profit FROM balance WHERE Date=?");
	        s.setDate(1, d);
	        ResultSet rs = s.executeQuery();
	      
			return rs.getBigDecimal("Remainder");
			
		}
		
}
	
