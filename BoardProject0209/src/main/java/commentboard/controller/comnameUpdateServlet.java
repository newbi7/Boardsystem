package commentboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commentboard.service.commentService;
import commentboard.vo.commentBoard;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/comnameupdateboard")
public class comnameUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public comnameUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		int commentNum = Integer.parseInt(request.getParameter("commentBoardNumber"));
		String commentBoardAuthor = request.getParameter("commentBoardAuthor");
		String commentTitle = request.getParameter("commentBoardTitle");
		String commentBoardContent = request.getParameter("commentBoardContent");
		
		commentBoard commentboard = new commentBoard();
		commentboard.setCommentBoardNumber(commentNum);
		commentboard.setCommentBoardTitle(commentTitle);
		commentboard.setCommentBoardContent(commentBoardContent);
		commentboard.setCommentBoardAuthor(commentBoardAuthor);
		
		new commentService().updateComment(commentboard);
		
		request.setAttribute("boardNum", boardNum);
		request.getRequestDispatcher("detail").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
