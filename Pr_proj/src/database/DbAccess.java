package database;
import java.math.BigDecimal;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import models.Costs;
import models.Staff;
import models.Stage;
import models.Position;
import models.Project;
import models.Department;
import models.Flow;
import models.FlowType;
import models.FlowCost;
import models.FlowEarnings;
import models.FlowRemuneration;
import models.FlowSalary;


public class DbAccess {
	private static Connection conn = null;
	private static Statement s;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public DbAccess() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("DbAccess> " + ex.getMessage());
		}
	}

	public static boolean connectionDb(String db, String user, String passwd) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/" + db + "?useSSL=false", user, passwd);
			s = conn.createStatement();
			return true;
		} catch (SQLException e) {
			System.out.println("connectionDB> " + e.getMessage());
			return false;
		}
	}

	public void disConnect() {
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			System.out.println("disConnect> " + e.getMessage());
		}
	}
	
	public static Connection getConn() {
		if (conn == null) {
			connectionDb("projects", "root", "root");
		}
		return conn;
	}

	public int addStaff(String surname, String sex, Date birthDate) {

		int rows = 0;
		try {
			ps = conn.prepareStatement(
					"insert into Staff (Surname, Sex, birthDate) values(?,?,?)");
			ps.setString(1, surname);
			ps.setString(2, sex);
			ps.setDate(3, birthDate);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("addStaff :" + e.getMessage());
		}
		return rows;
	}

	public Staff getStaff(int id) {
		Staff p = null;
		try {
			sql = "select Surname, Sex, BirthDate  from Staff where idStaff = "
					+ id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			if ((rs != null) && (rs.next())) {
				p = new Staff(id, rs.getString(1), rs.getString(2), rs.getDate(3));
			}
		} catch (SQLException e) {
			System.out.println("getStaff : " + e.getMessage());
		}
		return p;
	}

	public ArrayList<Staff> getAllStaff() {
		ArrayList<Staff> res = new ArrayList<Staff>();
		try {
			sql = "select idStaff, Surname, Sex, BirthDate from Staff";
			Statement s1 = conn.createStatement();
			s1.execute(sql);
			ResultSet rs = s1.getResultSet();

			while ((rs != null) && (rs.next())) {
				res.add(getStaff(rs.getInt(1)));
			}
		} catch (SQLException e) {
			System.out.println("getAllStaff : " + e.getMessage());
		}
		return res;
	}
	
	java.util.Date today =
	        new java.util.Date();
	java.sql.Date sqlToday =
	        new java.sql.Date(today.getTime());

	
	public ArrayList<Staff> getAllStaffDep(int id) {
		ArrayList<Staff> res = new ArrayList<Staff>();
		try {
			sql = "select * from Staff inner join Position on Staff.idStaff = Position.idStaff Where idDepartment =" + id;
			Statement s1 = conn.createStatement();
			s1.execute(sql);
			ResultSet rs = s1.getResultSet();

			while ((rs != null) && (rs.next())) {
				res.add(getStaff(rs.getInt(1)));
			}
		} catch (SQLException e) {
			System.out.println("getAllStaffDep : " + e.getMessage());
		}
		return res;
	}
	
	
	

	public int editStaff(int id, String surname, String sex, Date birthDate) {
		int rows = 0;
		try {
			ps = conn.prepareStatement(
					"update staff set surname = ?, sex = ?, birthDate = ? where idStaff ="
							+ id + ";");
			ps.setString(1, surname);
			ps.setString(2, sex);
			ps.setDate(3, birthDate);

			rows = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("editStaff :" + e.getMessage());
		}
		return rows;
	}

	public void delStaff(int id) {
		try {
			conn.setAutoCommit(false);
			try {
				sql = "delete from position where idStaff = " + id;
				s.executeUpdate(sql);
				sql = "delete from staff where idStaff = " + id;
				s.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println(" delStaff :" + e.getMessage());
			}
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public int addPosition(String title, Date start, Date fact_end, double pay, int idDepartment, int idStaff) {

		int rows = 0;
		try {
			ps = conn.prepareStatement(
					"insert into position (title, beginning, ending, pay, idDepartment, idStaff) values(?,?,?,?,?,?)");
			ps.setString(1, title);
			ps.setDate(2, start);
			ps.setDate(3, fact_end);
			ps.setDouble(4, pay);
			ps.setInt(5, idDepartment);
			ps.setInt(6, idStaff);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("addPosition :" + e.getMessage());
		}
		return rows;
	}
	
	public Position getPosition(int id) {
		Position p = null;
		try {
			sql = "select title, beginning, ending, pay, idDepartment, idStaff from position where idPosition = "
					+ id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			if ((rs != null) && (rs.next())) {
				p  = new Position(id, rs.getString(1), rs.getDate(2), rs.getDate(3), rs.getDouble(4),
						rs.getInt(5), rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println("getPosition : " + e.getMessage());
		}
		return p;
		
	}

	public ArrayList<Position> getAllPositions(int id) {
		ArrayList<Position> res = new ArrayList<Position>();
		try {
			sql = "select * from position where idStaff=" + id + ";";
			Statement s1 = conn.createStatement();
			s1.execute(sql);
			ResultSet rs = s1.getResultSet();

			while ((rs != null) && (rs.next())) {
				res.add(getPosition(rs.getInt(1)));
			}
		} catch (SQLException e) {
			System.out.println("getAllPositions : " + e.getMessage());
		}
		return res;
	}

	public int editPosition(int id, String title, Date start, Date fact_end, double pay, int idDepartment, int idStaff) {
		int rows = 0;
		try {
			ps = conn.prepareStatement(
					"update position set title = ?, Beginning = ?, Ending = ?, Pay = ?, idDepartment = ?, idStaff = ? where idPosition ="
							+ id + ";");
			ps.setString(1, title);
			ps.setDate(2, start);
			ps.setDate(3, fact_end);
			ps.setDouble(4, pay);
			ps.setInt(5, idDepartment);
			ps.setInt(6, idStaff);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("editPosition :" + e.getMessage());
		}
		return rows;
	}
	
	public void delPosition(int id) {
		try {
			conn.setAutoCommit(false);
			try {
				sql = "delete from position where idPosition = " + id;
				s.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println(" delPosition :" + e.getMessage());
			}
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int addDepartment(String name, String phoneNum) {

		int rows = 0;
		try {
			ps = conn.prepareStatement(
					"insert into Department (name, phoneNum) values(?,?)");
			ps.setString(1, name);
			ps.setString(2, phoneNum);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("addDepartment :" + e.getMessage());
		}
		return rows;
	}

	public Department getDepartment(int id) {
		Department p = null;
		try {
			sql = "select *  from Department where idDepartment = "
					+ id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			if ((rs != null) && (rs.next())) {
				p = new Department(id, rs.getString("Name"), rs.getString("PhoneNum"));
			}
		} catch (SQLException e) {
			System.out.println("getDepartment : " + e.getMessage());
		}
		return p;
	}

	public ArrayList<Department> getAllDepartment() {
		ArrayList<Department> res = new ArrayList<Department>();
		try {
			sql = "select idDepartment, name, phoneNum from Department";
			Statement s1 = conn.createStatement();
			s1.execute(sql);
			ResultSet rs = s1.getResultSet();
		
			while ((rs != null) && (rs.next())) {
		
				res.add(getDepartment(rs.getInt("idDepartment")));
				
			}
		} catch (SQLException e) {
			System.out.println("getAllDepartment : " + e.getMessage());
		}
		
//		for(Department department:res) {
//			System.out.println(department.getName());
//			System.out.println(department.getPhoneNum());
//
//		}
		return res;
	}

	public int editDepartment(int id, String name, String phoneNum) {
		int rows = 0;
		try {
			ps = conn.prepareStatement(
					"update Department set name = ?, phoneNum = ? where idDepartment ="
							+ id + ";");
			ps.setString(1, name);
			ps.setString(2, phoneNum);

			rows = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("editDepartment :" + e.getMessage());
		}
		return rows;
	}

	public void delDepartment(int id) {
		try {
			conn.setAutoCommit(false);
			try {
				sql = "delete from Department where idDepartment = " + id;
				s.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println(" delDepartment :" + e.getMessage());
			}
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public int addProject_costs(int stage_id, Date date, int year, int month, double sum){
		int rows = 0;
		try {
			ps = conn.prepareStatement(
					"insert into flow (idStage, date, year, month, sum, FlowType) values(?,?,?,?,?,?)");
			ps.setInt(1, stage_id);
			ps.setDate(2, date);
			ps.setInt(3, year);
			ps.setInt(4, month);
			ps.setDouble(5, sum);
			ps.setInt(6, 4);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("addProject_costs :" + e.getMessage());
		}
		return rows;
	}
	
	
public ArrayList<Position> viewAllPositions(){
	ArrayList<Position> res = new ArrayList<Position>();
	try {
		sql = "SELECT * FROM position;" ;
				Statement s1 = conn.createStatement();
		s1.execute(sql);
		ResultSet rs = s1.getResultSet();

		while ((rs != null) && (rs.next())) {
			res.add(getPosition(rs.getInt(1)));
		}
	} catch (SQLException e) {
		System.out.println("viewAllPositions : " + e.getMessage());
	}
	return res;
	}


public ArrayList<Position> getAllPositionsDate(int id,String st,String en) throws ParseException, SQLException {
	ArrayList<Position> getAllByDate = new ArrayList<Position>();
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date date = sdf1.parse(st);
	java.util.Date date2 = sdf1.parse(en);

	java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());  
	java.sql.Date sqlEndDate = new java.sql.Date(date2.getTime()); 
	try {
		String secSql = "SELECT *  FROM projects.position WHERE projects.position.idStaff ="+id+" AND projects.position.Beginning<= "+st+" AND projects.position.Ending >= "+en+";";
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(secSql);
		
		if(!rs.next())
			System.out.println("EMPTY");
		
		while(rs.next()) {
			int i=1;
			System.out.println(i++);
			/*Position position = new Position(rs.getInt("idPosition"), rs.getString("Title"), rs.getDate("Beggining"), rs.getDate("Ending"), rs.getLong("Pay"), rs.getInt("idDepartment"), rs.getInt("idStaff"));
			getAllByDate.add(position);
*/		}
		
	} catch (SQLException e) {
		System.out.println("getAllPositionsDate : " + e.getMessage());
	}
	return getAllByDate;
}
	   public ArrayList<Flow> getAllFlowById(int idStaff){
		ArrayList<Flow> res = new ArrayList<Flow>();
		try {
			sql = "SELECT * FROM projects.flow where flowType = 3 and idStaff=" + idStaff + ";";
			PreparedStatement s1 = conn.prepareStatement(sql);
			s1.executeQuery();
			ResultSet rs = s1.executeQuery();
			
			while (rs.next()) {		
				
				Flow flow = new Flow(rs.getInt("idFlow"), rs.getInt("idStaff"), rs.getDate("date"), rs.getBigDecimal("sum"), rs.getInt("year"), rs.getInt("month"), rs.getInt("idStage"),
						rs.getInt("idBalance"), FlowType.values()[(rs.getInt("flowType"))]);
				res.add((flow));
			}
		} catch (SQLException e) {
			System.out.println("getAllIncomeById : " + e.getMessage());
		}
		return res;
	}
	   
	   
	 public BigDecimal getAllIncomeById(int idStaff){
		 BigDecimal res = null;
		 try {
				sql = "SELECT * FROM projects.flow where flowType = 3 and idStaff=" + idStaff + ";";
				PreparedStatement s1 = conn.prepareStatement(sql);
				s1.executeQuery();
				ResultSet rs = s1.executeQuery();
				
				rs.next();
				res = rs.getBigDecimal("Sum");
		
			} catch (SQLException e) {
				System.out.println("getAllIncomeById : " + e.getMessage());
			}
		 return res;
	 
	 }
	
	 public BigDecimal getEarnings(int idStaff){
		 BigDecimal res = null;
		 try {
				sql = "SELECT * FROM projects.flow where flowType = 1 and idManager=" + idStaff + ";";
				PreparedStatement s1 = conn.prepareStatement(sql);
				s1.executeQuery();
				ResultSet rs = s1.executeQuery();
				
				rs.next();
				res = rs.getBigDecimal("Sum");
		
			} catch (SQLException e) {
				System.out.println("getEarnings : " + e.getMessage());
			}
		 return res;
		 
		  }
	
	 public BigDecimal getSalary(int idStaff){
		 BigDecimal res = null;
		 try {
				sql = "SELECT * FROM projects.flow where flowType = 2 and idStaff=" + idStaff + ";";
				PreparedStatement s1 = conn.prepareStatement(sql);
				s1.executeQuery();
				ResultSet rs = s1.executeQuery();
				
				rs.next();
				res = rs.getBigDecimal("Sum");
		
			} catch (SQLException e) {
				System.out.println("getSalary : " + e.getMessage());
			}
		 return res;
		 
	 }
	 
	public ArrayList<FlowCost> getAllCosts(int stage_id){
		ArrayList<FlowCost> res = new ArrayList<FlowCost>();
		try {
			sql = "select * from flow where idStage =" + stage_id + " AND FlowType = 4;";
			Statement s1 = conn.createStatement();
			s1.execute(sql);
			ResultSet rs = s1.getResultSet();
			
			while ((rs != null) && (rs.next())) {
				FlowCost c = new FlowCost(rs.getInt(1),rs.getInt(6), rs.getDate(2), rs.getBigDecimal(3), rs.getInt(4), rs.getInt(5), rs.getInt(9), rs.getInt(10));
				res.add(c);
			}
		} catch (SQLException e) {
			System.out.println("getAllCosts: " + e.getMessage());
		}
		return res;

	}
	public int addProject(String name, int department_id, String owner, Date start, Date planned_end, double price) {

		int rows = 0;
		try {
			ps = conn.prepareStatement(
					"insert into project (Name, idDepartment, Client, Beginning, EndingPlanned, EndingFact, Cost, Spending, Rate) values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setInt(2, department_id);
			ps.setString(3, owner);
			ps.setDate(4, start);
			ps.setDate(5, planned_end);
			ps.setDate(6, null);
			ps.setDouble(7, price);
			ps.setDouble(8, 0);
			ps.setString(9, null);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("addProject :" + e.getMessage());
		}
		return rows;
	}

	public Project getProject(int id) {
		Project p = null;
		try {
			sql = "select name, idDepartment, Client, Beginning, EndingPlanned, EndingFact, Cost, Spending, Rate from project where idProject = "
					+ id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			if ((rs != null) && (rs.next())) {
				p = new Project(id, rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getDate(6), rs.getDouble(7), rs.getDouble(8), rs.getString(9));
			}
		} catch (SQLException e) {
			System.out.println("getProject : " + e.getMessage());
		}
		return p;
	}

	public ArrayList<Project> getAllProjects() {
		ArrayList<Project> res = new ArrayList<Project>();
		try {
			sql = "select * from project";
			Statement s1 = conn.createStatement();
			s1.execute(sql);
			ResultSet rs = s1.getResultSet();

			while ((rs != null) && (rs.next())) {
				res.add(getProject(rs.getInt(1)));
			}
		} catch (SQLException e) {
			System.out.println("getAllProjects : " + e.getMessage());
		}
		return res;
	}

	public int editProject(int id, String name, int department_id, String owner, Date start, Date planned_end,
			Date real_end, double price, double costs, String mark) {
		int rows = 0;
		try {
			ps = conn.prepareStatement(
					"update project set name = ?, idDepartment = ?, Client = ?, Beginning = ?, EndingPlanned = ?, EndingFact = ?, Cost = ?, Spending = ?, Rate = ? where idProject ="
							+ id + ";");
			ps.setString(1, name);
			ps.setInt(2, department_id);
			ps.setString(3, owner);
			ps.setDate(4, start);
			ps.setDate(5, planned_end);
			ps.setDate(6, real_end);
			ps.setDouble(7, price);
			ps.setDouble(8, costs);
			ps.setString(9, mark);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("editProject :" + e.getMessage());
		}
		return rows;
	}

	public void delProject(int id) {
		try {
			conn.setAutoCommit(false);
			try {
				sql = "delete from stage where idProject = " + id;
				s.executeUpdate(sql);
				sql = "delete from project where idProject = " + id;
				s.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println(" delProject :" + e.getMessage());
			}
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public int addStage(int number, int project_id, Date start, Date planned_end, double price) {

		int rows = 0;
		try {
			ps = conn.prepareStatement(
					"insert into stage (Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending) values(?,?,?,?,?,?,?)");
			ps.setInt(1, number);
			ps.setInt(2, project_id);
			ps.setDate(3, start);
			ps.setDate(4, planned_end);
			ps.setDate(5, null);
			ps.setDouble(6, price);
			ps.setDouble(7, 0);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("addStage :" + e.getMessage());
		}
		return rows;
	}
	
	public Stage getStage(int id) {
		Stage st = null;
		try {
			sql = "select Number, idProject, Beginning, EndingPlanned, EndingFact, Cost, Spending from stage where idStage = "
					+ id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			if ((rs != null) && (rs.next())) {
				st = new Stage(id, rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4),
						rs.getDate(5), rs.getDouble(6), rs.getDouble(7));
			}
		} catch (SQLException e) {
			System.out.println("getStage : " + e.getMessage());
		}
		return st;
	}

	public ArrayList<Stage> getAllStages(int id) {
		ArrayList<Stage> res = new ArrayList<Stage>();
		try {
			sql = "select * from stage where idProject=" + id + ";";
			Statement s1 = conn.createStatement();
			s1.execute(sql);
			ResultSet rs = s1.getResultSet();

			while ((rs != null) && (rs.next())) {
				res.add(getStage(rs.getInt(1)));
			}
		} catch (SQLException e) {
			System.out.println("getAllStages : " + e.getMessage());
		}
		return res;
	}

	public int editStage(int id, int number, Date start, Date planned_end,
			Date real_end, double price, double costs) {
		int rows = 0;
		try {
			ps = conn.prepareStatement(
					"update stage set Number = ?, Beginning = ?, EndingPlanned = ?, EndingFact = ?, Cost = ?, Spending = ? where idStage ="
							+ id + ";");
			ps.setInt(1, number);
			ps.setDate(2, start);
			ps.setDate(3, planned_end);
			ps.setDate(4, real_end);
			ps.setDouble(5, price);
			ps.setDouble(6, costs);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("editStage :" + e.getMessage());
		}
		return rows;
	}
	
	public void delStage(int id) {
		try {
			conn.setAutoCommit(false);
			try {
				sql = "delete from stage where idStage = " + id;
				s.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println(" delStage :" + e.getMessage());
			}
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	


	
}
