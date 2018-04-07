package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import models.Project;
import models.Stage;
import reposirory.interfaces.IStageRepository;

public class StageRepository implements IStageRepository {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String CONNECTION = "jdbc:mysql://localhost/Projects?useSSL=false";
	
	@Override
	public List<Stage> getAll() throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
		PreparedStatement s = c.prepareStatement("SELECT * FROM stage;");
        ResultSet rs = s.executeQuery();
		return toList(rs);

	}


	@Override
	public Stage getById(int id) throws SQLException {
		Connection c = DBConnection.getConnection();
		 if(c.isClosed()) {
			 System.out.println("Hello");
			 c =DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD); ;
			 
		 }
		PreparedStatement s = c.prepareStatement("SELECT * FROM stage WHERE idStage=?");
        s.setLong(1, id);
        ResultSet rs = s.executeQuery();
        
		return toObject(rs);
	}
		private Stage toObject(ResultSet rs) throws SQLException {
	    	return new Stage(rs.getInt("idStage"),rs.getInt("Number"),rs.getInt("idProject"),rs.getDate("Beginning"), rs.getDate("EndingPlanned"),rs.getDate("EndingFact"),rs.getDouble("Cost"),rs.getDouble("Spending")); 
	}


		 private List<Stage> toList(ResultSet rs) throws SQLException {
		        List<Stage> list = new ArrayList<Stage>();
		        while (rs.next()) list.add(toObject(rs));
		        return list;
		    }
}
