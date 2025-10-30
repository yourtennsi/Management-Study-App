package model;
import dao.StudentscoreDAO;
public class TestupdateLogic {
	public  void execute(Studentscore studentscore) {
		StudentscoreDAO dao=new StudentscoreDAO();
		dao.testupdate(studentscore);
	}

}
