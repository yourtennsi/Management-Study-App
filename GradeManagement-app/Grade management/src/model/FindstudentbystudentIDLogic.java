package model;
import dao.StudentscoreDAO;

public class FindstudentbystudentIDLogic {
	public Studentscore execute(int studentid) {

		StudentscoreDAO dao=new StudentscoreDAO();
		Studentscore  studentscore=dao.findstudentbystudentID(studentid);
		return studentscore;

	}

}

