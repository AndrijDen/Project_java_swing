package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import database.DbAccess;
import models.Staff;

public class GetAllStaffDep extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;

	
	public GetAllStaffDep(int id) {
		dba = new DbAccess();
		this.id = id;
		dba.connectionDb("Projects", "root", "root");
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		frame.setSize(1100, 300);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("All staff from this department");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		ArrayList<Staff> allStaff = dba.getAllStaffDep(id);
    	DefaultListModel<Staff> l = new DefaultListModel<>();
    	for(int i = 0; i<allStaff.size(); ++i){
    		l.addElement(allStaff.get(i));
    	}
    	JList<Staff> list = new JList<Staff>(l);
    	contentPane.add(list);
	}

}
