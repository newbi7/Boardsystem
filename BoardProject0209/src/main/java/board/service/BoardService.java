package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.vo.Board;

public class BoardService {

	public List<Board> getAllBoard() {
		
		BoardDao dao = new BoardDao();
		
		List<Board> list = dao.selectAll();
		
		return list;
	}

	public int updateBoard(Board board) {
		
		BoardDao dao = new BoardDao();
		
		int result = dao.updateWrite(board);
		
		return result;
	}
	
	public int deleteBoard(int boardNum) {
		
		BoardDao dao = new BoardDao();
		
		int result = dao.deleteWrite(boardNum);
		
		return result;
	}

	public Board updateDetail(Board board) {
		BoardDao dao = new BoardDao();
		
		Board list = dao.updateDetail(board);
		
		return list;
	}
	
	public Board insertBoard(Board board) {
		
		BoardDao dao = new BoardDao();
		
		Board result = dao.insertBoard(board);
		
		return result;
	}
}
