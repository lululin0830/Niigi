package orders.dao;

import java.sql.Timestamp;
import java.util.List;

import com.google.gson.JsonObject;

import core.dao.CoreDAO;
import orders.entity.SubOrder;

public interface SubOrderDAO extends CoreDAO<SubOrder, String>{
	
	public SubOrder update(SubOrder newSubOrder)throws Exception;
            
    public String getAllByOrderId(String searchcase,String SearchSelect,Timestamp startDate,Timestamp closeDate,String dateSelect) throws Exception;
    
    public String getAllInit();
   
    public String getSupplierSubOrderInit(String supplierId);
    
    public String getSupplierSubOrderSearch();
  
}
