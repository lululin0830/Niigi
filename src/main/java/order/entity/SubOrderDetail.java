package order.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


public class SubOrderDetail implements Serializable{

	/*
	 訂單明細
	 */
	
	private static final long serialVersionUID = -3459181800840488062L;

	private String orderDetailId;
	private String subOrderId;
	private String orderId ;
	private String productId;
	private String productSpecId;
	private int productPrice;
	private int itemCouponDiscount;
	private int eventPrice;
	private int ratingPrice;
	private String comment;
	private Date commentDate;
	private Date refundDeadline;
	private Date refundDate;
	private String refundReason;
	private String refundRemark;
	private String itemStatus;
	
	
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
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
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductSpecId() {
		return productSpecId;
	}
	public void setProductSpecId(String productSpecId) {
		this.productSpecId = productSpecId;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getItemCouponDiscount() {
		return itemCouponDiscount;
	}
	public void setItemCouponDiscount(int itemCouponDiscount) {
		this.itemCouponDiscount = itemCouponDiscount;
	}
	public int getEventPrice() {
		return eventPrice;
	}
	public void setEventPrice(int eventPrice) {
		this.eventPrice = eventPrice;
	}
	public int getRatingPrice() {
		return ratingPrice;
	}
	public void setRatingPrice(int ratingPrice) {
		this.ratingPrice = ratingPrice;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Date getRefundDeadline() {
		return refundDeadline;
	}
	public void setRefundDeadline(Date refundDeadline) {
		this.refundDeadline = refundDeadline;
	}
	public Date getRefundDate() {
		return refundDate;
	}
	public void setRefundDate(Date refundDate) {
		this.refundDate = refundDate;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	public String getRefundRemark() {
		return refundRemark;
	}
	public void setRefundRemark(String refundRemark) {
		this.refundRemark = refundRemark;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(orderDetailId);
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj) 
			return true;
		if(obj!=null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		SubOrderDetail other = (SubOrderDetail) obj;
		return Objects.equals(orderDetailId,other.orderDetailId);
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "order_detail_id:" + orderDetailId + 
						"sub_order_id:" + subOrderId +
						"order_id:" + orderId +
						"product_id:" + productId +
						"product_spec_id:" + productSpecId +
						"product_price:" + productPrice +
						"item_coupon_discount:" + itemCouponDiscount +
						"event_price:" + eventPrice +
						"rating_price:" + ratingPrice + 
						"comment:" + comment +
						"comment_date:" + commentDate +
						"refund_deadline:" + refundDeadline +
						"refund_date:" + refundDate +
						"refund_reason:" + refundReason +
						"refund_remark:" + refundRemark +
						"item_status:" + itemStatus;
		return result;
	}
	
}
