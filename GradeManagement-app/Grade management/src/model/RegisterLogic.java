package model;
import dao.TeacherDAO;;

public class RegisterLogic {

	public void execute(TeacherAccount teacheraccount) {
		TeacherDAO dao=new TeacherDAO();
		dao.create(teacheraccount);
	}
}
