package test;
import dao.StudentscoreDAO;
import model.Studentscore;
public class FindstudentbystudentIDTest {

	public static void main(String[]args) {
		findstudentbystudentIDOK();
		findstudentbystudentIDNG();
	}

	public static void findstudentbystudentIDOK() {
		StudentscoreDAO dao=new StudentscoreDAO();
		Studentscore studentscore=null;
		studentscore=dao.findstudentbystudentID(69);
		if(studentscore.getClassnum().equals("1年1組") && studentscore.getTest_name().equals("中間テスト")&& studentscore.getStudentname().equals("吉原久美")) {
			System.out.println("findstudentbystudentID：成功です");

		}
		else {System.out.println("findstudentbystudentID:失敗です");
		System.out.println(studentscore.getClassnum());
		System.out.println(studentscore.getTest_name());
		System.out.println(studentscore.getStudentname());
		}


	}


	public static void findstudentbystudentIDNG() {
		StudentscoreDAO dao=new StudentscoreDAO();
		Studentscore studentscore=null;
		studentscore=dao.findstudentbystudentID(120);
		if(studentscore==null) {
			System.out.println("findstudentbystudentIDNG：成功です");
		}
		else {System.out.println("findstudentbystudentIDNG:失敗です");}
	}
}
