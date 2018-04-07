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

public class EditStage extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;
	
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
	private JLabel lblRealEndYear;
	private JSpinner realEndYear;
	private JLabel lblMonth_1;
	private JSpinner realEndMonth;
	private JLabel lblDay_1;
	private JSpinner realEndDay;
	private JLabel lblCosts;
	private JSpinner costs;
	private JButton editButton;
	
	private JFrame alien;
	private int project_id;

	
	public EditStage(int id, int project_id, JFrame alien) {
		this.id = id;
		this.project_id = project_id;
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
		
		frame.setTitle("Edit stage");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblName = new JLabel("Number: ");
		lblName.setBounds(10, 21, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblNewLabel_4 = new JLabel("Price: ");
		lblNewLabel_4.setBounds(10, 146, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		SpinnerModel value = new SpinnerNumberModel(1,1,1000,1);
		number = new JSpinner(value);
		number.setBounds(80, 18, 136, 20);
		contentPane.add(number);

		
		SpinnerModel value2 = new SpinnerNumberModel(1,1,10000000,1);
		price = new JSpinner(value2);
		price.setBounds(107, 143, 79, 20);
		contentPane.add(price);
		
		lblStartYear = new JLabel("Start year: ");
		lblStartYear.setBounds(10, 96, 79, 14);
		contentPane.add(lblStartYear);
		
		SpinnerModel year = new SpinnerNumberModel(1,1,10000000,1);
		startYear = new JSpinner(year);
		startYear.setBounds(80, 93, 56, 20);
		contentPane.add(startYear);
		
		lblStartMonth = new JLabel("Start month: ");
		lblStartMonth.setBounds(137, 96, 79, 14);
		contentPane.add(lblStartMonth);
		
		SpinnerModel month = new SpinnerNumberModel(1,1,12,1);
		startMonth = new JSpinner(month);
		startMonth.setBounds(208, 93, 46, 20);
		contentPane.add(startMonth);
		
		lblStartDay = new JLabel("Start day:");
		lblStartDay.setBounds(257, 96, 70, 14);
		contentPane.add(lblStartDay);
		
		SpinnerModel day = new SpinnerNumberModel(1,1,31,1);
		startDay = new JSpinner(day);
		startDay.setBounds(313, 93, 46, 20);
		contentPane.add(startDay);
		
		lblPlannedEndYear = new JLabel("Planned end year: ");
		lblPlannedEndYear.setBounds(10, 121, 136, 14);
		contentPane.add(lblPlannedEndYear);
		
		SpinnerModel year1 = new SpinnerNumberModel(1,1,10000000,1);
		endYear = new JSpinner(year1);
		endYear.setBounds(125, 118, 61, 20);
		contentPane.add(endYear);
		
		lblMonth = new JLabel("month: ");
		lblMonth.setBounds(196, 121, 46, 14);
		contentPane.add(lblMonth);
		
		SpinnerModel month1 = new SpinnerNumberModel(1,1,12,1);
		endMonth = new JSpinner(month1);
		endMonth.setBounds(236, 118, 43, 20);
		contentPane.add(endMonth);
		
		lblDay = new JLabel("day: ");
		lblDay.setBounds(281, 121, 46, 14);
		contentPane.add(lblDay);
		
		SpinnerModel day1 = new SpinnerNumberModel(1,1,31,1);
		endDay = new JSpinner(day1);
		endDay.setBounds(313, 118, 46, 20);
		contentPane.add(endDay);
		
		lblRealEndYear = new JLabel("Real end year: ");
		lblRealEndYear.setBounds(10, 171, 114, 14);
		contentPane.add(lblRealEndYear);
		
		SpinnerModel year2 = new SpinnerNumberModel(1,1,10000000,1);
		realEndYear = new JSpinner(year2);
		realEndYear.setBounds(124, 168, 62, 20);
		contentPane.add(realEndYear);
		
		lblMonth_1 = new JLabel("month: ");
		lblMonth_1.setBounds(196, 171, 56, 14);
		contentPane.add(lblMonth_1);
		
		SpinnerModel month2 = new SpinnerNumberModel(1,1,12,1);
		realEndMonth = new JSpinner(month2);
		realEndMonth.setBounds(236, 168, 43, 20);
		contentPane.add(realEndMonth);
		
		lblDay_1 = new JLabel("day: ");
		lblDay_1.setBounds(281, 171, 46, 14);
		contentPane.add(lblDay_1);
		
		SpinnerModel day2 = new SpinnerNumberModel(1,1,31,1);
		realEndDay = new JSpinner(day2);
		realEndDay.setBounds(313, 168, 46, 20);
		contentPane.add(realEndDay);
		
		lblCosts = new JLabel("Costs: ");
		lblCosts.setBounds(10, 196, 46, 14);
		contentPane.add(lblCosts);
		
		SpinnerModel value3 = new SpinnerNumberModel(1,1,10000000,1);
		costs = new JSpinner(value3);
		costs.setBounds(107, 193, 79, 20);
		contentPane.add(costs);
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date st = new Date((int)startYear.getValue(), (int)startMonth.getValue(), (int)startDay.getValue());
				Date end = new Date((int)endYear.getValue(), (int)endMonth.getValue(), (int)endDay.getValue());
				Date rend = new Date((int)realEndYear.getValue(), (int)realEndMonth.getValue(), (int)realEndDay.getValue());
				int temp = (int)price.getValue();
				double pr = (double)temp;
				int temp2 = (int)costs.getValue();
				double c = (double)temp2;
				int num = (int)number.getValue();
				dba.editStage(id, num, st, end, rend, pr, c);
				frame.setVisible(false);
				frame.dispose();
				alien.setVisible(false);
				alien.dispose();
				
			}
		});
		editButton.setBounds(10, 263, 89, 23);
		contentPane.add(editButton);
		
		
		
	}
}
