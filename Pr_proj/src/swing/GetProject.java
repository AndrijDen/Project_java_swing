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
import models.Project;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class GetProject extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;
	private JButton editProjectButton;
	private JButton deleteProjectButton;
	private JButton getStagesButton;
	private JButton createStageManager;
	private JLabel lblStagesManager;
	private JLabel lblEnterStageId;
	private JSpinner stageId;
	private JButton btnGetStage;

	
	public GetProject(int id) {
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
		
		frame.setTitle("Project");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		Project p = dba.getProject(id);
    	DefaultListModel<Project> l = new DefaultListModel<>();
    	l.addElement(p);
    	contentPane.setLayout(null);
    	JList<Project> list = new JList<>(l);
    	list.setBounds(5, 5, 1074, 20);
    	contentPane.add(list);
    	
    	editProjectButton = new JButton("Edit");
    	editProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditProject ep = new EditProject(id, frame);
			}
    	});
    	editProjectButton.setBounds(5, 40, 89, 23);
    	contentPane.add(editProjectButton);
    	
    	deleteProjectButton = new JButton("Delete");
    	deleteProjectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dba.delProject(id);
				frame.setVisible(false);
				frame.dispose();
			}
    	});
    	deleteProjectButton.setBounds(104, 40, 89, 23);
    	contentPane.add(deleteProjectButton);
    	
    	lblStagesManager = new JLabel("Stages manager");
    	lblStagesManager.setBounds(5, 77, 108, 14);
    	contentPane.add(lblStagesManager);
    	
    	getStagesButton = new JButton("Get stages");
    	getStagesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GetAllStages gas = new GetAllStages(id);
			}
    	});
    	getStagesButton.setBounds(5, 102, 115, 23);
    	contentPane.add(getStagesButton);
    	
    	createStageManager = new JButton("Create stage");
    	createStageManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateStage cs = new CreateStage(id);
			}
    	});
    	createStageManager.setBounds(5, 136, 115, 23);
    	contentPane.add(createStageManager);
    	
    	lblEnterStageId = new JLabel("Enter stage id: ");
    	lblEnterStageId.setBounds(5, 169, 89, 14);
    	contentPane.add(lblEnterStageId);
    	
		SpinnerModel value = new SpinnerNumberModel(1,1,1000000,1);
    	stageId = new JSpinner(value);
    	stageId.setBounds(104, 166, 55, 20);
    	contentPane.add(stageId);
    	
    	btnGetStage = new JButton("Get stage");
    	btnGetStage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GetStage gs = new GetStage((int)stageId.getValue(), id);
			}
    	});
    	btnGetStage.setBounds(169, 165, 89, 23);
    	contentPane.add(btnGetStage);
    	
	}

}
