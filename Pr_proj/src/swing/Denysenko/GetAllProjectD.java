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
import reposirory.interfaces.IProjectRepository;
import repositories.FlowRepository;
import repositories.ProjectRepository;

public class GetAllProjectD extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	IProjectRepository prRep = new ProjectRepository();

	
	public GetAllProjectD() throws SQLException {
		
		initialize();
		frame.setVisible(true);
	}
	
	public GetAllProjectD(int id) throws SQLException {
		initialize(id);
		frame.setVisible(true);
	}
	
	public GetAllProjectD(Date d) throws SQLException {
		initialize(d);
		frame.setVisible(true);
	}
	
	
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("All projects");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setSize(1100, 300);
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		List<Project> allProjects = prRep.getAll();
		DefaultListModel<Project> l = new DefaultListModel<>();
    	for(int i = 0; i<allProjects.size(); ++i){
    		l.addElement(allProjects.get(i));
    	}
    	JList<Project> list = new JList<Project>(l);
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
		frame.setSize(1100, 300);
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		prRep.toFormCost(id);
		List<Project> allProjects = prRep.getById(id);
		DefaultListModel<Project> l = new DefaultListModel<>();
    	for(int i = 0; i<allProjects.size(); ++i){
    		l.addElement(allProjects.get(i));
    	}
    	JList<Project> list = new JList<Project>(l);
    	contentPane.add(list);
	}
	private void initialize(Date d) throws SQLException {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Projects by date:" + d);
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setSize(1100, 300);
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		
		List<Project> allProjects = prRep.getAllByDate(d);
		DefaultListModel<Project> l = new DefaultListModel<>();
    	for(int i = 0; i<allProjects.size(); ++i){
    		l.addElement(allProjects.get(i));
    	}
    	JList<Project> list = new JList<Project>(l);
    	contentPane.add(list);
	}
	

}
