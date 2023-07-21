package member.service;

import core.service.CoreService;
import member.entity.Member;

public interface MemberService extends CoreService {

	// 註冊
	public boolean register(Member newMember);

	// 登入
	public boolean logIn (Member member);

}
