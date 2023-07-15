package order.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.Session;

import order.dao.MainOrderDAO;
import order.dao.SubOrderDAO;
import order.dao.SubOrderDetailDAO;
import order.dao.impl.MainOrderDAOImpl;
import order.dao.impl.SubOrderDAOImpl;
import order.dao.impl.SubOrderDetailDAOImpl;
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

}
