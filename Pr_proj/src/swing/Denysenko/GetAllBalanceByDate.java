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
import repositories.BalanceRepository;
import repositories.FlowRepository;

public class GetAllBalanceByDate extends JFrame {
	
	private JFrame frame;
	private JPanel contentPane;
	IBalanceRepository balRep = new BalanceRepository();

	
	public GetAllBalanceByDate(Date d) throws SQLException {
		
		initialize(d);
		frame.setVisible(true);
	}
	
	private void initialize(Date d) throws SQLException {
		frame = new JFrame();
		frame.setBounds(200, 100, 450, 300);
		
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Balance by date:" + d);
       
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setSize(600, 300);
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		balRep.formBalanceByDay(d);

		List<Balance> allProjects = balRep.getBalanseByDate(d);
		DefaultListModel<Balance> l = new DefaultListModel<>();
    	for(int i = 0; i<allProjects.size(); ++i){
    		l.addElement(allProjects.get(i));
    	}
    	JList<Balance> list = new JList<Balance>(l);
    	contentPane.add(list);
	}

}
