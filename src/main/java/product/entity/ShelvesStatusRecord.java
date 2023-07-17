package product.entity;

import java.sql.Timestamp;

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
public class ShelvesStatusRecord {

	@Id
	private String shelvesStatusId;
	private String productId;
	private String productSpecId;
	private String shelvesMemberId;
	private String statusModify;
	private Timestamp statusModifyTime;
}
