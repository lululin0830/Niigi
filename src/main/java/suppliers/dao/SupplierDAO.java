package suppliers.dao;

import java.sql.Timestamp;

import core.dao.CoreDAO;
import suppliers.entity.Supplier;

public interface SupplierDAO extends CoreDAO<Supplier,String>{
	
	public String getAllBySearch(String searchCase,String searchSelect,Timestamp startDate,Timestamp closeDate,String dateSelect);
	
	public String getAllInit();
}
