package order.dao;

import java.util.List;
import java.util.Map;

import order.entity.MainOrder;

public interface MainOrderDAO {

	public void insert(MainOrder MainOrder);

	public void updatePaymentTime(MainOrder MainOrder);
	
	public void updatePaymentStatus(MainOrder MainOrder);
	
	public void updateOrderStatus(MainOrder MainOrder);
	
	public void updateBillStatus(MainOrder MainOrder);

	public void delete(String orderId);

	public MainOrder getByPrimaryKey(String orderId);

	public List<MainOrder> getAll();

	public List<MainOrder> getAll(Map<String, String[]> map);

}
