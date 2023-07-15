package order.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import order.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	private static volatile int orderCounter = 1;
	private static final int MAX_ORDER_COUNTER_VALUE = 999999999;
	private static final Object counterLock = new Object();
	
	// 取得自動編號
	public static String generateNextId() {
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

}
