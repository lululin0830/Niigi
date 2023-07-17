package product.entity;

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
public class ProductSpec {
	
	@Id
	private String productSpecId;
	private String productId;
	private String specType1;
	private String specInfo1;
	private String specType2;
	private String specInfo2;
	private byte[] specPicture;
	@Column(insertable = false)
	private String shelvesStatus;
	private Integer initialStock;
	private Integer specStock;
}
