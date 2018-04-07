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
import models.FlowType;
import models.Flow;
import models.FlowCost;
import models.FlowEarnings;
import models.FlowRemuneration;
import models.FlowSalary;
import reposirory.interfaces.IFlowRepository;

public class FlowRepository implements IFlowRepository {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String CONNECTION = "jdbc:mysql://localhost/Projects?useSSL=false";
	
	
	@Override
	public List<Flow> getAll() throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
        PreparedStatement s = c.prepareStatement("SELECT * FROM flow;");
        ResultSet rs = s.executeQuery();
        return toList(rs);
	}

	@Override
	public List<Flow> getAllByDate(Date d) throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
		PreparedStatement s = c.prepareStatement("SELECT * FROM flow where Date=?;");
        s.setDate(1, d);
        ResultSet rs = s.executeQuery();
        
        return toList(rs);
	}

	
	@Override
	public List<Flow> getAllByStartDateToAnd(Date d,Date d2) throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
		PreparedStatement s = c.prepareStatement("SELECT * FROM flow where Date Between ? and ?;");
        s.setDate(1, d);
        s.setDate(2, d2);
        ResultSet rs = s.executeQuery();
        
        return toList(rs);
	}
	
	
	
	
	
	@Override
	public List<Flow> getById(int id) throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
		PreparedStatement s = c.prepareStatement("SELECT * FROM flow WHERE idFlow=?;");
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();
        
        return toList(rs);
	}
	
	@Override
	public List<Flow> getByType(int id) throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
		PreparedStatement s = c.prepareStatement("SELECT * FROM flow WHERE FlowType=?;");
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();
        return toList(rs);
	}
	
	
	
	private Flow toObject(ResultSet rs) throws SQLException {
		if ((Integer)rs.getInt("FlowType") == (Integer)(FlowType.SALARY_MANAGER).getValue())
        	return new FlowSalary(rs.getInt("idFlow"),rs.getInt("idStaff"), rs.getDate("Date"),
        			rs.getBigDecimal("Sum"), rs.getInt("Year"),rs.getInt("Month"),rs.getInt("idStage"),rs.getInt("idBalance"));
        else if ((Integer)rs.getInt("FlowType") == (Integer)(FlowType.EARNINGS_STAFF).getValue())
        	return new FlowEarnings(rs.getInt("idFlow"),rs.getInt("idStaff"), rs.getDate("Date"),
        			rs.getBigDecimal("Sum"), rs.getInt("Year"),rs.getInt("Month"),rs.getInt("idStage"),rs.getInt("idBalance"));
        else if ((Integer)rs.getInt("FlowType") == (Integer)(FlowType.REMUNERATION_WORK).getValue())
        	return new FlowRemuneration(rs.getInt("idFlow"),rs.getInt("idStaff"), rs.getDate("Date"),
        			rs.getBigDecimal("Sum"), rs.getInt("Year"),rs.getInt("Month"),rs.getInt("idStage"),rs.getInt("idBalance"));
        else 
        	return new FlowCost(rs.getInt("idFlow"),rs.getInt("idStaff"), rs.getDate("Date"),
        			rs.getBigDecimal("Sum"), rs.getInt("Year"),rs.getInt("Month"),rs.getInt("idStage"),rs.getInt("idBalance"));
    }
	
	 
	@Override
	public BigDecimal getSumOfAllFlowFromProjects() throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c=DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
		PreparedStatement s = c.prepareStatement("Select sum(f.Sum) as Sum from flow f Inner join stage st on f.idStage=st.idStage where st.idProject=1" );
	    //	    PreparedStatement s = c.prepareStatement("Select sum(f.Sum) as Sum from (( flow f Inner join stage st on f.idStage=st.idStage) Inner join project pr on f.idPRoject=pr.idProject y)" );
	    ResultSet rs = s.executeQuery();
		rs.next();
		return rs.getBigDecimal("Sum"); 
	}
	
	@Override
	public BigDecimal getSumOfAllFlowFromProjectsBy_Date(Date d) throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
		PreparedStatement s = c.prepareStatement("Select sum(f.Sum) as Sum from flow f Inner join stage st on f.idStage=st.idStage where f.Date=?" );
	    //	    PreparedStatement s = c.prepareStatement("Select sum(f.Sum) as Sum from (( flow f Inner join stage st on f.idStage=st.idStage) Inner join project pr on f.idPRoject=pr.idProject y)" );
        s.setDate(1, d);
	    ResultSet rs = s.executeQuery();
		rs.next();
		return rs.getBigDecimal("Sum"); 
	}
	
	/*private BigDecimal getSumOfCostFromStage(int id) throws SQLException {
		 Connection c = DBConnection.getConnection();
		 PreparedStatement s = c.prepareStatement("SELECT SUM(Cost) AS Cost FROM stage WHERE idProject=? ");
		 s.setInt(1, id);
		 ResultSet rs = s.executeQuery();
		 rs.next();
		 return rs.getBigDecimal("Cost"); 
	 }*/
	/*
	 * SALARY_MANAGER(1),
	//заробіток
	EARNINGS_STAFF(2),
	//винагорода
	REMUNERATION_WORK(3),
	//вартість
	COST_STAGE(4);
	*/
	
    private List<Flow> toList(ResultSet rs) throws SQLException {
        List<Flow> list = new ArrayList<Flow>();
        while (rs.next()) list.add(toObject(rs));
        return list;
    }

	



	

	


	
}
