package model;
import java.util.List;

import dao.StudentscoreDAO;

public class GetStudentscoreListLogic {
	public List<Studentscore> execute(String studentname){
		StudentscoreDAO dao=new StudentscoreDAO();
		List<Studentscore> studentscoreList=dao.findstudentname(studentname);
		return studentscoreList;
	}


}
