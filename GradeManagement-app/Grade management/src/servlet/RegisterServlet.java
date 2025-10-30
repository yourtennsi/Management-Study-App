package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterLogic;
import model.TeacherAccount;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String forwardPath=null;

		String action=request.getParameter("action");
//			登録入力画面に案内

		if(action==null) {
		forwardPath="WEB-INF/jsp/register.jsp";}

	//登録完了画面に案内

		else if(action.equals("done")) {

			forwardPath="WEB-INF/jsp/registerfinish.jsp";
			HttpSession session =request.getSession();
			TeacherAccount teacheraccount=(TeacherAccount)session.getAttribute("teacheraccount");
//			データベースに登録
			RegisterLogic registerlogic=new RegisterLogic();
			registerlogic.execute(teacheraccount);
			session.setAttribute("teacheraccount", teacheraccount);

		}

		RequestDispatcher dispatcher=request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");

		String teacher_Id=request.getParameter("teacher_Id");
		String pass=request.getParameter("pass");
		String mail=request.getParameter("mail");
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
//		空白チェック
//文字化け防止

		if (name != null) {
		    name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		}
		if (subject != null) {
		    subject = new String(subject.getBytes("ISO-8859-1"), "UTF-8");
		}

		if(teacher_Id==null || teacher_Id.isEmpty() || pass==null ||pass.isEmpty()||mail==null ||mail.isEmpty() || name==null ||name.isEmpty() ||subject==null | subject.isEmpty()) {
			request.setAttribute("errorMsg", "エラー：空白の欄があります！");
			RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);

		}

		else {TeacherAccount teacheraccount=new TeacherAccount(teacher_Id,pass,mail,name,subject);
			HttpSession session=request.getSession();
			session.setAttribute("teacheraccount",teacheraccount );



		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/registerresult.jsp");
		dispatcher.forward(request, response);}



	}

}
