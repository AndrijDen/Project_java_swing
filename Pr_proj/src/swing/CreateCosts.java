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

public class CreateCosts extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private JSpinner sum;
	private JLabel lblStartYear;
	private JSpinner year;
	private JLabel lblStartMonth;
	private JSpinner month;
	private JLabel lblStartDay;
	private JSpinner day;

	private int stage_id;
	private JButton createButton;
	
	public CreateCosts(int stage_id) {
		dba = new DbAccess();
		this.stage_id = stage_id;
		dba.connectionDb("Projects", "root", "root");
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		frame.setSize(1100, 300);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("New income");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Sum: ");
		lblNewLabel_4.setBounds(10, 82, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		
		SpinnerModel value2 = new SpinnerNumberModel(1,1,10000000,1);
		sum = new JSpinner(value2);
		sum.setBounds(66, 79, 79, 20);
		contentPane.add(sum);
		
		lblStartYear = new JLabel("Year: ");
		lblStartYear.setBounds(10, 46, 79, 14);
		contentPane.add(lblStartYear);
		
		SpinnerModel years = new SpinnerNumberModel(1,1,10000000,1);
		year = new JSpinner(years);
		year.setBounds(80, 43, 56, 20);
		contentPane.add(year);
		
		lblStartMonth = new JLabel("Month: ");
		lblStartMonth.setBounds(137, 46, 79, 14);
		contentPane.add(lblStartMonth);
		
		SpinnerModel months = new SpinnerNumberModel(1,1,12,1);
		month = new JSpinner(months);
		month.setBounds(206, 43, 46, 20);
		contentPane.add(month);
		
		lblStartDay = new JLabel("Day:");
		lblStartDay.setBounds(257, 46, 70, 14);
		contentPane.add(lblStartDay);
		
		SpinnerModel days = new SpinnerNumberModel(1,1,31,1);
		day = new JSpinner(days);
		day.setBounds(313, 43, 46, 20);
		contentPane.add(day);
		
		
		createButton = new JButton("Add");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date d = new Date((int)year.getValue(), (int)month.getValue(), (int)day.getValue());
				int temp = (int)sum.getValue();
				double s = (double)temp;
				dba.addProject_costs(stage_id, d, (int)year.getValue(), (int)month.getValue(), s);
				frame.setVisible(false);
				frame.dispose();
			}
		});
		createButton.setBounds(10, 135, 89, 23);
		contentPane.add(createButton);

	
	}
	
	
	
	
	
	
	/*private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int stage_id;

	
	public CreateCosts(int stage_id) {
		this.stage_id = stage_id;
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
		
		frame.setTitle("New income");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setLayout(null);
		
		JLabel lblYear = new JLabel("Year: ");
		lblYear.setBounds(10, 11, 46, 14);
		getContentPane().add(lblYear);
		
		SpinnerModel years = new SpinnerNumberModel(1,1,10000000,1);
		JSpinner year = new JSpinner(years);
		year.setBounds(61, 8, 72, 20);
		getContentPane().add(year);
		
		JLabel lblMonth = new JLabel("Month: ");
		lblMonth.setBounds(143, 11, 46, 14);
		getContentPane().add(lblMonth);
		
		
		SpinnerModel months = new SpinnerNumberModel(1,1,12,1);
		JSpinner month = new JSpinner(months);
		month.setBounds(199, 8, 46, 20);
		getContentPane().add(month);
		
		JLabel lblDay = new JLabel("Day: ");
		lblDay.setBounds(255, 11, 46, 14);
		getContentPane().add(lblDay);
				
		SpinnerModel days = new SpinnerNumberModel(1,1,31,1);
		JSpinner day = new JSpinner(days);
		day.setBounds(294, 8, 46, 20);
		getContentPane().add(day);
		
		JLabel lblSum = new JLabel("Sum:");
		lblSum.setBounds(10, 50, 46, 14);
		getContentPane().add(lblSum);
		
		SpinnerModel value2 = new SpinnerNumberModel(1,1,10000000,1);
		JSpinner sum = new JSpinner(value2);
		sum.setBounds(61, 47, 95, 20);
		getContentPane().add(sum);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date d = new Date((int)year.getValue(), (int)month.getValue(), (int)day.getValue());
				int temp = (int)sum.getValue();
				double s = (double)temp;
				dba.addProject_costs(stage_id, d, s);
			}
		});
		btnAdd.setBounds(10, 89, 70, 34);
		getContentPane().add(btnAdd);

	
	}*/
}
