package test;
import dao.StudentscoreDAO;
import model.Studentscore;
public class StudentscoreDAOTest {
	public static void main(String[]args) {
		testcreateOK();

	}


	public static void  testcreateOK() {
		Studentscore studentscore=new Studentscore("1年4組","中間","斎藤未知矢",70,70,50,60,60,null,null,null,null,null,null,true);
		StudentscoreDAO dao=new StudentscoreDAO();
		boolean succsess=dao.testcreate(studentscore);


if(succsess) {
	System.out.println("testcreateOK:成功しました");
}
else {System.out.println("testcreateOK:失敗しました");

	}

}



}
