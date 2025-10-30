package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteStudentscoreLogic;
/**
 * Servlet implementation class TestDeleteServlet
 */
@WebServlet("/TestDeleteServlet")
public class TestDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String studentidstr=request.getParameter("studentid");

		if(studentidstr!=null && !studentidstr.isEmpty()) {
		System.out.println(studentidstr);

		int studentid=0;

		try {
		 studentid=Integer.parseInt(studentidstr);

		}catch(NumberFormatException e){
			System.out.println("IDの形式が不正です: " + studentid);
		}

		DeleteStudentscoreLogic logic=new DeleteStudentscoreLogic();
		logic.execute(studentid);
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testdeletefinish.jsp");
		dispatcher.forward(request, response);

		}
//		nullもしくは空だった場合
		else {System.out.println("内部エラー:idがからです");
			request.setAttribute("errorMsg", "内部エラーが発生しました");

		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testdeleteconfirm.jsp");
		dispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String  studentidstr=request.getParameter("studentid");
//		idのログ
//		System.out.println(studentidstr);
		if(studentidstr!=null && !studentidstr.isEmpty()) {
			int studentid=0;
			try {

				studentid=Integer.parseInt(studentidstr);}

			catch(NumberFormatException e) {
				System.out.println("IDの形式が不正です: " + studentid);
			}

		request.setAttribute("studentid", studentid);
		request.setAttribute("alertMsg","本当に削除しますか？");
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testdeleteconfirm.jsp");
		dispatcher.forward(request, response);
		}
//		null 空だった場合

		else {
			System.out.println("内部エラー：Idが空です");
			request.setAttribute("errorMsg", "内部エラーが発生しました");

		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testdisplayresult.jsp");
		dispatcher.forward(request, response);
		}

	}

}
