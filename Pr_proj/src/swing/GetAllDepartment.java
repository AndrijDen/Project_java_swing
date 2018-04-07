package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import models.Department;
import models.Staff;

public class GetAllDepartment extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;

	
	public GetAllDepartment() {
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
		
		frame.setTitle("All departments");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		ArrayList<Department> allDepartment = dba.getAllDepartment	();
    	DefaultListModel<Department> l = new DefaultListModel<>();
    	for(int i = 0; i<allDepartment.size(); ++i){
    		l.addElement(allDepartment.get(i));
    	}
    	JList<Department> list = new JList<Department>(l);
    	contentPane.add(list);
	}

}
