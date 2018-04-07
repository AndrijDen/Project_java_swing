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

public class EditDepartment extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;
	
	private JTextField name;
	private JTextField phoneNum;
	private JLabel lblPlannedEndYear;
	private JSpinner endYear;
	private JLabel lblMonth;
	private JSpinner endMonth;
	private JLabel lblDay;
	private JSpinner endDay;
	private JButton editButton;
	
	private JFrame alien;

	
	public EditDepartment(int id, JFrame alien) {
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
		
		frame.setTitle("Edit department: ");
       
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
		
		
		editButton = new JButton("Edit");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dba.editDepartment(id, name.getText(), phoneNum.getText());
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
