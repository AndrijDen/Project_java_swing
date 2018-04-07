package swing.Denysenko;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DbAccess;
import models.Flow;
import models.Project;
import reposirory.interfaces.IFlowRepository;
import repositories.FlowRepository;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class GetFlowByTypeD extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private int id;
	private JButton editProjectButton;
	private JButton deleteProjectButton;
	private JButton getStagesButton;
	private JButton createStageManager;
	private JLabel lblStagesManager;
	private JLabel lblEnterStageId;
	private JSpinner stageId;
	private JButton btnGetStage;
	IFlowRepository flRep = new FlowRepository();

	
	public GetFlowByTypeD(int id) throws SQLException {
		this.id = id;
		initialize();
		frame.setVisible(true);
	}
	
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("FLow By Type");
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setSize(800, 300);
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		
		
		List<Flow> p = flRep.getByType(id);
		//System.out.println(p);
    	DefaultListModel<Flow> l = new DefaultListModel<>();
    	for(int i = 0; i<p.size(); ++i){
    		l.addElement(p.get(i));
    	}
    	JList<Flow> list = new JList<Flow>(l);
    	contentPane.add(list);
    	
    
    	
    	
	}

}
