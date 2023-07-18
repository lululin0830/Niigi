package orders.service.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Session;

import com.google.gson.JsonObject;
import com.mysql.cj.xdevapi.Result;

import orders.dao.MainOrderDAO;
import orders.dao.impl.MainOrderDAOImpl;
import orders.dao.impl.SubOrderDAOImpl;
import orders.entity.MainOrder;
import orders.entity.SubOrder;
import orders.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private static volatile int orderCounter = 1;
	private static final int MAX_ORDER_COUNTER_VALUE = 999999999;
	private static final Object counterLock = new Object();

	SubOrderDAOImpl dao;
	
	public OrderServiceImpl() {
		
		dao = new SubOrderDAOImpl();
	}
	
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

	// 後臺訂單列表-取得查詢結果
	@Override
	public String orderlist(JsonObject searchCondition) {
		
		

		String searchcase = searchCondition.get("searchcase").getAsString();

		String SearchSelect = searchCondition.get("searchway").getAsString();

		String startDateString = searchCondition.get("StartDate").getAsString();

		Timestamp startDate, closeDate;

		if (startDateString.length() > 0) {
			startDateString += " 00:00:00";
			startDate = Timestamp.valueOf(startDateString);
		} else {
			startDate = Timestamp.valueOf("1970-01-01 00:00:00");
		}

		String closeDateString = searchCondition.get("EndDate").getAsString();

		if (closeDateString.length() > 0) {		
			closeDateString+= " 00:00:00";
			closeDate = Timestamp.valueOf(closeDateString);
		}else {
			closeDate = Timestamp.valueOf(LocalDateTime.now());
		}

		String dateSelect = searchCondition.get("DateSelect").getAsString();

//		SubOrderDAOImpl subOrderDAOImpl = new SubOrderDAOImpl();

	
		String result = null;
		try {
			
			beginTransaction();				
			result = dao.getAllByOrderId(searchcase, SearchSelect, startDate, closeDate, dateSelect);
			commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
		

	}

	public String getAllInit() {
		
		String result = null;
		try {
			beginTransaction();
			result = dao.getAllInit();
			commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
}

	
