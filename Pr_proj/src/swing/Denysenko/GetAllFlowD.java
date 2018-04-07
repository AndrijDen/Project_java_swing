package swing.Denysenko;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
import models.Balance;
import models.Flow;
import models.Project;
import reposirory.interfaces.IBalanceRepository;
import reposirory.interfaces.IFlowRepository;
import repositories.FlowRepository;

public class GetAllFlowD extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	IFlowRepository flRep = new FlowRepository();

	
	public GetAllFlowD() throws SQLException {
		initialize();
		frame.setVisible(true);
	}
	
	public GetAllFlowD(int id) throws SQLException {
		initialize(id);
		frame.setVisible(true);
	}
	
	public GetAllFlowD(Date d) throws SQLException {
		initialize(d);
		frame.setVisible(true);
	}
	public GetAllFlowD(Date d, Date d2) throws SQLException {
		initialize(d,d2);
		frame.setVisible(true);
	}
	
	
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("All projects");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setSize(800, 600);
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		List<Flow> allProjects = flRep.getAll();
		DefaultListModel<Flow> l = new DefaultListModel<>();
    	for(int i = 0; i<allProjects.size(); ++i){
    		l.addElement(allProjects.get(i));
    	}
    	JList<Flow> list = new JList<Flow>(l);
    	contentPane.add(list);
	}
	private void initialize(int id) throws SQLException {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		frame.setSize(1100, 300);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Projects by id");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setSize(800, 300);
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		List<Flow> allProjects = flRep.getById(id);
		DefaultListModel<Flow> l = new DefaultListModel<>();
    	for(int i = 0; i<allProjects.size(); ++i){
    		l.addElement(allProjects.get(i));
    	}
    	JList<Flow> list = new JList<Flow>(l);
    	contentPane.add(list);
	}
	
	
	private void initialize(Date d) throws SQLException {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Flow by date:" + d);
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setSize(800, 300);
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		
		List<Flow> allProjects = flRep.getAllByDate(d);
		DefaultListModel<Flow> l = new DefaultListModel<>();
    	for(int i = 0; i<allProjects.size(); ++i){
    		l.addElement(allProjects.get(i));
    	}
    	JList<Flow> list = new JList<Flow>(l);
    	contentPane.add(list);
	}
	
	private void initialize(Date d,Date d2) throws SQLException {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Flow by date: From - " + d+"To - "+d2);
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setSize(800, 300);
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		
		List<Flow> allProjects = flRep.getAllByStartDateToAnd(d, d2);
		DefaultListModel<Flow> l = new DefaultListModel<>();
    	for(int i = 0; i<allProjects.size(); ++i){
    		l.addElement(allProjects.get(i));
    	}
    	JList<Flow> list = new JList<Flow>(l);
    	contentPane.add(list);
	}

}
