package model;
import dao.StudentscoreDAO;

public class StudentscorePostLogic {
	public void execute(Studentscore studentscore) {
		StudentscoreDAO dao=new StudentscoreDAO();
		dao.testcreate(studentscore);
	}
}
