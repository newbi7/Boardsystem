package commentboard.service;

import java.util.List;

import commentboard.dao.commentDao;
import commentboard.vo.commentBoard;

public class commentService {

	public List<commentBoard> getAllContentBoard(int boardNum) {

		commentDao dao = new commentDao();

		List<commentBoard> list = dao.contentselectAll(boardNum);

		return list;
	}

	public int updateComment(commentBoard commentboard) {

		commentDao dao = new commentDao();

		int result = dao.updateComment(commentboard);

		return result;
	}

	public int deleteComment(int commentNumber) {

		commentDao dao = new commentDao();

		int result = dao.deleteComment(commentNumber);

		return result;
	}

	public int addComment(commentBoard commentBoard) {

		commentDao dao = new commentDao();

		int result = dao.addComment(commentBoard);

		return result;
	}

	public commentBoard getcommenteditBoard(int commentNum) {

		commentDao dao = new commentDao();

		commentBoard result = dao.getcommenteditBoard(commentNum);

		return result;
	}

}
