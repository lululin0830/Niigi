package member.entity;

import java.sql.Blob;
import java.util.Date;

public class Member implements java.io.Serializable{

	/**
	 * 會員資料
	 */
	private static final long serialVersionUID = 2365248678814032865L;
	
	private String memberId;
	private String memberAcct;
	private String password;
	private String phone;
	private String name;
	private String gender;
	private Date birthday;
	private Date regTime;
	private String banStatus;
	private Integer memberPointBalance;
	private Date memberPointMinExp;
	private String backupEmail;
	private Blob memberPhoto;
	private String memberAddress;
	private String lastRecipient;
	private String lastPhoneNum;
	private String lastDeliveryAddress;
	private String creditNum;
	private String cardholder;
	private String creditExp;
	private String cvv;
	private String regStatusOpen;
	private String backupStatusOpen;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberAcct() {
		return memberAcct;
	}
	public void setMemberAcct(String memberAcct) {
		this.memberAcct = memberAcct;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public String getBanStatus() {
		return banStatus;
	}
	public void setBanStatus(String banStatus) {
		this.banStatus = banStatus;
	}
	public Integer getMemberPointBalance() {
		return memberPointBalance;
	}
	public void setMemberPointBalance(Integer memberPointBalance) {
		this.memberPointBalance = memberPointBalance;
	}
	public Date getMemberPointMinExp() {
		return memberPointMinExp;
	}
	public void setMemberPointMinExp(Date memberPointMinExp) {
		this.memberPointMinExp = memberPointMinExp;
	}
	public String getBackupEmail() {
		return backupEmail;
	}
	public void setBackupEmail(String backupEmail) {
		this.backupEmail = backupEmail;
	}
	public Blob getMemberPhoto() {
		return memberPhoto;
	}
	public void setMemberPhoto(Blob memberPhoto) {
		this.memberPhoto = memberPhoto;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getLastRecipient() {
		return lastRecipient;
	}
	public void setLastRecipient(String lastRecipient) {
		this.lastRecipient = lastRecipient;
	}
	public String getLastPhoneNum() {
		return lastPhoneNum;
	}
	public void setLastPhoneNum(String lastPhoneNum) {
		this.lastPhoneNum = lastPhoneNum;
	}
	public String getLastDeliveryAddress() {
		return lastDeliveryAddress;
	}
	public void setLastDeliveryAddress(String lastDeliveryAddress) {
		this.lastDeliveryAddress = lastDeliveryAddress;
	}
	public String getCreditNum() {
		return creditNum;
	}
	public void setCreditNum(String creditNum) {
		this.creditNum = creditNum;
	}
	public String getCardholder() {
		return cardholder;
	}
	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}
	public String getCreditExp() {
		return creditExp;
	}
	public void setCreditExp(String creditExp) {
		this.creditExp = creditExp;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getRegStatusOpen() {
		return regStatusOpen;
	}
	public void setRegStatusOpen(String regStatusOpen) {
		this.regStatusOpen = regStatusOpen;
	}
	public String getBackupStatusOpen() {
		return backupStatusOpen;
	}
	public void setBackupStatusOpen(String backupStatusOpen) {
		this.backupStatusOpen = backupStatusOpen;
	}
}
