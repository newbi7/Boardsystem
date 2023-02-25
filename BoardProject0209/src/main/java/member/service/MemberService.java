package member.service;

import member.dao.MemberDao;
import member.vo.Member;

public class MemberService {

	public Member login(Member member) {
		
		MemberDao dao = new MemberDao();
		
		Member result = dao.select(member);
		
		return result;
	}
	
	public Member newassign(Member member) {

		MemberDao dao = new MemberDao();
		
		Member result = dao.assign(member);
		
		return result;
	}

	public int memberdelete (String memberId) {
		
		MemberDao dao = new MemberDao();
		
		int result = dao.memberdelete(memberId);
		
		return result;
	}
	
	public int memberupdate (Member member) {
		
		MemberDao dao = new MemberDao();
		
		int result = dao.memberupdate(member);
		
		return result;
	}

}
