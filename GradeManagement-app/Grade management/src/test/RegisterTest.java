package test;
import dao.TeacherDAO;
import model.TeacherAccount;
public class RegisterTest {
	public static void main(String[]args) {



	testRegisterOK();

	}


public static void testRegisterOK() {

	TeacherAccount teacheraccount=new TeacherAccount("suzuki18","yane23","suzuki.koudai@yamuyamu.jp","鈴木航大","社会");
	TeacherDAO dao=new TeacherDAO();

	boolean result=dao.create(teacheraccount);
	if(result) {
		System.out.println("testRegisterOK：成功です");
	}
	else {System.out.println("testRegisterOK:失敗です");}
}



}




