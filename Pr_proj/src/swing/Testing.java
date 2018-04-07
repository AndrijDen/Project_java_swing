package swing;
import java.sql.Date;
import java.util.ArrayList;

import database.DbAccess;
import models.Staff;

public class Testing {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbAccess dba = new DbAccess();
		dba.connectionDb("Projects", "root", "root");
		Date start = new Date(2018, 2, 21);
		Date planned_end = new Date(2018, 9, 22);
		/*dba.addStage(1, 13, start, planned_end, 135.44);
		dba.addStage(2, 13, start, planned_end, 13445.44);
		dba.addStage(3, 13, start, planned_end, 134345.44);
		
		Stage p = dba.getStage(14);
		System.out.println( p.toString());
		
		dba.delStage(p);
		
		dba.editStage(13, 1, 13, start, planned_end, planned_end, 4444, 4444);
		
		ArrayList<Stage> st = dba.getAllStages();
		for(int i = 0; i < st.size(); ++i){
			System.out.println(st.get(i).toString());
		}*/
		
		Staff p = dba.getStaff(13);
		//dba.delProject(p);
	}

}
