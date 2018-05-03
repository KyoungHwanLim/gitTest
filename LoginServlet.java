package user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.UserVO;
import user.service.UserService;
import user.service.UserServiceInf;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter pw = response.getWriter();

		String[] userIds = request.getParameterValues("userId");
		for (String userId : userIds) {
			pw.write("userId : " + userId + "<br>");
		}

		// pw.write("userId : " + request.getParameter("userId") + "<br>");
		pw.write("password : " + request.getParameter("password") + "<br>");

		// as-is
		// LoginServlet에서 userId, password 파라미터를 화면 응답으로 생성
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		UserServiceInf service = new UserService();
		boolean loginResult = service.loginProcess(new UserVO("", request
				.getParameter("userId"), request.getParameter("password")));

		if (loginResult) {
			// response.sendRedirect("main.jsp");

			request.setAttribute("userId", userId);

			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);

			ServletContext sc = getServletContext();
			sc.setAttribute("userId", "Application");

			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("login/login.jsp");
		}
		// to-be

		// userId, password 파라미터에 해당하는 사용자가
		// 존재할 경우 :main.jsp로 redirect
		// 존재하지 않을 경우 : login.jsp, redirect

		// userService 인스턴스 생성

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
