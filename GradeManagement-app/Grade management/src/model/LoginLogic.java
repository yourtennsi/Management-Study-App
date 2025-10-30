package model;
import dao.TeacherDAO;

public class LoginLogic {
	public boolean execute(Login login) {
		TeacherDAO dao=new TeacherDAO();
		TeacherAccount teacheraccount=dao.findLogin(login);
		return teacheraccount!=null;

	}

}
