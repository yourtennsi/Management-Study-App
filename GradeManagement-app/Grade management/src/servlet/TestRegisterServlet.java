package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Studentscore;
import model.StudentscorePostLogic;
import model.StudentscorecalcLogic;

/**
 * Servlet implementation class TestRegisterServlet
 */
@WebServlet("/TestRegisterServlet")
public class TestRegisterServlet extends HttpServlet {
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
//		テスト登録の画面に案内

		if(action==null) {
			forwardPath="WEB-INF/jsp/testregister.jsp";
		}
//テスト完了画面に案内
		else if(action.equals("done")) {
			forwardPath="WEB-INF/jsp/testregisterfinish.jsp";

//			データベースに登録
			HttpSession session=request.getSession();
			Studentscore studentscore=(Studentscore)session.getAttribute("studentscore");
			StudentscorePostLogic studentscorepostlogic=new StudentscorePostLogic();
			studentscorepostlogic.execute(studentscore);
//			もう一度studentscoreをセッションに入れるかどうか

		}

		RequestDispatcher dispatcher=request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("UTF-8");
		String classnum=request.getParameter("classnum");
		String test_name=request.getParameter("test_name");
		String studentname=request.getParameter("studentname");
		String japanesestr=request.getParameter("japanese");
		String englishstr=request.getParameter("english");
		String mathstr=request.getParameter("math");
		String sciencestr=request.getParameter("science");
		String socialstudiesstr=request.getParameter("socialstudies");
		String artstr=request.getParameter("art");
		String musicstr=request.getParameter("music");
		String healthstr=request.getParameter("health");
		String industrialartstr=request.getParameter("industrialart");
		String homeeconomicsstr=request.getParameter("homeeconomics");
		String infostr=request.getParameter("info");
		String attendancestr=request.getParameter("attendance");
//		文字コードチェック
		if(classnum!=null) {
			 classnum=new String(classnum.getBytes("ISO-8859-1"), "UTF-8");
		}

		if(test_name!=null) {
			test_name=new String(test_name.getBytes("ISO-8859-1"), "UTF-8");
		}
		if(studentname!=null) {
			studentname=new String(studentname.getBytes("ISO-8859-1"), "UTF-8");
		}

		int japanese=0;
		int english=0;
		int math=0;
		int science=0;
		int socialstudies=0;
		Integer art=0;
		Integer music=0;
		Integer health=0;
		Integer industrialart=0;
		Integer homeeconomics=0;
		Integer info=0;


		//		必須項目に空白があれば、エラーの表示
		if(classnum==null || classnum.isEmpty()|| test_name==null || test_name.isEmpty()||studentname==null || studentname.isEmpty()|| japanesestr ==null ||japanesestr.isEmpty()||
				englishstr==null || englishstr.isEmpty()|| mathstr==null || mathstr.isEmpty()|| sciencestr==null|| sciencestr.isEmpty()|| socialstudiesstr==null || socialstudiesstr.isEmpty()|| attendancestr==null ||attendancestr.isEmpty()) {
		request.setAttribute("errorMsg", "エラー：必須項目に空白があります");
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testregister.jsp");
		dispatcher.forward(request, response);}


//		数値に変換
			else { try {  japanese=Integer.parseInt(japanesestr);
						english=Integer.parseInt(englishstr);
						math=Integer.parseInt(mathstr);
					   science=Integer.parseInt(sciencestr);
					   socialstudies=Integer.parseInt(socialstudiesstr);
			}
//		必須項目に数値以外が入力された場合

		catch(NumberFormatException e) {request.setAttribute("errorMsg", "半角数値を入力してください");
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testregister.jsp");
		dispatcher.forward(request, response);

		}

//				表示の際もいったん0で統一
			try {
			art = (artstr == null || artstr.isEmpty()) ? null : Integer.parseInt(artstr);
			music = (musicstr == null || musicstr.isEmpty()) ? null : Integer.parseInt(musicstr);
		   	health = (healthstr == null || healthstr.isEmpty()) ? null : Integer.parseInt(healthstr);
		   	industrialart= (industrialartstr == null || industrialartstr.isEmpty()) ? null : Integer.parseInt(industrialartstr);
		   	homeeconomics = (homeeconomicsstr == null || homeeconomicsstr.isEmpty()) ? null : Integer.parseInt(homeeconomicsstr);
		   	info = (infostr == null || infostr.isEmpty()) ? null : Integer.parseInt(infostr);

			}catch(NumberFormatException e) {
				request.setAttribute("errorMsg","半角数値で入力してください");
				RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testregister.jsp");
				dispatcher.forward(request, response);
			}

		   	boolean attendance=Boolean.parseBoolean(attendancestr);

		 Studentscore studentscore=new Studentscore(classnum,test_name,studentname,japanese,english,math,science,socialstudies,art,music,health,industrialart, homeeconomics,info,attendance);
		StudentscorecalcLogic studentscorecalclogic=new StudentscorecalcLogic();
		studentscorecalclogic.execute(studentscore);
		HttpSession session=request.getSession();
		session.setAttribute("studentscore", studentscore);




//		確認画面に飛ばす
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/jsp/testregisterconfirm.jsp");
			dispatcher.forward(request, response);
			}
	}

}
