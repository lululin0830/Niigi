package order.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonObject;

import order.dao.MainOrderDAO;
import order.dao.impl.MainOrderDAOImpl;
import order.entity.MainOrder;
import order.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	private static volatile int orderCounter = 1;
	private static final int MAX_ORDER_COUNTER_VALUE = 999999999;
	private static final Object counterLock = new Object();
	
	// 取得自動編號
	public static String generateOrderId() {
		LocalDate currentDate = LocalDate.now();
		String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

		synchronized (counterLock) { 
			String formattedCounter = String.format("%09d", orderCounter);
			if (orderCounter >= MAX_ORDER_COUNTER_VALUE) {
				orderCounter = 1; 
			} else {
				orderCounter++;
			}

			return formattedDate + formattedCounter;
		}
	}

	@Override
	public boolean createOrder(MainOrder mainOrder) {
		
		MainOrderDAO mainOrderDAO = new MainOrderDAOImpl();
//		SubOrderDAO subOrderDAO = new SubOrderDAOImpl();
//		SubOrderDetailDAO subOrderDetailDAO = new SubOrderDetailDAOImpl();
		
		mainOrder.setOrderId(generateOrderId());
		
		try {
			beginTransaction();
			
			mainOrderDAO.insert(mainOrder);
			
			commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			rollback();
			return false;
		}
		
	}

	@Override
	public boolean cancelOrder() {
		return false;
	}

	@Override
	public boolean refund() {
		return false;
	}

	@Override
	public boolean comment() {
		return false;
	}

	@Override
	public boolean updatepayment() {
		return false;
	}

	@Override
	public boolean updateStatus() {
		return false;
	}

	@Override
	public boolean closeOrder() {
		return false;
	}

	
	//後臺訂單列表-取得查詢結果
	@Override
	public boolean orderlist(JsonObject searchCondition) {
		
		String searchcase = searchCondition.get("searchcase").getAsString();
		
		String searchway = searchCondition.get("searchway").getAsString();
		
		String startDateString = searchCondition.get("StartDate").getAsString();
		LocalDate startDate = LocalDate.parse(startDateString, DateTimeFormatter.ISO_DATE);
		
		String closeDateString = searchCondition.get("CloseDate").getAsString();
		LocalDate closeDate = LocalDate.parse(closeDateString,DateTimeFormatter.ISO_DATE);
		
		String dateSelect = searchCondition.get("DateSelect").getAsString();
		
		
		
		
		return false;
	}

}
