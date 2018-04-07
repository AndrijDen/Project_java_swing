package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import database.DbAccess;

public class CreatePosition extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private JSpinner number;
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

	private int project_id;
	private JButton createButton;
	private JTextField textField;
	
	public CreatePosition(int project_id) {
		dba = new DbAccess();
		this.project_id = project_id;
		dba.connectionDb("Projects", "root", "root");
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		frame.setSize(1100, 300);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("New position");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Position title: ");
		lblName.setBounds(10, 21, 89, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel_4 = new JLabel("Salary: ");
		lblNewLabel_4.setBounds(10, 96, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextField title = new JTextField();
		title.setBounds(111, 15, 269, 26);
		contentPane.add(title);
		title.setColumns(10);
		
		SpinnerModel value2 = new SpinnerNumberModel(1,1,10000000,1);
		price = new JSpinner(value2);
		price.setBounds(80, 93, 79, 20);
		contentPane.add(price);
		
		lblStartYear = new JLabel("Start year: ");
		lblStartYear.setBounds(10, 46, 79, 14);
		contentPane.add(lblStartYear);
		
		SpinnerModel year = new SpinnerNumberModel(1,1,10000000,1);
		startYear = new JSpinner(year);
		startYear.setBounds(80, 43, 56, 20);
		contentPane.add(startYear);
		
		lblStartMonth = new JLabel("Start month: ");
		lblStartMonth.setBounds(136, 46, 89, 14);
		contentPane.add(lblStartMonth);
		
		SpinnerModel month = new SpinnerNumberModel(1,1,12,1);
		startMonth = new JSpinner(month);
		startMonth.setBounds(214, 43, 46, 20);
		contentPane.add(startMonth);
		
		lblStartDay = new JLabel("Start day:");
		lblStartDay.setBounds(268, 46, 70, 14);
		contentPane.add(lblStartDay);
		
		SpinnerModel day = new SpinnerNumberModel(1,1,31,1);
		startDay = new JSpinner(day);
		startDay.setBounds(339, 43, 46, 20);
		contentPane.add(startDay);
		
		lblPlannedEndYear = new JLabel("End year: ");
		lblPlannedEndYear.setBounds(10, 71, 126, 14);
		contentPane.add(lblPlannedEndYear);
		
		SpinnerModel year1 = new SpinnerNumberModel(1,1,10000000,1);
		endYear = new JSpinner(year1);
		endYear.setBounds(80, 68, 61, 20);
		contentPane.add(endYear);
		
		lblMonth = new JLabel("month: ");
		lblMonth.setBounds(163, 71, 58, 14);
		contentPane.add(lblMonth);
		
		SpinnerModel month1 = new SpinnerNumberModel(1,1,12,1);
		endMonth = new JSpinner(month1);
		endMonth.setBounds(214, 68, 43, 20);
		contentPane.add(endMonth);
		
		lblDay = new JLabel("day: ");
		lblDay.setBounds(278, 72, 46, 14);
		contentPane.add(lblDay);
		
		SpinnerModel day1 = new SpinnerNumberModel(1,1,31,1);
		endDay = new JSpinner(day1);
		endDay.setBounds(316, 68, 46, 20);
		contentPane.add(endDay);
		
		JLabel lblDepartmentId = new JLabel("Department ID:");
		lblDepartmentId.setBounds(10, 122, 109, 16);
		contentPane.add(lblDepartmentId);
		
		JSpinner idDepartment = new JSpinner();
		idDepartment.setBounds(116, 117, 58, 26);
		contentPane.add(idDepartment);
		
		JLabel lblStaffId = new JLabel("Staff ID:");
		lblStaffId.setBounds(10, 145, 61, 16);
		contentPane.add(lblStaffId);
		
		JSpinner idStaff = new JSpinner();
		idStaff.setBounds(69, 140, 50, 26);
		contentPane.add(idStaff);
		
		createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dateString = startYear.getValue().toString() + "-" + startMonth.getValue().toString() + "-" + startDay.getValue().toString();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dateSt = endYear.getValue().toString() + "-" + endMonth.getValue().toString() + "-" + endDay.getValue().toString();
				DateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date parsedDat = null;
				java.util.Date parsedDate = null;
				try {
					parsedDate = dateFormat.parse(dateString);
					parsedDat = dateForm.parse(dateSt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.sql.Date startDate = new java.sql.Date(parsedDate.getTime());
				java.sql.Date endDate = new java.sql.Date(parsedDat.getTime());
				
				
				//String dateSt = endYear.getValue().toString() + "-" + endMonth.getValue().toString() + "-" + endDay.getValue().toString();
//				LocalDate endDate = LocalDate.parse(dateString);
				//DateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
				//java.util.Date parsedDat = null;
				//try {
				//	parsedDat = dateForm.parse(dateSt);
				//} catch (ParseException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				//}
				//java.sql.Date endDate = new java.sql.Date(parsedDat.getTime());
				
				
				
				//Date st = new Date((int)startYear.getValue(), (int)startMonth.getValue(), (int)startDay.getValue());
				//Date end = new Date((int)endYear.getValue(), (int)endMonth.getValue(), (int)endDay.getValue());
				int temp = (int)price.getValue();
				double pr = (double)temp;
				//String num = (String)number.getValue();
				dba.addPosition(title.getText(), startDate, endDate, pr, (int)idDepartment.getValue(), (int)idStaff.getValue() );
				frame.setVisible(false);
				frame.dispose();
			}
		});
		createButton.setBounds(10, 173, 89, 23);
		contentPane.add(createButton);
		
	
		
		

	
	}
}
