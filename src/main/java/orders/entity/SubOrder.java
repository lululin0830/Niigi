package orders.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Comparator;
import java.sql.Date;
import java.util.Objects;

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
@AllArgsConstructor
@NoArgsConstructor
public class SubOrder implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5618369222849326060L;
	
	@Id
	private String subOrderId;
	private String orderId;	
	private String supplierId;
	private String memberId;
	private Timestamp orderCreateTime;
	@Column(insertable = false)
	private Timestamp orderCloseTime;
	@Column(insertable = false)
	private String subOrderStatus;
	private Integer subPaidAmount;
	@Column(insertable = false)
	private Integer subPointsDiscount;
	@Column(insertable = false)
	private Integer subCouponDiscount;
	private Integer grossProfit;
	private Integer pointsReward;	
	private String grantStatus;
	@Column(insertable = false)
	private Date grantDate;
	private String recipient;
	private String phoneNum;
	private String deliveryAddress;

}
