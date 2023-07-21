package user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import core.entity.Core;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends Core{

	/**
	 * 平台使用者
	 */
	private static final long serialVersionUID = -6071858145966342981L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String userAcct;
	private String password;
	private String financialAuthority;
	private String customerServiceAuthority;
	private String marketingAuthority;
	private String hrAuthority;
	
	public User(String userAcct,String password) {
		this.userAcct = userAcct;
		this.password = password;
	}
	
}
