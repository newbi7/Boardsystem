package commentboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commentboard.service.commentService;
import commentboard.vo.commentBoard;

/**
 * Servlet implementation class commenteditshowServlet
 */
@WebServlet("/commenteditshow")
public class commenteditshowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commenteditshowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		commentService cservice = new commentService();
		int commentNum = Integer.parseInt(request.getParameter("commentNumber"));
		
		commentBoard commentboard = cservice.getcommenteditBoard(commentNum);
		request.setAttribute("commenteditBoard", commentboard);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("contentcommentEdit.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
