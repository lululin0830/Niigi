package member.service;

import java.util.List;

import core.service.CoreService;
import member.entity.Member;

public interface MemberService extends CoreService {

	// 註冊
	public boolean register(Member newMember);

	// 登入
	public boolean logIn (Member member);

	Member register(Member member);

	Member login(Member member);

	Member edit(Member member);

	List<Member> findAll();

	boolean remove(Integer id);

	boolean save(Member member);
}
