package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.MemberService;
import member.vo.Member;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userID");
		String userPw = request.getParameter("userPW");
		String userName = request.getParameter("userName");

		Member member = new Member();
		member.setMemberId(userId);
		member.setMemberPw(userPw);
		member.setMemberName(userName);

		MemberService service = new MemberService();
		Member result = service.login(member);

		if(result != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("member", result);
			response.sendRedirect("contentshow");
		} else {
			response.sendRedirect("loginFail.jsp");
		}

	}

}

