package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetStudentscoreListLogic;
import model.Studentscore;
/**
 * Servlet implementation class TestDisplayServlet
 */
@WebServlet("/TestDisplayServlet")
public class TestDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testdisplay.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	request.setCharacterEncoding("UTF-8");
	String studentname=request.getParameter("studentname").trim();
//   ログの出力
//	System.out.println("入力された名前：" + studentname);
//	System.out.println("SQLに渡す値：" + "%" + studentname + "%");
//	空白の時
	if(studentname==null || studentname.isEmpty()) {
		request.setAttribute("errorMsg","学生名が空白です");
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testdisplay.jsp");
		dispatcher.forward(request, response);
	}

	else {
	GetStudentscoreListLogic getstudentscorelistlogic=new GetStudentscoreListLogic();
	List<Studentscore>studentscoreList=getstudentscorelistlogic.execute(studentname);
//	リストが空で帰ってきた場合
	if(studentscoreList==null || studentscoreList.isEmpty()) {
		request.setAttribute("errorMsg", "入力された生徒が存在しません");
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testdisplay.jsp");
		dispatcher.forward(request, response);
	}



	else {request.setAttribute("studentscoreList",studentscoreList);

		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testdisplayresult.jsp");
		dispatcher.forward(request, response);
	}
}

	}
}
