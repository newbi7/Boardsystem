package commentboard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import commentboard.service.commentService;
import commentboard.vo.commentBoard;

/**
 * Servlet implementation class commentaddServlet
 */
@WebServlet("/commentadd")
public class commentaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public commentaddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		doPost(request, response);
//
//	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String commentBoardAuthor = request.getParameter("commentBoardAuthor");
		String commentBoardTitle = request.getParameter("commentBoardTitle");
		String commentBoardContent = request.getParameter("commentBoardContent");
		
		if (commentBoardTitle == null || commentBoardTitle.equals("")) {
			JOptionPane.showMessageDialog(null, "제목이 없습니다.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		} else if (commentBoardContent == null || commentBoardContent.equals("")) {
			JOptionPane.showMessageDialog(null, "내용이 없습니다.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
		} else {
			commentBoard commentboard = new commentBoard();
			commentboard.setBoardNum(boardNum);
			commentboard.setCommentBoardAuthor(commentBoardAuthor);
			commentboard.setCommentBoardTitle(commentBoardTitle);
			commentboard.setCommentBoardContent(commentBoardContent);
			
			commentService commentservice = new commentService();
			int result = commentservice.addComment(commentboard);
			response.getWriter().print(result);
		}
	}

}
