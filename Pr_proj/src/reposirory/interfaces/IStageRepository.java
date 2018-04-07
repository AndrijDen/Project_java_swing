package reposirory.interfaces;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import models.Project;
import models.Stage;

public interface IStageRepository {
	
    List<Stage> getAll() throws SQLException;
    Stage getById(int id) throws SQLException;    
}
