package product.entity;

import java.sql.Date;

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
public class Product {

	@Id
	private String productId;
	private String registerSupplier;
	private String categoryId;
	private String productName;
	private int productPrice;
	private String productInfo;
	private byte[] picture1;
	private byte[] picture2;
	private byte[] picture3;
	private byte[] picture4;
	private byte[] picture5;
	@Column(insertable = false)
	private String productStatus;
	@Column(insertable = false)
	private double avgRating;
	@Column(insertable = false)
	private Date firstOnShelvesDate;
	
}
