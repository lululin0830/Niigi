package member.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import member.dao.MemberDAO;
import member.entity.Member;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public Boolean insert(Member entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectById(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member update(Member newMember) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectByLogin(String memberAcct, String password) {
		final String sql = "select * from Member where memberAcct =:memberAcct and password =:password";
		return getSession()
				.createNativeQuery(sql, Member.class)
				.setParameter("memberAcct", memberAcct)
				.setParameter("password", password)
				.uniqueResult();
	}

	@Override
	public Member selectOneByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectOneByMemberAcct(String memberAcct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectManyByMemberId(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectManyByMemberAcct(String memberAcct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectManyByMemberIdDate(String memberId, Timestamp regTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectManyByMemberIdRegStatusOpen(String memberId, String regStatusOpen) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member selectByRecientPhoneNumDeliveryAddress(String lastRecipient, String lastPhoneNum,
			String lastDeliveryAddress) {
		// TODO Auto-generated method stub
		return null;
	}

}
