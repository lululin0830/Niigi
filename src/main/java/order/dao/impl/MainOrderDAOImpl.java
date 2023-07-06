package order.dao.impl;

import java.util.*;

import order.dao.MainOrderDAO;
import order.entity.MainOrder;

import java.sql.*;
import java.sql.Date;
import java.text.*;

public class MainOrderDAOImpl implements MainOrderDAO {

	public static String driver = "com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/GP?serverTimezone=Asia/Taipei";
	public static String user = "root";
	public static String password = "password";

	private static final String INSERT_STMT = """

			
			insert into `MainOrder` (
				`orderId`,
				`memberId`,
				`totalAmount`,
				`totalGrossProfit`,
				`pointsDiscount`,
				`couponDiscount`,
				`paidAmount`,
				`paymentType`,
				`recipient`,
				`phoneNum`,
				`deliveryAddress`)
			values (?,?,?,?,?,?,?,?,?,?,?); """;

	private static final String GET_ALL_STMT = """

			
			select * from MainOrder order by orderId ; """;

	private static final String GET_ONE_STMT = """

			
			select * from MainOrder where orderId = ? ; """;

	private static final String UPDATE_PAYMENT_TIME_BILLING_TIME = """

			update MainOrder
			set
				paymentTime = ?,
				billDate = ?
			where orderId = ? ; """;

	private static final String UPDATE_PAYMENT_STATU_order_status = """

			update MainOrder
			set
				paymentStatus = ?,
				orderStatus = ?
			where orderId = ? ;

			""";
	private static final String UPDATE_order_status = """

			update MainOrder
			set orderStatus = ?
			where orderId = ? ;

			""";

	private static final String UPDATE_BILL_STATU = """

			update MainOrder
			set billStatus = ?
			where orderId = ? ;

			""";

	private static final String DELETE = """

			delete from MainOrder where orderId = ? ;

			""";

	@Override
	public void insert(MainOrder MainOrder) {
		// TODO Auto-generated method stub

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(INSERT_STMT)) {

			pstmt.setString(1, MainOrder.getOrderId());
			pstmt.setString(2, MainOrder.getMemberId());
			pstmt.setInt(3, MainOrder.getTotalAmount());
			pstmt.setInt(4, MainOrder.getTotalGrossProfit());
			pstmt.setInt(5, MainOrder.getPointDiscount());
			pstmt.setInt(6, MainOrder.getCouponDiscount());
			pstmt.setInt(7, MainOrder.getPaidAmount());
			pstmt.setString(8, MainOrder.getPaymentType());
			pstmt.setString(9, MainOrder.getRecipient());
			pstmt.setString(10, MainOrder.getPhoneNum());
			pstmt.setString(11, MainOrder.getDeliveryAddress());

			pstmt.execute();
			System.out.println("insert successfully！！");
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePaymentTime(MainOrder MainOrder) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_PAYMENT_TIME_BILLING_TIME)) {

			pstmt.setTimestamp(1, MainOrder.getPaymentTime());
			pstmt.setDate(2, MainOrder.getBillDate());
			pstmt.setString(3, MainOrder.getOrderId());

			if (pstmt.execute()) {
				System.out.println("update successfully！！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updatePaymentStatus(MainOrder MainOrder) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_PAYMENT_STATU_order_status)) {

			pstmt.setString(1, MainOrder.getPaymentStatus());
			pstmt.setString(2, MainOrder.getOrderStatus());
			pstmt.setString(3, MainOrder.getOrderId());

			if (pstmt.execute()) {
				System.out.println("update successfully！！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrderStatus(MainOrder MainOrder) {
		// TODO Auto-generated method stub

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_order_status)) {

			pstmt.setString(1, MainOrder.getOrderStatus());
			pstmt.setString(2, MainOrder.getOrderId());

			if (pstmt.execute()) {
				System.out.println("update successfully！！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBillStatus(MainOrder MainOrder) {
		// TODO Auto-generated method stub

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_BILL_STATU)) {

			pstmt.setString(1, MainOrder.getBillStatus());
			pstmt.setString(2, MainOrder.getOrderId());

			if (pstmt.execute()) {
				System.out.println("update successfully！！");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String orderId) {
		// TODO Auto-generated method stub

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(DELETE)) {

			if (!orderId.isBlank() && orderId != null) {
				pstmt.setString(1, orderId);
				if (pstmt.execute()) {
					System.out.println("delete successfully！！");
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public MainOrder getByPrimaryKey(String orderId) {
		// TODO Auto-generated method stub

		MainOrder queryResult = null;

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(GET_ONE_STMT)) {

			if (!orderId.isBlank() && orderId != null) {
				pstmt.setString(1, orderId);

				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					queryResult = new MainOrder();

					queryResult.setOrderId(rs.getString(1));
					queryResult.setMemberId(rs.getString(2));
					queryResult.setOrderCreateTime(rs.getTimestamp(3));
					queryResult.setOrderStatus(rs.getString(4));
					queryResult.setTotalAmount(rs.getInt(5));
					queryResult.setTotalGrossProfit(rs.getInt(6));
					queryResult.setPointDiscount(rs.getInt(7));
					queryResult.setCouponDiscount(rs.getInt(8));
					queryResult.setPaidAmount(rs.getInt(9));
					queryResult.setPaymentType(rs.getString(10));
					queryResult.setPaymentStatus(rs.getString(11));
					queryResult.setPaymentTime(rs.getTimestamp(12));
					queryResult.setBillStatus(rs.getString(13));
					queryResult.setBillDate(rs.getDate(14));
					queryResult.setPhoneNum(rs.getString(15));
					queryResult.setDeliveryAddress(rs.getString(16));

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return queryResult;
	}

	@Override
	public List<MainOrder> getAll() {
		// TODO Auto-generated method stub

		List<MainOrder> queryResultList = new ArrayList<MainOrder>();
		MainOrder queryResult = null;

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(GET_ALL_STMT)) {

		
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				queryResult = new MainOrder();

				queryResult.setOrderId(rs.getString(1));
				queryResult.setMemberId(rs.getString(2));
				queryResult.setOrderCreateTime(rs.getTimestamp(3));
				queryResult.setOrderStatus(rs.getString(4));
				queryResult.setTotalAmount(rs.getInt(5));
				queryResult.setTotalGrossProfit(rs.getInt(6));
				queryResult.setPointDiscount(rs.getInt(7));
				queryResult.setCouponDiscount(rs.getInt(8));
				queryResult.setPaidAmount(rs.getInt(9));
				queryResult.setPaymentType(rs.getString(10));
				queryResult.setPaymentStatus(rs.getString(11));
				queryResult.setPaymentTime(rs.getTimestamp(12));
				queryResult.setBillStatus(rs.getString(13));
				queryResult.setBillDate(rs.getDate(14));
				queryResult.setPhoneNum(rs.getString(15));
				queryResult.setDeliveryAddress(rs.getString(16));

				queryResultList.add(queryResult);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return queryResultList;
	}

	@Override
	public List<MainOrder> getAll(Map<String, String[]> map) {
		// TODO Auto-generated method stub

		List<MainOrder> queryResultList = new ArrayList<MainOrder>();
		MainOrder queryResult = null;

		try (Connection connection = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = connection.prepareStatement(GET_ONE_STMT)) {

			for (String[] values : map.values()) {

				for (int i = 0; i < values.length; i++) {

					String order_id = values[i];

					if (!order_id.isBlank() && order_id != null) {

						pstmt.setString(1, order_id);

						pstmt.addBatch();

					}
				}

			}

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				queryResult = new MainOrder();

				queryResult.setOrderId(rs.getString(1));
				queryResult.setMemberId(rs.getString(2));
				queryResult.setOrderCreateTime(rs.getTimestamp(3));
				queryResult.setOrderStatus(rs.getString(4));
				queryResult.setTotalAmount(rs.getInt(5));
				queryResult.setTotalGrossProfit(rs.getInt(6));
				queryResult.setPointDiscount(rs.getInt(7));
				queryResult.setCouponDiscount(rs.getInt(8));
				queryResult.setPaidAmount(rs.getInt(9));
				queryResult.setPaymentType(rs.getString(10));
				queryResult.setPaymentStatus(rs.getString(11));
				queryResult.setPaymentTime(rs.getTimestamp(12));
				queryResult.setBillStatus(rs.getString(13));
				queryResult.setBillDate(rs.getDate(14));
				queryResult.setShipmentType(rs.getString(15));
				queryResult.setRecipient(rs.getString(16));
				queryResult.setPhoneNum(rs.getString(17));
				queryResult.setDeliveryAddress(rs.getString(18));

				queryResultList.add(queryResult);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return queryResultList;
	}

	public static void main(String[] args) {


		String orderId = "20230626123456799";
		String memberId = "M123456789";
		String orderStatus = "0";
		Integer totalAmount = 1000;
		Integer totalGrossProfit = 10;
		Integer pointDiscount = 10;
		Integer couponDiscount = 100;
		Integer paidAmount = totalAmount - pointDiscount - couponDiscount;
		String paymentType = "1";
		String paymentStatus = "1";
		Timestamp paymentTime = new Timestamp(System.currentTimeMillis());
		String billStatus = "1";
		String recipient = "Hello";
		String phoneNum = "0939-000-000";
		String deliveryAddress = "地址";

		MainOrder test = new MainOrder(orderId, memberId, orderStatus, totalAmount, totalGrossProfit,
				pointDiscount, couponDiscount, paidAmount, paymentType, paymentStatus, billStatus, recipient,
				phoneNum, deliveryAddress);
		
		MainOrderDAOImpl dao = new MainOrderDAOImpl();
		dao.insert(test);
		List<MainOrder> list = dao.getAll();
		
		for (MainOrder order : list) {
			System.out.println(order);
		}
		
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(paymentTime.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, 3);

  
        Date billDate = new Date(calendar.getTimeInMillis());
        
        test.setPaymentTime(paymentTime);
        test.setBillDate(billDate);
		dao.updatePaymentTime(test);
		
		test.setPaymentStatus("2");
		test.setOrderStatus("1");
		dao.updatePaymentStatus(test);

		test.setOrderStatus("0");
		dao.updateOrderStatus(test);
		
		test.setBillStatus("0");
		dao.updateBillStatus(test);
		
		dao.delete("20230626123456780");
		

	}

}
