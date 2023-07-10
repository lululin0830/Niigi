package member.dao;

import java.util.Date;
import java.util.List;

import member.entity.Member;

public interface MemberDAO {
	// 新增會員(編號，帳號，密碼，姓名，手機，性別，生日)
	public void insert(Member member);

	// 更新開通狀態
	public void updateReg(String memberId);

	// 更新備用信箱帳號
	public void updatBackupEmail(String memberId);

	// 更新備用信箱開通狀態
	public void updateBackup(String memberId);

	// 更新姓名
	public void updateName(String memberId);

	// 更新手機
	public void updatePhone(String memberId);

	// 更新會員圖片
	public void updatePhoto(String memberId);

	// 更新停權狀態
	public void updateBanStatus(String memberId);

	// 更新會員點數餘額
	public void updateMemberPointBlance(String memberId);

	// 更新會員點數最短有效期限
	public void updateMemberPointMinExp(String memberId);

	// 更新卡號，持卡人姓名，安全碼，後面傳四個參數
	public void updateCreditCard(String memberId);

	// 更新地址
	public void updateAddress(String memberId);

	// 更新常用收件人，常用地址，常用收件電話
	public void updateAnotherPeople(String memberId);

	// 找單一會員 找編號
	public Member findOneBymemberId(String memberId);

	// 找單一會員 找帳號
	public Member findOneBymemberAcct(String memberId);

	// 找多個會員 找編號
	public Member findManyBymemberId(String memberId);

	// 找多個會員 帳號
	public Member findManyBymemberAcct(String memberId);

	// 找多個會員 註冊日期，參數兩個
	public Member findManyByPrimaryKeyAndDate(String memberId, Date regTime);

	// 找多個會員 查詢帳號狀態
	public Member findManyByPrimaryKeyAndRegStatusOpen(String memberId, String regStatusOpen);

	// 需要單獨查詢常用收件人，常用地址，常用收件電話
	public Member findLastByRecientAndPhoneNumAndDeliveryAddress(String lastRecipient, String lastPhoneNum,
			String lastDeliveryAddress);

	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
	public List<Member> getAll();
}
