package order.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MainOrder implements java.io.Serializable {

	/**
	 * 主訂單(MainOrder)
	 */
	
	private static final long serialVersionUID = 2442580178437547429L;

	@Id
	private String orderId;
	private String memberId;
	@Column(insertable = false)
	private Timestamp orderCreateTime;
	@Column(insertable = false)
	private String orderStatus;
	private Integer totalAmount;
	private Integer totalGrossProfit;
	private Integer pointDiscount;
	private Integer couponDiscount;
	private Integer paidAmount;
	private String paymentType;
	@Column(insertable = false)
	private String paymentStatus;
	@Column(insertable = false)
	private Timestamp paymentTime;
	@Column(insertable = false)
	private String billStatus;
	@Column(insertable = false)
	private Date billDate;
	@Column(insertable = false)
	private String shipmentType;
	private String recipient;
	private String phoneNum;
	private String deliveryAddress;

}
