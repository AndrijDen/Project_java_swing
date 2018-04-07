package repositories;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import database.DBConnection;
import database.DbAccess;
import models.Flow;
import models.Project;
import reposirory.interfaces.IProjectRepository;

public class ProjectRepository implements IProjectRepository {
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String CONNECTION = "jdbc:mysql://localhost/Projects?useSSL=false";
	
	@Override
	public List<Project> getAll() throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
        PreparedStatement s = c.prepareStatement("SELECT * FROM project;");
        ResultSet rs = s.executeQuery();
		return toList(rs);

	}


	@Override
	public List<Project> getById(int id) throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
        PreparedStatement s = c.prepareStatement("SELECT * FROM project WHERE idProject=?;");
        s.setLong(1, id);
        ResultSet rs = s.executeQuery();
        
		return toList(rs);
	}
	
	
	@Override
	public List<Project> getAllByDate(Date d) throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
		 }
		PreparedStatement s = c.prepareStatement("SELECT * FROM project where Beginning=?;");
        s.setDate(1, d);
        ResultSet rs = s.executeQuery();
        return toList(rs);
	}
	
	
	
	private Project toObject(ResultSet rs) throws SQLException {
	    	return new Project(rs.getInt("idProject"),rs.getString("Name"),rs.getInt("idDepartment"),rs.getString("Client"),rs.getDate("Beginning"), rs.getDate("EndingPlanned"),rs.getDate("EndingFact"),rs.getDouble("Cost"), rs.getDouble("Spending"),rs.getString("Rate")); 
	}


	private List<Project> toList(ResultSet rs) throws SQLException {
		        List<Project> list = new ArrayList<Project>();
		        while (rs.next()) list.add(toObject(rs));
		        return list;
	}
	
	private Date getStartDate() throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
        PreparedStatement s = c.prepareStatement("SELECT MIN(Date) As Date FROM project");
        ResultSet rs = s.executeQuery();
        
		return rs.getDate("Date");
	}

		 /*
		private BigDecimal getSumOfCostFromStage(int id) throws SQLException {
			 Connection c = DBConnection.getConnection();
			 PreparedStatement s = c.prepareStatement("SELECT SUM(Cost) AS Cost FROM stage WHERE idProject=? ");
			 s.setInt(1, id);
			 ResultSet rs = s.executeQuery();
			 rs.next();
			 return rs.getBigDecimal("Cost"); 
		 }
		 */
		@Override
		public void toFormCost(int id) throws SQLException {
			Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			try {
		    PreparedStatement sp = c.prepareStatement("update project set Cost=(SELECT SUM(Cost) AS Cost FROM stage WHERE idProject=?) where idProject=?" );
		    sp.setInt(1, id);
		    sp.setInt(2, id);	    
		    sp.executeUpdate();
		    c.close();
		    }catch (SQLException e){System.out.println("updatePrinting : " + e.getMessage());}
		}
		
		
		@Override
		public BigDecimal getSumOfCostFromStage(int id) throws SQLException{
			 Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			 PreparedStatement s = c.prepareStatement("SELECT SUM(Cost) AS Cost FROM stage WHERE idProject=?");
			 s.setInt(1, id);
			 ResultSet rs = s.executeQuery();
			 
			 return rs.getBigDecimal("Cost"); 
		 }
		

		@Override
		public BigDecimal getSumOfCostFromAllProject() throws SQLException {
			 Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			 PreparedStatement s = c.prepareStatement("SELECT SUM(Cost) AS Cost FROM Project");
			 ResultSet rs = s.executeQuery();
			 rs.next();
			 
			 return rs.getBigDecimal("Cost"); 
		}
		
		@Override
		public BigDecimal getSumOfSpendingFromStage(int id) throws SQLException {
			 Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			 PreparedStatement s = c.prepareStatement("SELECT SUM(Spending) AS Spending FROM stage WHERE idProject=? ");
			 s.setInt(1, id);
			 ResultSet rs = s.executeQuery();
			 
			 return rs.getBigDecimal("Spending"); 
		 }
		 

		@Override
		public void toFormSpending(int id) throws SQLException {
			Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			try {
				
		    PreparedStatement sp = c.prepareStatement("update project set Spending=? where idProject=?" );
		    sp.setBigDecimal(1, getSumOfSpendingFromStage(id));
		    sp.setInt(2, id);	    
		    sp.executeUpdate();
		    c.close();
		    }catch (SQLException e){System.out.println("updatePrinting : " + e.getMessage());}
			
		}

		
		  private static final String formateTheCost = "SELECT SUM(COST) FROM stage INNER JOIN project ON stage.idProject=project.idProject";


		@Override
		public BigDecimal getSumOfSpendingFromAllProject() throws SQLException {
			 Connection c = DBConnection.getConnection();
			 if(c.isClosed()) {
				 System.out.println("Hello");
				 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
				 
			 }
			 PreparedStatement s = c.prepareStatement("SELECT SUM(Spending) AS Spending FROM Project");
			 ResultSet rs = s.executeQuery();
			 
			 return rs.getBigDecimal("Spending"); 

		}


}
