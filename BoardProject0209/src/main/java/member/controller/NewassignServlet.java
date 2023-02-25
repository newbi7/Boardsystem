package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class NewassignServlet
 */
@WebServlet("/newassign")
public class NewassignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewassignServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userID");
		String userPw = request.getParameter("userPW");
		String userName = request.getParameter("userName");

		if (userId == null || userId.equals("")) {
			JOptionPane.showMessageDialog(null, "아이디가 공백입니다.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			response.sendRedirect("Newassign.jsp");
		} else if (userPw == null || userPw.equals("")) {
			JOptionPane.showMessageDialog(null, "비밀번호가 공백입니다.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			response.sendRedirect("Newassign.jsp");
		} else if (userName == null || userName.equals("")) {
			JOptionPane.showMessageDialog(null, "이름이 공백입니다.", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
			response.sendRedirect("Newassign.jsp");
		} else {
			Member member = new Member();
			member.setMemberId(userId);
			member.setMemberPw(userPw);
			member.setMemberName(userName);

			MemberService service = new MemberService();
			service.newassign(member);
			response.sendRedirect("login.jsp");
		}
	}
}

