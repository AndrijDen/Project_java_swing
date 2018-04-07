package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class GetPosition extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private DbAccess dba;
	private int id;
	private JButton editStageButton;
	private JButton deleteStageButton;
	
	private int project_id;

	
	public GetPosition(int id, int project_id) {
		this.id = id;
		this.project_id = project_id;
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
		
		frame.setTitle("Position");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		Position s = dba.getPosition(id);
    	DefaultListModel<Position> l = new DefaultListModel<>();
    	l.addElement(s);
    	contentPane.setLayout(null);
    	JList<Position> list = new JList<>(l);
    	list.setBounds(5, 5, 1074, 20);
    	contentPane.add(list);
    	
    	editStageButton = new JButton("Edit");
    	editStageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditPosition es = new EditPosition(id, project_id, frame);
			}
    	});
    	editStageButton.setBounds(5, 40, 89, 23);
    	contentPane.add(editStageButton);
    	
    	deleteStageButton = new JButton("Delete");
    	deleteStageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dba.delPosition(id);
				frame.setVisible(false);
				frame.dispose();
			}
    	});
    	deleteStageButton.setBounds(104, 40, 89, 23);
    	contentPane.add(deleteStageButton);
    	
    	
	}
}
