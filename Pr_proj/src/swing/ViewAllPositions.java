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
	import models.Position;
import models.Staff;
	
	public class ViewAllPositions extends JFrame {
	
		private JFrame frame;
		private JPanel contentPane;
		private DbAccess dba;

		
		public ViewAllPositions() {
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
			
			frame.setTitle("All Positions");
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			frame.setContentPane(contentPane);
			
			ArrayList<Position> allPosition = dba.viewAllPositions();
	    	DefaultListModel<Position> l = new DefaultListModel<>();
	    	for(int i = 0; i<allPosition.size(); ++i){
	    		l.addElement(allPosition.get(i));
	    	}
	    	JList<Position> list = new JList<Position>(l);
	    	contentPane.add(list);
	}
	}
