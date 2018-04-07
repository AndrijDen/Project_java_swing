package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DbAccess;
import models.Staff;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class GetStaff extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;
	private JButton editProjectButton;
	private JButton deleteProjectButton;
	private JButton getStagesButton;
	private JButton createStageManager;
	private JLabel lblEnterStageId;
	private JSpinner positionId;
	private JButton btnGetStage;
	private JLabel lblSearchPositionFrom;
	private JLabel lblYear;
	private JSpinner startYear;
	private JLabel lblMonth;
	private JSpinner startMonth;
	private JLabel lblDay;
	private JSpinner startDay;
	private JLabel lblToYear;
	private JSpinner endYear;
	private JLabel label_1;
	private JSpinner endMonth;
	private JLabel label_2;
	private JSpinner endDay;
	private JButton btnSearch;
	private String startDate;
	private String endDate;

	
	public GetStaff(int id) {
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
		
		frame.setTitle("Staff");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		Staff p = dba.getStaff(id);
    	DefaultListModel<Staff> l = new DefaultListModel<>();
    	l.addElement(p);
    	contentPane.setLayout(null);
    	JList<Staff> list = new JList<>(l);
    	list.setBounds(5, 5, 1074, 20);
    	contentPane.add(list);
    	
    	editProjectButton = new JButton("Edit");
    	editProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditStaff ep = new EditStaff(id, frame);
			}
    	});
    	editProjectButton.setBounds(5, 40, 89, 23);
    	contentPane.add(editProjectButton);
    	
    	deleteProjectButton = new JButton("Delete");
    	deleteProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dba.delStaff(id);
				frame.setVisible(false);
				frame.dispose();
			}
    	});
    	deleteProjectButton.setBounds(107, 40, 89, 23);
    	contentPane.add(deleteProjectButton);
    	
    	getStagesButton = new JButton("Get all employee positions");
    	getStagesButton.setHorizontalAlignment(SwingConstants.LEFT);
    	getStagesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GetAllPositions gas = new GetAllPositions(id);
			}
    	});
    	getStagesButton.setBounds(5, 75, 191, 23);
    	contentPane.add(getStagesButton);
    	
    	createStageManager = new JButton("Create new position");
    	createStageManager.setHorizontalAlignment(SwingConstants.LEFT);
    	createStageManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreatePosition cs = new CreatePosition(id);
			}
    	});
    	createStageManager.setBounds(5, 102, 191, 23);
    	contentPane.add(createStageManager);
    	
    	lblEnterStageId = new JLabel("Enter position id: ");
    	lblEnterStageId.setBounds(5, 137, 118, 14);
    	contentPane.add(lblEnterStageId);
    	
		SpinnerModel value = new SpinnerNumberModel(1,1,1000000,1);
    	positionId = new JSpinner(value);
    	positionId.setBounds(5, 163, 55, 20);
    	contentPane.add(positionId);
    	
    	btnGetStage = new JButton("Get position");
    	btnGetStage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GetPosition gs = new GetPosition((int)positionId.getValue(), id);
			}
    	});
    	btnGetStage.setBounds(63, 163, 108, 23);
    	contentPane.add(btnGetStage);
    	
    	lblSearchPositionFrom = new JLabel("Search employee position");
    	lblSearchPositionFrom.setBounds(319, 42, 191, 16);
    	contentPane.add(lblSearchPositionFrom);
    	
    	lblYear = new JLabel("From year:");
    	lblYear.setBounds(227, 76, 74, 16);
    	contentPane.add(lblYear);
    	
    	
    	SpinnerModel year = new SpinnerNumberModel(1,1,10000000,1);
		startYear = new JSpinner(year);
		startYear.setBounds(294, 74, 56, 20);
		contentPane.add(startYear);
    	
    	lblMonth = new JLabel("month:");
    	lblMonth.setBounds(362, 76, 61, 16);
    	contentPane.add(lblMonth);
    	
    	
    	SpinnerModel month = new SpinnerNumberModel(1,1,12,1);
		startMonth = new JSpinner(month);
		startMonth.setBounds(411, 74, 56, 20);
		contentPane.add(startMonth);
    	
    	lblDay = new JLabel("day:");
    	lblDay.setBounds(479, 76, 31, 16);
    	contentPane.add(lblDay);
    	
    	
    	SpinnerModel day = new SpinnerNumberModel(1,1,31,1);
		startDay = new JSpinner(day);
		startDay.setBounds(506, 74, 56, 20);
		contentPane.add(startDay);
    	
    	lblToYear = new JLabel("To year:");
    	lblToYear.setBounds(227, 104, 74, 16);
    	contentPane.add(lblToYear);
    	
    SpinnerModel year1 = new SpinnerNumberModel(1,1,10000000,1);
    endYear = new JSpinner(year1);
    	endYear.setBounds(294, 102, 56, 20);
    	contentPane.add(endYear);
    	
    	label_1 = new JLabel("month:");
    	label_1.setBounds(362, 104, 61, 16);
    	contentPane.add(label_1);
    	
    	SpinnerModel month1 = new SpinnerNumberModel(1,1,12,1);
		endMonth = new JSpinner(month1);
		endMonth.setBounds(411, 102, 56, 20);
		contentPane.add(endMonth);
    	
    	label_2 = new JLabel("day:");
    	label_2.setBounds(479, 104, 31, 16);
    	contentPane.add(label_2);
    	
    	SpinnerModel day1 = new SpinnerNumberModel(1,1,31,1);
		endDay = new JSpinner(day1);
		endDay.setBounds(506, 102, 56, 20);
		contentPane.add(endDay);
    	
    	btnSearch = new JButton("Search");
    	btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//				String  endDay= day1.getValue().toString();
//				String endMonth = month1.getValue().toString();
//				String endYear = year1.getValue().toString();
//				
//				String startDay = day.getValue().toString();
//				String startMonth = month.getValue().toString();
//				String startYear = year.getValue().toString();
//				
//				startDate = startYear+"-"+startMonth+"-"+startDay;
//				endDate = endYear+"-"+endMonth+"-"+endDay;
				
				GetAllPositions gap = new GetAllPositions(id);
			}
    	});
    	btnSearch.setBounds(472, 136, 90, 23);
    	contentPane.add(btnSearch);
    	
	}

}
