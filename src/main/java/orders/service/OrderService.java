package orders.service;

import com.google.gson.JsonObject;

import core.service.CoreService;

public interface OrderService extends CoreService{
	
	public boolean createOrder(JsonObject orderData);

	public boolean cancelOrder();
	
	public boolean refund();
	
	public boolean comment();
	
	public boolean updatepayment();
	
	public boolean updateStatus();
	
	public boolean closeOrder();
	
	//======================後台訂單列表區塊======================
	
	public String orderlist(JsonObject SearchCondition);	
	
	public String getAllInit();
	
	//======================後台訂單列表區塊======================
	
}
