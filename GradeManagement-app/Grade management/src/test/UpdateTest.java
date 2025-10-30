package test;
import dao.StudentscoreDAO;
import model.Studentscore;
public class UpdateTest {
	public static void main(String[]args) {
		UpdateTestOK();
		UpdateTestNG();
	}



	public static void UpdateTestOK() {
		StudentscoreDAO dao=new StudentscoreDAO();
		Studentscore studentscore=new Studentscore("2年A組","中間テスト","鈴木琢磨",80,50,25,90,90,50,70,0,90,70,50,true);
		studentscore.setId(5);
		boolean result=dao.testupdate(studentscore);
		if(result) {
			System.out.println("UpdateTestOK：成功です");
		}
		else {System.out.println("UpdateTestOK:失敗です");}
//		System.out.println(studentscore.getClassnum());
	}

	public static void UpdateTestNG() {
		StudentscoreDAO dao=new StudentscoreDAO();
		Studentscore studentscore=new Studentscore();
		studentscore.setId(145);
		boolean result=dao.testupdate(studentscore);
		if(!result) {
			System.out.println("updateTestNG:成功です");
		}
		else {System.out.println("updateTestNG:失敗です");}
	}
}
