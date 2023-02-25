package member.dao;

import org.apache.ibatis.session.SqlSession;

import common.mybatis.MyBatisConnectionFactory;
import member.vo.Member;

public class MemberDao {

	public Member select(Member member) {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		Member result = sqlSession.selectOne("myMember.login", member);

		sqlSession.close();

		return result;
	}

	public Member assign(Member member) {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		Member result = sqlSession.selectOne("myMember.assign", member);
		
		sqlSession.close();		

		return result;
	}
	
	public int memberdelete(String memberId) {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		int result = sqlSession.delete("myMember.deletemember", memberId);
		
		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();

		return result;
	}
	
	public int memberupdate(Member member) {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		int result = sqlSession.update("myMember.updatemember", member);
		
		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();

		return result;
	}

}
