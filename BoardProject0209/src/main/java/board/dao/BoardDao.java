package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.vo.Board;
import common.mybatis.MyBatisConnectionFactory;

public class BoardDao {

	public List<Board> selectAll() {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		List<Board> result = sqlSession.selectList("myBoard.allBoards");

		sqlSession.close();

		return result;
	}

	public int updateWrite(Board board) {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		int result = sqlSession.update("myBoard.updateBoard", board);
		
		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return result;
	}
	
	public int deleteWrite(int boardNum) {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		int result = sqlSession.delete("myBoard.deleteBoard", boardNum);
		
		if (result == 1) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();

		return result;
	}
	
	public Board updateDetail (Board board) {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		Board result = sqlSession.selectOne("myBoard.oneBoard", board);

		sqlSession.close();

		return result;
	}

	public Board insertBoard (Board board) {

		SqlSession sqlSession = 
				MyBatisConnectionFactory.getSqlSessionFactory().openSession();

		Board result = sqlSession.selectOne("myBoard.registBoard", board);
		
		sqlSession.close();

		return result;
	}
}	


