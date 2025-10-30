package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.LoginLogic;
/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF-8");
			String teacher_id=request.getParameter("teacher_Id");
			String pass=request.getParameter("pass");

			if((teacher_id==null ||teacher_id.isEmpty())|| (pass==null ||pass.isEmpty())) {
				request.setAttribute("errorMsg","ユーザ,または、パスワードが空");
			}
//			空でなければログイン処理
			else {

			Login login=new Login(teacher_id,pass);
			LoginLogic loginlogic=new LoginLogic();
			boolean result=loginlogic.execute(login);
//			ログイン成功の場合

			if(result) { HttpSession session=request.getSession();
						session.setAttribute("login",login);
			}

			else {request.setAttribute("errorMsg","ユーザ名、もしくは、パスワードの間違い");}
			}

		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/loginresult.jsp");
			dispatcher.forward(request, response);

	}

	}

