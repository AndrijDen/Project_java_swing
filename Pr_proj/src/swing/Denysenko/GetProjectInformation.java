package swing.Denysenko;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DbAccess;
import models.Project;
import reposirory.interfaces.IBalanceRepository;
import reposirory.interfaces.IProjectRepository;
import repositories.BalanceRepository;
import repositories.ProjectRepository;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class GetProjectInformation extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField id;
	private JTextField owner;
	private JButton createButton;
	private JSpinner price;
	private JLabel lblStartYear;
	private JSpinner flowType;
	private JSpinner startYear;
	private JLabel lblStartMonth;
	private JSpinner startMonth;
	private JLabel lblStartDay;
	private JSpinner startDay;
	private JLabel lblPlannedEndYear;
	private JSpinner endYear;
	private JLabel lblMonth;
	private JSpinner endMonth;
	private JLabel lblDay;
	private JSpinner endDay;
	IProjectRepository prRep = new ProjectRepository();
	
	public GetProjectInformation() throws SQLException{
		initialize();
		frame.setVisible(true);
	}
	private void initialize() throws SQLException {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 350);
		
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Flow information");
		/*
		balRep.formProfitAll();
		balRep.formSpendingAll();
		balRep.formRemainderAll();
		*/
		//----
		JLabel allFlowLabel = new JLabel("Click to get all projects");
		allFlowLabel.setBounds(10, 30, 131, 14);
		frame.getContentPane().add(allFlowLabel);
		
		
		JButton allFlow = new JButton("Get all projects");
		allFlow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GetAllProjectD gap = new GetAllProjectD();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		allFlow.setBounds(200, 25, 89, 23);
		allFlow.setSize(150, 30);
		frame.getContentPane().add(allFlow);
		
//----------------
		
		JLabel allFlowLabel1 = new JLabel("Click to get project by id");
		allFlowLabel1.setBounds(10, 75, 131, 14);
		frame.getContentPane().add(allFlowLabel1);
		
		id = new JTextField();
		id.setBounds(150, 72, 40, 20);
		frame.getContentPane().add(id);
		id.setColumns(30);
		
		JButton allFlow1 = new JButton("Get project by id");
		allFlow1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idi = Integer.parseInt(id.getText());
				
				try {
					GetAllProjectD gap = new GetAllProjectD(idi);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		allFlow1.setBounds(200, 65, 89, 23);
		allFlow1.setSize(150, 30);
		frame.getContentPane().add(allFlow1);
		
//-----------------------
	
		
		lblStartYear = new JLabel("Year:");
		lblStartYear.setBounds(10, 146,40, 14);
		frame.getContentPane().add(lblStartYear);
		
		SpinnerModel year = new SpinnerNumberModel(1,1,10000000,1);
		startYear = new JSpinner(year);
		startYear.setBounds(40, 143, 56, 20);
		frame.getContentPane().add(startYear);
		
		lblStartMonth = new JLabel("Month:");
		lblStartMonth.setBounds(110, 146, 40, 14);
		frame.getContentPane().add(lblStartMonth);
		
		SpinnerModel month = new SpinnerNumberModel(1,1,12,1);
		startMonth = new JSpinner(month);
		startMonth.setBounds(150, 143, 46, 20);
		frame.getContentPane().add(startMonth);
		
		lblStartDay = new JLabel("Day:");
		lblStartDay.setBounds(210, 146, 40, 14);
		frame.getContentPane().add(lblStartDay);
		
		SpinnerModel day = new SpinnerNumberModel(1,1,31,1);
		startDay = new JSpinner(day);
		startDay.setBounds(240, 143, 46, 20);
		frame.getContentPane().add(startDay);
		
		createButton = new JButton("Get");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date d = new Date((int)startYear.getValue()-1900, (int)startMonth.getValue()-1, (int)startDay.getValue());
				System.out.println(d);
				try {
					GetAllProjectD gap = new GetAllProjectD(d);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		createButton.setBounds(110, 185, 89, 23);
		frame.getContentPane().add(createButton);
		
		
	}
}
