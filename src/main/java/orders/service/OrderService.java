package orders.service;

import java.util.List;

import com.google.gson.JsonObject;


import core.service.CoreService;
import orders.entity.MainOrder;
import orders.entity.SubOrder;

public interface OrderService extends CoreService{
	
	public boolean createOrder(MainOrder mainOrder);

//	public boolean createOrder(MainOrder mainOrder, List<Product> productList ,List<EventSingleThreshold> eventList);
	
	public boolean cancelOrder();
	
	public boolean refund();
	
	public boolean comment();
	
	public boolean updatepayment();
	
	public boolean updateStatus();
	
	public boolean closeOrder();
	
	//======================後台訂單列表區塊======================
	
	public List<SubOrder> orderlist(JsonObject SearchCondition);	
	
	//======================後台訂單列表區塊======================
	
}
