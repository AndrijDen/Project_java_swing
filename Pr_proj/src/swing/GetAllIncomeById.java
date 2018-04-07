package swing;

import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DbAccess;
import models.Flow;
import models.Position;
public class GetAllIncomeById {
	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;
	private Object startDate;
	private Object endDate;
	
	public GetAllIncomeById(int id) {
		dba = new DbAccess();
		this.id = id;
		dba.connectionDb("Projects", "root", "root");
		
		//System.out.println("\n\tID : "+ id+"\n");
		
		initialize();
		frame.setVisible(true);
	}
		
	
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(200, 100, 450, 300);
			frame.setSize(1100, 300);
			frame.getContentPane().setLayout(null);
			
			frame.setTitle("All Income");
	       
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			frame.setContentPane(contentPane);
			
			BigDecimal res = dba.getAllIncomeById(id);
			
			
	    	
	}

}
