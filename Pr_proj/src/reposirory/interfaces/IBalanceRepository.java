package reposirory.interfaces;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import models.Balance;
import models.Flow;

public interface IBalanceRepository {
    List<Balance> getAll() throws SQLException;
    Balance getById(int id) throws SQLException;
    //
    void formSpendingAll() throws SQLException;
    void formProfitAll() throws SQLException;
    void formRemainderAll() throws SQLException;
    
    
    void formBalanceByDay(Date d) throws SQLException;
    
    BigDecimal getSpendingByDate(Date d) throws SQLException;
    BigDecimal getRemainderByDate(Date d) throws SQLException;
	BigDecimal getProfitByDate(Date d) throws SQLException;
	List<Balance> getAllBalanseInfo() throws SQLException;
	List<Balance> getBalanseByDate(Date d) throws SQLException;
    
    
}
