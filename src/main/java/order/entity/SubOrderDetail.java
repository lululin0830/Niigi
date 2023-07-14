package order.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SubOrderDetail")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubOrderDetail implements Serializable{

	
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