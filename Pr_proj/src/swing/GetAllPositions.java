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
import models.Position;

public class GetAllPositions extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;
	
	public GetAllPositions(int id) {
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
		
		frame.setTitle("Positions");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		ArrayList<Position> allPositions = dba.getAllPositions(id);
    	DefaultListModel<Position> l = new DefaultListModel<>();
    	for(int i = 0; i<allPositions.size(); ++i){
    		l.addElement(allPositions.get(i));
    	}
    	JList<Position> list = new JList<Position>(l);
    	contentPane.add(list);
	}
}
