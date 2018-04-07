package swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DbAccess;
import models.Department;
import models.Staff;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class GetDepartment extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;
	private JButton editProjectButton;
	private JButton deleteProjectButton;
	private JButton getStagesButton;
	private JButton createStageManager;
	private JLabel lblEnterStageId;
	private JSpinner stageId;
	private JButton btnGetStage;
	private JLabel lblStartYear;
	private JSpinner startYear;
	private JLabel lblStartMonth;
	private JSpinner startMonth;
	private JLabel lblStartDay;
	private JSpinner startDay;

	
	public GetDepartment(int id) {
		this.id = id;
		dba = new DbAccess();
		dba.connectionDb("Projects", "root", "root");
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		frame.setSize(1100, 250);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Department");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		Department p = dba.getDepartment(id);
    	DefaultListModel<Department> l = new DefaultListModel<>();
    	l.addElement(p);
    	contentPane.setLayout(null);
    	JList<Department> list = new JList<>(l);
    	list.setBounds(5, 5, 1074, 20);
    	contentPane.add(list);
    	
    	editProjectButton = new JButton("Edit");
    	editProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditDepartment ed = new EditDepartment(id, frame);
			}
    	});
    	editProjectButton.setBounds(5, 40, 89, 23);
    	contentPane.add(editProjectButton);
    	
    	deleteProjectButton = new JButton("Delete");
    	deleteProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dba.delDepartment(id);
				frame.setVisible(false);
				frame.dispose();
			}
    	});
    	deleteProjectButton.setBounds(104, 40, 89, 23);
    	contentPane.add(deleteProjectButton);
    	
    	getStagesButton = new JButton("Get all staff from this department");
    	getStagesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GetAllStaffDep gas = new GetAllStaffDep(id);
			}
    	});
    	getStagesButton.setBounds(218, 40, 249, 23);
    	contentPane.add(getStagesButton);
    	
    	JLabel lblStartYear = new JLabel("Date:");
		lblStartYear.setBounds(10, 79, 99, 14);
		contentPane.add(lblStartYear);
		
		SpinnerModel year = new SpinnerNumberModel(1,1,10000000,1);
		startYear = new JSpinner(year);
		startYear.setBounds(110, 76, 56, 20);
		contentPane.add(startYear);
		
		JLabel lblStartMonth = new JLabel("month: ");
		lblStartMonth.setBounds(178, 79, 56, 14);
		contentPane.add(lblStartMonth);
		
		SpinnerModel month = new SpinnerNumberModel(1,1,12,1);
		startMonth = new JSpinner(month);
		startMonth.setBounds(231, 76, 46, 20);
		contentPane.add(startMonth);
		
		lblStartDay = new JLabel("day:");
		lblStartDay.setBounds(289, 79, 34, 14);
		contentPane.add(lblStartDay);
		
		SpinnerModel day = new SpinnerNumberModel(1,1,31,1);
		startDay = new JSpinner(day);
		startDay.setBounds(321, 76, 46, 20);
		contentPane.add(startDay);
		
		JButton button = new JButton("Get staff");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("deprecation")
				Date st = new Date((int)startYear.getValue(), (int)startMonth.getValue(), (int)startDay.getValue());
				GetAllStaffDep gasp = new GetAllStaffDep(id);
			}
		});
		button.setBounds(5, 126, 249, 23);
		contentPane.add(button);
		

    	
//    	createStageManager = new JButton("Create position");
//    	createStageManager.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				CreatePosition cs = new CreatePosition(id);
//			}
//    	});
//    	createStageManager.setBounds(5, 136, 130, 23);
//    	contentPane.add(createStageManager);
//    	
//    	lblEnterStageId = new JLabel("Enter position id: ");
//    	lblEnterStageId.setBounds(5, 169, 118, 14);
//    	contentPane.add(lblEnterStageId);
//    	
//		SpinnerModel value = new SpinnerNumberModel(1,1,1000000,1);
//    	stageId = new JSpinner(value);
//    	stageId.setBounds(123, 166, 55, 20);
//    	contentPane.add(stageId);
//    	
//    	btnGetStage = new JButton("Get position");
//    	btnGetStage.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				GetPosition gs = new GetPosition((int)stageId.getValue(), id);
//			}
//    	});
//    	btnGetStage.setBounds(183, 166, 108, 23);
//    	contentPane.add(btnGetStage);
    	
	}

}
