package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

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

public class CreateStage extends JFrame {

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
	
	public CreateStage(int project_id) {
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
		
		frame.setTitle("New stage");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Number: ");
		lblName.setBounds(10, 21, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel_4 = new JLabel("Price: ");
		lblNewLabel_4.setBounds(10, 96, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		SpinnerModel value = new SpinnerNumberModel(1,1,100,1);
		number = new JSpinner(value);
		number.setBounds(80, 18, 86, 20);
		contentPane.add(number);
		
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
		lblStartMonth.setBounds(137, 46, 79, 14);
		contentPane.add(lblStartMonth);
		
		SpinnerModel month = new SpinnerNumberModel(1,1,12,1);
		startMonth = new JSpinner(month);
		startMonth.setBounds(206, 43, 46, 20);
		contentPane.add(startMonth);
		
		lblStartDay = new JLabel("Start day:");
		lblStartDay.setBounds(257, 46, 70, 14);
		contentPane.add(lblStartDay);
		
		SpinnerModel day = new SpinnerNumberModel(1,1,31,1);
		startDay = new JSpinner(day);
		startDay.setBounds(313, 43, 46, 20);
		contentPane.add(startDay);
		
		lblPlannedEndYear = new JLabel("Planned end year: ");
		lblPlannedEndYear.setBounds(10, 71, 126, 14);
		contentPane.add(lblPlannedEndYear);
		
		SpinnerModel year1 = new SpinnerNumberModel(1,1,10000000,1);
		endYear = new JSpinner(year1);
		endYear.setBounds(121, 68, 61, 20);
		contentPane.add(endYear);
		
		lblMonth = new JLabel("month: ");
		lblMonth.setBounds(192, 71, 46, 14);
		contentPane.add(lblMonth);
		
		SpinnerModel month1 = new SpinnerNumberModel(1,1,12,1);
		endMonth = new JSpinner(month1);
		endMonth.setBounds(235, 68, 43, 20);
		contentPane.add(endMonth);
		
		lblDay = new JLabel("day: ");
		lblDay.setBounds(281, 71, 46, 14);
		contentPane.add(lblDay);
		
		SpinnerModel day1 = new SpinnerNumberModel(1,1,31,1);
		endDay = new JSpinner(day1);
		endDay.setBounds(313, 68, 46, 20);
		contentPane.add(endDay);
		
		createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date st = new Date((int)startYear.getValue(), (int)startMonth.getValue(), (int)startDay.getValue());
				Date end = new Date((int)endYear.getValue(), (int)endMonth.getValue(), (int)endDay.getValue());
				int temp = (int)price.getValue();
				double pr = (double)temp;
				int num = (int)number.getValue();
				dba.addStage(num, project_id, st, end, pr);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		createButton.setBounds(10, 135, 89, 23);
		contentPane.add(createButton);

	
	}

}
