package model;
import dao.StudentscoreDAO;


public class DeleteStudentscoreLogic {
	public  void execute(int studentid) {
		StudentscoreDAO dao=new StudentscoreDAO();
		dao.testdelite(studentid);

	}

}
