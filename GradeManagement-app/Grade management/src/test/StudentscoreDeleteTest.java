package test;
import dao.StudentscoreDAO;
public class StudentscoreDeleteTest {
	public static void main(String[]args) {
		StudentscoreDeleteOK();
		StudentscoreDeleteNG();
	}


	public static void  StudentscoreDeleteOK() {
		StudentscoreDAO dao=new StudentscoreDAO();
		boolean result=dao.testdelite(4);

			if(result) {
				System.out.println("StudentscoreDelteOK;成功です");
			}
			else {System.out.println("StudentscoreDeleteOK：失敗です");}

	}

	public static void StudentscoreDeleteNG() {
		StudentscoreDAO dao=new StudentscoreDAO();
		boolean result=dao.testdelite(156);


	
		if(!(result)) {System.out.println("StudentDeleteNG:成功です");

		}
		else {System.out.println("StudentDeleteNG:失敗です");}
	}

}
