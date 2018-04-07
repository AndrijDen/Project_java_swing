package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DbAccess;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class CreateDepartment extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private JTextField name;
	private JTextField phoneNum;
	private JButton createButton;
	private JLabel lblStartYear;
	private JSpinner startYear;
	private JLabel lblStartMonth;
	private JSpinner startMonth;
	private JLabel lblStartDay;
	private JSpinner startDay;

	
	public CreateDepartment() {
		dba = new DbAccess();
		dba.connectionDb("Projects", "root", "root");
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		frame.setSize(1100, 300);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("New department");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(10, 21, 79, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("Phone number: ");
		lblNewLabel_1.setBounds(10, 47, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(80, 18, 162, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		phoneNum = new JTextField();
		phoneNum.setBounds(80, 47, 86, 20);
		contentPane.add(phoneNum);
		phoneNum.setColumns(10);
		
		//SpinnerModel value = new SpinnerNumberModel(1,1,1000000,1);
		
		//SpinnerModel value2 = new SpinnerNumberModel(1,1,10000000,1);
		
//		lblStartYear = new JLabel("Date of birth: ");
//		lblStartYear.setBounds(10, 79, 99, 14);
//		contentPane.add(lblStartYear);
//		
//		SpinnerModel year = new SpinnerNumberModel(1,1,10000000,1);
//		startYear = new JSpinner(year);
//		startYear.setBounds(110, 76, 56, 20);
//		contentPane.add(startYear);
//		
//		lblStartMonth = new JLabel("month: ");
//		lblStartMonth.setBounds(178, 79, 56, 14);
//		contentPane.add(lblStartMonth);
//		
//		SpinnerModel month = new SpinnerNumberModel(1,1,12,1);
//		startMonth = new JSpinner(month);
//		startMonth.setBounds(231, 76, 46, 20);
//		contentPane.add(startMonth);
//		
//		lblStartDay = new JLabel("day:");
//		lblStartDay.setBounds(289, 79, 34, 14);
//		contentPane.add(lblStartDay);
//		
//		SpinnerModel day = new SpinnerNumberModel(1,1,31,1);
//		startDay = new JSpinner(day);
//		startDay.setBounds(321, 76, 46, 20);
//		contentPane.add(startDay);
		
//		SpinnerModel year1 = new SpinnerNumberModel(1,1,10000000,1);
//		
//		SpinnerModel month1 = new SpinnerNumberModel(1,1,12,1);
//		
//		SpinnerModel day1 = new SpinnerNumberModel(1,1,31,1);
		
		createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String dateString = startYear.getValue().toString() + "-" + startMonth.getValue().toString() + "-" + startDay.getValue().toString();
//				LocalDate endDate = LocalDate.parse(dateString);
//				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//				java.util.Date parsedDate = null;
//				try {
//					parsedDate = dateFormat.parse(dateString);
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				java.sql.Date startDate = new java.sql.Date(parsedDate.getTime());
				
				
				//Date birth = new Date((int)startYear.getValue(), (int)startMonth.getValue(), (int)startDay.getValue());
				dba.addDepartment(name.getText(), phoneNum.getText());
				frame.setVisible(false);
				frame.dispose();
			}
		});
		createButton.setBounds(77, 185, 89, 23);
		contentPane.add(createButton);

	
	}
}
