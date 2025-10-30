package test;
import dao.TeacherDAO;
import model.Login;
import model.TeacherAccount;

public class TecaherDAOtest {

	public static void main(String[]args) {
		testfindByLoginOK();
		testfindByLoginNG();
	}

	public static void testfindByLoginOK() {
		Login login=new Login("yamada","yama12");
		TeacherDAO dao=new TeacherDAO();
		TeacherAccount result=dao.findLogin(login);
		String teacher=result.getTeacher_Id();

		String pass=result.getPass();
		String mail=result.getMail();
		String name=result.getName();
		String subject=result.getSubject();

		if(	result!=null&&
			result.getTeacher_Id().equals("yamada")&&
			result.getPass().equals("yama12")&&
			result.getMail().equals("noboru.yamada@yamanashi.jp")&&
			result.getName().equals("山田 昇")&&
			result.getSubject().equals("理科")) {

			System.out.println("testfindByLoginOK成功しました");



			System.out.println(teacher);
			System.out.println(pass);
			System.out.println(mail);
			System.out.println(name);
			System.out.println(subject);
			System.out.println("testfindByLoginOK：失敗しました");

	}

	}

	public static void testfindByLoginNG() {
		Login login=new Login("yosi","yosi14");
		TeacherDAO dao=new TeacherDAO();
		TeacherAccount result=dao.findLogin(login);
		if(result==null) {
			System.out.println("testfindByLoginNG：成功しました");
		}
		else {System.out.println("testfindByLoginNG：失敗しました");}
	}
}