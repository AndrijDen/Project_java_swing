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
import repositories.BalanceRepository;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class GetFlowInformation extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField id;
	private JTextField owner;
	private JButton createButton;
	private JButton createButton2;
	private JSpinner price;
	private JLabel lblStartYear;
	private JSpinner flowType;
	private JSpinner startYear;
	private JLabel lblStartMonth;
	private JSpinner startMonth;
	private JLabel lblStartDay;
	private JSpinner startDay;
	private JLabel lbYear;
	private JSpinner endYear;
	private JLabel lbMonth;
	private JSpinner endMonth;
	private JLabel lbDay;
	private JSpinner endDay;
	private JLabel lbYear2;
	private JSpinner endYear2;
	private JLabel lbMonth2;
	private JSpinner endMonth2;
	private JLabel lbDay2;
	private JSpinner endDay2;
	IBalanceRepository balRep = new BalanceRepository();
	
	public GetFlowInformation() throws SQLException{
		initialize();
		frame.setVisible(true);
	}
	private void initialize() throws SQLException {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 380, 450);
		
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Flow information");
		/*
		balRep.formProfitAll();
		balRep.formSpendingAll();
		balRep.formRemainderAll();
		*/
		//----
		JLabel allFlowLabel = new JLabel("Click to get all flow");
		allFlowLabel.setBounds(10, 30, 131, 14);
		frame.getContentPane().add(allFlowLabel);
		
		
		JButton allFlow = new JButton("Get all flow");
		allFlow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GetAllFlowD gap = new GetAllFlowD();
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
		
		JLabel allFlowLabel1 = new JLabel("Click to get flow by id");
		allFlowLabel1.setBounds(10, 75, 131, 14);
		frame.getContentPane().add(allFlowLabel1);
		
		id = new JTextField();
		id.setBounds(150, 72, 40, 20);
		frame.getContentPane().add(id);
		id.setColumns(30);
		
		JButton allFlow1 = new JButton("Get flow by id");
		allFlow1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idi = Integer.parseInt(id.getText());
				
				try {
					GetAllFlowD gap = new GetAllFlowD(idi);
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
		
		JLabel allFlowLabel2 = new JLabel("Click to get flow by Type");
		allFlowLabel2.setBounds(90, 120, 171, 14);
		frame.getContentPane().add(allFlowLabel2);
		
		JLabel allFlowLabel3 = new JLabel("Salary-1 | Earnings-2 | Remuneration - 3 | Cost - 4.");
		allFlowLabel3.setBounds(10, 150, 291, 14);
		frame.getContentPane().add(allFlowLabel3);
		
		
		SpinnerModel type = new SpinnerNumberModel(1,1,4,1);
		flowType = new JSpinner(type);
		flowType.setBounds(140, 173, 35, 20);
		frame.getContentPane().add(flowType);
		
		
		JButton allFlow2 = new JButton("Get flow by type");
		allFlow2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				try {
					GetFlowByTypeD gap = new GetFlowByTypeD((int)flowType.getValue());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		allFlow2.setBounds(90, 200, 89, 23);
		allFlow2.setSize(150, 30);
		frame.getContentPane().add(allFlow2);
		
		
//--------------------
		
		lblStartYear = new JLabel("Year:");
		lblStartYear.setBounds(10, 246,40, 14);
		frame.getContentPane().add(lblStartYear);
		
		SpinnerModel year = new SpinnerNumberModel(1,1,10000000,1);
		startYear = new JSpinner(year);
		startYear.setBounds(40, 243, 56, 20);
		frame.getContentPane().add(startYear);
		
		lblStartMonth = new JLabel("Month:");
		lblStartMonth.setBounds(110, 246, 40, 14);
		frame.getContentPane().add(lblStartMonth);
		
		SpinnerModel month = new SpinnerNumberModel(1,1,12,1);
		startMonth = new JSpinner(month);
		startMonth.setBounds(150, 243, 46, 20);
		frame.getContentPane().add(startMonth);
		
		lblStartDay = new JLabel("Day:");
		lblStartDay.setBounds(210, 246, 40, 14);
		frame.getContentPane().add(lblStartDay);
		
		SpinnerModel day = new SpinnerNumberModel(1,1,31,1);
		startDay = new JSpinner(day);
		startDay.setBounds(240, 243, 46, 20);
		frame.getContentPane().add(startDay);
		
		createButton = new JButton("Get Flow by date");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date d = new Date((int)startYear.getValue()-1900, (int)startMonth.getValue()-1, (int)startDay.getValue());
				//System.out.println(st);
				try {
					GetAllFlowD gap = new GetAllFlowD(d);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		createButton.setBounds(70, 275, 189, 23);
		frame.getContentPane().add(createButton);
		
//-------------------------------
		
		lbYear = new JLabel("Year:");
		lbYear.setBounds(10, 313,40, 14);
		frame.getContentPane().add(lbYear);
		

		SpinnerModel year2 = new SpinnerNumberModel(1,1,10000000,1);
			endYear = new JSpinner(year2);
			endYear.setBounds(40, 313, 56, 20);
			frame.getContentPane().add(endYear);
			
			lbMonth = new JLabel("Month:");
			lbMonth.setBounds(110, 316, 40, 14);
			frame.getContentPane().add(lbMonth);
			
			SpinnerModel month2 = new SpinnerNumberModel(1,1,12,1);
			endMonth = new JSpinner(month2);
			endMonth.setBounds(150, 313, 46, 20);
			frame.getContentPane().add(endMonth);
			
			lbDay = new JLabel("Day:");
			lbDay.setBounds(210, 316, 40, 14);
			frame.getContentPane().add(lbDay);
			
			SpinnerModel day2 = new SpinnerNumberModel(1,1,31,1);
			endDay = new JSpinner(day2);
			endDay.setBounds(240, 313, 46, 20);
			frame.getContentPane().add(endDay);
			
			
			
			lbYear2 = new JLabel("Year:");
			lbYear2.setBounds(10, 346,40, 14);
			frame.getContentPane().add(lbYear2);
			

			SpinnerModel year3 = new SpinnerNumberModel(1,1,10000000,1);
				endYear2 = new JSpinner(year3);
				endYear2.setBounds(40, 346, 56, 20);
				frame.getContentPane().add(endYear2);
				
				lbMonth2 = new JLabel("Month:");
				lbMonth2.setBounds(110, 346, 40, 14);
				frame.getContentPane().add(lbMonth2);
				
				SpinnerModel month3 = new SpinnerNumberModel(1,1,12,1);
				endMonth2 = new JSpinner(month3);
				endMonth2.setBounds(150, 343, 46, 20);
				frame.getContentPane().add(endMonth2);
				
				lbDay2 = new JLabel("Day:");
				lbDay2.setBounds(210, 346, 40, 14);
				frame.getContentPane().add(lbDay2);
				
				SpinnerModel day3 = new SpinnerNumberModel(1,1,31,1);
				endDay2 = new JSpinner(day3);
				endDay2.setBounds(240, 343, 46, 20);
				frame.getContentPane().add(endDay2);
		
		
		
		createButton2 = new JButton("Get Flow from date to date");
		createButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date d = new Date((int)endYear.getValue()-1900, (int)endMonth.getValue()-1, (int)endDay.getValue());
				Date d2 = new Date((int)endYear2.getValue()-1900, (int)endMonth2.getValue()-1, (int)endDay2.getValue());

				//System.out.println(d);
				//System.out.println(d2);
				try {
					GetAllFlowD gap = new GetAllFlowD(d,d2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		createButton2.setBounds(70, 375, 189, 23);
		frame.getContentPane().add(createButton2);
		
		
	}
}
