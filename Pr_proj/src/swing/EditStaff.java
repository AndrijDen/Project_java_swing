package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import database.DbAccess;

public class EditStaff extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;
	
	private JTextField surname;
	private JTextField sex;
	private JLabel lblPlannedEndYear;
	private JSpinner endYear;
	private JLabel lblMonth;
	private JSpinner endMonth;
	private JLabel lblDay;
	private JSpinner endDay;
	private JButton editButton;
	
	private JFrame alien;

	
	public EditStaff(int id, JFrame alien) {
		this.id = id;
		this.alien = alien;
		dba = new DbAccess();
		dba.connectionDb("Projects", "root", "root");
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		frame.setSize(1100, 400);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Edit staff");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblName = new JLabel("Surname: ");
		lblName.setBounds(10, 21, 79, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel_1 = new JLabel("Sex: ");
		lblNewLabel_1.setBounds(10, 71, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		surname = new JTextField();
		surname.setBounds(80, 18, 162, 20);
		contentPane.add(surname);
		surname.setColumns(10);
		
		sex = new JTextField();
		sex.setBounds(80, 71, 162, 20);
		contentPane.add(sex);
		sex.setColumns(10);
		
		SpinnerModel value = new SpinnerNumberModel(1,1,1000000,1);
		
		SpinnerModel value2 = new SpinnerNumberModel(1,1,10000000,1);
		
		SpinnerModel year = new SpinnerNumberModel(1,1,10000000,1);
		
		SpinnerModel month = new SpinnerNumberModel(1,1,12,1);
		
		SpinnerModel day = new SpinnerNumberModel(1,1,31,1);
		
		lblPlannedEndYear = new JLabel("Date of birth: ");
		lblPlannedEndYear.setBounds(10, 121, 126, 14);
		contentPane.add(lblPlannedEndYear);
		
		SpinnerModel year1 = new SpinnerNumberModel(1,1,3000,0);
		endYear = new JSpinner(year1);
		endYear.setBounds(110, 118, 61, 20);
		contentPane.add(endYear);
		
		lblMonth = new JLabel("month: ");
		lblMonth.setBounds(187, 121, 55, 14);
		contentPane.add(lblMonth);
		
		SpinnerModel month1 = new SpinnerNumberModel(1,1,12,0);
		endMonth = new JSpinner(month1);
		endMonth.setBounds(236, 118, 43, 20);
		contentPane.add(endMonth);
		
		lblDay = new JLabel("day: ");
		lblDay.setBounds(281, 121, 46, 14);
		contentPane.add(lblDay);
		
		SpinnerModel day1 = new SpinnerNumberModel(1,1,31,0);
		endDay = new JSpinner(day1);
		endDay.setBounds(313, 118, 46, 20);
		contentPane.add(endDay);
		
		SpinnerModel year2 = new SpinnerNumberModel(1,1,10000000,1);
		
		SpinnerModel month2 = new SpinnerNumberModel(1,1,12,1);
		
		SpinnerModel day2 = new SpinnerNumberModel(1,1,31,1);
		
		SpinnerModel value3 = new SpinnerNumberModel(1,1,10000000,1);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Date st = new Date((int)startYear.getValue(), (int)startMonth.getValue(), (int)startDay.getValue());
				String dateString = endYear.getValue().toString() + "-" + endMonth.getValue().toString() + "-" + endDay.getValue().toString();
//				LocalDate endDate = LocalDate.parse(dateString);
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsedDate = null;
				try {
					parsedDate = dateFormat.parse(dateString);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.sql.Date endDate = new java.sql.Date(parsedDate.getTime());
				//Date rend = new Date((int)realEndYear.getValue(), (int)realEndMonth.getValue(), (int)realEndDay.getValue());
				//int temp = (int)price.getValue();
				//double pr = (double)temp;
				//int temp2 = (int)costs.getValue();
				//double c = (double)temp2;
				dba.editStaff(id, surname.getText(), sex.getText(), endDate);
				frame.setVisible(false);
				frame.dispose();
				alien.setVisible(false);
				alien.dispose();
				
			}
		});
		editButton.setBounds(6, 165, 89, 23);
		contentPane.add(editButton);
		
		
		
	}

}
