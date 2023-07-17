package order.service;

import com.google.gson.JsonObject;

import antlr.collections.List;
import core.service.CoreService;
import order.entity.MainOrder;

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
	
	public boolean orderlist(JsonObject SearchCondition);
	
	//======================後台訂單列表區塊======================
	
}
