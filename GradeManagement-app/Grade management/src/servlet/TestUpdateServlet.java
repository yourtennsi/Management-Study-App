package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FindstudentbystudentIDLogic;
import model.Studentscore;
import model.TestupdateLogic;
/**
 * Servlet implementation class TestUpdateservlet
 */
@WebServlet("/TestUpdateServlet")
public class TestUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

//	3つのaction パラメータで処理を分岐
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");
//		action パラメターのログ
//		System.out.println(action);


		String path="";//それぞれのパスへ

//		テストデータ表示画面から
		if(action==null) {
			String studentidstr=request.getParameter("studentid");
//			idの不正チェック
			if(studentidstr!=null && !studentidstr.isEmpty()) {
				int studentid=0;

				try {studentid=Integer.parseInt(studentidstr);

				}catch(NumberFormatException e) {
					System.out.println("idの値が不正です");
					System.out.println(studentid);

				}

//				指定されたIdのデータを抽出
			FindstudentbystudentIDLogic logic=new FindstudentbystudentIDLogic();

			Studentscore studentscore=logic.execute(studentid);

			HttpSession session=request.getSession();
			session.setAttribute("studentscore",studentscore);

		path="WEB-INF/jsp/testupdate.jsp";

	}

			else {System.out.println("内部エラー：idが空です");
					request.setAttribute("errorMsg", "内部エラーが発生しました");
					path="WEB-INF/jsp/testupdate.jsp";

			}
		}



//		変更確認画面から

		else if(action.equals("confirm")) {
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
			String sumscorestr=request.getParameter("sumscore");
			String avrstr=request.getParameter("avr");
			String rank=request.getParameter("rank");
			String attendancestr=request.getParameter("attendance");

//			ローカル変数の対策
			int japanese=0;
			int english=0;
			int math=0;
			int science=0;
			int socialstudies=0;
			int sumscore=0;
			double avr=0;
			Integer art=0;
			Integer music=0;
			Integer health=0;
			Integer industrialart=0;
			Integer homeeconomics=0;
			Integer info=0;

//			必須項目のチェック
			if(classnum==null || classnum.isEmpty()||test_name==null||test_name.isEmpty()||studentname==null || studentname.isEmpty()|| japanesestr==null ||
					japanesestr.isEmpty()|| englishstr==null ||englishstr.isEmpty()|| mathstr==null ||mathstr.isEmpty()||sciencestr==null||sciencestr.isEmpty() || socialstudiesstr==null ||socialstudiesstr.isEmpty()||
					sumscorestr==null ||sumscorestr.isEmpty()|| avrstr==null ||avrstr.isEmpty() ||rank==null ||rank.isEmpty() ||attendancestr==null ||attendancestr.isEmpty()) {
				request.setAttribute("errorMsg","必須項目に空白があります");
				path="WEB-INF/jsp/testupdate.jsp";}

			//			数値チェック
			else {try {
				 japanese=Integer.parseInt(japanesestr);
				 english=Integer.parseInt(englishstr);
				 math=Integer.parseInt(mathstr);
				 science=Integer.parseInt(sciencestr);
				 socialstudies=Integer.parseInt(socialstudiesstr);
				 sumscore=Integer.parseInt(sumscorestr);
				 avr=Double.parseDouble(avrstr);
			}
			catch(NumberFormatException e) {request.setAttribute("errorMsg","半角数値を入力してください");
			path="WEB-INF/jsp/testupdate.jsp";}

//			実技教科のチェック
// 念のため、"null"もチェック

			try {
			art = (artstr == null || artstr.isEmpty()||artstr.equals("null")) ? null : Integer.parseInt(artstr);
			 music=(musicstr==null || musicstr.isEmpty()|| musicstr.equals("null"))? null:	Integer.parseInt(musicstr);
			 health=(healthstr==null || healthstr.isEmpty()||healthstr.equals("null"))? null:Integer.parseInt(healthstr);
			 industrialart=(industrialartstr==null || industrialartstr.isEmpty()||industrialartstr.equals("null"))? null:Integer.parseInt(industrialartstr);
			 homeeconomics=(homeeconomicsstr==null ||homeeconomicsstr.isEmpty()|| homeeconomicsstr.equals("null"))? null:Integer.parseInt(homeeconomicsstr);
			info=(infostr==null ||infostr.isEmpty()|| infostr.equals("null"))? null:Integer.parseInt(infostr);
			}catch(NumberFormatException e) {
				 request.setAttribute("errorMsg", "半角数値を入力してください");
				 path="WEB-INF/jsp/testupdate.jsp";
			}

			boolean attendances=Boolean.parseBoolean(attendancestr);
//			 新しいsutudentインスタンスをセッションに格納
			 HttpSession session=request.getSession();
//古いインスタンスを格納
			 Studentscore old=(Studentscore)session.getAttribute("studentscore");
			 Studentscore studentscore=new Studentscore(classnum,test_name,studentname,japanese,english,math,science,socialstudies,art,music,health,industrialart,info,homeeconomics,attendances);
			 studentscore.setSumscore(sumscore);
			 studentscore.setAvr(avr);
			 studentscore.setRank(rank);
//			 Idだけは引き継ぐ
			 studentscore.setId(old.getId());

			 session.setAttribute("studentscore", studentscore);

			path= "WEB-INF/jsp/testupdateconfirm.jsp";}

		}

// データベースの更新を行う処理

		else if(action.equals("done")) {
			String studentidstr=request.getParameter("studentid");
//			idの不正チェック
			if(studentidstr!=null && !studentidstr.isEmpty()) {
				int studentid=0;

				try {studentid=Integer.parseInt(studentidstr);
				}

				catch(NumberFormatException e) {
					System.out.println("idの値が不正です");

				}
				HttpSession session=request.getSession();
				Studentscore studentscore=(Studentscore)session.getAttribute("studentscore");
				studentscore.setId(studentid);
				TestupdateLogic logic=new TestupdateLogic();
				logic.execute(studentscore);
			path="WEB-INF/jsp/testupdatefinish.jsp";

		}

			else {System.out.println("内部エラー：idが空です");
			request.setAttribute("errorMsg", "内部エラーが発生しました");
			path="WEB-INF/jsp/testupdateconfirm.jsp";
	}

	}

		RequestDispatcher dispatcher=request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
//次回データベースが更新されているかの確認から
}
