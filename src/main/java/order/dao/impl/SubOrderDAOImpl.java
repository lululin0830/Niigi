package order.dao.impl;

import java.util.ArrayList;
import java.util.List;

import order.dao.SubOrderDAO;
import order.entity.SubOrder;

import java.sql.*;

public class SubOrderDAOImpl implements SubOrderDAO{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test01?serverTimezone=Asia/Taipei";
	String user = "root";
	String password = "password";	
	
	private static final String INSERT_STMT = 				
			"""			
			INSERT INTO SubOrder (			
			subOrderId,
			orderId,
			supplierId,
			memberId,
			orderCreateTime,	
			orderCloseTime,
			subOrderStatus,
			subPaidAmount,
			subPointsDiscount,
			subCouponDiscount,
			grossProfit,
			pointsReward,
			grantStatus,
			grantDate,
			recipient,
			phoneNum,
			deliveryAddress) 
			VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,? ,? ,? ,?);
			""";	
	private static final String GET_ALL_STMT = 
			"""
			SELECT * FROM SubOrder order by subOrderId
			""";
	private static final String Get_Sub_Order_Id = 
			"""
			SELECT * FROM SubOrder where subOrderId = ?
			""";
	private static final String Get_Order_Id =
			"""
			SELECT * FROM SubOrder where orderId = ?
			""";
	private static final String Get_Member_Id =
			"""
			SELECT * FROM SubOrder where memberId = ?
			""";
	private static final String Get_Supplier_Id =
			"""
			SELECT * FROM SubOrder where supplierId = ?
			""";
	private static final String Get_order_create_time =
			"""
			SELECT * FROM SubOrder where orderCreateTime between ? and ?
			""";
	private static final String Get_order_close_time =
			"""
			SELECT * FROM SubOrder where orderCloseTime between ? and ?
			""";
	private static final String DELETE = 
			"""
			DELETE FROM SubOrder where subOrderId = ?
			""";
	private static final String UPDATE_ORDER_ClOSE_TIME =
			"""
			UPDATE SubOrder set 
			orderCloseTime = ?
			where subOrderId = ?
			""";
	private static final String UPDATE_SUB_ORDER_STATUS =
			"""
			UPDATE SubOrder set 
			subOrderStatus = ?
			where subOrderId = ?
			""";
	private static final String UPDATE_GRANT_STATUS =
			"""
			UPDATE SubOrder set 
			grantStatus = ?
			where subOrderId = ?
			""";
	private static final String UPDATE_GRANT_DATE =
			"""
			UPDATE SubOrder set 
			grantDate = ?
			where subOrderId = ?
			""";

	@Override
	public void insert(SubOrder SubOrder) {
		// TODO Auto-generated method stub
		try(Connection connection = DriverManager.getConnection(url,user,password);
				PreparedStatement pstmt = connection.prepareStatement(INSERT_STMT)){
			
			pstmt.setString(1,SubOrder.getSubOrderId());
			pstmt.setString(2,SubOrder.getOrderId());	
			pstmt.setString(3,SubOrder.getSupplierId());	
			pstmt.setString(4,SubOrder.getMemberId());	
			pstmt.setTimestamp(5,SubOrder.getOrderCreateTime());
			pstmt.setTimestamp(6,SubOrder.getOrderCloseTime());
			pstmt.setString(7,SubOrder.getSubOrderStatus());
			pstmt.setInt(8,SubOrder.getSubPaidAmount());	
			pstmt.setInt(9,SubOrder.getSubPointsDiscount());	
			pstmt.setInt(10,SubOrder.getSubCouponDiscount());	
			pstmt.setInt(11,SubOrder.getGrossProfit());	
			pstmt.setInt(12,SubOrder.getPointsReward());
			pstmt.setString(13,SubOrder.getGrantStatus());
			pstmt.setDate(14,SubOrder.getGrantDate());
			pstmt.setString(15,SubOrder.getRecipient());	
			pstmt.setString(16,SubOrder.getPhoneNum());	
			pstmt.setString(17,SubOrder.getDeliveryAddress());		
			
			System.out.println("新增成功");
			
			pstmt.execute();
			
			
			}catch(SQLException se){
				throw new RuntimeException("新增失敗 RuntimeException"+ se.getMessage());
				
			}
	}

	@Override
	public List<SubOrder> getAll() {
		// TODO Auto-generated method stub
		List<SubOrder> list = new ArrayList<SubOrder>();
		SubOrder Sub_OrderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				Sub_OrderVO = new SubOrder();
				Sub_OrderVO.setSubOrderId(rs.getString("SubOrderId"));
				Sub_OrderVO.setOrderId(rs.getString("OrderId"));
				Sub_OrderVO.setSupplierId(rs.getString("SupplierId"));
				Sub_OrderVO.setMemberId(rs.getString("MemberId"));
				Sub_OrderVO.setOrderCreateTime(rs.getTimestamp("OrderCreateTime"));
				Sub_OrderVO.setOrderCloseTime(rs.getTimestamp("OrderCloseTime"));
				Sub_OrderVO.setSubOrderStatus(rs.getString("SubOrderStatus"));
				Sub_OrderVO.setSubPaidAmount(rs.getInt("SubPaidAmount"));
				Sub_OrderVO.setSubPointsDiscount(rs.getInt("SubPointsDiscount"));
				Sub_OrderVO.setSubCouponDiscount(rs.getInt("SubCouponDiscount"));
				Sub_OrderVO.setGrossProfit(rs.getInt("GrossProfit"));
				Sub_OrderVO.setPointsReward(rs.getInt("PointsReward"));
				Sub_OrderVO.setGrantStatus(rs.getString("GrantStatus"));
				Sub_OrderVO.setGrantDate(rs.getDate("GrantDate"));
				Sub_OrderVO.setRecipient(rs.getString("Recipient"));
				Sub_OrderVO.setPhoneNum(rs.getString("PhoneNum"));
				Sub_OrderVO.setDeliveryAddress(rs.getString("DeliveryAddress"));
				list.add(Sub_OrderVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}
	
	
	
	@Override
	public void delete(String subOrderId) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, subOrderId);
			
			System.out.println("刪除成功");

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}
	
	@Override
	public void updateOrderCloseTime(SubOrder SubOrder) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(UPDATE_ORDER_ClOSE_TIME);

			pstmt.setTimestamp(1, SubOrder.getOrderCloseTime());
			pstmt.setString(2, SubOrder.getSubOrderId());

			System.out.println("修改成功");
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void updateSubOrderStatus(SubOrder SubOrder) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(UPDATE_SUB_ORDER_STATUS);

			pstmt.setString(1, SubOrder.getSubOrderStatus());
			pstmt.setString(2, SubOrder.getSubOrderId());
			
			System.out.println("修改成功");
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void updateGrantStatus(SubOrder SubOrder) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(UPDATE_GRANT_STATUS);

			pstmt.setString(1, SubOrder.getGrantStatus());
			pstmt.setString(2, SubOrder.getSubOrderId());
			
			System.out.println("修改成功");

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void updateGrantDate(SubOrder SubOrder) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(UPDATE_GRANT_DATE);

			pstmt.setDate(1, SubOrder.getGrantDate());
			pstmt.setString(2, SubOrder.getSubOrderId());
			
			System.out.println("修改成功");
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public SubOrder getByPrimaryKey(String subOrderId) {
		// TODO Auto-generated method stub
		SubOrder queryResult = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(Get_Sub_Order_Id);

			pstmt.setString(1,subOrderId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				queryResult = new SubOrder();
				queryResult.setSubOrderId(rs.getString("sub_order_id"));
				queryResult.setOrderId(rs.getString("order_id"));
				queryResult.setSupplierId(rs.getString("supplier_id"));
				queryResult.setMemberId(rs.getString("member_id"));
				queryResult.setOrderCreateTime(rs.getTimestamp("order_create_time"));
				queryResult.setOrderCloseTime(rs.getTimestamp("Order_close_time"));
				queryResult.setSubOrderStatus(rs.getString("Sub_order_status"));
				queryResult.setSubPaidAmount(rs.getInt("Sub_paid_amount"));
				queryResult.setSubPointsDiscount(rs.getInt("Sub_points_discount"));
				queryResult.setSubCouponDiscount(rs.getInt("Sub_coupon_discount"));
				queryResult.setGrossProfit(rs.getInt("Gross_profit"));
				queryResult.setPointsReward(rs.getInt("Points_reward"));
				queryResult.setGrantStatus(rs.getString("Grant_status"));
				queryResult.setGrantDate(rs.getDate("Grant_date"));
				queryResult.setRecipient(rs.getString("Recipient"));
				queryResult.setPhoneNum(rs.getString("Phone_num"));
				queryResult.setDeliveryAddress(rs.getString("Delivery_address"));
				
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return queryResult;
	}

	@Override
	public SubOrder getsubOrderId(String orderId) {
		// TODO Auto-generated method stub
		SubOrder queryResult = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(Get_Order_Id);

			pstmt.setString(1,orderId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				queryResult = new SubOrder();
				queryResult.setSubOrderId(rs.getString("subOrderId"));
				queryResult.setOrderId(rs.getString("orderId"));
				queryResult.setSupplierId(rs.getString("supplierId"));
				queryResult.setMemberId(rs.getString("memberId"));
				queryResult.setOrderCreateTime(rs.getTimestamp("orderCreateTime"));
				queryResult.setOrderCloseTime(rs.getTimestamp("OrderCloseTime"));
				queryResult.setSubOrderStatus(rs.getString("SubOrderStatus"));
				queryResult.setSubPaidAmount(rs.getInt("SubPaidAmount"));
				queryResult.setSubPointsDiscount(rs.getInt("SubPointsDiscount"));
				queryResult.setSubCouponDiscount(rs.getInt("SubCouponDiscount"));
				queryResult.setGrossProfit(rs.getInt("GrossProfit"));
				queryResult.setPointsReward(rs.getInt("PointsReward"));
				queryResult.setGrantStatus(rs.getString("GrantStatus"));
				queryResult.setGrantDate(rs.getDate("GrantDate"));
				queryResult.setRecipient(rs.getString("Recipient"));
				queryResult.setPhoneNum(rs.getString("PhoneNum"));
				queryResult.setDeliveryAddress(rs.getString("DeliveryAddress"));				
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return queryResult;
	}
		
	@Override
	public SubOrder getBymemberId(String memberId) {
		// TODO Auto-generated method stub
		SubOrder queryResult = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(Get_Member_Id);

			pstmt.setString(1,memberId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				queryResult = new SubOrder();
				queryResult.setSubOrderId(rs.getString("sub_order_id"));
				queryResult.setOrderId(rs.getString("order_id"));
				queryResult.setSupplierId(rs.getString("supplier_id"));
				queryResult.setMemberId(rs.getString("member_id"));
				queryResult.setOrderCreateTime(rs.getTimestamp("order_create_time"));
				queryResult.setOrderCloseTime(rs.getTimestamp("Order_close_time"));
				queryResult.setSubOrderStatus(rs.getString("Sub_order_status"));
				queryResult.setSubPaidAmount(rs.getInt("Sub_paid_amount"));
				queryResult.setSubPointsDiscount(rs.getInt("Sub_points_discount"));
				queryResult.setSubCouponDiscount(rs.getInt("Sub_coupon_discount"));
				queryResult.setGrossProfit(rs.getInt("Gross_profit"));
				queryResult.setPointsReward(rs.getInt("Points_reward"));
				queryResult.setGrantStatus(rs.getString("Grant_status"));
				queryResult.setGrantDate(rs.getDate("Grant_date"));
				queryResult.setRecipient(rs.getString("Recipient"));
				queryResult.setPhoneNum(rs.getString("Phone_num"));
				queryResult.setDeliveryAddress(rs.getString("Delivery_address"));				
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return queryResult;
	}
	
	@Override
	public SubOrder getBysupplierId(String supplierId) {
		// TODO Auto-generated method stub
		SubOrder queryResult = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(Get_Supplier_Id);

			pstmt.setString(1,supplierId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				queryResult = new SubOrder();
				queryResult.setSubOrderId(rs.getString("sub_order_id"));
				queryResult.setOrderId(rs.getString("order_id"));
				queryResult.setSupplierId(rs.getString("supplier_id"));
				queryResult.setMemberId(rs.getString("member_id"));
				queryResult.setOrderCreateTime(rs.getTimestamp("order_create_time"));
				queryResult.setOrderCloseTime(rs.getTimestamp("Order_close_time"));
				queryResult.setSubOrderStatus(rs.getString("Sub_order_status"));
				queryResult.setSubPaidAmount(rs.getInt("Sub_paid_amount"));
				queryResult.setSubPointsDiscount(rs.getInt("Sub_points_discount"));
				queryResult.setSubCouponDiscount(rs.getInt("Sub_coupon_discount"));
				queryResult.setGrossProfit(rs.getInt("Gross_profit"));
				queryResult.setPointsReward(rs.getInt("Points_reward"));
				queryResult.setGrantStatus(rs.getString("Grant_status"));
				queryResult.setGrantDate(rs.getDate("Grant_date"));
				queryResult.setRecipient(rs.getString("Recipient"));
				queryResult.setPhoneNum(rs.getString("Phone_num"));
				queryResult.setDeliveryAddress(rs.getString("Delivery_address"));				
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return queryResult;
	}
	
	@Override
	public SubOrder getByorderCreateTime(Timestamp orderCreateTime1,Timestamp orderCreateTime2) {
		// TODO Auto-generated method stub
		SubOrder queryResult = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(Get_order_create_time);

			pstmt.setTimestamp(1,orderCreateTime1);
			pstmt.setTimestamp(2,orderCreateTime2);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				queryResult = new SubOrder();
				queryResult.setSubOrderId(rs.getString("sub_order_id"));
				queryResult.setOrderId(rs.getString("order_id"));
				queryResult.setSupplierId(rs.getString("supplier_id"));
				queryResult.setMemberId(rs.getString("member_id"));
				queryResult.setOrderCreateTime(rs.getTimestamp("order_create_time"));
				queryResult.setOrderCloseTime(rs.getTimestamp("Order_close_time"));
				queryResult.setSubOrderStatus(rs.getString("Sub_order_status"));
				queryResult.setSubPaidAmount(rs.getInt("Sub_paid_amount"));
				queryResult.setSubPointsDiscount(rs.getInt("Sub_points_discount"));
				queryResult.setSubCouponDiscount(rs.getInt("Sub_coupon_discount"));
				queryResult.setGrossProfit(rs.getInt("Gross_profit"));
				queryResult.setPointsReward(rs.getInt("Points_reward"));
				queryResult.setGrantStatus(rs.getString("Grant_status"));
				queryResult.setGrantDate(rs.getDate("Grant_date"));
				queryResult.setRecipient(rs.getString("Recipient"));
				queryResult.setPhoneNum(rs.getString("Phone_num"));
				queryResult.setDeliveryAddress(rs.getString("Delivery_address"));				
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return queryResult;
	}

	@Override
	public SubOrder getByorderCloseTime(Timestamp orderCloseTime1,Timestamp orderCloseTime2) {
		// TODO Auto-generated method stub
		SubOrder queryResult = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(Get_order_close_time);

			pstmt.setTimestamp(1,orderCloseTime1);
			pstmt.setTimestamp(2,orderCloseTime2);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				queryResult = new SubOrder();
				queryResult.setSubOrderId(rs.getString("sub_order_id"));
				queryResult.setOrderId(rs.getString("order_id"));
				queryResult.setSupplierId(rs.getString("supplier_id"));
				queryResult.setMemberId(rs.getString("member_id"));
				queryResult.setOrderCreateTime(rs.getTimestamp("order_create_time"));
				queryResult.setOrderCloseTime(rs.getTimestamp("Order_close_time"));
				queryResult.setSubOrderStatus(rs.getString("Sub_order_status"));
				queryResult.setSubPaidAmount(rs.getInt("Sub_paid_amount"));
				queryResult.setSubPointsDiscount(rs.getInt("Sub_points_discount"));
				queryResult.setSubCouponDiscount(rs.getInt("Sub_coupon_discount"));
				queryResult.setGrossProfit(rs.getInt("Gross_profit"));
				queryResult.setPointsReward(rs.getInt("Points_reward"));
				queryResult.setGrantStatus(rs.getString("Grant_status"));
				queryResult.setGrantDate(rs.getDate("Grant_date"));
				queryResult.setRecipient(rs.getString("Recipient"));
				queryResult.setPhoneNum(rs.getString("Phone_num"));
				queryResult.setDeliveryAddress(rs.getString("Delivery_address"));				
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return queryResult;
	}

	public static void main(String[] args) {

		SubOrderDAOImpl dao = new SubOrderDAOImpl();
//
//		// 新增
		SubOrder Sub_OrderVO1 = new SubOrder();
		Sub_OrderVO1.setSubOrderId("t3826501846251486-001");
		Sub_OrderVO1.setOrderId("20230627123456789");
		Sub_OrderVO1.setSupplierId("MF84750213");
		Sub_OrderVO1.setMemberId("M836592658");
		Sub_OrderVO1.setOrderCreateTime(java.sql.Timestamp.valueOf("2023-06-27 16:40:00"));
		Sub_OrderVO1.setOrderCloseTime(null);
		Sub_OrderVO1.setSubOrderStatus("1");
		Sub_OrderVO1.setSubPaidAmount(100);
		Sub_OrderVO1.setSubPointsDiscount(10);
		Sub_OrderVO1.setSubCouponDiscount(10);
		Sub_OrderVO1.setGrossProfit(3);
		Sub_OrderVO1.setPointsReward(3);
		Sub_OrderVO1.setGrantStatus("0");
		Sub_OrderVO1.setGrantDate(null);
		Sub_OrderVO1.setRecipient("吳永志");
		Sub_OrderVO1.setPhoneNum("012345678901");
		Sub_OrderVO1.setDeliveryAddress("地球");

		dao.insert(Sub_OrderVO1);

		// 修改
		SubOrder Sub_OrderVO2 = new SubOrder();
		Sub_OrderVO2.setOrderCloseTime(java.sql.Timestamp.valueOf("2023-06-27 11:11:11"));
		Sub_OrderVO2.setSubOrderId("t3826501846251486-001");
		dao.updateOrderCloseTime(Sub_OrderVO2);
		
		SubOrder Sub_OrderVO3 = new SubOrder();
		Sub_OrderVO3.setSubOrderStatus("3");
		Sub_OrderVO3.setSubOrderId("t3826501846251486-001");
		dao.updateSubOrderStatus(Sub_OrderVO3);
		
		SubOrder Sub_OrderVO4 = new SubOrder();
		Sub_OrderVO4.setGrantStatus("2");
		Sub_OrderVO4.setSubOrderId("t3826501846251486-001");
		dao.updateGrantStatus(Sub_OrderVO4);

		SubOrder Sub_OrderVO5 = new SubOrder();
		Sub_OrderVO5.setGrantDate(java.sql.Date.valueOf("2023-06-27"));
		Sub_OrderVO5.setSubOrderId("t3826501846251486-001");
		dao.updateGrantDate(Sub_OrderVO5);
		
		// 刪除
		dao.delete("t3826501846251486-001");

		// 查詢
		SubOrder Sub_OrderVO6 = dao.getByPrimaryKey("t3826501846251486-001");
		System.out.println(Sub_OrderVO6);

		// 查詢訂單創立日期
		SubOrder Sub_OrderVO7 = dao.getByorderCreateTime(java.sql.Timestamp.valueOf("2023-06-27 16:40:00"),java.sql.Timestamp.valueOf("2023-06-27 16:40:00"));		
		System.out.println(Sub_OrderVO7);
		
		//查詢結單日期
		SubOrder Sub_OrderVO8 = dao.getByorderCloseTime(java.sql.Timestamp.valueOf("2023-06-27 16:40:00"),java.sql.Timestamp.valueOf("2023-06-27 16:40:00"));		
		System.out.println(Sub_OrderVO8);
		
		//查詢會員編號
		SubOrder Sub_OrderVO9 = dao.getBymemberId("t3826501846251486-001");		
		System.out.println(Sub_OrderVO9);
		
		//查詢商家編號
		SubOrder Sub_OrderVO10 = dao.getBysupplierId("t3826501846251486-001");		
		System.out.println(Sub_OrderVO10);

		// 查詢全部
		List<SubOrder> list = dao.getAll();
			System.out.println(list);
	}
}
