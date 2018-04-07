package reposirory.interfaces;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import models.Flow;

public interface IFlowRepository {
	
    List<Flow> getAll() throws SQLException;
    List<Flow> getById(int id) throws SQLException;
    List<Flow> getAllByDate(Date d) throws SQLException;
    List<Flow> getByType(int id) throws SQLException;
	BigDecimal getSumOfAllFlowFromProjects() throws SQLException;
	BigDecimal getSumOfAllFlowFromProjectsBy_Date(Date d) throws SQLException;
	//void getSUmOfAllFlowFromProjectById(int id) throws SQLException;
	//void getSumOfAllFlowFromProjectById(int id) throws SQLException;
	List<Flow> getAllByStartDateToAnd(Date d, Date d2) throws SQLException;

}