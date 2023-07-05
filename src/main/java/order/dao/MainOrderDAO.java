package order.dao;

import java.util.List;
import java.util.Map;

public interface MainOrderDAO {

	public void insert(MainOrderDAO main_orderVO);

	public void updatePayment_time(MainOrderDAO main_orderVO);
	
	public void updatePayment_status(MainOrderDAO main_orderVO);
	
	public void updateOrder_status(MainOrderDAO main_orderVO);
	
	public void updateBill_status(MainOrderDAO main_orderVO);

	public void delete(String order_id);

	public MainOrderDAO getByPrimaryKey(String order_id);

	public List<MainOrderDAO> getAll();

	public List<MainOrderDAO> getAll(Map<String, String[]> map);

}
