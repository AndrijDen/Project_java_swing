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

public class GetBalanceInformation extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField name;
	private JTextField owner;
	private JButton createButton;
	private JSpinner price;
	private JLabel lblStartYear;
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
	IBalanceRepository balRep = new BalanceRepository();
	
	public GetBalanceInformation() throws SQLException{
		 String str="2017-12-25";  
		 String str2="2018-02-25"; 
		 Date d=Date.valueOf(str);
		 Date d2=Date.valueOf(str2);
		 balRep.formBalanceByDay(d);
		 balRep.formBalanceByDay(d2);
		initialize();
		frame.setVisible(true);
	}
	private void initialize() throws SQLException {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 250);
		
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Balance information");
		/*
		balRep.formProfitAll();
		balRep.formSpendingAll();
		balRep.formRemainderAll();
		*/
		//----
		JLabel allBalanceLabel = new JLabel("Click to get balance for all time");
		allBalanceLabel.setBounds(10, 40, 180, 15);
		frame.getContentPane().add(allBalanceLabel);
	
		JButton allBalance = new JButton("Get balance");
		allBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GetAllBalanceD gap = new GetAllBalanceD();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		allBalance.setBounds(200, 35, 89, 23);
		allBalance.setSize(150, 30);
		frame.getContentPane().add(allBalance);
		//-----------
		
		JLabel findBalanceLabel = new JLabel("Click to get balance by date");
		findBalanceLabel.setBounds(80, 80, 180, 15);
		frame.getContentPane().add(findBalanceLabel);
		
		
		
		lblStartYear = new JLabel("Year:");
		lblStartYear.setBounds(10, 116,40, 14);
		frame.getContentPane().add(lblStartYear);
		
		SpinnerModel year = new SpinnerNumberModel(1,1,10000000,1);
		startYear = new JSpinner(year);
		startYear.setBounds(40, 113, 56, 20);
		frame.getContentPane().add(startYear);
		
		lblStartMonth = new JLabel("Month:");
		lblStartMonth.setBounds(110, 116, 40, 14);
		frame.getContentPane().add(lblStartMonth);
		
		SpinnerModel month = new SpinnerNumberModel(1,1,12,1);
		startMonth = new JSpinner(month);
		startMonth.setBounds(150, 113, 46, 20);
		frame.getContentPane().add(startMonth);
		
		lblStartDay = new JLabel("Day:");
		lblStartDay.setBounds(210, 116, 40, 14);
		frame.getContentPane().add(lblStartDay);
		
		SpinnerModel day = new SpinnerNumberModel(1,1,31,1);
		startDay = new JSpinner(day);
		startDay.setBounds(240, 113, 46, 20);
		frame.getContentPane().add(startDay);
		
		createButton = new JButton("Get");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date d = new Date((int)startYear.getValue()-1900, (int)startMonth.getValue()-1, (int)startDay.getValue());
				//System.out.println(st);
				try {
					GetAllBalanceByDate gbd = new GetAllBalanceByDate(d);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		createButton.setBounds(110, 145, 89, 23);
		frame.getContentPane().add(createButton);
		
		
		
		
	}
}
