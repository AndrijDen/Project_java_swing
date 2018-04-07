package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DbAccess;
import models.Position;

public class GetAllPositionsDate extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;
	private String startDate;
	private String endDate;
	ArrayList<Position> allPositions;
	
	public GetAllPositionsDate(int id) {
		dba = new DbAccess();
		this.id = id;
		System.out.println("strings: "+startDate+endDate);
		dba.connectionDb("Projects", "root", "root");
		
		System.out.println("\n\tID : "+ id+"\n");
		
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
		
		
	
			try {
				allPositions = dba.getAllPositionsDate(id,startDate,endDate);
			} catch (ParseException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Position position:allPositions) {
				System.out.println(position.getIdPosition());
			}
			DefaultListModel<Position> l = new DefaultListModel<>();
	    	for(int i = 0; i<allPositions.size(); ++i){
	    		l.addElement(allPositions.get(i));
	    	}
	    	JList<Position> list = new JList<Position>(l);
	    	contentPane.add(list);

			
    	
	}
}
