package order.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class MainOrder implements java.io.Serializable {

	/**
	 * 主訂單(Main_Order)
	 */
	
	private static final long serialVersionUID = 2442580178437547429L;

	private String order_id;
	private String member_id;
	private Timestamp order_Create_Time;
	private String order_status;
	private Integer total_amount;
	private Integer total_gross_profit;
	private Integer point_discount;
	private Integer coupon_discount;
	private Integer paid_amount;
	private String payment_type;
	private String payment_status;
	private Timestamp payment_time;
	private String bill_status;
	private Date bill_date;
	private String shipment_type;
	private String recipient;
	private String phone_num;
	private String delivery_address;

	public MainOrder() {

	}

	public MainOrder(String order_id, String member_id, Timestamp order_Create_Time,
			String order_status, Integer total_amount, Integer total_gross_profit, Integer point_discount,
			Integer coupon_discount, Integer paid_amount, String payment_type,
			String payment_status, String bill_status, String shipment_type, String recipient,
			String phone_num, String delivery_address) {
		super();
		this.order_id = order_id;
		this.member_id = member_id;
		this.order_Create_Time = order_Create_Time;
		this.order_status = order_status;
		this.total_amount = total_amount;
		this.total_gross_profit = total_gross_profit;
		this.point_discount = point_discount;
		this.coupon_discount = coupon_discount;
		this.paid_amount = paid_amount;
		this.payment_type = payment_type;
		this.payment_status = payment_status;
		this.bill_status = bill_status;
		this.shipment_type = shipment_type;
		this.recipient = recipient;
		this.phone_num = phone_num;
		this.delivery_address = delivery_address;
	}
	
	public MainOrder(String order_id, String member_id,
			String order_status, Integer total_amount, Integer total_gross_profit, Integer point_discount,
			Integer coupon_discount, Integer paid_amount, String payment_type,
			String payment_status, String bill_status, String recipient,
			String phone_num, String delivery_address) {
		super();
		this.order_id = order_id;
		this.member_id = member_id;
		this.order_status = order_status;
		this.total_amount = total_amount;
		this.total_gross_profit = total_gross_profit;
		this.point_discount = point_discount;
		this.coupon_discount = coupon_discount;
		this.paid_amount = paid_amount;
		this.payment_type = payment_type;
		this.payment_status = payment_status;
		this.bill_status = bill_status;
		this.recipient = recipient;
		this.phone_num = phone_num;
		this.delivery_address = delivery_address;
	}


	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public Timestamp getOrder_Create_Time() {
		return order_Create_Time;
	}

	public void setOrder_Create_Time(Timestamp order_Create_Time) {
		this.order_Create_Time = order_Create_Time;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public Integer getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Integer total_amount) {
		this.total_amount = total_amount;
	}

	public Integer getTotal_gross_profit() {
		return total_gross_profit;
	}

	public void setTotal_gross_profit(Integer total_gross_profit) {
		this.total_gross_profit = total_gross_profit;
	}

	public Integer getPoint_discount() {
		return point_discount;
	}

	public void setPoint_discount(Integer point_discount) {
		this.point_discount = point_discount;
	}

	public Integer getCoupon_discount() {
		return coupon_discount;
	}

	public void setCoupon_discount(Integer coupon_discount) {
		this.coupon_discount = coupon_discount;
	}

	public Integer getPaid_amount() {
		return paid_amount;
	}

	public void setPaid_amount(Integer paid_amount) {
		this.paid_amount = paid_amount;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public Timestamp getPayment_time() {
		return payment_time;
	}

	public void setPayment_time(Timestamp payment_time) {
		this.payment_time = payment_time;
	}

	public String getBill_status() {
		return bill_status;
	}

	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}

	public Date getBill_date() {
		return bill_date;
	}

	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}

	public String getShipment_type() {
		return shipment_type;
	}

	public void setShipment_type(String shipment_type) {
		this.shipment_type = shipment_type;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getPhone_num() {
		return phone_num;
	}

	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}

	public String getDelivery_address() {
		return delivery_address;
	}

	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	@Override
	public int hashCode() {

		return order_id.hashCode();

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
		return Objects.equals(order_id, other.order_id);
	}

	@Override
	public String toString() {
		String print = "order_id:" + order_id + "member_id:" + member_id + "order_Create_Time:" + order_Create_Time
				+ "order_status:" + order_status + "total_amount:" + total_amount + "total_gross_profit:"
				+ total_gross_profit + "point_discount:" + point_discount + "coupon_discount:" + coupon_discount
				+ "paid_amount:" + paid_amount + "payment_type:" + payment_type + "payment_status:" + payment_status
				+ "payment_time:" + payment_time + "bill_status:" + bill_status + "bill_date:" + bill_date
				+ "shipment_type:" + shipment_type + "recipient:" + recipient + "phone_num:" + phone_num
				+ "delivery_address:" + delivery_address;
		return print;

	}

}
