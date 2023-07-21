package member.dao;

import java.sql.Timestamp;

import core.dao.CoreDAO;
import member.entity.Member;

public interface MemberDAO extends CoreDAO<Member, String>{
	// 新增會員(編號，帳號，密碼，姓名，手機，性別，生日)
//	public void insert(Member member);

	// 更新開通狀態
	public Member updateReg(String memberId);

	// 更新備用信箱帳號
	public Member updatBackupEmail(String memberId);

	// 更新備用信箱開通狀態
	public Member updateBackup(String memberId);

	// 更新姓名
	public Member updateName(String memberId);

	// 更新手機
	public Member updatePhone(String memberId);

	// 更新會員圖片
	public Member updatePhoto(String memberId);

	// 更新停權狀態
	public Member updateBanStatus(String memberId);

	// 更新會員點數餘額
	public Member updateMemberPointBlance(String memberId);

	// 更新會員點數最短有效期限
	public Member updateMemberPointMinExp(String memberId);

	// 更新卡號，持卡人姓名，安全碼，後面傳四個參數
	public Member updateCreditCard(String memberId);

	// 更新地址
	public Member updateAddress(String memberId);

	// 更新常用收件人，常用地址，常用收件電話
	public Member updateAnotherPeople(String memberId);

	// 找單一會員 找編號
	public Member findOneByMemberId(String memberId);

	// 找單一會員 找帳號
	public Member findOneByMemberAcct(String memberId);

	// 找多個會員 找編號
	public Member findManyByMemberId(String memberId);

	// 找多個會員 帳號
	public Member findManyByMemberAcct(String memberId);

	// 找多個會員 註冊日期，參數兩個
	public Member findManyByPrimaryKeyAndDate(String memberId, Timestamp regTime);

	// 找多個會員 查詢帳號狀態
	public Member findManyByPrimaryKeyAndRegStatusOpen(String memberId, String regStatusOpen);

	// 需要單獨查詢常用收件人，常用地址，常用收件電話
	public Member findLastByRecientAndPhoneNumAndDeliveryAddress(String lastRecipient, String lastPhoneNum,
			String lastDeliveryAddress);

}
