package order.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class MainOrder implements java.io.Serializable {

	/**
	 * 主訂單(Main_Order)
	 */
	
	private static final long serialVersionUID = 2442580178437547429L;

	private String orderId;
	private String memberId;
	private Timestamp orderCreateTime;
	private String orderStatus;
	private Integer totalAmount;
	private Integer totalGrossProfit;
	private Integer pointDiscount;
	private Integer couponDiscount;
	private Integer paidAmount;
	private String paymentType;
	private String paymentStatus;
	private Timestamp paymentTime;
	private String billStatus;
	private Date billDate;
	private String shipmentType;
	private String recipient;
	private String phoneNum;
	private String deliveryAddress;

	public MainOrder() {

	}

	public MainOrder(String orderId, String memberId, Timestamp orderCreateTime,
			String orderStatus, Integer totalAmount, Integer totalGrossProfit, Integer pointDiscount,
			Integer couponDiscount, Integer paidAmount, String paymentType,
			String paymentStatus, String billStatus, String shipmentType, String recipient,
			String phoneNum, String deliveryAddress) {
		super();
		this.orderId = orderId;
		this.memberId = memberId;
		this.orderCreateTime = orderCreateTime;
		this.orderStatus = orderStatus;
		this.totalAmount = totalAmount;
		this.totalGrossProfit = totalGrossProfit;
		this.pointDiscount = pointDiscount;
		this.couponDiscount = couponDiscount;
		this.paidAmount = paidAmount;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.billStatus = billStatus;
		this.shipmentType = shipmentType;
		this.recipient = recipient;
		this.phoneNum = phoneNum;
		this.deliveryAddress = deliveryAddress;
	}
	
	public MainOrder(String orderId, String memberId,
			String orderStatus, Integer totalAmount, Integer totalGrossProfit, Integer pointDiscount,
			Integer couponDiscount, Integer paidAmount, String paymentType,
			String paymentStatus, String billStatus, String recipient,
			String phoneNum, String deliveryAddress) {
		super();
		this.orderId = orderId;
		this.memberId = memberId;
		this.orderStatus = orderStatus;
		this.totalAmount = totalAmount;
		this.totalGrossProfit = totalGrossProfit;
		this.pointDiscount = pointDiscount;
		this.couponDiscount = couponDiscount;
		this.paidAmount = paidAmount;
		this.paymentType = paymentType;
		this.paymentStatus = paymentStatus;
		this.billStatus = billStatus;
		this.recipient = recipient;
		this.phoneNum = phoneNum;
		this.deliveryAddress = deliveryAddress;
	}


	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Timestamp getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Timestamp orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getTotalGrossProfit() {
		return totalGrossProfit;
	}

	public void setTotalGrossProfit(Integer totalGrossProfit) {
		this.totalGrossProfit = totalGrossProfit;
	}

	public Integer getPointDiscount() {
		return pointDiscount;
	}

	public void setPointDiscount(Integer pointDiscount) {
		this.pointDiscount = pointDiscount;
	}

	public Integer getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(Integer couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public Integer getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Timestamp getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Timestamp paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getShipmentType() {
		return shipmentType;
	}

	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public int hashCode() {

		return orderId.hashCode();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		MainOrder other = (MainOrder) obj;
		return Objects.equals(orderId, other.orderId);
	}

	@Override
	public String toString() {
		String print = "orderId:" + orderId + "memberId:" + memberId + "orderCreateTime:" + orderCreateTime
				+ "orderStatus:" + orderStatus + "totalAmount:" + totalAmount + "totalGrossProfit:"
				+ totalGrossProfit + "pointDiscount:" + pointDiscount + "couponDiscount:" + couponDiscount
				+ "paidAmount:" + paidAmount + "paymentType:" + paymentType + "paymentStatus:" + paymentStatus
				+ "paymentTime:" + paymentTime + "billStatus:" + billStatus + "billDate:" + billDate
				+ "shipmentType:" + shipmentType + "recipient:" + recipient + "phoneNum:" + phoneNum
				+ "deliveryAddress:" + deliveryAddress;
		return print;

	}

}
