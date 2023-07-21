package member.dao;

import java.sql.Timestamp;

import core.dao.CoreDAO;
import member.entity.Member;

public interface MemberDAO extends CoreDAO<Member, String> {
	// 新增會員(編號，帳號，密碼，姓名，手機，性別，生日)

	// 萬用更新
	public Member update(Member newMember);

	// 登入 找帳號,密碼
	Member selectByLogin(String memberAcct, String password);

	// 找單一會員 找編號
	public Member selectOneByMemberId(String memberId);

	// 找單一會員 找帳號
	public Member selectOneByMemberAcct(String memberAcct);

	// 找多個會員 找編號
	public Member selectManyByMemberId(String memberId);

	// 找多個會員 帳號
	public Member selectManyByMemberAcct(String memberAcct);

	// 找多個會員 註冊日期，參數兩個
	public Member selectManyByMemberIdDate(String memberId, Timestamp regTime);

	// 找多個會員 查詢帳號狀態
	public Member selectManyByMemberIdRegStatusOpen(String memberId, String regStatusOpen);

	// 需要單獨查詢常用收件人，常用地址，常用收件電話
	public Member selectByRecientPhoneNumDeliveryAddress(String lastRecipient, String lastPhoneNum,
			String lastDeliveryAddress);

}
