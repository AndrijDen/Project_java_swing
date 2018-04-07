package reposirory.interfaces;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import models.Flow;
import models.Project;

public interface IProjectRepository {
	
    List<Project> getAll() throws SQLException;
    List<Project> getById(int id) throws SQLException;
    void toFormCost(int id) throws SQLException;
    void toFormSpending(int id) throws SQLException;  
    BigDecimal getSumOfCostFromStage(int id) throws SQLException;
    BigDecimal getSumOfSpendingFromStage(int id) throws SQLException;
   /* + */ BigDecimal getSumOfCostFromAllProject() throws SQLException;
   /* + */ BigDecimal getSumOfSpendingFromAllProject() throws SQLException;
List<Project> getAllByDate(Date d) throws SQLException;

}
