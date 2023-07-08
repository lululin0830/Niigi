package order.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Comparator;
import java.sql.Date;
import java.util.Objects;

public class SubOrder implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5618369222849326060L;
	
	private String subOrderId;
	private String orderId;	
	private String supplierId;
	private String memberId;
	private Timestamp orderCreateTime;
	private Timestamp orderCloseTime;
	private String subOrderStatus;
	private Integer subPaidAmount;
	private Integer subPointsDiscount;
	private Integer subCouponDiscount;
	private Integer grossProfit;
	private Integer pointsReward;	
	private String grantStatus;
	private Date grantDate;
	private String recipient;
	private String phoneNum;
	private String deliveryAddress;
	
	
	public String getSubOrderId() {
		return subOrderId;
	}
	public void setSubOrderId(String subOrderId) {
		this.subOrderId = subOrderId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
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
	public Timestamp getOrderCloseTime() {
		return orderCloseTime;
	}
	public void setOrderCloseTime(Timestamp orderCloseTime) {
		this.orderCloseTime = orderCloseTime;
	}
	public String getSubOrderStatus() {
		return subOrderStatus;
	}
	public void setSubOrderStatus(String subOrderStatus) {
		this.subOrderStatus = subOrderStatus;
	}
	public Integer getSubPaidAmount() {
		return subPaidAmount;
	}
	public void setSubPaidAmount(Integer subPaidAmount) {
		this.subPaidAmount = subPaidAmount;
	}
	public Integer getSubPointsDiscount() {
		return subPointsDiscount;
	}
	public void setSubPointsDiscount(Integer subPointsDiscount) {
		this.subPointsDiscount = subPointsDiscount;
	}
	public Integer getSubCouponDiscount() {
		return subCouponDiscount;
	}
	public void setSubCouponDiscount(Integer subCouponDiscount) {
		this.subCouponDiscount = subCouponDiscount;
	}
	public Integer getGrossProfit() {
		return grossProfit;
	}
	public void setGrossProfit(Integer grossProfit) {
		this.grossProfit = grossProfit;
	}
	public Integer getPointsReward() {
		return pointsReward;
	}
	public void setPointsReward(Integer pointsReward) {
		this.pointsReward = pointsReward;
	}
	public String getGrantStatus() {
		return grantStatus;
	}
	public void setGrantStatus(String grantStatus) {
		this.grantStatus = grantStatus;
	}
	public Date getGrantDate() {
		return grantDate;
	}
	public void setGrantDate(Date grantDate) {
		this.grantDate = grantDate;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(subOrderId);
		
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		SubOrder other = (SubOrder) obj;
		return Objects.equals(subOrderId, other.subOrderId);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "orderId:" + orderId + 
						"sub_orderId:" + subOrderId +  
						"supplierId:" + supplierId + 
						"memberId:" + memberId + 
						"orderCreateTime:" + orderCreateTime +
						"orderCloseTime:" + orderCloseTime +
						"subOrderStatus:" + subOrderStatus + 
						"subPaidAmount:" + subPaidAmount +
						"subPointsDiscount:" + subPointsDiscount +
						"subCouponDiscount:" + subCouponDiscount +
						"grossProfit:" + grossProfit + 
						"pointsReward:" + pointsReward +
						"grantStatus:" + grantStatus +
						"grantDate:" + grantDate + 
						"recipient:" + recipient + 
						"phoneNum:" + phoneNum + 
						"deliveryAddress:" + deliveryAddress;
		return result;
	}
	
	
}
