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
import models.Costs;
import models.FlowCost;

public class GetAllStageCosts extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int stage_id;
	
	public GetAllStageCosts(int stage_id) {
		dba = new DbAccess();
		this.stage_id = stage_id;
		dba.connectionDb("Projects", "root", "root");
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		frame.setSize(1100, 300);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("All stage costs");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		ArrayList<FlowCost> allStageCosts = dba.getAllCosts(stage_id);
    	DefaultListModel<FlowCost> l = new DefaultListModel<>();
    	for(int i = 0; i<allStageCosts.size(); ++i){
    		l.addElement(allStageCosts.get(i));
    	}
    	JList<FlowCost> list = new JList<FlowCost>(l);
    	contentPane.add(list);
	}
}
