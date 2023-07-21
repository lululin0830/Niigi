package member.service;

import java.util.List;

import core.service.CoreService;
import member.entity.Members;

public interface MemberService extends CoreService {

	// 註冊
	public boolean register(Members newMember);

	// 登入
	public boolean logIn (Members member);

	Members register(Members member);

	Members login(Members member);

	Members edit(Members member);

	List<Members> findAll();

	boolean remove(Integer id);

	boolean save(Members member);
}
