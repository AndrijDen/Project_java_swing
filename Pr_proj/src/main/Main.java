package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import database.DbAccess;
import swing.CreateStaff;
import swing.GetAllDepartment;
import swing.GetAllIncomeById;
import swing.GetAllStaff;
import swing.GetDepartment;
import swing.GetStaff;
import swing.ViewAllPositions;
import swing.Denysenko.GetBalanceInformation;
import swing.Denysenko.GetFlowInformation;
import swing.Denysenko.GetProjectInformation;
import swing.CreateDepartment;
import swing.CreateProject;
import swing.GetAllProjects;
import swing.GetProject;


public class Main {

	private JFrame frame;
	private DbAccess dba;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DbAccess.connectionDb("projects", "root", "root");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		dba = new DbAccess();
		dba.getConn();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		frame = new JFrame();
		frame.setBounds(100, 100, 698, 517);
		frame.setTitle("Main Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel allStaffLabel = new JLabel("Click to get all staff:");
		allStaffLabel.setBounds(333, 48, 179, 14);
		frame.getContentPane().add(allStaffLabel);
		
		JButton allStaff = new JButton("Get all staff");
		allStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GetAllStaff gap = new GetAllStaff();
			}
		});
		allStaff.setBounds(171, 41, 129, 30);
		allStaff.setSize(150, 30);
		frame.getContentPane().add(allStaff);
		
		
		
		JLabel getStaffLabel = new JLabel("Enter staff id: ");
		getStaffLabel.setBounds(10, 71, 104, 22);
		frame.getContentPane().add(getStaffLabel);
		
		SpinnerModel val = new SpinnerNumberModel(1,1,1000000,1);
		JSpinner getStuffSpinner = new JSpinner(val);
		getStuffSpinner.setBounds(126, 72, 46, 20);
		frame.getContentPane().add(getStuffSpinner);
		
		JButton getStaffButton = new JButton("Get staff");
		getStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = (int)getStuffSpinner.getValue();
				GetStaff gp = new GetStaff(id);
			}
		});
		getStaffButton.setBounds(171, 72, 150, 23);
		frame.getContentPane().add(getStaffButton);
		
		
		JLabel addStaffLabel = new JLabel("Click to create new staff: ");
		addStaffLabel.setBounds(10, 101, 161, 14);
		frame.getContentPane().add(addStaffLabel);
		
		JButton addStaffButton = new JButton("New staff");
		addStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateStaff cp = new CreateStaff();
			}
		});
		addStaffButton.setBounds(171, 98, 150, 23);
		frame.getContentPane().add(addStaffButton);
		
		JLabel lblDepartments = new JLabel("DEPARTMENTS");
		lblDepartments.setBounds(445, 12, 103, 16);
		frame.getContentPane().add(lblDepartments);
		
		JLabel label = new JLabel("Click to get all departments:");
		label.setBounds(10, 47, 195, 14);
		frame.getContentPane().add(label);
		
		JButton btnGetAllDepartments = new JButton("Get all departments");
		btnGetAllDepartments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg00) {
				GetAllDepartment gad = new GetAllDepartment();
			}
		});
		btnGetAllDepartments.setBounds(532, 41, 150, 30);
		frame.getContentPane().add(btnGetAllDepartments);
		
		JLabel lblEnterDepartmentId = new JLabel("Enter department id: ");
		lblEnterDepartmentId.setBounds(333, 71, 150, 22);
		frame.getContentPane().add(lblEnterDepartmentId);
		
		SpinnerModel spinner = new SpinnerNumberModel(1,1,1000000,1);
		JSpinner getDepSpinner = new JSpinner(spinner);
		getDepSpinner.setBounds(474, 74, 46, 20);
		frame.getContentPane().add(getDepSpinner);
		
//		JSpinner spinner = new JSpinner((SpinnerModel) null);
//		spinner.setBounds(161, 208, 60, 20);
//		frame.getContentPane().add(spinner);
		
		JButton btnGetDepartment = new JButton("Get department");
		btnGetDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg00) {
				int id = (int)getDepSpinner.getValue();
				GetDepartment gs = new GetDepartment(id);
			}
		});
		btnGetDepartment.setBounds(532, 72, 150, 23);
		frame.getContentPane().add(btnGetDepartment);

		
		JLabel lblClickToCreate = new JLabel("Click to create new department: ");
		lblClickToCreate.setBounds(333, 101, 215, 14);
		frame.getContentPane().add(lblClickToCreate);
		
		JButton btnNewDepartment = new JButton("New department");
		btnNewDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg00) {
				CreateDepartment cd = new CreateDepartment();
			}
		});
		btnNewDepartment.setBounds(534, 98, 150, 23);
		frame.getContentPane().add(btnNewDepartment);
		
	
		
		JLabel lblEmployees = new JLabel("EMPLOYEES");
		lblEmployees.setBounds(138, 12, 81, 16);
		frame.getContentPane().add(lblEmployees);
		
		JLabel lblClickToGet = new JLabel("Click to get all positions:");
		lblClickToGet.setBounds(10, 138, 162, 14);
		frame.getContentPane().add(lblClickToGet);
		
		JButton btnGetAllPositions = new JButton("Get all positions");

		btnGetAllPositions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg00) {
				ViewAllPositions vap = new ViewAllPositions();
			}
		});
		btnGetAllPositions.setBounds(171, 135, 150, 23);
		frame.getContentPane().add(btnGetAllPositions);
		
		JLabel lblEnterStaffId = new JLabel("Enter staff id:");
		lblEnterStaffId.setBounds(10, 198, 93, 14);
		frame.getContentPane().add(lblEnterStaffId);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), null, null, new Integer(1)));
		spinner_1.setBounds(95, 195, 46, 20);
		frame.getContentPane().add(spinner_1);
		
		JButton btnGetSalaryearnings = new JButton("Get totall income");
		btnGetSalaryearnings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BigDecimal res = dba.getAllIncomeById(Integer.parseInt((spinner_1.getValue().toString())));
				
				//new GetAllIncomeById( Integer.parseInt((spinner_1.getValue().toString())) );
				JOptionPane.showMessageDialog(frame,
					    res.toString(),
					    "Total Income",
					    JOptionPane.PLAIN_MESSAGE);
				
				
				
			}
		});
		btnGetSalaryearnings.setBounds(4, 287, 134, 30);
		frame.getContentPane().add(btnGetSalaryearnings);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(263, 224, 46, 23);
		frame.getContentPane().add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(81, 224, 57, 23);
		frame.getContentPane().add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(263, 257, 46, 22);
		frame.getContentPane().add(spinner_4);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(10, 228, 46, 14);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(10, 261, 46, 14);
		frame.getContentPane().add(lblTo);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(81, 259, 57, 22);
		frame.getContentPane().add(spinner_5);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(183, 258, 46, 22);
		frame.getContentPane().add(spinner_6);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(183, 224, 46, 23);
		frame.getContentPane().add(spinner_7);
		
		JLabel lblIncome = new JLabel("INCOME");
		lblIncome.setBounds(142, 170, 87, 22);
		frame.getContentPane().add(lblIncome);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(45, 228, 46, 14);
		frame.getContentPane().add(lblYear);
		
		JLabel lblYear_1 = new JLabel("Year:");
		lblYear_1.setBounds(45, 261, 46, 14);
		frame.getContentPane().add(lblYear_1);
		
		JButton btnNewButton = new JButton("Get salary");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BigDecimal res = dba.getSalary(Integer.parseInt((spinner_1.getValue().toString())));
				
				JOptionPane.showMessageDialog(frame,
					    res.toString(),
					    "Salary",
					    JOptionPane.PLAIN_MESSAGE);
				
				
			}
		});
		btnNewButton.setBounds(228, 287, 93, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Get earnnigs");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					BigDecimal res = dba.getEarnings(Integer.parseInt((spinner_1.getValue().toString())));
					
					JOptionPane.showMessageDialog(frame,
						    res.toString(),
						    "Earnings",
						    JOptionPane.PLAIN_MESSAGE);
			}
			
		});
		btnNewButton_1.setBounds(130, 287, 104, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setBounds(138, 228, 46, 14);
		frame.getContentPane().add(lblMonth);
		
		JLabel lblMoth = new JLabel("Month:");
		lblMoth.setBounds(140, 261, 46, 14);
		frame.getContentPane().add(lblMoth);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setBounds(236, 229, 46, 14);
		frame.getContentPane().add(lblDay);
		
		JLabel lblDay_1 = new JLabel("Day:");
		lblDay_1.setBounds(236, 263, 46, 14);
		frame.getContentPane().add(lblDay_1);
		
		
		
		
		
		
		JLabel allProjectsLabel = new JLabel("Click to get all projects");
		allProjectsLabel.setBounds(333, 229, 152, 14);
		frame.getContentPane().add(allProjectsLabel);
		
		JButton allProjects = new JButton("Get all projects");
		allProjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GetAllProjects gap = new GetAllProjects();
			}
		});
		allProjects.setBounds(532, 222, 173, 30);
		allProjects.setSize(150, 30);
		frame.getContentPane().add(allProjects);
		
		
		
		JLabel getProjectLabel = new JLabel("Enter project id: ");
		getProjectLabel.setBounds(333, 257, 129, 22);
		frame.getContentPane().add(getProjectLabel);
		
		SpinnerModel value = new SpinnerNumberModel(1,1,1000000,1);
		JSpinner getProjectSpinner = new JSpinner(value);
		getProjectSpinner.setBounds(459, 258, 56, 20);
		frame.getContentPane().add(getProjectSpinner);
		
		JButton getProjectButton = new JButton("Get project");
		getProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id = (int)getProjectSpinner.getValue();
				GetProject gp = new GetProject(id);
			}
		});
		getProjectButton.setBounds(534, 260, 150, 23);
		frame.getContentPane().add(getProjectButton);
		
		
		
		
		JLabel addProjectLabel = new JLabel("Click to create new project: ");
		addProjectLabel.setBounds(333, 294, 185, 14);
		frame.getContentPane().add(addProjectLabel);
		
		JButton addProjectButton = new JButton("New project");
		addProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateProject cp = new CreateProject();
			}
		});
		addProjectButton.setBounds(518, 291, 164, 23);
		frame.getContentPane().add(addProjectButton);
		
		JLabel lblProjects = new JLabel("PROJECTS");
		lblProjects.setBounds(459, 170, 87, 22);
		frame.getContentPane().add(lblProjects);
		
		
//-----------------------------
		
		JLabel allBalanceLabel = new JLabel("Click to get balance information ");
		allBalanceLabel.setBounds(10, 340, 191, 14);
		frame.getContentPane().add(allBalanceLabel);
		
		JButton allBalance = new JButton("Balanse info");
		allBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GetBalanceInformation gap = new GetBalanceInformation();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		allBalance.setBounds(200, 335, 89, 23);
		allBalance.setSize(150, 30);
		frame.getContentPane().add(allBalance);
		
		
		
		
		JLabel allFlowLabel = new JLabel("Click to get flow information ");
		allFlowLabel.setBounds(10, 385, 191, 14);
		frame.getContentPane().add(allFlowLabel);
		
		JButton allFlow = new JButton("Flow info");
		allFlow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GetFlowInformation gap = new GetFlowInformation();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		allFlow.setBounds(200, 375, 89, 23);
		allFlow.setSize(150, 30);
		frame.getContentPane().add(allFlow);
		
//---------------------------------
		
		JLabel allFlowLabel1 = new JLabel("Click to get project information ");
		allFlowLabel1.setBounds(10, 430, 191, 14);
		frame.getContentPane().add(allFlowLabel1);
		
		JButton allFlow1 = new JButton("Projects info");
		allFlow1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GetProjectInformation gap = new GetProjectInformation();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		allFlow1.setBounds(200, 415, 89, 23);
		allFlow1.setSize(150, 30);
		frame.getContentPane().add(allFlow1);
		
	}
	}

