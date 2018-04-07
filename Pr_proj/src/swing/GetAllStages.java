package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DbAccess;
import models.Stage;

public class GetAllStages extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;
	
	public GetAllStages(int id) {
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
		
		frame.setTitle("Stages");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		ArrayList<Stage> allStages = dba.getAllStages(id);
    	DefaultListModel<Stage> l = new DefaultListModel<>();
    	for(int i = 0; i<allStages.size(); ++i){
    		l.addElement(allStages.get(i));
    	}
    	JList<Stage> list = new JList<Stage>(l);
    	contentPane.add(list);
	}
}
