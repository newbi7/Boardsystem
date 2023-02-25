package commentboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import commentboard.vo.commentBoard;
import common.mybatis.MyBatisConnectionFactory;

public class commentDao {

	public List<commentBoard> contentselectAll(int boardNum) {
		
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		List<commentBoard> result = sqlSession.selectList("myCommentBoard.allcommentboards", boardNum);
		
		sqlSession.close();
		
		
		return result;
	}
	
	public int updateComment(commentBoard commentboard) {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		int result = sqlSession.update("myCommentBoard.updatecommentboard", commentboard);
		
		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return result;
	}
	
	public int deleteComment(int commentNumber) {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		int result = sqlSession.delete("myCommentBoard.deletecommentboard", commentNumber);
		
		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();

		return result;
	}
	
	public int addComment(commentBoard commentBoard) {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		int result = sqlSession.insert("myCommentBoard.addcommentboard", commentBoard);
		
		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();

		return result;
	}

	public commentBoard getcommenteditBoard (int commentNum) {
		
		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		commentBoard result = sqlSession.selectOne("myCommentBoard.editcommentboard", commentNum);
		
		sqlSession.close();
		
		
		return result;
	}
}
