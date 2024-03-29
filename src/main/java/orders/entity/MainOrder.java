package orders.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.type.TrueFalseType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
	private Integer pointsDiscount;
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
	
	@OneToMany
	@JoinColumn(name = "orderId",referencedColumnName = "orderId",insertable = false,updatable = false)
	private List<SubOrder> subOrders;

	public MainOrder(String memberId, Integer totalAmount, Integer totalGrossProfit, Integer pointsDiscount,
			Integer couponDiscount, Integer paidAmount, String paymentType, String recipient, String phoneNum,
			String deliveryAddress) {
		super();
		this.memberId = memberId;
		this.totalAmount = totalAmount;
		this.totalGrossProfit = totalGrossProfit;
		this.pointsDiscount = pointsDiscount;
		this.couponDiscount = couponDiscount;
		this.paidAmount = paidAmount;
		this.paymentType = paymentType;
		this.recipient = recipient;
		this.phoneNum = phoneNum;
		this.deliveryAddress = deliveryAddress;
	}

	
}
