package products.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String registerSupplier;
	private String categorieId;
	private String productName;
	private Integer productPrice;
	private String productInfo;
	private Byte[] picture1;
	private Byte[] picture2;
	private Byte[] picture3;
	private Byte[] picture4;
	private Byte[] picture5;
	@Column(insertable = false)
	private String productStatus;
	@Column(insertable = false)
	private Double avgRating;
	@Column(insertable = false)
	private Date firstOnShelvesDate;
	
}
